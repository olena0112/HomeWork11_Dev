
INSERT INTO client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 2, 'EARTH', 'MARS'),
    (CURRENT_TIMESTAMP, 3, 'VEN', 'EARTH'),
    (CURRENT_TIMESTAMP, 4, 'JUP', 'SAT'),
    (CURRENT_TIMESTAMP, 5, 'SAT', 'MARS'),
    (CURRENT_TIMESTAMP, 6, 'EARTH', 'JUP'),
    (CURRENT_TIMESTAMP, 7, 'MARS', 'EARTH'),
    (CURRENT_TIMESTAMP, 8, 'VEN', 'JUP'),
    (CURRENT_TIMESTAMP, 9, 'SAT', 'VEN'),
    (CURRENT_TIMESTAMP, 10, 'MARS', 'SAT');
