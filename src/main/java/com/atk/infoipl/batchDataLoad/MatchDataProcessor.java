package com.atk.infoipl.batchDataLoad;

import java.text.SimpleDateFormat;

import com.atk.infoipl.model.Match;

import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{
    
    @Override
    public Match process(MatchInput item) throws Exception {

        Match match = new Match();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        match.setDate(dateFormat.parse(item.getDate()));

        match.setMan_of_the_match(item.getPlayer_of_match());
        match.setOptedFor(item.getToss_decision());

        match.setResult(item.getResult());
        match.setResultMargin(item.getResult_margin());

        match.setTeam1Name(item.getTeam1());
        match.setTeam2Name(item.getTeam2());

        match.setTossWinnerName(item.getToss_winner());
        match.setWinnerName(item.getWinner());
        match.setVenue(item.getVenue());

        return match;
    }
}
