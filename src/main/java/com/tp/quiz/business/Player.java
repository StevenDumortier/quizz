package com.tp.quiz.business;

import javax.persistence.*;

@Entity
@Table(name = "players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int score;
    private int partie;

    public Player(String name, int score, int partie) {
        this.name = name;
        this.score = score;
        this.partie = partie;
    }
    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPartie() {
        return partie;
    }

    public void setPartie(int partie) {
        this.partie = partie;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", partie=" + partie +
                '}';
    }
    public void game(Boolean isWin){
        if(isWin){
            this.score = this.score +1;
            this.partie = this.partie + 1;
        }
        else{
            this.partie = this.partie + 1;
        }

    }
}
