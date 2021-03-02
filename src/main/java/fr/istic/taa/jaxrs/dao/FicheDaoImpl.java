package fr.istic.taa.jaxrs.dao;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.EntityTransaction;
import java.util.List;


public class FicheDaoImpl extends AbstractJpaDao<Fiche, Long> {
    public FicheDaoImpl() {
        super(Fiche.class);
    }

    @Override
    public Fiche findOne(Long id) {
        return super.entityManager.createQuery("select e from " + theClass.getName() + " " +
                "as e where e.enabled = :enabled ", super.theClass)
                .setParameter("enabled", true)
                .getSingleResult();
    }

    @Override
    public List<Fiche> findAll() {
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
    public Fiche attachUserToCard(Long id, User user){
        Fiche card = findOne(id);
        card.setUser(user);
        //user.getFiches().add(card);
        EntityTransaction t = super.entityManager.getTransaction();
        t.begin();
        Fiche updatedCard = entityManager.merge(card);
        //entityManager.merge(user);
        t.commit();
        return updatedCard;
    }
}
