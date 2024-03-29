import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem } from 'react-bootstrap'
import UserProfile from './UserProfile'
import axios from 'axios'
import { useHistory } from 'react-router-dom'

class Community extends Component {
    constructor(props) {
        super(props);
        // this.handleClick = this.handleClick.bind(this);
    }
    state = {
        communities: [],
    };

    componentDidMount() {
        axios.get("http://localhost:8080/users/usercommunity")
            .then(res => {
                console.log(res);
                this.setState({communities: res.data});
            })
    }

    render() {
        const history = this.props.history;

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
                
                <ListGroup variant="flush">
                    {this.state.communities.map(function(d, idx) {

                        return (<ListGroupItem onClick = {() => {
                            UserProfile.setCommunityID(d.communityId);
                            UserProfile.setCommunity(d.name);
                            history.push('/main');
                        }} key={idx}>{d.name}</ListGroupItem>)
                    })}
                </ListGroup>
            </div>
        );
    }
    
}

export default Community;
    