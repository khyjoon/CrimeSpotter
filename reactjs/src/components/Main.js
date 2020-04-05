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
        // latitude: null,
        // longitude: null,
    };

    componentDidMount() {
        // get requests here
        if (navigator.geolocation) {
            navigator.geolocation.watchPosition(position => {
                // this.setState({latitude: (position.coords.latitude).toFixed(3),
                // longitude: (position.coords.longitude).toFixed(3)});
                UserProfile.setLatitude((position.coords.latitude).toFixed(3));
                UserProfile.setLongitude((position.coords.longitude).toFixed(3));
                // console.log("Latitude is :", (position.coords.latitude).toFixed(3));
                // console.log("Longitude is :", (position.coords.longitude).toFixed(3));
                console.log("Latitude is :", UserProfile.getLatitude());
                console.log("Longitude is :", UserProfile.getLongitude());
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

    resetForm = () => {
        document.getElementById("create-form").reset();
    }

    handleCrimeSubmit = event => {
        event.preventDefault();
        const data = new FormData(event.target);
        const form = event.target;

        // Find location ID
        axios.put('http://localhost:8080/event/location', null, {
            params: {
                latitude: Number(UserProfile.getLatitude()),
                longitude: Number(UserProfile.getLongitude()),
                name: form.location.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            UserProfile.setLocationID(res.data[0].locationId)
            // Get event ID
            axios.put('http://localhost:8080/event/crime', null, {
                params: {
                    location_id: UserProfile.getLocationID(),
                    community_id: Number(UserProfile.getCommunityID()),
                    title: form.title.value,
                    severity: form.severity.value,
                    caused_injury: (form.injury.checked) ? 1 : 0,
                    suspect_description: form.description.value,
                    crime_type: form.crimetype.value
                }
            }).then(res => {
                console.log(res);
                console.log(res.data);
                const eventid = res.data[0].eventId;
                // Send Post ID
                axios.put('http://localhost:8080/post', null, {
                    params: {
                        user_id: UserProfile.getID(),
                        event_id: eventid,
                        isActive: true,
                    }
                }).then(res => {
                    console.log(res.data);
                    window.location.reload(false);

                }).catch(err => console.log(err))
            }).catch(err => console.log(err))
        }).catch(err => console.log(err))

    }


    handleNaturalDisasterSubmit = event => {
        event.preventDefault();
        const data = new FormData(event.target);
        const form = event.target;

        // Find location ID
        axios.put('http://localhost:8080/event/location', null, {
            params: {
                latitude: Number(UserProfile.getLatitude()),
                longitude: Number(UserProfile.getLongitude()),
                name: form.location.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            UserProfile.setLocationID(res.data[0].locationId)
            // Get event ID
            axios.put('http://localhost:8080/event/natural_disaster', null, {
                params: {
                    location_id: UserProfile.getLocationID(),
                    community_id: Number(UserProfile.getCommunityID()),
                    title: form.title.value,
                    severity: form.severity.value,
                    caused_injury: (form.injury.checked) ? 1 : 0,
                    type: form.disastertype.value,
                    magnitude: form.magnitude.value
                }
            }).then(res => {
                console.log(res);
                console.log(res.data);
                const eventid = res.data[0].eventId;
                // Send Post ID
                axios.put('http://localhost:8080/post', null, {
                    params: {
                        user_id: UserProfile.getID(),
                        event_id: eventid,
                        isActive: true,
                    }
                }).then(res => {
                    console.log(res.data);
                    window.location.reload(false);
                }).catch(err => console.log(err))
            }).catch(err => console.log(err))
        }).catch(err => console.log(err))       
    }

    handleCarAccidentSubmit = event => {
        event.preventDefault();
        const data = new FormData(event.target);
        const form = event.target;

        // Find location ID
        axios.put('http://localhost:8080/event/location', null, {
            params: {
                latitude: Number(UserProfile.getLatitude()),
                longitude: Number(UserProfile.getLongitude()),
                name: form.location.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            UserProfile.setLocationID(res.data[0].locationId)
            // Get event ID
            axios.put('http://localhost:8080/event/car_accident', null, {
                params: {
                    location_id: UserProfile.getLocationID(),
                    community_id: Number(UserProfile.getCommunityID()),
                    title: form.title.value,
                    severity: form.severity.value,
                    caused_injury: (form.injury.checked) ? 1 : 0,
                    collision_type: form.collisiontype.value,
                    pedestrians_involved: form.pedestrians.value,
                    license: form.licenseplate.value,
                    make: form.carmake.value,
                    model: form.carmodel.value,
                    colour: form.carcolour.value
                }
            }).then(res => {
                console.log(res);
                console.log(res.data);
                const eventid = res.data[0].eventId;
                // Send Post ID
                axios.put('http://localhost:8080/post', null, {
                    params: {
                        user_id: UserProfile.getID(),
                        event_id: eventid,
                        isActive: true,
                    }
                }).then(res => {
                    console.log(res.data);
                    window.location.reload(false);

                }).catch(err => console.log(err))
            }).catch(err => console.log(err))
        }).catch(err => console.log(err))
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
                    Welcome to {UserProfile.getCommunity()}, {UserProfile.getName()}
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
                                    <div>
                                        <textarea id = "location" type = "text" placeholder = "Enter Location Details"/>
                                    </div>
                                    <p> Your latitude is: {Number(UserProfile.getLatitude())} </p>
                                    <p> Your longitude is: {Number(UserProfile.getLongitude())} </p>
                                </div>
                                <div>
                                    <h1 style = {{color:'blue'}}>Details</h1>
                                    <p> Title of Post: 
                                        <input id = "title" type = "text" placeholder = "Enter Post Title here"/> 
                                    </p>
                                    <p> Severity (Out of 10):  
                                        <input id="severity" type = "number" pattern='[0-9]' placeholder = "How severe is the crime?"/>
                                    </p>
                                    <p> Was there injury?:
                                        <input id = "injury" type="checkbox"/>
                                    </p>
                                    <div> Describe the suspect: 
                                        <div>
                                            <textarea id = "description" type = "text" placeholder = "E.g. sex, color of hair, clothing, build"/>
                                        </div>
                                    </div>
                                    <p>Type of crime?: 
                                        <input id = "crimetype" type="text" placeholder = "E.g. theft, assault, arson"/>
                                    </p>
                                </div>
                                <Button variant = "primary" type = "submit" active>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
                        
                    </Popup>

                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Natural Disaster Post</Button>} modal closeOnDocumentClick> 
                        <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            marginTop: '2%',
                            flexDirection: 'column'
                        }}> 
                            <form id = "create-form" onSubmit = {this.handleNaturalDisasterSubmit} style={{marginTop:'1%'}}>
                                <h1 style = {{color:'blue'}}>Location</h1>
                                <div> Where are you right now? 
                                    <div>
                                        <textarea id = "location" type = "text" placeholder = "Enter Location Details"/>
                                    </div>
                                    <p> Your latitude is: {Number(UserProfile.getLatitude())} </p>
                                    <p> Your longitude is: {Number(UserProfile.getLongitude())} </p>
                                </div>
                                <div>
                                    <h1 style = {{color:'blue'}}>Details</h1>
                                    <p> Title of Post: 
                                        <input id = "title" type = "text" placeholder = "Enter Post Title here"/> 
                                    </p>
                                    <p>Severity (Out of 10):  
                                        <input id="severity" type = "number" pattern='[0-9]' placeholder = "How severe is the accident?"/>
                                    </p>
                                    <p>Was there injury?:
                                        <input id = "injury" type="checkbox"/>
                                    </p>
                                    <p>Type of Disaster:
                                        <input id = "disastertype" type = "text" placeholder = "e.g. Earthquake, Hurricane"/> 
                                    </p>
                                    <p>Magnitude (Out of 10):  
                                        <input id="magnitude" type = "number" pattern='[0-9]' placeholder = "What is the scale of disaster?"/>
                                    </p>
                                </div>
                                <Button variant = "primary" type = "submit" active>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
                    </Popup>

                    <Popup trigger={<Button size="lg" onClick={this.resetForm}>Create Car Accident Post</Button>} modal closeOnDocumentClick> 
                    <div style = {{
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            marginTop: '2%',
                            flexDirection: 'column'
                        }}> 
                            <form id = "create-form" onSubmit = {this.handleCarAccidentSubmit} style={{marginTop:'1%'}}>
                                <h1 style = {{color:'blue'}}>Location</h1>
                                <div> Where are you right now? 
                                    <div>
                                        <textarea id = "location" type = "text" placeholder = "Enter Location Details"/>
                                    </div>
                                    <p> Your latitude is: {Number(UserProfile.getLatitude())} </p>
                                    <p> Your longitude is: {Number(UserProfile.getLongitude())} </p>
                                </div>
                                <div>
                                    <h1 style = {{color:'blue'}}>Details</h1>
                                    <p> Title of Post: 
                                        <input id = "title" type = "text" placeholder = "Enter Post Title here"/> 
                                    </p>
                                    <p>Severity (Out of 10):  
                                        <input id="severity" type = "number" pattern='[0-9]' placeholder = "How severe is the accident?"/>
                                    </p>
                                    <p>Was there injury?:
                                        <input id = "injury" type="checkbox"/>
                                    </p>
                                    <p>Describe the collision:
                                        <input id = "collisiontype" type = "text" placeholder = "e.g. T-boned, Rear-ended"/> 
                                    </p>
                                    <p>Pedestrians injured: 
                                        <input id="pedestrians" type = "number" pattern='[0-9]' placeholder = "How many injured?"/>
                                    </p>
                                    <p>License plate number:
                                        <input id = "licenseplate" type = "text" placeholder = "Enter plate number here"/> 
                                    </p>
                                    <p>Make of the car:
                                        <input id = "carmake" type = "text" placeholder = "e.g. Toyota, Volkswagen"/> 
                                    </p>
                                    <p>Model of the car:
                                        <input id = "carmodel" type = "text" placeholder = "e.g. Camry, Jetta"/> 
                                    </p>
                                    <p>Colour of the car:
                                        <input id = "carcolour" type = "text" placeholder = "e.g. Blue, Black, Red, Grey"/> 
                                    </p>
                                </div>
                                <Button variant = "primary" type = "submit" active>
                                    Submit!
                                </Button>
                            </form>                        
                        </div>    
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
                    <ListGroup horizontal>
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