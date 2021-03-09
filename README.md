# Backend 

## Prérequis

 + MySQL Server version 8
 + Maven

## Install
1. Cloner le projet
2. Lancer server rest à partir de la classe RestServer

## Endpoints

### Tableaux
  + [POST] http://localhost:8080/kanban/board/add : Ajoute un tableau kanban
  + [POST] http://localhost:8080/kanban/board/{kanbanId}/add-section : Ajoute une section à un kanban  
  + [GET] http://localhost:8080/kanban/board/{id} : Retourne le kanban ayant l'id  
  + [GET] http://localhost:8080/kanban/boards : Liste tous les tableaux kanban

### Users
  + [POST] http://localhost:8080/kanban/user/add : Ajoute un user
  + [PUT] http://localhost:8080/kanban/user/edit : Modifie un user
  + [GET] http://localhost:8080/kanban/user/{id} : Retourne le user ayant l'id
  + [GET] http://localhost:8080/kanban/users : Liste tous les users

### Fiches
  + [POST] http://localhost:8080/kanban/card/add : Ajoute une fiche
  + [GET] http://localhost:8080/kanban/card/{id} : Retourne la fiche ayant l'id
  + [GET] http://localhost:8080/kanban/cards : Liste toutes les fiches
  + [PUT] http://localhost:8080/kanban/card/{cardId}/{userId}/user-assign: Assigne une fiche à un user
  + [PUT] http://localhost:8080/kanban/card/delete : Supprime (en sens de cacher à l'utilisateur) une fiche
  + [PUT] http://localhost:8080/kanban/card/edit : Modifie une fiche
