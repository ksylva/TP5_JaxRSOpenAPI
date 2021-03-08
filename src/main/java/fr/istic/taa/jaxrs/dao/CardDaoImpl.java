package fr.istic.taa.jaxrs.dao;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.CardUser;
import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.EntityTransaction;
import java.util.List;


public class CardDaoImpl extends AbstractJpaDao<Card, Long> {
    public CardDaoImpl() {
        super(Card.class);
    }

    @Override
    public Card findOne(Long id) {
        return super.entityManager.createQuery("select e from " + theClass.getName() + " " +
                "as e where e.enabled = :enabled and e.idFiche = :id", super.theClass)
                .setParameter("enabled", true)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Card> findAll() {
        return super.entityManager.createQuery("select e from " + theClass.getName() + " " +
                "as e where e.enabled = :enabled ", super.theClass)
                .setParameter("enabled", true)
                .getResultList();
    }

}
