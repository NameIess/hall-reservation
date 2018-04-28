INSERT INTO Employee(first_name, last_name, personal_number) VALUES
	  ('Alex', 'Nosko', 'ANJD97'),
    ('Tinner', 'Turner', 'TTID98'),
    ('Scott', 'Tiger', 'STMD73'),
    ('John', 'Smith', 'JSSD64'),
    ('Peter	', 'Jackson', 'PJMD44'),
    ('Jacky', 'Chan', 'JCMD55'),
    ('Susan', 'Boyle', 'SBI70'),
    ('Lotus', 'Notes', 'LNSD86'),
    ('Henry', 'Dickson', 'HDI79'),
    ('Sam', 'Davis', 'SDPM86'),
    ('Jonathan', 'Davis', 'Korn2000');


INSERT INTO Room(number, capacity, description) VALUES
	  ('A101', 10, 'Interview room'),
    ('A102', 10, 'Interview room'),
    ('A103', 20, 'Meeting room'),
    ('B101', 30, 'Meeting room'),
    ('B102', 35, 'Conference room'),
    ('C101', 20, 'Meeting room'),
    ('C102', 15, 'Interview room'),
    ('C103', 40, 'Presentation room'),
    ('D101', 45, 'Presentation room'),
    ('D102', 70, 'Presentation room');


INSERT INTO Reservation(empl_id, room_id, start_time, end_time) VALUES
	(1, 1, '2018-01-18 10:00:00', '2018-01-18 10:30:00'),
	(3, 1, '2018-04-18 14:00:00', '2018-04-18 15:00:00'),
	(3, 2, '2018-04-18 15:25:00', '2018-04-18 15:30:00'),
	(4, 1, '2018-04-18 15:30:00', '2018-04-18 16:00:00'),
  (5, 1, '2018-04-18 16:00:00', '2018-04-18 17:00:00'),
  (6, 2, '2018-04-18 17:00:00', '2018-04-18 18:00:00'),
  (7, 3, '2018-04-19 10:00:00', '2018-04-19 12:00:00'),
  (8, 3, '2018-04-19 12:00:00', '2018-04-19 12:30:00'),
  (9, 4, '2018-04-19 13:00:00', '2018-04-19 13:30:00'),
  (10, 5, '2018-04-20 11:00:00', '2018-04-20 11:30:00'),
  (10, 5, '2018-04-20 11:30:00', '2018-04-20 11:40:00'),
  (2, 1, '2018-05-18 14:00:00', '2018-05-18 17:30:00');