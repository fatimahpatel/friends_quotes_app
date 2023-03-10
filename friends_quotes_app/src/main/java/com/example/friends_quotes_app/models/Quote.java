package com.example.friends_quotes_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String quote;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties({"quotes"})
    private Character character;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @JsonIgnoreProperties({"quotes"})
    private Season season;

    public Quote(String quote, Character character, Season season){
        this.quote = quote;
        this.character = character;
        this.season = season;
    }

    public Quote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
