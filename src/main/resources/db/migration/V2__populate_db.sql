INSERT INTO space_travel.client (name)
VALUES ('John Doe'),
       ('Jane Smith'),
       ('Alice Johnson'),
       ('Bob Brown'),
       ('Charlie Davis'),
       ('Diana Miller'),
       ('Eve Wilson'),
       ('Frank Moore'),
       ('Grace Taylor'),
       ('Hannah Anderson');

INSERT INTO space_travel.planet(id, name)
VALUES ('PLNT1', 'Mars'),
       ('PLNT2', 'Venus'),
       ('PLNT3', 'Jupiter'),
       ('PLNT4', 'Saturn'),
       ('PLNT5', 'Earth');

INSERT INTO space_travel.ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2024-11-14 10:00:00', 1, 'PLNT1', 'PLNT2'),
       ('2024-11-14 11:00:00', 2, 'PLNT2', 'PLNT3'),
       ('2024-11-14 12:00:00', 3, 'PLNT3', 'PLNT4'),
       ('2024-11-14 13:00:00', 4, 'PLNT4', 'PLNT5'),
       ('2024-11-14 14:00:00', 5, 'PLNT5', 'PLNT1'),
       ('2024-11-14 15:00:00', 6, 'PLNT1', 'PLNT3'),
       ('2024-11-14 16:00:00', 7, 'PLNT2', 'PLNT5'),
       ('2024-11-14 17:00:00', 8, 'PLNT3', 'PLNT1'),
       ('2024-11-14 18:00:00', 9, 'PLNT4', 'PLNT2'),
       ('2024-11-14 19:00:00', 10, 'PLNT5', 'PLNT4');

