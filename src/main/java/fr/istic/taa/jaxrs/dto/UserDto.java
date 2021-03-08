package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Card;

import java.util.List;

public class UserDto {
    private String username;
    private List<CardDto> cards;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public void setCards(List<CardDto> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", cards=" + cards +
                '}';
    }
}
