import './MatchList.css';

import { React, useEffect, useState } from 'react'
import { MatchBriefCard } from '../components/MatchBriefCard'

export const MatchList = () => {

    const [error, setError] = useState(null);
    const [matches, setMatches] = useState([]);

    useEffect(()=> {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/matches/latest`)
            .then(res=> res.json())
            .then(
                (data)=> {
                    setMatches(data);
                },
                (error)=> {
                    setError(error);
                }
            )

    }, [])

    if(error) {
        return(
            <div>
                <h5>{error.message}</h5>
            </div>

        );
    } else{
        return(
            <div className='match-list-container'>
                {
                    matches.map(match => <MatchBriefCard match={match}/>)
                }
                <h3>Show More</h3>
            </div>
        );
    }
}