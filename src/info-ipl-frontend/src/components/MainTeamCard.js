import { React } from 'react';
import TeamRadialChart from './TeamRadialChart';

import './MainTeamCard.css'
import LatestMatchTile from './LatestMatchTile';

export const MainTeamCard = ({team}) => {
    if(!team) return null;
    return(
        <div className='main-team-card'>

            <div className='detail-sub-card'>
                <h1 className='team-name'>{team.name}</h1>
                <div className='team-stat'>
                    <div className='team-radial-chart'>
                        <TeamRadialChart team={team}/>
                    </div>                    
                    <div className='stat-details'>
                        <p>Wins : {team.totalWins}</p>
                        <p>Losses : {team.noLosses}</p>
                        <p>Draw : {team.noDraw}</p>
                    </div>
                </div>                
            </div>

            <div className='latest-match-card'>
                <h2 className='latest-match'>Latest Matches</h2>
                <LatestMatchTile teamName={team.name}/>
            </div>

        </div>
    );
}