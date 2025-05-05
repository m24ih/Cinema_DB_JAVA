CREATE DATABASE IF NOT EXISTS cinema_db;
USE cinema_db;

/* cinema_db.Movies  */
CREATE TABLE Movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    genre VARCHAR(100),
    duration INT,
    director VARCHAR(100),
    description TEXT
);

INSERT INTO Movies (title, genre, duration, director, description) VALUES
('The Matrix', 'Sci-Fi', 136, 'Wachowski Sisters', 'A computer hacker learns about the true nature of reality.'),
('Interstellar', 'Sci-Fi', 169, 'Christopher Nolan', 'A team travels through a wormhole in space.'),
('Gladiator', 'Action', 155, 'Ridley Scott', 'A former general seeks revenge in Rome.'),
('Titanic', 'Romance', 195, 'James Cameron', 'A love story aboard the Titanic.'),
('Inception', 'Sci-Fi', 148, 'Christopher Nolan', 'Dream within a dream heist.'),
('The Godfather', 'Crime', 175, 'Francis Ford Coppola', 'The aging patriarch of an organized crime dynasty transfers control to his reluctant son.'),
('Pulp Fiction', 'Crime', 154, 'Quentin Tarantino', 'The lives of two hitmen and others intertwine in a series of incidents.'),
('The Shawshank Redemption', 'Drama', 142, 'Frank Darabont', 'Two imprisoned men bond over a number of years.'),
('The Dark Knight', 'Action', 152, 'Christopher Nolan', 'Batman faces the Joker, a criminal mastermind.'),
('Forrest Gump', 'Drama', 142, 'Robert Zemeckis', 'The story of Forrest Gump, a man with a low IQ who achieves great things.'),
('The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', 178, 'Peter Jackson', 'A hobbit sets out to destroy a powerful ring.'),
('Avatar', 'Sci-Fi', 162, 'James Cameron', 'A marine on an alien planet becomes torn between following orders and protecting the world he feels is his home.'),
('Whiplash', 'Drama', 107, 'Damien Chazelle', 'A young drummer is pushed to the edge by his instructor.'),
('Joker', 'Drama', 122, 'Todd Phillips', 'The origin story of the infamous Batman villain.'),
('Mad Max: Fury Road', 'Action', 120, 'George Miller', 'In a post-apocalyptic world, a woman rebels against a tyrant.');



/* cinema_db.Salons  */
CREATE TABLE Salons (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    capacity INT
);

INSERT INTO Salons (name, capacity) VALUES
('Salon A', 25),
('Salon B', 25),
('Salon C', 30),
('Salon D', 40),
('Salon E', 20),
('Salon F', 50),
('Salon G', 35),
('Salon H', 25),
('Salon I', 60),
('Salon J', 45),
('Salon K', 30),
('Salon L', 40);



/* cinema_db.Seats  */
CREATE TABLE Seats (
    id INT PRIMARY KEY AUTO_INCREMENT,
    salon_id INT,
    seat_row VARCHAR(5),
    number INT,
    FOREIGN KEY (salon_id) REFERENCES Salons(id)
);

-- Salon A: id 1
INSERT INTO Seats (salon_id, seat_row, number)
SELECT 1, CHAR(65 + FLOOR((n-1)/5)), (n-1)%5 + 1
FROM (SELECT @n := @n + 1 AS n FROM (SELECT 0 UNION ALL SELECT 0) t1,
      (SELECT 0 UNION ALL SELECT 0) t2,
      (SELECT 0 UNION ALL SELECT 0) t3,
      (SELECT 0 UNION ALL SELECT 0) t4,
      (SELECT 0 UNION ALL SELECT 0) t5,
      (SELECT 0 UNION ALL SELECT 0) t6,
      (SELECT 0 UNION ALL SELECT 0) t7,
      (SELECT 0 UNION ALL SELECT 0) t8,
      (SELECT 0 UNION ALL SELECT 0) t9,
      (SELECT 0 UNION ALL SELECT 0) t10,
      (SELECT @n := 0) t0
) AS seat_nums
LIMIT 25;

-- Salon B: id 2
INSERT INTO Seats (salon_id, seat_row, number)
SELECT 2, CHAR(65 + FLOOR((n-1)/5)), (n-1)%5 + 1
FROM (SELECT @n := @n + 1 AS n FROM (SELECT 0 UNION ALL SELECT 0) t1,
      (SELECT 0 UNION ALL SELECT 0) t2,
      (SELECT 0 UNION ALL SELECT 0) t3,
      (SELECT 0 UNION ALL SELECT 0) t4,
      (SELECT 0 UNION ALL SELECT 0) t5,
      (SELECT 0 UNION ALL SELECT 0) t6,
      (SELECT 0 UNION ALL SELECT 0) t7,
      (SELECT 0 UNION ALL SELECT 0) t8,
      (SELECT 0 UNION ALL SELECT 0) t9,
      (SELECT 0 UNION ALL SELECT 0) t10,
      (SELECT @n := 0) t0
) AS seat_nums
LIMIT 25;



/* cinema_db.Sessions  */
CREATE TABLE Sessions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id INT,
    salon_id INT,
    session_time DATETIME,
    FOREIGN KEY (movie_id) REFERENCES Movies(id),
    FOREIGN KEY (salon_id) REFERENCES Salons(id)
);

INSERT INTO Sessions (movie_id, salon_id, session_time) VALUES
(1, 1, '2025-05-01 18:00:00'),
(2, 2, '2025-05-01 20:00:00'),
(3, 1, '2025-05-02 18:00:00'),
(4, 2, '2025-05-02 21:00:00'),
(5, 1, '2025-05-03 16:00:00'),
(6, 3, '2025-05-01 19:30:00'),
(7, 4, '2025-05-01 21:00:00'),
(8, 5, '2025-05-02 17:00:00'),
(9, 6, '2025-05-02 20:30:00'),
(10, 7, '2025-05-03 15:00:00'),
(11, 8, '2025-05-03 18:30:00'),
(12, 9, '2025-05-04 20:00:00'),
(13, 10, '2025-05-04 16:00:00'),
(14, 11, '2025-05-05 19:00:00'),
(15, 12, '2025-05-05 21:30:00');



/* cinema_db.Tickets  */
CREATE TABLE Tickets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    session_id INT,
    seat_id INT,
    price DECIMAL(5,2),
    is_sold BOOLEAN,
    FOREIGN KEY (session_id) REFERENCES Sessions(id),
    FOREIGN KEY (seat_id) REFERENCES Seats(id)
);

INSERT INTO Tickets (session_id, seat_id, price, is_sold) VALUES
(1, 1, 10.00, TRUE),
(1, 2, 10.00, FALSE),
(1, 3, 10.00, TRUE),
(3, 4, 11.00, TRUE),
(3, 5, 11.00, TRUE),
(5, 6, 10.00, TRUE),
(6, 7, 11.00, TRUE),
(6, 8, 11.00, TRUE),
(6, 9, 11.00, FALSE),
(7, 10, 13.00, TRUE),
(7, 11, 13.00, FALSE),
(7, 12, 13.00, TRUE),
(8, 13, 10.00, TRUE),
(8, 14, 10.00, FALSE),
(9, 15, 12.00, TRUE),
(9, 16, 12.00, TRUE),
(10, 17, 11.00, FALSE),
(10, 18, 11.00, TRUE);

