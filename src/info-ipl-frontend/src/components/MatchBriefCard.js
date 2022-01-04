import './MatchBriefCard.css'

import { React} from 'react';
import { Link } from 'react-router-dom';

export const MatchBriefCard = ({match}) => {
    
    if(!match) return null;
    const matchURL = `/matches/${match.id}`;
    const team1Link = `/teams/${match.team1Name}`;
    const team2Link = `/teams/${match.team2Name}`;

    return(
        <div className='match-brief-card'>
            <div className='team-details'>                
                <h3>
                    <Link className='team-link' to={team1Link}>
                        {match.team1Name}
                    </Link> 
                </h3>
                <h3>vs</h3>
                <h3>
                    <Link className='team-link' to={team2Link}>
                        {match.team2Name}
                    </Link>
                </h3>
            </div>
            <h3 className="match-brief-result">
                {match.winnerName} won by {match.resultMargin} {match.result} 
            </h3>
            <div className='details-link'>
                <Link className='details-link-link' to={matchURL}>Details</Link>
            </div>
        </div>

    );
}
