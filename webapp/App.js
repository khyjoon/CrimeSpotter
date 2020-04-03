import React, {useState} from 'react';
import { 
  StyleSheet, 
  Text, 
  View,
  Image,
  TouchableOpacity,
  ScrollView,
  Button
} from 'react-native';
import InputTextField from "./components/InputTextField";

export default class App extends React.Component {
  
  loginPressButton() {
    console.log("Login time")
  }

  registerPressButton() {
    console.log("Register time")
  }

  render(){
    return (

      <ScrollView>

        <View>
          <View style = {{ marginTop: 10, alignItems: 'center', justifyContent: 'center' }} >
            <Image source = {require("./assets/crimelogo.jpeg")}></Image>
            <Text style = {{marginTop: 10, fontWeight: 'bold', fontSize: 22}}> CrimeSpotter </Text>
          </View>

          <InputTextField title="User name" isSecure={false} placeholderText="Enter User Name"> </InputTextField>
          <InputTextField style={{marginTop: 32, marginBottom: 8}} title="Password" isSecure={true} placeholderText="Enter Password"></InputTextField>

          <View style = {{marginTop: 45, flexDirection: "row", justifyContent: "center"}}>
            <TouchableOpacity style = {styles.loginContainer} onPress={this.loginPressButton}>
              <Text style = {{color: 'white'}}>Login</Text>
            </TouchableOpacity>
            <TouchableOpacity style = {styles.loginContainer} onPress={this.registerPressButton}>
              <Text style = {{color: 'white'}}>Register here</Text>
            </TouchableOpacity>
          </View>
        </View>

      </ScrollView>

    );
  }
}

const styles = StyleSheet.create({
  CrimeSpotterTitle: {
    alignItems:'center',
    fontWeight: 'bold',
  },
  loginContainer: {
    flex: 1,
    backgroundColor: 'red',
    padding: 3,
    borderWidth: 3,
    borderColor: 'pink',
    fontWeight: "300",
    alignItems: 'center',
    justifyContent: 'center',
    shadowColor: "rgba(171, 180, 189, 0.35)",
    shadowOffset: {width: 0, height: 9},
    shadowOpacity: 1,
    shadowRadius: 20,
    elevation: 5
  },
  login: {
    backgroundColor: 'white',
    padding: 1,
  },
  boldText: {
    fontWeight: 'bold',
  },
  buttonContainer: {
    marginTop: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: '#777',
    padding: 8,
    margin: 10,
    width: 200,
  }
});
