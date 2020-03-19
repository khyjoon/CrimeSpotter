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