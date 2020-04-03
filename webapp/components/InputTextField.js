import React from "react";
import { 
    StyleSheet,
    View,
    Text,
    TextInput
} from "react-native"

export default class InputTextField extends React.Component {
    render() {
        return (
            <View>
                <Text>{this.props.title}</Text>
                <TextInput 
                    placeholder={this.props.placeholderText}
                    secureTextEntry={this.props.isSecure}
                    />
                <View></View>
            </View>
        );
    }
}