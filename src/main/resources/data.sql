INSERT INTO user (first_name, last_name, username, password, email)
  VALUES 
    ('Ty', 'Johnson', 'tjohnson', 'password', 'tj@email.com'),
    ('Kirk', 'Hahn', 'khahn', 'password', 'kh@email.com'),
    ('Rashid', 'Taleb', 'rtaleb', 'somepass', 'rt@email.com'),
    ('Jacen', 'Wyke', 'jwyke', 'somepass', 'jw@email.com');

INSERT INTO movie (id, director, plot, poster, rated, released, title, year)
  VALUES
    ('tt0083658',
    'Ridley Scott', 
    'A blade runner must pursue and terminate four replicants who stole a ship in space, and have returned to Earth to find their creator.', 
    'https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg', 
    'R', 
    '25 Jun 1982', 
    'Blade Runner', 
    '1982'),

    ('tt4154796',
    'Anthony Russo, Joe Russo', 
    'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe.', 
    'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
    'PG-13', 
    '26 Apr 2019', 
    'Avengers: Endgame', 
    '2019');

-- INSERT INTO genre (name)
--   VALUES ('Action'), ('Adventure'), ('Drama'), ('Sci-Fi'), ('Thriller');


INSERT INTO review (user_id, movie_id, rating, recommended, review)
  VALUES
    (1, 'tt4154796', 4, true, 'Was pretty cool'),
    (1, 'tt0083658', 4, true, 'wow'),
    (2, 'tt4154796', 2, false, 'Eh. Not my style'),
    (3, 'tt0083658', 5, true, 'OMG MY FAVORITE MOVIE'),
    (4, 'tt0083658', 1, true, 'This was the worst movie I have ever seen. Def a must watch!');

-- INSERT INTO follow (follower_id, following_id, follow_date)
--   VALUES
--     (1, 2, current_timestamp),
--     (1, 3, current_timestamp),
--     (1, 4, current_timestamp),
--     (2, 1, current_timestamp),
--     (2, 3, current_timestamp),
--     (3, 4, current_timestamp),
--     (3, 2, current_timestamp),
--     (4, 1, current_timestamp),
--     (4, 2, current_timestamp);