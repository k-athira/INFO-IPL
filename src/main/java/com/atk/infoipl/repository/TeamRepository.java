package com.atk.infoipl.repository;

import com.atk.infoipl.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,String> {
    
}
