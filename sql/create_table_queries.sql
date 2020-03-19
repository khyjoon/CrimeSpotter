CREATE TABLE IF NOT EXISTS User (
    user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    password CHAR(36) NOT NULL,
    user_name CHAR(36) NOT NULL,
    user_email CHAR(36) NOT NULL,
    isBanned BIT,
    isAdmin BIT,
    UNIQUE (user_name),
    UNIQUE (user_email)
);

CREATE TABLE IF NOT EXISTS Location (
    location_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    latitude FLOAT(6),
    longitude FLOAT (6)
);

CREATE TABLE IF NOT EXISTS Coordinates (
    latitude FLOAT(6),
    longitude FLOAT (6),
    location_name CHAR(100),
    PRIMARY KEY(latitude, longitude)
);

CREATE TABLE IF NOT EXISTS Community (
    c_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    c_name CHAR(36),
    UNIQUE (c_name)
);

CREATE TABLE IF NOT EXISTS Event (
    event_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    location_id INTEGER NOT NULL,
    c_id INTEGER NOT NULL,
    time TIME,
    tile CHAR(100),
    severity INTEGER,
    caused_injury CHAR(100),
    FOREIGN KEY(location_id) REFERENCES Location(location_id),
    FOREIGN KEY(c_id) REFERENCES Community(c_id)
);

CREATE TABLE IF NOT EXISTS Crime (
    event_id INTEGER NOT NULL,
    suspect_description CHAR(100),
    crime_type CHAR(100),
    PRIMARY KEY(event_id),
    FOREIGN KEY(event_id) REFERENCES Event(event_id)
);

CREATE TABLE IF NOT EXISTS CarAccident(
    event_id INTEGER NOT NULL,
    collision_type CHAR(20),
    pedestrians_involved INTEGER,
    PRIMARY KEY (event_id),
    FOREIGN KEY(event_id) REFERENCES Event(event_id)
);

CREATE TABLE IF NOT EXISTS CarDetails(
    event_id INTEGER,
    license CHAR(10),
    make CHAR(20),
    model CHAR(20),
    colour CHAR(10),
    PRIMARY KEY (event_id, license),
    FOREIGN KEY (event_id) REFERENCES Event(event_id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS NaturalDisaster(
    event_id INTEGER,
    type CHAR(20),
    magnitude INTEGER,
    PRIMARY KEY (event_id),
    FOREIGN KEY(event_id) REFERENCES Event(event_id)
);


CREATE TABLE IF NOT EXISTS Post(
    post_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    event_id INTEGER NOT NULL,
    post_time TIME,
    isActive BIT,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (event_id) REFERENCES Event(event_id),
    UNIQUE (post_time)
);

CREATE TABLE IF NOT EXISTS UserPostComment(
    comment_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER,
    post_id INTEGER,
    content TEXT,
    time TIME,
    UNIQUE (time),
    FOREIGN KEY (user_id)
        REFERENCES User(user_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (post_id)
        REFERENCES Post(post_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS UserCommunity (
    user_id INTEGER NOT NULL,
    c_id INTEGER NOT NULL,
    PRIMARY KEY(user_id, c_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY(c_id) REFERENCES Community(c_id)
);