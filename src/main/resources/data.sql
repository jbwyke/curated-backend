INSERT INTO user (first_name, last_name, username, password)
  VALUES 
    ('Ty', 'Johnson', 'tjohnson', 'password'),
    ('Kirk', 'Hahn', 'khahn', 'password'),
    ('Rashid', 'Taleb', 'rtaleb', 'somepass'),
    ('Jacen', 'Wyke', 'jwyke', 'somepass');

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

INSERT INTO genre (name)
  VALUES ('Action'), ('Adventure'), ('Drama'), ('Sci-Fi'), ('Thriller');


INSERT INTO review (user_id, movie_id, rating, recommended, review)
  VALUES
    (1, 'tt4154796', 4, true, 'Was pretty cool'),
    (2, 'tt4154796', 2, false, 'Eh. Not my style'),
    (3, 'tt0083658', 5, true, 'OMG MY FAVORITE MOVIE'),
    (4, 'tt0083658', 1, true, 'This was the worst movie I have ever seen. Def a must watch!');