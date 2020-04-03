import React, {Component} from 'react'
import { Button } from 'react-bootstrap'

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {name: '', password: '', email: ''};
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        // TODO: PUT request for user data
        const data = new FormData(event.target);
        // check all data and see it is correct
        let noduplicateaccount = 1;
        if (noduplicateaccount) {
            this.props.history.push('/');
        }
        else {
            alert('Account already exists!');
        }
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
                </form>
            </div>
        );
    }
}

export default Register;