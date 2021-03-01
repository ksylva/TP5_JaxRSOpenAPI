package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.User;

public class UserDaoImpl extends AbstractJpaDao<User, Long> {
    public UserDaoImpl() {
        super(User.class);
    }

    public User attachCardToUser(Fiche card){
        return null;
    }
}
