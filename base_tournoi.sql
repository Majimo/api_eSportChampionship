CREATE DATABASE gestion_tournoi;

USE gestion_tournoi;

CREATE TABLE tournoi(
	id INT IDENTITY PRIMARY KEY,
	jeu VARCHAR(50) NOT NULL,
	nbPlaces INT NOT NULL,
	dateTournoi VARCHAR(50) NOT NULL
);

CREATE TABLE joueur(
	id INT IDENTITY PRIMARY KEY,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	pseudo VARCHAR(50) NOT NULL,
	mail VARCHAR(50) NOT NULL
);

CREATE TABLE joueur_tournoi(
	id INT IDENTITY PRIMARY KEY,
	joueur_id INT FOREIGN KEY (joueur_id) REFERENCES joueur(id),
	tournoi_id INT FOREIGN KEY (tournoi_id) REFERENCES tournoi(id)
);

CREATE TABLE match(
	id INT IDENTITY PRIMARY KEY,
	joueur_1 INT FOREIGN KEY (joueur_1) REFERENCES joueur(id),
	joueur_2 INT FOREIGN KEY (joueur_2) REFERENCES joueur(id),
);

INSERT INTO tournoi VALUES(
	'Street Fighter V',
	128,
	'8 Mai 2018'
);

INSERT INTO tournoi VALUES(
	'Dragon Ball FighterZ',
	128,
	'8 Mai 2018'
);

INSERT INTO tournoi VALUES(
	'Street Fighter 3rd',
	64,
	'9 Mai 2018'
);

ALTER TABLE match
ADD tournoi INT NOT NULL FOREIGN KEY (tournoi) REFERENCES tournoi(id);