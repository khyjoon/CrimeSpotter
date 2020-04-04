import React, { Component } from 'react'
import '../App.css'
import crimelogo from '../assets/crimelogo.jpeg'
import { Button } from 'react-bootstrap'
import UserProfile from './UserProfile'
import axios from 'axios'

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {id: '', name: '', password: ''};
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    // handleChange = event => {
    //     this.setState({ name: event.target.value, password: event.target.value});
    // }

    componentDidMount() {

    }

    handleSubmit = event => {
        event.preventDefault();
        // TODO: retrieve login and password via HTTP request here;
        // if valid:
        // NOTE: when i implement axios.get, we will use the username/userid/useremail from the http response
        
        axios.get('http://localhost:8080/users', {
            params: {
                user_id:'',
                user_name: event.target.name.value,
                password: event.target.password.value
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            UserProfile.setID(res.data[0].userId);
            UserProfile.setName(res.data[0].userName);
            UserProfile.setEmail(res.data[0].email);

            if (UserProfile.getName() == res.data[0].userName) {
                this.props.history.push('/community');
            }
            else {
                alert("Wrong username or password");
            }
        }).catch(err => {
            console.log(err)
            alert("Wrong username or password");
        })
    }

    registerNewUser = () => {
        this.props.history.push('/register');
    }

    render() {
        return (
            <div style = {{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                marginTop: '2%',
                flexDirection: 'column',    // stack items vertically!
            }}>
                <img src = {crimelogo} />
                <h1 style={{
                    color: 'red',
                    fontFamily: 'Monaco',
                    fontWeight: 'bold',
                    }}>CRIME SPOTTER
                </h1>
                <form onSubmit = {this.handleSubmit} style = {{
                    marginTop: '1%',
                }}>
                    <p>
                        <input id = "name" type = "text" placeholder = "Enter Login Name here"/>
                    </p>
                    <p>
                        <input id = "password" type = "password" placeholder = "Enter Password here" />
                    </p>
                    <p>
                        <Button variant="primary" type = "submit" active>
                            Login!
                        </Button>
                        <Button style={{
                            marginLeft:15,
                        }} variant="secondary" onClick = {this.registerNewUser} active>
                            Register!
                        </Button>
                    </p>
                </form>
            </div>
        );
    }
}

export default Login;