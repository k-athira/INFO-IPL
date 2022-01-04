import './HomePage.css';
import { React }from "react";
import { Navigator } from '../components/Navigator'
import { ChampionsTile } from '../components/ChampionsTile'

export const HomePage = () => {
    return(

        <div className='home-page'>
            <div className='home-nav-bar'>
                <Navigator />
            </div>

            <div className='home-ipl'>
                <p className='home-ipl-about'>
                    IPL is a franchise cricket tournament organised by BCCI.
                </p>

                <div className='home-first-tile'>
                    <ChampionsTile/>
                </div>
            </div>            
        </div>

    );
}