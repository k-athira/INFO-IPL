import './App.css';

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent';

import { TeamList } from './pages/TeamList';
import { HomePage } from './pages/HomePage';
import { TeamPage } from './pages/TeamPage';
import { MatchPage } from './pages/MatchPage';
import { MatchList } from './pages/MatchList';
import { ContactPage } from './pages/Contact';

function App() {
  return (
    <Router>
      <HeaderComponent/>
      <Routes>
        <Route path="/" element={<HomePage/>}></Route>
        <Route path="/teams" element={<TeamList/>}></Route>
        <Route path="/teams/:teamName" element={<TeamPage/>}></Route>
        <Route path="/matches" element={<MatchList/>}></Route>
        <Route path="/matches/:matchId" element={<MatchPage/>}></Route>
        <Route path="/contact" element={<ContactPage/>}></Route>     
      </Routes>
      <FooterComponent/>
    </Router>
  );
}

export default App;