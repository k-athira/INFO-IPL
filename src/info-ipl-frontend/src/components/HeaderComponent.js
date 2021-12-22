import './HeaderComponent.css';

import React, { Component } from "react";
import { NavLink } from 'react-router-dom'

class HeaderComponent extends Component {
    render() {
        return(
            <div className='HeaderComponent'>
                <nav>
                    <NavLink exact activeClassName='active' to="/">
                        <div className='logo_main'>info.ipl</div>
                    </NavLink>
                </nav>
            </div>
            
        );
    }
    
}

export default HeaderComponent;