package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.FicheDaoImpl;
import fr.istic.taa.jaxrs.dao.KanbanBoardDaoImpl;
import fr.istic.taa.jaxrs.dao.UserDaoImpl;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.KanbanBoard;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.service.ServiceJob;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kanban")
public class KanbanResource implements ServiceJob {
    // Instantiate dao
    KanbanBoardDaoImpl kanbanDao = new KanbanBoardDaoImpl();
    FicheDaoImpl ficheDao = new FicheDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();

    /* Start kanban */

    @POST
    @Path("/board/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addKanban(KanbanBoard kanban) {
        System.out.println("Le tableau est : "+kanban.getName());
        //kanban.addSection(kanban.getSections());
        List<Section> section = kanban.getSections();
        for (Section s : section){
            s.setKanbanBoard(kanban);
        }
        kanbanDao.save(kanban);
    }

    @GET
    @Path("/board/{tableId}")
    @Produces(MediaType.APPLICATION_JSON)
    public KanbanBoard getKanbanBoardById(@PathParam("tableId") Long tableId){
        return kanbanDao.findOne(tableId);
    }

    @GET
    @Path("/board")
    @Produces(MediaType.APPLICATION_JSON)
    public List<KanbanBoard> getAllKanban() {
        return kanbanDao.findAll();
    }
    /* End kanban */

    /* Start card */

    @POST
    @Path("/card/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCard(Fiche fiche){
        ficheDao.save(fiche);
    }

    @PUT
    @Path("/card/user-assign")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addUserToACard(Fiche card, User user){
        ficheDao.attachUserToCard(card, user);
    }

    @GET
    @Path("/card/{cardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fiche getFicheById(@PathParam("cardId") Long id){
        return ficheDao.findOne(id);
    }

    @GET
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getAllFiche(){
        return ficheDao.findAll();
    }
    /* End cards */
    /* Start user */

    @POST
    @Path("/user/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user){
        userDao.save(user);
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Long id){
        return userDao.findOne(id);
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        return userDao.findAll();
    }
    /* End user */
}
