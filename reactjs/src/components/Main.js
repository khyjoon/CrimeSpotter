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
        this.handleCrimeSubmit = this.handleCrimeSubmit.bind(this);
        this.handleCarAccidentSubmit = this.handleCarAccidentSubmit.bind(this);
        this.handleNaturalDisasterSubmit = this.handleNaturalDisasterSubmit.bind(this);

    }

    state = {
        eventType: null,
        latitude: null,
        longitude: null,
    };

    componentDidMount() {
        // get requests here
        if ("geolocation" in navigator) {
            console.log("Geolocation available!!");
            navigator.geolocation.watchPosition(position => {
                this.setState({latitude: position.coords.latitude,
                longitude: position.coords.longitude});
                console.log("Latitude is :", position.coords.latitude);
                console.log("Longitude is :", position.coords.longitude);
            });
        }
        else {
            console.log("Geolocation not available!!");
        }
        

    }

    filterPosts = () => {
        // filter the post section here
    }

    resetForm = () => {
        document.getElementById("create-form").reset();
    }

    handleCrimeSubmit = event => {
        event.preventDefault();
        const data = new FormData(event.target);
        // alert(event.target.location.value);
        // alert(this.state.latitude + this.state.longitude);
        // alert(event.target.title.value);
        // alert(event.target.severity.value);
        alert((event.target.injury.checked) ? 1 : 0);
        alert(Number(UserProfile.getCommunityID()));
        // alert(event.target.description.value);
        // alert(event.target.crimetype.value);
        
        // Get location ID first:
        axios.put('http://localhost:8080/event/location', null, {
            params: {
                // latitude: this.state.latitude,
                // longitude: this.state.longitude,
                latitude: 778,
                longitude: 797,
                name: event.target.location.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            UserProfile.setLocationID(res.data[0].locationId)

        }).catch(err => console.log(err))

        axios.put('http://localhost:8080/event/crime', null, {
            params: {
                location_id: UserProfile.getLocationID(),
                community_id: Number(UserProfile.getCommunityID()),
                title: event.target.title.value,
                severity: event.target.severity.value,
                caused_injury: (event.target.injury.checked) ? 1 : 0,
                suspect_description: event.target.description.value,
                crime_type: event.target.crimetype.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            alert("WHAATTTTTT");
            alert(event.target.title.value);
        }).catch(err => console.log(err))

    }

    handleCarAccidentSubmit = event => {

    }

    handleNaturalDisasterSubmit = event => {
        
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
                    marginTop: '1%',
                    display: 'flex',
                    flexDirection: 'row',
                }}>
                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Crime Post</Button>} modal closeOnDocumentClick closeOnEscape> 
                        
                        <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            flexDirection: 'column'
                        }}> 
                            <form id = "create-form" onSubmit = {this.handleCrimeSubmit} style={{marginTop:'1%'}}>
                                <h1 style = {{color:'blue'}}>Location</h1>
                                <div> Where are you right now? 
                                    <p>
                                        <textarea id = "location" type = "text" placeholder = "Enter Location Details"/>
                                    </p>
                                    <p> Your latitude is: {this.state.latitude} </p>
                                    <p> Your longitude is: {this.state.longitude} </p>
                                </div>
                                <h1 style = {{color:'blue'}}>Details</h1>
                                <p>
                                    <text>Title of Post: </text>
                                    <input id = "title" type = "text" placeholder = "Enter Post Title here"/>
                                </p>
                                <p>
                                    <text>Severity: </text>
                                    <input id="severity" type = "number" pattern='[0-9]' maxLength='10' placeholder = "How severe is the crime? (Out of 10)"/>
                                </p>
                                <p>
                                    <text>Was there injury?: </text>
                                    <input id = "injury" type="checkbox"/>
                                </p>
                                <p>
                                    <text>Describe the suspect: </text>
                                    <textarea id = "description" type = "text" placeholder = "E.g. sex, color of hair, clothing, build"/>
                                </p>
                                <p>
                                    <text>Type of crime?: </text>
                                    <input id = "crimetype" type="text" placeholder = "E.g. theft, assault, arson"/>
                                </p>
                                <Button variant = "primary" type = "submit" active>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
                        
                    </Popup>

                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Car Accident Post</Button>} modal closeOnDocumentClick> 
                        {close => (
                        <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            marginTop: '2%',
                            flexDirection: 'column'
                        }}> 
                            <form id = "create-form" onSubmit = {this.handleSubmit} style={{marginTop:'1%'}}>
                                <Button variant = "primary" type = "submit" active onClick={() => {
                                    this.state.eventName = "crime";
                                    close();
                                    }}>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
                    )}    
                    </Popup>

                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Natural Disaster Post</Button>} modal closeOnDocumentClick> 
                        {close => (
                        <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            marginTop: '2%',
                            flexDirection: 'column'
                        }}> 
                            <form id = "create-form" onSubmit = {this.handleSubmit} style={{marginTop:'1%'}}>
                                <Button variant = "primary" type = "submit" active onClick={() => {
                                    this.state.eventName = "crime";
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