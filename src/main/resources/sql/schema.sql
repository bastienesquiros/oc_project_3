CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE UNIQUE INDEX users_email_index ON users (email);

CREATE TABLE rentals (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    surface INTEGER,
    price INTEGER,
    picture VARCHAR(255),
    description TEXT,
    owner_id BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (owner_id) REFERENCES users (id)
);

CREATE TABLE messages (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    rental_id BIGINT,
    message TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (rental_id) REFERENCES rentals (id)
);
