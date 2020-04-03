import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem } from 'react-bootstrap'
import UserProfile from './UserProfile'
import { CardStack, Card } from 'react-cardstack'

class Main extends Component {
    constructor(props) {
        super(props);
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

                <p> Drop down list here</p>
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