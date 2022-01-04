package com.atk.infoipl.batchDataLoad;

import com.atk.infoipl.model.Team;

import org.springframework.batch.item.ItemProcessor;

public class TeamDataProcessor implements ItemProcessor<Team, Team>{

    @Override
    public Team process(Team item) throws Exception {

        Team team = new Team();
        team.setName(item.getName());
        team.setNoDraw(0);
        team.setNoLosses(0);
        team.setTotalMatch(0);
        team.setTotalWins(0);
        team.setIs_current_champion(false);
        return team;
    }
    
}
