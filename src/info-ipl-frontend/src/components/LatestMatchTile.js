import './LatestMatchTile.css';

import { React, useEffect, useState  } from 'react';
import { MatchCard } from './MatchCard';

const LatestMatchTile = ({teamName})=> {

    const [error, setError] = useState(null);
    const [matches, setMatches] = useState([]);

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}/latestMatches/`)
            .then(res => res.json())
            .then(
                (data) => {
                    setMatches(data);
                },
                (error) => {
                    setError(error);
                }
            )
    }, [teamName])

    if(error) {
        return(
            <div>
                <h5>{error.message}</h5>
            </div>
        );

    } else{
        return(
            <div className='latest-match-container'>
                {
                    matches.map(
                        match => 
                            <div>
                                <MatchCard match={match} teamName={teamName}/>
                            </div>
                    )
                }
                <h3 className='more-matches'>Show More</h3>
            </div>
        );
    }

    
    
}

export default LatestMatchTile