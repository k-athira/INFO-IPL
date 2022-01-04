package com.atk.infoipl.repository;

import java.util.List;

import com.atk.infoipl.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,String> {

    List<Match> findByTeam1NameOrTeam2Name(String team1, String team2);
    Match findById(Long id);
    List<Match> getByTeam1NameOrTeam2NameOrderByDateDesc(String teamName1, String teamName2, Pageable pageable);
    List<Match> OrderByDateDesc(Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByTeam1NameOrTeam2NameOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    };

    default List<Match> findLatestMatches(int count){
        return OrderByDateDesc(PageRequest.of(0, count));
    }
    
}
