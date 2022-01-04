import { React, useEffect, useState  } from 'react';
import { useParams } from 'react-router-dom';

import { MainTeamCard } from "../components/MainTeamCard";

import './TeamPage.css';

export const TeamPage = () => {

    const [error, setError] = useState(null);
    const [team, setTeam] = useState([]);
    const { teamName } = useParams();

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}`)
            .then(res => res.json())
            .then(
                (data) => {
                    setTeam(data);
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
            <div className='team-page'>
                <div className='team-colour-header'></div>
                <MainTeamCard key={team.id} team={team} />
            </div>
        );
    }

    
    
}