-- TIEP3 Tietokantojen perusteet
-- Harjoitustyö: Liikuntakeskuksen ryhmäliikuntakanta
-- Eveliina Toivanen (eveliina.toivanen@tuni.fi)

CREATE TABLE kategoria(
ktunnus INT, 
knimi VARCHAR(30) NOT NULL,
PRIMARY KEY(ktunnus),
UNIQUE(knimi));

INSERT INTO kategoria VALUES(1, 'Lihaskunto');
INSERT INTO kategoria VALUES(2, 'Kehonhuolto');
INSERT INTO kategoria VALUES(3, 'Spinning');

CREATE TABLE rltunti(
rltunnus INT, 
rlnimi VARCHAR(50) NOT NULL, 
kuvaus VARCHAR(100), 
kesto VARCHAR(10),
taso INT, 
ktunnus INT NOT NULL,
PRIMARY KEY(rltunnus),
UNIQUE(rlnimi),
FOREIGN KEY(ktunnus) REFERENCES kategoria);

INSERT INTO rltunti VALUES(1, 'Muokkaus', 'Muokataan lihaksia', 45, 2, 1);
INSERT INTO rltunti VALUES(2, 'Joogan perusteet', 'Opetellaan joogaa', 50, 1, 2);
INSERT INTO rltunti VALUES(3, 'Jooga 1', 'Jatketaan joogaamista', 50, 2, 2);
INSERT INTO rltunti VALUES(4, 'Pilates 1', 'Opetellaan pilatesta', 60, 2, 2);
INSERT INTO rltunti VALUES(5, 'Spinning alkeet', 'Poljetaan', 60, 1, 3);
INSERT INTO rltunti VALUES(6, 'Spinning Pro', 'Raskaita osuuksia ja tiukkoja spurtteja', 80, 4, 3);

CREATE TABLE ohjaaja(
otunnus INT, 
onimi VARCHAR(50) NOT NULL, 
syntymäaika DATE,
PRIMARY KEY(otunnus));

INSERT INTO ohjaaja VALUES(1, 'Elisa Markkanen', '1986-01-21');
INSERT INTO ohjaaja VALUES(2, 'Eero Ilonen', '1988-03-14');
INSERT INTO ohjaaja VALUES(3, 'Mikko Kontinen', '1977-11-01');

CREATE TABLE voi_ohjata(
otunnus INT, 
rltunnus INT,
PRIMARY KEY(otunnus, rltunnus),
FOREIGN KEY(otunnus) REFERENCES ohjaaja,
FOREIGN KEY(rltunnus) REFERENCES rltunti);

INSERT INTO voi_ohjata VALUES(1, 3);
INSERT INTO voi_ohjata VALUES(1, 5);
INSERT INTO voi_ohjata VALUES(1, 6);
INSERT INTO voi_ohjata VALUES(2, 2);
INSERT INTO voi_ohjata VALUES(2, 3);
INSERT INTO voi_ohjata VALUES(2, 4);
INSERT INTO voi_ohjata VALUES(3, 5);
INSERT INTO voi_ohjata VALUES(3, 6);

CREATE TABLE sali(
stunnus INT, 
snimi VARCHAR(30) NOT NULL, 
paikkalkm INT,
PRIMARY KEY(stunnus),
UNIQUE(snimi));

INSERT INTO sali VALUES(1, 'Sali 1', 25);
INSERT INTO sali VALUES(2, 'Spinning-sali', 20);
INSERT INTO sali VALUES(3, 'Sali 3', 20);

CREATE TABLE ljtunti(
rltunnus INT, 
viikonpaiva VARCHAR(15), 
alkamisaika TIME, 
paattymisaika TIME NOT NULL,
maxosallistujalkm INT NOT NULL, 
otunnus INT NOT NULL, 
stunnus INT NOT NULL,
PRIMARY KEY(rltunnus, viikonpaiva, alkamisaika),
FOREIGN KEY(otunnus) REFERENCES ohjaaja,
FOREIGN KEY(stunnus) REFERENCES sali);

INSERT INTO ljtunti VALUES(3, 'maanantai', '08:10:00', '09:00:00', 10, 1, 3);
INSERT INTO ljtunti VALUES(3, 'maanantai', '13:00:00', '13:50:00', 15, 1, 1);
INSERT INTO ljtunti VALUES(3, 'maanantai', '20:10:00', '21:00:00', 10, 1, 3);
INSERT INTO ljtunti VALUES(3, 'tiistai', '08:10:00', '09:00:00', 15, 2, 1);
INSERT INTO ljtunti VALUES(4, 'maanantai', '08:00:00', '09:00:00', 15, 2, 1);
INSERT INTO ljtunti VALUES(6, 'maanantai', '07:00:00', '08:20:00', 20, 3, 2);
INSERT INTO ljtunti VALUES(5, 'maanantai', '10:45:00', '11:45:00', 20, 3, 2);
INSERT INTO ljtunti VALUES(6, 'perjantai', '14:00:00', '15:20:00', 20, 1, 2);

