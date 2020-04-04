import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem, Dropdown } from 'react-bootstrap'
import UserProfile from './UserProfile'
import { CardStack, Card } from 'react-cardstack'


class Main extends Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        // get requests here
    }

    render() {
        return(
            <div style = {{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                marginTop: '2%',
                flexDirection: 'column',    // stack items vertically!
            }}>

                <h1 style = {{
                    color:'blue',
                }}>
                    {UserProfile.getCommunity()}
                </h1>

                <Dropdown>
                    <Dropdown.Toggle variant="danger" id="dropdown-basic">
                        Event Type
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        <Dropdown.Item onClick = {this.selectFilter}>Crime</Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Car Accident</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Natural Disaster</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
                


                <p>Create Post Button --> Take to Form/Popup</p>

                <p> ScrollView of Posts</p>
                <CardStack
                    height={500}
                    width={400}
                    background='#f8f8f8'
                    hoverOffset={25}>
                    <Card background = '#2980B9'>
                        <h1>Post 1</h1>
                    </Card>
                    <Card background = '#27AE60'>
                        <h1>Post 2</h1>
                    </Card>
                </CardStack>

            </div>
        );
    }

}

export default Main