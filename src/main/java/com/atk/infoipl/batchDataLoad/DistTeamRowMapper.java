package com.atk.infoipl.batchDataLoad;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.atk.infoipl.model.Team;

import org.springframework.jdbc.core.RowMapper;

public class DistTeamRowMapper implements RowMapper<Team>{

    public static final String TEAM1NAME_COLUMN = "TEAM1NAME";

    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        Team team = new Team();
        team.setName(rs.getString(TEAM1NAME_COLUMN));
        return team;
    }
    
}
