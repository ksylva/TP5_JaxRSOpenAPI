package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.domain.KanbanBoard;

import java.util.List;

public interface ServiceJob {

    List<KanbanBoard> getAllKanban();

    KanbanBoard getKanbanBoardById(Long kanbanId);

    void addKanban(KanbanBoard kanban);
}
