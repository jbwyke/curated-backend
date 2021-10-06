INSERT INTO user (first_name, last_name, username, password)
  VALUES 
    ('Ty', 'Johnson', 'tjohnson', 'password'),
    ('Kirk', 'Hahn', 'khahn', 'password'),
    ('Rashid', 'Taleb', 'rtaleb', 'somepass'),
    ('Jacen', 'Wyke', 'jwyke', 'somepass');

INSERT INTO movie (director, plot, poster, rated, released, title, year)
  VALUES
    ('Joseph D. Kucan', 
    'You play a blade runner investigating a series of violent replicant crimes, only to discover far more than you bargained for.', 
    'https://m.media-amazon.com/images/M/MV5BYWRkYjczZWMtN2Q5NS00YWFmLTk3M2MtNWUwNWRjYzdkMjZhXkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg', 
    'T', 
    '03 Nov 1997', 
    'Blade Runner', 
    '1997'),

    ('Anthony Russo, Joe Russo', 
    'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe.', 
    'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
    'PG-13', 
    '26 Apr 2019', 
    'Avengers: Endgame', 
    '2019');