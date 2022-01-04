package com.atk.infoipl.controller;

import java.util.List;
import java.util.Optional;

import com.atk.infoipl.exception.ResourceNotFoundException;
import com.atk.infoipl.model.Match;
import com.atk.infoipl.repository.MatchRepository;

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
public class MatchController {
    private MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    // create a new match
    @PostMapping("/match/new")
    public Match newMatch(@RequestBody Match match){
        return this.matchRepository.save(match);
    }

    @GetMapping("/team/{name}/latestMatches/")
    public ResponseEntity<List<Match>> getMatchByTeam(@PathVariable(value = "name") String name){
        int count = 5;
        return ResponseEntity.ok(
            this.matchRepository.findLatestMatchesByTeam(name, count)
        );
    }

    @GetMapping("/matches/latest")
    public ResponseEntity<List<Match>> getAllMatches(){
        int count = 10;
        return ResponseEntity.ok(
            this.matchRepository.findLatestMatches(count)
        );
    }


    //////////////////////////////////////////////////////////

    // get all match
    @GetMapping("/match/all")
    public ResponseEntity<Iterable<Match>> getmatchs(){
        return ResponseEntity.ok(
            this.matchRepository.findAll()
        );
    }
    
    //get match by id
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getmatch(@PathVariable(value = "id") String id){
        Long long_id = Long.parseLong(id);
        Match match = matchRepository.findById(long_id);
        return ResponseEntity.ok(match);
    }

    //put match
    @PutMapping("/match/{id}")
    public Match updatematch(@RequestBody Match newMatch, @PathVariable(value = "id") String id){
        Match match = matchRepository.findById(id)
            .orElseThrow( ()-> new ResourceNotFoundException("match Not Found"));

        match.setTeam1(newMatch.getTeam1());
        match.setTeam2(newMatch.getTeam2());

        match.setDate(newMatch.getDate());
        match.setVenue(newMatch.getVenue());

        match.setTossWinner(newMatch.getTossWinner());
        match.setOptedFor(newMatch.getOptedFor());
        
        match.setWinner(newMatch.getWinner());
        match.setMan_of_the_match(newMatch.getMan_of_the_match());
        
        match.setResult(newMatch.getResult());

        return this.matchRepository.save(match);
    }

    // delete match
    @DeleteMapping("/match/{id}")
    public ResponseEntity<Optional<Match>> removematch(@PathVariable(value="id") String id){
        Optional<Match> optionalmatch = this.matchRepository.findById(id);
        Match match = optionalmatch.get();
        this.matchRepository.delete(match);
        return ResponseEntity.ok().build();
    }
}
