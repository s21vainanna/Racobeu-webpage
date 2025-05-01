-- ievieto sakuma datus datubaze

-- LANGUAGES

-- id: 1
INSERT INTO language (name, language_code) VALUES ('Latviešu', 'lv');
-- id: 2
INSERT INTO language (name, language_code) VALUES ('English', 'en');
-- id: 3
INSERT INTO language (name, language_code) VALUES ('Polski', 'pl');
-- id: 4
INSERT INTO language (name, language_code) VALUES ('Español', 'es');

-- ADMINISTROTORS

INSERT INTO administrators (password, username) VALUES ('admin', 'admin');

-- CATEGORY

-- lv
INSERT INTO category (title, language_id) VALUES ('Par Racobeu', 1);
INSERT INTO category (title, language_id) VALUES ('Nodaļas', 1);
INSERT INTO category (title, language_id) VALUES ('Zinātniskie Pētījumi', 1);
INSERT INTO category (title, language_id) VALUES ('Radioteleskopi', 1);
INSERT INTO category (title, language_id) VALUES ('Radioastronomijas institūcijas', 1);
INSERT INTO category (title, language_id) VALUES ('Pasākumi', 1);
-- en
INSERT INTO category (title, language_id) VALUES ('About Racobeu', 2);
INSERT INTO category (title, language_id) VALUES ('Departments', 2);
INSERT INTO category (title, language_id) VALUES ('Scientific Research', 2);
INSERT INTO category (title, language_id) VALUES ('Radiotelescopes', 2);
INSERT INTO category (title, language_id) VALUES ('RadioAstronomy institutions', 2);
INSERT INTO category (title, language_id) VALUES ('Events', 2);
-- pl
INSERT INTO category (title, language_id) VALUES ('O Racobeu', 3);
INSERT INTO category (title, language_id) VALUES ('Departamenty', 3);
INSERT INTO category (title, language_id) VALUES ('Badania naukowe', 3);
INSERT INTO category (title, language_id) VALUES ('Radioteleskopy', 3);
INSERT INTO category (title, language_id) VALUES ('Instytucje radioastronomiczne', 3);
INSERT INTO category (title, language_id) VALUES ('Wydarzenia', 3);
-- es
INSERT INTO category (title, language_id) VALUES ('Acerca de Racobeu', 4);
INSERT INTO category (title, language_id) VALUES ('Departamentos', 4);
INSERT INTO category (title, language_id) VALUES ('Investigación Científica', 4);
INSERT INTO category (title, language_id) VALUES ('Radiotelescopios', 4);
INSERT INTO category (title, language_id) VALUES ('Instituciones de Radioastronomía', 4);
INSERT INTO category (title, language_id) VALUES ('Eventos', 4);
