package com.atk.infoipl.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    private String id;
    private String codeName;
    private String fullName;
    private String status;
    private String intro_year;
    private String last_played_year;

    public Team(String codeName, String fullName, String status, String intro_year, String last_played_year) {
        this.codeName = codeName;
        this.fullName = fullName;
        this.status = status;
        this.intro_year = intro_year;
        this.last_played_year = last_played_year;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntro_year() {
        return intro_year;
    }

    public void setIntro_year(String intro_year) {
        this.intro_year = intro_year;
    }

    public String getLast_played_year() {
        return last_played_year;
    }

    public void setLast_played_year(String last_played_year) {
        this.last_played_year = last_played_year;
    }

    

    
    
}
