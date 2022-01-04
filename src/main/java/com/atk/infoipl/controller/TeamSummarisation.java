package com.atk.infoipl.controller;

import java.util.ArrayList;
import java.util.List;

import com.atk.infoipl.model.Team;
import com.atk.infoipl.repository.MatchRepository;
import com.atk.infoipl.repository.TeamRepository;
import com.atk.infoipl.service.SummaryUpdate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamSummarisation {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamSummarisation(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/summary/load")
    public ResponseEntity<List<String>> summaryLoad(){

        SummaryUpdate sumUpdate = new SummaryUpdate(teamRepository, matchRepository);
        sumUpdate.update();

        List<String> result = new ArrayList<>();
        result.add("Summary is updated");
        return ResponseEntity.ok(result);
    }

    // Update Status and Colour

    @PostMapping("/data/update")
    public Iterable<Team> newTeam(@RequestBody Iterable<Team> teams){        
        return this.teamRepository.saveAll(teams);
    }

    

}