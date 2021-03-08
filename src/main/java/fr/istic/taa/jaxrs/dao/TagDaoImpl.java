package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Tag;

public class TagDaoImpl extends AbstractJpaDao<Tag, Long> {
    public TagDaoImpl() {
        super(Tag.class);
    }
}
