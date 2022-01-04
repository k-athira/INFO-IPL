package com.atk.infoipl.repository;


import java.util.List;

import com.atk.infoipl.model.Team;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends CrudRepository<Team,String> {

    Team findByName(String name);
    Team findById(Long id);

    @Query("SELECT m FROM Team m WHERE m.is_current_champion = :value")
    List<Team> findCurrentChampion(
        @Param("value") boolean value
    );
    
}
