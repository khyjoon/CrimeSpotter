import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem } from 'react-bootstrap'
import UserProfile from './UserProfile'
import {useHistory} from 'react-router-dom'

// example community list -- eventually get it from a http request
let communities = [
    'Vancouver',
    'Surrey',
    'Richmond',
    'Downtown',
]

let i;


class Community extends Component {
    constructor(props) {
        super(props);
        // this.handleClick = this.handleClick.bind(this);
    }

    // handleClick(event) {
    //     event.preventDefault;
    //     alert("clicked!");
    //     this.props.history.push('/main');
    // }

    render() {
        const data = [{'name':'Vancouver'}, {'name': 'Richmond'}, {'name': 'Downtown'}];
        // const listItems = data.map((d) => <li key = {d.name}>{d.name}</li>);

        return (
            <div style = {{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                marginTop: '2%',
                flexDirection: 'column',
            }}>                
                <h1 style = {{
                    color:'blue',
                }}>Select Your Community</h1>
                <p>Community drop down menu selector</p>

                <ListGroup variant="flush">
                    {data.map(function(d, idx) {
                        return (<ListGroupItem onClick = {() => {
                            UserProfile.setCommunity(d.name);
                            alert(d.name);
                            // this.props.history.push('/main');
                        }} key={idx}>{d.name}</ListGroupItem>)
                    })}
                </ListGroup>
            </div>
        );
    }
    
}

export default Community;
    