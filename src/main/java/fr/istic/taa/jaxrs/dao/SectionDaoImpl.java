package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Section;

public class SectionDaoImpl extends AbstractJpaDao<Section, Long> {

    public SectionDaoImpl() {
        super(Section.class);
    }
}
