package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Card;

import java.util.List;

public class UserDto {
    private String username;
    private List<Card> cards;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
