import { React, useEffect, useState  } from 'react';
import { TeamCard } from "../components/TeamCard";

import './TeamList.css';

export const TeamList = () => {

    const [error, setError] = useState(null);
    const [teams, setTeams] = useState([]);

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/all`)
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
            <div className='team-list-container'>
                {
                    teams.map(team => <TeamCard key={team.id} team={team}/>)
                }
            </div>
        );
    }

    
    
}