import React, {Component} from 'react'
import { render } from 'react-dom'

/* To access  */

var UserProfile = (function() {
    var latitude = "";
    var longitude = "";
    var userID = "";
    var userName = "";
    var userEmail = "";
    var userCommunityID = "";
    var userCommunity = "";
    var userPostID = "";
    var userLocationID = "";
    var userIsAdmin ="";

    /* Getters */
    var getLatitude = function() {
        return localStorage.getItem('latitude');
    }
    
    var getLongitude = function() {
        return localStorage.getItem('longitude');
    }

    var getID = function() {
        // return userID;
        return localStorage.getItem('userID');
    };
    var getName = function() {
        // return userName;
        return localStorage.getItem('userName');
    };
    var getEmail = function() {
        // return userEmail;
        return localStorage.getItem('userEmail');
    };
    var getCommunityID = function() {
        // return userCommunityID;
        return localStorage.getItem('userCommunityID');
    };
    var getCommunity = function() {
        // return userCommunity;
        return localStorage.getItem('userCommunity');
    };
    var getPostID = function() {
        // return userPostID;
        return localStorage.getItem('userPostID');
    };
    var getLocationID = function() {
        return localStorage.getItem('userLocationID');
    }
    var getIsAdmin = function() {
        // return userIsAdmin;
        return localStorage.getItem('userIsAdmin');
    };

    /* Setters */
    var setLatitude = function(newLatitude) {
        latitude = newLatitude;
        localStorage.setItem('latitude', newLatitude);
    }

    var setLongitude = function(newLongitude) {
        longitude = newLongitude;
        localStorage.setItem('longitude', newLongitude);
    }

    var setID = function(id) {
        userID = id;
        localStorage.setItem('userID', id);
    };
    var setName = function(name) {
        userName = name;
        localStorage.setItem('userName', name);
    };
    var setEmail = function(email) {
        userEmail = email;
        localStorage.setItem('userEmail', email);
    };
    var setCommunityID = function(cid) {
        userCommunityID = cid;
        localStorage.setItem('userCommunityID', cid);
    };
    var setCommunity = function(community) {
        userCommunity = community;
        localStorage.setItem('userCommunity', community);
    };
    var setPostID = function(postid) {
        userPostID = postid;
        localStorage.setItem('userPostID', postid);
    };
    var setLocationID = function(locationid) {
        userLocationID = locationid;
        localStorage.setItem('userLocationID', locationid);
    }
    var setIsAdmin = function(isAdmin) {
        userIsAdmin = isAdmin;
        localStorage.setItem('userIsAdmin', isAdmin);
    };

    // localStorage solution:
    /* Getters */
    /* Setters */

    return {
        getLatitude: getLatitude,
        getLongitude: getLongitude,
        getID: getID,
        getName: getName,
        getEmail: getEmail,
        getCommunityID: getCommunityID,
        getCommunity: getCommunity,
        getPostID: getPostID,
        getLocationID: getLocationID,
        getIsAdmin: getIsAdmin,

        setLatitude: setLatitude,
        setLongitude: setLongitude,
        setID: setID,
        setName: setName,
        setEmail: setEmail,
        setCommunityID: setCommunityID,
        setCommunity: setCommunity,
        setPostID: setPostID,
        setLocationID: setLocationID,
        setIsAdmin: setIsAdmin
    }
})();

export default UserProfile;