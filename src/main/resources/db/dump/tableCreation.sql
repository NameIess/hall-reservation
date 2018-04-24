CREATE TABLE Employee (
	  id 				    INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name		VARCHAR(150) NOT NULL,
    last_name		  VARCHAR(150) NOT NULL,
	personal_number	VARCHAR(255) NOT NULL UNIQUE
) ENGINE = InnoDB;


CREATE TABLE Room (
	  id				    INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    number			  VARCHAR(10) NOT NULL,
    capacity		  SMALLINT UNSIGNED NOT NULL,
    description		VARCHAR(255)
) ENGINE = InnoDB;


CREATE TABLE Reservation (
	  id				    INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    empl_id			  INT UNSIGNED NOT NULL,
    room_id			  INT UNSIGNED NOT NULL,
    start_time	  DATETIME NOT NULL,
    end_time		  DATETIME NOT NULL,
    
    FOREIGN KEY(empl_id) REFERENCES Employee(id),
    FOREIGN KEY(room_id) REFERENCES Room(id)
) ENGINE = InnoDB;