import React, { Component } from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Navigation from './components/Navigation';
import Login from './components/Login';
import Community from './components/Community';
import Register from './components/Register';
import Main from './components/Main';
import Namechange from './components/Namechange';

class Routes extends Component {
    render() {
        return (
            <BrowserRouter>
              <Switch>
                <Route path = "/" component = {Login} exact/>
                <Route path = "/community" component = {Community}/>
                <Route path = "/register" component = {Register}/>
                <Route path = "/main" component = {Main}/>
                <Route path = "/namechange" component = {Namechange}/>
                <Route component = {Error}/>                
              </Switch>
            </BrowserRouter>
        )
    }
}

// NOTE: UserProfile may not be implemented

export default Routes;