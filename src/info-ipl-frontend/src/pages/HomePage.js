import './HomePage.css';
import React, { Component } from "react";
import HeaderComponent from "../components/HeaderComponent";
import FooterComponent from "../components/FooterComponent";
import ChampionTile from "../components/ChampionsTile";
import LatestMatchTile from "../components/LatestMatchTile";

class HomePage extends Component {
    render() {
        return(
            <div className="HomePage">
                <div className='header'>
                    <HeaderComponent/>
                </div>
                <div className='ContentHomePage'>
                    <div className='Grid 1'><ChampionTile/></div>
                    <div className='Grid 2'><LatestMatchTile/></div>
                </div>
                <div className='footer'>
                    <FooterComponent/>
                </div>               
            </div>
        );
    }
}

export default HomePage;