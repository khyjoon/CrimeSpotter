import React, { Component } from 'react'
import '../App.css'
import { Button, ListGroup, ListGroupItem, Dropdown } from 'react-bootstrap'
import UserProfile from './UserProfile'
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
        posts: [],
        postsFound: [],
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

        axios.get("http://localhost:8080/post", {
            params: {
                post_id: null,
                user_id: null,
                community_id: Number(UserProfile.getCommunityID()),
            }
        }).then(res => {
            console.log(res);
            this.setState({posts: res.data});
        })

        axios.get("http://localhost:8080/post/communitytotal")
        .then(res => {
            this.setState({postsFound: res.data});
        })

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
            alert("sent");
            alert(event.target.title.value);
        }).catch(err => console.log(err))

    }

    handleCarAccidentSubmit = event => {

    }

    handleNaturalDisasterSubmit = event => {
        
    }

    goToCommunity = () => {
        this.props.history.push('/community');
    }

    changeUserName = () => {
        this.props.history.push('/namechange');
    }

    deleteUser = () => {
        axios.delete('http://localhost:8080/users', {
            params: {
                userId: UserProfile.getID(),
            }
        })
        this.props.history.push('/');
    }

    logOut = () => {
        this.props.history.push('/');
    }



    render() {
        const history = this.props.history;

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
                            Menu
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item onClick = {this.goToCommunity}>Back to Community Selection</Dropdown.Item>
                            <Dropdown.Item onClick = {this.changeUserName}>Change User Name</Dropdown.Item>
                            <Dropdown.Item onClick = {this.deleteUser}>Delete User</Dropdown.Item>
                            <Dropdown.Item onClick = {this.logOut}>Log Out</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>

                <ListGroup variant = "primary">
                {this.state.posts.map(function(d,idx) {
                    return (
                        <ListGroupItem background = 'lightblue' key={idx}>
                            
                            {d.eventType == 'crime' &&
                                <div>
                                    <h1>{d.title}</h1>
                                    {/* <p>User: {d.userId}</p> */}
                                    <p>Time of Post: {d.postTime}</p>
                                    <p>Description: {d.suspectDesription}</p>
                                    <p>Crime Type: {d.crimeType}</p>
                                    <p>Severity: {d.severity}</p>
                                    <p>Anybody hurt?: {d.causedInjury ? 'Yes': 'No'}</p>
                                    <Button onClick={() => {
                                        axios.get('http://localhost:8080/users', {
                                            params: {
                                                user_id: d.userId,
                                            }
                                        }).then(res => {
                                            alert("Username: " + res.data[0].userName + "\n" + "Email: " + res.data[0].email);
                                        })
                                    }}>Click for User Info</Button>
                                </div>
                            }
                            
                            
                            {d.eventType == 'car_accident' &&
                                <div>
                                    <h1>{d.title}</h1>
                                    {/* <p>User: {d.userId}</p> */}
                                    <p>Time of Post: {d.postTime}</p>
                                    <p>Collision Type: {d.collisionType}</p>
                                    <p>Pedestrians involved: {d.pedestriansInvolved}</p>
                                    <p>Severity: {d.severity}</p>
                                    <p>Anybody hurt?: {d.causedInjury ? 'Yes': 'No'}</p>
                                    <Button onClick={() => {
                                        axios.get('http://localhost:8080/users', {
                                            params: {
                                                user_id: d.userId,
                                            }
                                        }).then(res => {
                                            alert("Username: " + res.data[0].userName + "\n" + "Email: " + res.data[0].email);
                                        })
                                    }}>Click for User Info</Button>
                                </div>  
                            }
                            
                            {d.eventType =='natural_disaster' &&
                                <div>
                                    <h1>{d.title}</h1>
                                    {/* <p>User: {d.userId}</p> */}
                                    <p>Time of Post: {d.postTime}</p>
                                    <p>Disaster type: {d.type}</p>
                                    <p>Magnitude: {d.magnitude}</p>
                                    <p>Severity: {d.severity}</p>
                                    <p>Anybody hurt?: {d.causedInjury ? 'Yes': 'No'}</p>
                                    <Button onClick={() => {
                                        axios.get('http://localhost:8080/users', {
                                            params: {
                                                user_id: d.userId,
                                            }
                                        }).then(res => {
                                            alert("Username: " + res.data[0].userName + "\n" + "Email: " + res.data[0].email);
                                        })
                                    }}>Click for User Info</Button>
                                </div>
                            }

                        </ListGroupItem>
                    )
                })}
                </ListGroup>
                <div style = {{
                    marginTop: '3%',
                }}>
                    <ListGroup variant = "flush" horizontal>
                    {this.state.postsFound.map(function(d,idx) {
                        return (
                            <ListGroupItem key = {idx}>
                                <div>
                                    <h1>{d.communityName}</h1>
                                    <p>Total # of Posts: {d.totalPosts}</p>
                                </div>

                            </ListGroupItem>
                        )
                    })}
                    </ListGroup>
                </div>
            </div>
        );
    }

}

export default Main