package com.atk.infoipl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.atk.infoipl.model.Match;
import com.atk.infoipl.model.Team;
import com.atk.infoipl.repository.MatchRepository;
import com.atk.infoipl.repository.TeamRepository;

public class SummaryUpdate {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public SummaryUpdate(){

    }

    public SummaryUpdate(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public void update(){

        HashMap<String,Team> teamMap = new HashMap<String,Team>();
        List<Team> updatedTeamList = new ArrayList<>();

        Iterable<Match> matchList = new ArrayList<>();
        matchList = matchRepository.findAll();

        Iterable<Team> teamList = new ArrayList<>();
        teamList = teamRepository.findAll();

        for(Team team : teamList){
            if( !teamMap.containsKey(team.getName()) ){
                teamMap.put(team.getName(), team);
            }
        }

        for(Match match : matchList){

            // Team1 data update
            //  // Total Match Update
            if(teamMap.containsKey(match.getTeam1Name())){
                
                Team team = teamMap.get(match.getTeam1Name());
                match.setTeam1(team);

                team.setTotalMatch(team.getTotalMatch() + 1);
                
                if(match.getWinnerName().equals(match.getTeam1Name())){
                    team.setTotalWins(team.getTotalWins() + 1);
                    match.setWinner(team);

                }else if(match.getWinnerName().equals("NA")){
                    team.setNoDraw(team.getNoDraw() + 1);

                }else{
                    team.setNoLosses(team.getNoLosses() + 1);

                }

                teamMap.replace(team.getName(), team);                
            }

            // Team2 data update
            if(teamMap.containsKey(match.getTeam2Name())){
                
                Team team = teamMap.get(match.getTeam2Name());
                match.setTeam2(team);

                team.setTotalMatch(team.getTotalMatch() + 1);

                if(match.getWinnerName().equals(match.getTeam2Name())){
                    team.setTotalWins(team.getTotalWins() + 1);
                    match.setWinner(team);

                }else if(match.getWinnerName().equals("NA")){
                    team.setNoDraw(team.getNoDraw() + 1);

                }else{
                    team.setNoLosses(team.getNoLosses() + 1);

                }

                teamMap.replace(team.getName(), team); 


            }

            // Toss winner Data
            if(teamMap.containsKey(match.getTossWinnerName())){
                Team team = teamMap.get(match.getTeam2Name());
                match.setTossWinner(team);
            }
        }


        teamMap.forEach( (k,v)-> 
                updatedTeamList.add(v)
            );
    
        teamRepository.saveAll(updatedTeamList);
        matchRepository.saveAll(matchList);
        


    }
    
}
