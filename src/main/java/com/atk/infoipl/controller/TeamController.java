package com.atk.infoipl.controller;

import java.util.List;
import java.util.Optional;

import com.atk.infoipl.model.Team;
import com.atk.infoipl.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TeamController {

    private TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    // create a new team
    @PostMapping("/team/new")
    public Team newTeam(@RequestBody Team team){
        return this.teamRepository.save(team);
    }

    // get all team
    @GetMapping("/team/all")
    public ResponseEntity<Iterable<Team>> getTeams(){
        return ResponseEntity.ok(
            this.teamRepository.findAll()
        );
    }

    // get Current Champion
    @GetMapping("team/currentChampion")
    public ResponseEntity<List<Team>> getChampions(){
        return ResponseEntity.ok(
            this.teamRepository.findCurrentChampion(true)
        );
    }
    
    //get team by id
    @GetMapping("/team/{name}")
    public ResponseEntity<Team> getTeam(@PathVariable(value = "name") String name){
        Team team = teamRepository.findByName(name);
        return ResponseEntity.ok(team);
    }

    //put team
    @PutMapping("/team/{id}")
    public Team updateTeam(@RequestBody Team newTeam, @PathVariable(value = "id") String id){

        Long team_id = Long.parseLong(id);

        Team team = teamRepository.findById(team_id);

        team.setName(newTeam.getName());
        team.setIntro_year(newTeam.getIntro_year());
        team.setLast_played_year(newTeam.getLast_played_year());
        team.setStatus(newTeam.getStatus());
        team.setIs_current_champion(newTeam.isIs_current_champion());

        return this.teamRepository.save(team);
    }

    // delete team
    @DeleteMapping("/team/{id}")
    public ResponseEntity<Optional<Team>> removeTeam(@PathVariable(value="id") String id){
        Optional<Team> optionalTeam = this.teamRepository.findById(id);
        Team team = optionalTeam.get();
        this.teamRepository.delete(team);
        return ResponseEntity.ok().build();
    }

    
}
