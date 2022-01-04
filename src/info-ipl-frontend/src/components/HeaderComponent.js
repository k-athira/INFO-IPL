import './HeaderComponent.css';
import infoipllogo from '../new_logo_2022_Jan.png'

import React, { Component } from "react";
import { Link } from 'react-router-dom';

class HeaderComponent extends Component {
    render() {
        return(
            <div className='header'>
                <Link to='/' className='logo'>
                    <img src={infoipllogo} alt='info-ipl-logo'></img>
                </Link>
            </div>            
        );
    }
    
}

export default HeaderComponent;