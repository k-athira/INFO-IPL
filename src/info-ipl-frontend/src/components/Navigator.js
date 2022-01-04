import './Navigator.css'

import { React } from 'react';

export const Navigator = () => {
    return(
        <div className='nav-bar'>
            <a href='/' className='active'>HOME</a>
            <a href='/teams'>TEAMS</a>
            <a href='/matches'>MATCHES</a>
            <a href='/contact'>CONTACT</a>       
        </div>
    );
    
}