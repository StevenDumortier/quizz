package com.tp.quiz.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class PlayerDTO {
    @JsonIgnore
        private int partieGagne;
    @JsonIgnore
        private int partieJoue;

        private long id;

        private int classement;
        private String name;
        private String partie;
        public PlayerDTO() {
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartie() {
        return partieGagne + "/" + partieJoue;
    }

    public void setPartie(String partie) {
        this.partie = partie;
    }

    public int getPartieGagne() {
        return partieGagne;
    }

    public void setPartieGagne(int partieGagne) {
        this.partieGagne = partieGagne;
    }

    public int getPartieJoue() {
        return partieJoue;
    }

    public void setPartieJoue(int partieJoue) {
        this.partieJoue = partieJoue;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

