import './TeamCard.css'
import { React } from 'react';
import { Link } from 'react-router-dom';

import TeamPieChart from './TeamPieChart';

export const TeamCard = ({team}) => {
    if(!team) return null;

    const teamURL = `/teams/${team.name}`;
    return(
        <div className='team-card'>
                <div className='team-card-header'></div>

                <div className='team-card-body'>
                    <h3 className='team-name'><Link to={teamURL}>{team.name}</Link></h3>
                    <div className='team-info'>
                        <div className='team-info-pie-chart'>
                            <TeamPieChart team={team}/>
                        </div>
                        <div className='team-info-stat-details'>
                            <p>Wins : {team.totalWins}</p>
                            <p>Losses : {team.noLosses}</p>
                            <p>Draw : {team.noDraw}</p>
                        </div>
                    </div>
                </div>

            </div>
    );
}