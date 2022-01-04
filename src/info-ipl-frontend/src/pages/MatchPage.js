import './MatchPage.css';

import { React, useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export const MatchPage = () => {

    const [error, setError] = useState(null);
    const [match, setMatch] = useState([]);
    const { matchId } = useParams();

    useEffect(()=> {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/match/${matchId}`)
            .then(res=> res.json())
            .then(
                (data)=> {
                    setMatch(data);
                },
                (error)=> {
                    setError(error);
                }
            )

    }, [matchId])

    if(error) {
        return(
            <div>
                <h5>{error.message}</h5>
            </div>

        );
    } else{
        const team1Link = `/teams/${match.team1Name}`;
        const team2Link = `/teams/${match.team2Name}`;
        return(
            <div className='match-detail-complete-card'>
                <div className='complete-card-team-details'>                
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

                <h3 className="complete-card-match-result">
                    <span className='winner-team'>{match.winnerName} </span>
                    , won by {match.resultMargin} {match.result} 
                </h3>

                <div className='add-match-details'>
                    <h3 className='complete-card-venue'>Venue : {match.venue}</h3>
                    <h3 className='complete-card-date'>Date : {match.date}</h3>
                    <h3 className='complete-card-toss-details'>
                        {match.tossWinnerName} won the toss and Opted for {match.optedFor}
                    </h3>
                    <h3 className='complete-card-man-of-match'>Man of the Match : {match.man_of_the_match}</h3>
                </div>
                
            </div>
        );
    }
}