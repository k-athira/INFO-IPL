package com.atk.infoipl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Match {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Team.class)
    private Team team1;

    private String team1Name;
    private String team2Name;
    private String winnerName;
    private String tossWinnerName;

    @OneToOne(targetEntity = Team.class)
    private Team team2;

    private Date date;
    private String venue;

    @OneToOne(targetEntity = Team.class)
    private Team tossWinner;

    private String optedFor;

    @OneToOne(targetEntity = Team.class)
    private Team winner;
    private String man_of_the_match;
    
    private String result;
    private String resultMargin;

    


    public Match(Team team1, String team1Name, String team2Name, String winnerName, String tossWinnerName, Team team2, Date date,
            String venue, Team tossWinner, String optedFor, Team winner, String man_of_the_match, String result,
            String resultMargin) {
        this.team1 = team1;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.winnerName = winnerName;
        this.tossWinnerName = tossWinnerName;
        this.team2 = team2;
        this.date = date;
        this.venue = venue;
        this.tossWinner = tossWinner;
        this.optedFor = optedFor;
        this.winner = winner;
        this.man_of_the_match = man_of_the_match;
        this.result = result;
        this.resultMargin = resultMargin;
    }




    public Match() {
    }


    

    public String getTeam1Name() {
        return team1Name;
    }




    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }




    public String getTeam2Name() {
        return team2Name;
    }




    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }




    public String getWinnerName() {
        return winnerName;
    }




    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }




    public String getTossWinnerName() {
        return tossWinnerName;
    }




    public void setTossWinnerName(String tossWinnerName) {
        this.tossWinnerName = tossWinnerName;
    }




    public Long getId(){
        return id;
    }


    public Team getTeam1() {
        return team1;
    }


    public void setTeam1(Team team1) {
        this.team1 = team1;
    }


    public Team getTeam2() {
        return team2;
    }


    public void setTeam2(Team team2) {
        this.team2 = team2;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getVenue() {
        return venue;
    }


    public void setVenue(String venue) {
        this.venue = venue;
    }


    public Team getTossWinner() {
        return tossWinner;
    }


    public void setTossWinner(Team tossWinner) {
        this.tossWinner = tossWinner;
    }


    public String getOptedFor() {
        return optedFor;
    }


    public void setOptedFor(String optedFor) {
        this.optedFor = optedFor;
    }


    public Team getWinner() {
        return winner;
    }


    public void setWinner(Team winner) {
        this.winner = winner;
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


    public String getResultMargin() {
        return resultMargin;
    }


    public void setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
    }

    

    

    
    

    

}
