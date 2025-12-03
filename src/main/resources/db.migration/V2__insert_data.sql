INSERT INTO developer (name, country) VALUES
                                          ('Epic Games', 'USA'),
                                          ('CD Projekt', 'Poland'),
                                          ('Gameloft', 'France');

INSERT INTO platform (name, manufacturer) VALUES
                                              ('PC', 'Various'),
                                              ('PlayStation 5', 'Sony'),
                                              ('Xbox Series X', 'Microsoft');

INSERT INTO game (title, rating, developer_id) VALUES
                                                   ('Fortnite', 8.5, 1),
                                                   ('The Witcher 3', 9.7, 2),
                                                   ('Asphalt 9', 7.8, 3);

INSERT INTO game_platform (game_id, platform_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (1, 3),
                                                     (2, 1),
                                                     (2, 2),
                                                     (3, 1),
                                                     (3, 2),
                                                     (3, 3);