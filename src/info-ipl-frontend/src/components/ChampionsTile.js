import './ChampionsTile.css';

import { React, useEffect, useState } from 'react';

export const ChampionsTile = () => {

    const [error, setError] = useState(null);
    const [teams, setTeams] = useState([]);

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/currentChampion`)
            .then(res => res.json())
            .then(
                (data) => {
                    setTeams(data);
                },
                (error) => {
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
            <div className='current-champion-container'>
                {
                    teams.map(team =>
                        <div className='current-champion-item'>
                            <h1 className='champion-title'>Current Champions</h1>
                            <h1 className='champion-name'>
                                {team.name}
                            </h1>
                        </div>
                    )
                }
                
            </div>
        );
    }

    
    
}