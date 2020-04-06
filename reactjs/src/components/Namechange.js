import React, {Component} from 'react'
import { Button } from 'react-bootstrap'
import axios from 'axios'
import UserProfile from './UserProfile';

class Namechange extends Component {
    constructor(props) {
        super(props);
    }

    handleSubmit = event => {
        event.preventDefault();
        // TODO: PUT request for user data
        const data = new FormData(event.target);
        // check all data and see it is correct
        axios.put('http://localhost:8080/users', null, {
            params: {
                old_user_name: event.target.newuser.value,
                new_user_name: event.target.olduser.value,
            }
        }).then(res => {
            console.log(res);
            console.log(res.data);
        }).catch(err => console.log(err))
        alert("Changed name!");
        UserProfile.setName(event.target.newuser.value);
        this.props.history.push('/main');
    }

    goBack = () => {
        this.props.history.push('/main');
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
                        }}>NAME CHANGE FORM
                </h1>
                <form onSubmit = {this.handleSubmit} style={{marginTop:'1%'}}>
                    <p>
                        <input id = "olduser" type = "text" placeholder = "Enter Old Account Name"/>
                    </p>
                    <p>
                        <input id = "newuser" type = "text" placeholder = "Enter New Account Nmae"/>
                    </p>
                    <Button variant = "primary" type = "submit" active>
                        Submit!
                    </Button>
                    <Button style={{
                            marginLeft:15,
                        }} variant="secondary" onClick = {this.goBack} active>
                            Back to Main
                    </Button>
                </form>
            </div>
        );
    }
}

export default Namechange;