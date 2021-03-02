package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.KanbanBoard;
import fr.istic.taa.jaxrs.domain.Section;

import javax.persistence.EntityTransaction;

public class KanbanBoardDaoImpl extends AbstractJpaDao<KanbanBoard, Long> {
    public KanbanBoardDaoImpl() {
        super(KanbanBoard.class);
    }

    /*@Override
    public void save(KanbanBoard entity) {
        super.save(entity);
    }*/

    //EntityManager em = EntityManagerHelper.getEntityManager();

    /*@Override
    public List<Section> getSectionByTable(long tableId) {
        String query ="select table.sections from KanbanBoard as table join fetch table.sections where table.idTableau = :id ";

        return em.createQuery(query, Section.class)
                .setParameter("id", tableId)
                .getResultList();
    }

    @Override
    public KanbanBoard getTable(long idTable) {
        String query = "select table from KanbanBoard as table where table.idTableau = :id";

        return em.createQuery(query, KanbanBoard.class)
                .setParameter("id", idTable)
                .getSingleResult();
    }

    @Override
    public void saveTable(KanbanBoard tableau) {
        EntityTransaction et = em.getTransaction();

        //et.begin();
        em.persist(tableau);
        //et.commit();
    }

    @Override
    public List<KanbanBoard> getTableaux() {
        String query = "select table from KanbanBoard as table";

        return em.createQuery(query, KanbanBoard.class)
                .getResultList();
    }*/

    public void addSection(Long id, Section section){
        KanbanBoard board = findOne(id);
        section.setKanbanBoard(board);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(section);
        transaction.commit();
    }
}
