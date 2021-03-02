package fr.istic.taa.jaxrs.dao;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Card;
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
                "as e where e.enabled = :enabled ", super.theClass)
                .setParameter("enabled", true)
                .getSingleResult();
    }

    @Override
    public List<Card> findAll() {
        return super.entityManager.createQuery("select e from " + theClass.getName() + " " +
                "as e where e.enabled = :enabled ", super.theClass)
                .setParameter("enabled", true)
                .getResultList();
    }

    /**
     * To assign a card to user
     * @param card card to assign
     * @param user user which receive card
     */
    public Card attachUserToCard(Long id, User user){
        Card card = findOne(id);
        card.setUser(user);
        //user.getFiches().add(card);
        EntityTransaction t = super.entityManager.getTransaction();
        t.begin();
        Card updatedCard = entityManager.merge(card);
        //entityManager.merge(user);
        t.commit();
        return updatedCard;
    }
}
