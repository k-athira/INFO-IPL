package com.atk.infoipl.data;

import com.atk.infoipl.model.Team;

import org.springframework.batch.item.ItemProcessor;

public class TeamDataProcessor implements ItemProcessor<TeamInput, Team>{

    @Override
    public Team process(TeamInput item) throws Exception {
        Team team = new Team();

        team.setCodeName(item.getCodeName());
        team.setFullName(item.getFullName());
        team.setIntro_year(item.getIntro_year());
        team.setLast_played_year(item.getLast_played_year());
        team.setStatus(item.getStatus());

        return team;
    }
    
}
