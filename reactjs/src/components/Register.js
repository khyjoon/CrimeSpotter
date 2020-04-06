import React, {Component} from 'react'
import { Button } from 'react-bootstrap'
import axios from 'axios'

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {name: '', password: '', email: ''};
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit = event => {
        event.preventDefault();
        // TODO: PUT request for user data
        const data = new FormData(event.target);
        // check all data and see it is correct
        axios.post('http://localhost:8080/users', null, {
            params: {
                user_name: event.target.name.value,
                password: event.target.password.value,
                user_email: event.target.email.value,
                isAdmin: false
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
            this.props.history.push('/');
        }).catch(err => {
            console.log(err)
            alert("Enter a unique account name or email!")
            window.location.reload(false);
        })
    }


    goBack = () => {
        this.props.history.push('/');
    }

    render() {
        return (
            <div style = {{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                marginTop: '2%',
                flexDirection: 'column'
            }}>
                <h1 style={{
                        color: 'blue',
                        fontFamily: 'Monaco',
                        fontWeight: 'bold',
                        }}>REGISTRATION
                </h1>
                <form onSubmit = {this.handleSubmit} style={{marginTop:'1%'}}>
                    <p>
                        <input id = "name" type = "text" placeholder = "Enter Account Name"/>
                    </p>
                    <p>
                        <input id = "password" type = "password" placeholder = "Enter Account Password"/>
                    </p>
                    <p>
                        <input id = "email" type = "text" placeholder = "Enter Email"/>
                    </p>
                    <Button variant = "primary" type = "submit" active>
                        Submit!
                    </Button>
                    <Button style={{
                            marginLeft:15,
                        }} variant="secondary" onClick = {this.goBack} active>
                            Back to Login
                    </Button>
                </form>
            </div>
        );
    }
}

export default Register;