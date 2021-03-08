package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.CardUser;
import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.EntityTransaction;
import java.sql.Date;


public class CardUserDaoImpl extends AbstractJpaDao<CardUser, Long> {
    public CardUserDaoImpl() {
        super(CardUser.class);
    }

    public void joinUserAndCard(Long userId, Long cardId, CardUser cardUser){
        Card card = new CardDaoImpl().findOne(cardId);
        User user = new UserDaoImpl().findOne(userId);

        cardUser.setCard(card);
        cardUser.setUser(user);

        cardUser.setDateDebut(new Date(cardUser.getDateDebut().getTime()));
        //System.err.println("Start date: "+cardUser.getDateDebut());
        cardUser.setDateFin(new Date(cardUser.getDateFin().getTime()));

        EntityTransaction t = super.entityManager.getTransaction();
        t.begin();
        entityManager.persist(cardUser);
        t.commit();
    }
}
