package com.atk.infoipl.repository;

import com.atk.infoipl.model.Match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,String> {
    
}
