import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem, Dropdown } from 'react-bootstrap'
import UserProfile from './UserProfile'
import { CardStack, Card } from 'react-cardstack'
import axios from 'axios'
import Popup from 'reactjs-popup'


class Main extends Component {
    constructor(props) {
        super(props);
    }

    state = {
        eventName: "",
        othertings: [],
    };

    componentDidMount() {
        // get requests here
    }

    filterPosts = () => {
        // filter the post section here
    }

    resetForm = () => {
        document.getElementById("create-form").reset();
    }

    selectPost() {
        return (                   
            <div>
                <p> whaaaaaaaaaaaaaat</p>
                <p> whaaaaaaaaaaaaaaaaaaaaat</p>
            </div>
        );
    }

    handleClick(eventName) {
        if (eventName == "crime") {
            axios.post();
        }
        else if (eventName == "caraccident") {
            axios.post();
        }
        else if (eventName == "disaster") {
            axios.post();
        }
        else {
            alert("Wrong input");
        }
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

                <div style = {{
                    marginTop: '1%'
                }}>
                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Post</Button>} modal closeOnDocumentClick> 
                        {close => (
                        <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            marginTop: '2%',
                            flexDirection: 'column'
                        }}> 
                            {this.selectPost}
                            <form id = "create-form" onSubmit = {this.handleSubmit} style={{marginTop:'1%'}}>

                                {/* <p>
                                    <input id = "name" type = "text" placeholder = "Enter Account Name"/>
                                </p>
                                 */}
                                <Button variant = "primary" type = "submit" active onClick={() => {
                                    this.handleClick(this.state.eventName);
                                    close();
                                    }}>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
                    )}    
                    </Popup>
                </div>
                
                <div style = {{
                    marginTop: '3%',
                }}>
                    <Dropdown>
                        <Dropdown.Toggle variant="danger" id="dropdown-basic">
                            Filter Event Type
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item onClick = {this.filterPosts}>Crime</Dropdown.Item>
                            <Dropdown.Item href="#/action-2">Car Accident</Dropdown.Item>
                            <Dropdown.Item href="#/action-3">Natural Disaster</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>

                <CardStack
                    height={500}
                    width={400}
                    background='#f8f8f8'
                    hoverOffset={25}>
                    <Card background = 'lightblue'>
                        <h1>Post 1</h1>
                    </Card>
                    <Card background = 'lightblue'>
                        <h1>Post 2</h1>
                    </Card>
                </CardStack>

            </div>
        );
    }

}

export default Main