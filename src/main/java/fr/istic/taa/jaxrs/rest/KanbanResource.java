package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.CardDaoImpl;
import fr.istic.taa.jaxrs.dao.CardUserDaoImpl;
import fr.istic.taa.jaxrs.dao.KanbanBoardDaoImpl;
import fr.istic.taa.jaxrs.dao.UserDaoImpl;
import fr.istic.taa.jaxrs.domain.*;
import fr.istic.taa.jaxrs.dto.UserDto;
import fr.istic.taa.jaxrs.service.ServiceJob;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kanban")
public class KanbanResource implements ServiceJob {
    // Instantiate dao
    KanbanBoardDaoImpl kanbanDao = new KanbanBoardDaoImpl();
    CardDaoImpl ficheDao = new CardDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();
    CardUserDaoImpl cardUserDao = new CardUserDaoImpl();

    /* Start kanban */

    /**
     * Save a board
     * @param kanban to save
     */
    @POST
    @Path("/board/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addKanban(KanbanBoard kanban) {
        System.out.println("Le tableau est : "+kanban.getName());
        List<Section> section = kanban.getSections();
        for (Section s : section){
            s.setKanbanBoard(kanban);
        }
        kanbanDao.save(kanban);
    }

    /**
     * Add a section to kanban board
     * @param id of kanban board which must receive new section
     * @param section to add
     */
    @POST
    @Path("/board/{tableId}/add-section")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSectionToBoard(@PathParam("tableId") Long id, Section section){
        kanbanDao.addSection(id, section);
    }

    /**
     * Provide the board which has id's given
     * @param tableId of board
     * @return the board with id = tableId
     */
    @GET
    @Path("/board/{tableId}")
    @Produces(MediaType.APPLICATION_JSON)
    public KanbanBoard getKanbanBoardById(@PathParam("tableId") Long tableId){
        return kanbanDao.findOne(tableId);
    }

    /**
     * Provide all kanban board
     * @return the list of kanban boards
     */
    @GET
    @Path("/boards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<KanbanBoard> getAllKanban() {
        return kanbanDao.findAll();
    }
    /* End kanban */

    /* Start card */

    /**
     * Add card on a board
     * @param card to save
     */
    @POST
    @Path("/card/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCard(Card card){
        ficheDao.save(card);
    }

    /**
     * Assign a card to an user
     * @param cardId the card to assign
     * @param userId the user to assign
     * @param cardUser the assignment infos
     */
    @PUT
    @Path("/card/{cardId}/{userId}/user-assign")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addUserToACard(@PathParam("cardId") Long cardId, @PathParam("userId") Long userId, CardUser cardUser){
        cardUserDao.joinUserAndCard(userId, cardId, cardUser);
    }

    /**
     * Provide the card which id's given
     * @param id of card
     * @return the card with id = cardId
     */
    @GET
    @Path("/card/{cardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Card getCardById(@PathParam("cardId") Long id){
        return ficheDao.findOne(id);
    }

    /**
     * Provide all cards
     * @return the list of saved cards
     */
    @GET
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getAllFiche(){
        return ficheDao.findAll();
    }

    /**
     * Edit a card
     * @param card to modify
     * @return the modified card
     */
    @PUT
    @Path("/card/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Card editCard(Card card){
        return ficheDao.update(card);
    }

    /**
     * Delete (disable) a card
     * @param card to disable
     * @return the disabled card
     */
    @PUT
    @Path("/card/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Card deleteCard(Card card){
        return ficheDao.update(card);
    }
    /* End cards */
    /* Start user */

    /**
     * Add an user to system
     * @param user to save
     */
    @POST
    @Path("/user/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user){
        userDao.save(user);
    }

    /**
     * Provide the user which id's given
     * @param id for user
     * @return the user with id = userId
     */
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Long id){
        User user = userDao.findOne(id);
        //UserDto userDto = userDao.getUserWithCards(id);
        //System.err.println("L'user dto is: "+userDto);
        //userDto.setUsername(user.getName());
        //userDto.setCards(user.getFiches());
        return user;
    }

    /**
     * Provide all users saved in system
     * @return the list of users
     */
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        return userDao.findAll();
    }

    /**
     * Update an user
     * @param user to update
     * @return updated user
     */
    @PUT
    @Path("/user/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User editUser(User user){ return userDao.update(user); }

    /**
     * Delete (disable) an user
     * @param user to disable
     * @return the disabled user
     */
    @PUT
    @Path("/user/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(User user){ return userDao.update(user); }
    /* End user */
}
