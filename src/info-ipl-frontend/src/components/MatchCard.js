import './MatchCard.css';

import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchCard = ({match, teamName}) => {
    if(!match) return null;

    const isMatchWon = teamName === match.winnerName;
    const otherTeam = match.team1Name === teamName ? match.team2Name : match.team1Name;
    const otherTeamURL = `/teams/${otherTeam}`;

    return(
        <div className={isMatchWon ? 'match-won-card' : 'match-lost-card'}>
            <span className='vs'>vs</span>
            <h2 className='other-team-name'>
                <Link className='other-team-link' to={otherTeamURL}>{ otherTeam }</Link>
            </h2>
            <h3 className="match-venue">at {match.venue}</h3>
            <h3 className='match-date'>on {match.date}</h3>
            <h3 className="match-result">
                {match.winnerName} won by {match.resultMargin} {match.result} 
            </h3>
        </div>
    )

}