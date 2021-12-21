package com.atk.infoipl.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
    
    @Id
    private String id;
    private Team team_1;
    private Team team_2;

    private Date date;
    private String Venue;

    private Team toss;
    private String optedFor;

    private String first_inng_score;
    private String sec_inng_score;

    private Team won;
    private String man_of_the_match;
    
    private String result;

    public Match(Team team_1, Team team_2, Date date, String venue, Team toss, String optedFor, String first_inng_score,
            String sec_inng_score, Team won, String man_of_the_match, String result) {
        this.team_1 = team_1;
        this.team_2 = team_2;
        this.date = date;
        Venue = venue;
        this.toss = toss;
        this.optedFor = optedFor;
        this.first_inng_score = first_inng_score;
        this.sec_inng_score = sec_inng_score;
        this.won = won;
        this.man_of_the_match = man_of_the_match;
        this.result = result;
    }

    public Team getTeam_1() {
        return team_1;
    }

    public void setTeam_1(Team team_1) {
        this.team_1 = team_1;
    }

    public Team getTeam_2() {
        return team_2;
    }

    public void setTeam_2(Team team_2) {
        this.team_2 = team_2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public Team getToss() {
        return toss;
    }

    public void setToss(Team toss) {
        this.toss = toss;
    }

    public String getOptedFor() {
        return optedFor;
    }

    public void setOptedFor(String optedFor) {
        this.optedFor = optedFor;
    }

    public String getFirst_inng_score() {
        return first_inng_score;
    }

    public void setFirst_inng_score(String first_inng_score) {
        this.first_inng_score = first_inng_score;
    }

    public String getSec_inng_score() {
        return sec_inng_score;
    }

    public void setSec_inng_score(String string) {
        this.sec_inng_score = string;
    }

    public Team getWon() {
        return won;
    }

    public void setWon(Team won) {
        this.won = won;
    }

    public String getMan_of_the_match() {
        return man_of_the_match;
    }

    public void setMan_of_the_match(String man_of_the_match) {
        this.man_of_the_match = man_of_the_match;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    

    

}
