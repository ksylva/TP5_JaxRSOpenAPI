package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.UserDto;

public class UserDaoImpl extends AbstractJpaDao<User, Long> {
    public UserDaoImpl() {
        super(User.class);
    }

    public UserDto getUserWithCards(Long userId){
        return super.entityManager.createQuery(
                "select u.name, uc , c.dateButoire, c.duree, c.lieu, c.url, c.note, c.section" +
                        " from user as u join u.fiches as uc join uc.card as c " +
                        " where u.idUser = :user", UserDto.class
        ).setParameter("user", userId)
                .getSingleResult();
    }
}
