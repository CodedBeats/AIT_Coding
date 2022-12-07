/*
    ===== Create Tables =====
        Line x - x
    =========================

    ===== Insert data into Tables =====
        Line x - x
    ===================================

    ===== Delete a row from Tables =====
        Line x - x
    ==================================

    ===== Alter a row from Tables =====
        Line x - x
    ==================================

    ===== Add an attribute to Tables =====
        Line x - x
    ==================================
*/

----------------------- Creation of tables -----------------------
-- (In order for referential integrity)

-- Customer Table
CREATE TABLE CUSTOMER(
    customerID varchar(100) NOT null UNIQUE,
    fName varchar(100) NOT null,
    lName varchar(100) NOT null,
    PRIMARY KEY(customerID)
);

-- Payment Details Table
CREATE TABLE PAYMENT_DETAILS(
    payDetID varchar(100) NOT null UNIQUE,
    cardNumber varchar(100) NOT null,
    cardName varchar(100) NOT null,
  	cardExpiry date NOT null,
  	cardType varchar(100) NOT null,
  	customerid varchar(100) NOT null,
    PRIMARY KEY(payDetID),
  	FOREIGN KEY(customerID) REFERENCES CUSTOMER(customerID)
);

-- Subscription Details Table
CREATE TABLE SUBSCRIPTION_DETAILS(
    subDetID varchar(100) NOT null UNIQUE,
    planType varchar(100) NOT null,
    screenCount int NOT null,
  	subExpiry date NOT null,
  	payDetID varchar(100) NOT null,
    PRIMARY KEY(subDetID),
  	FOREIGN KEY(payDetID) REFERENCES PAYMENT_DETAILS(payDetID)
);

-- Address Table
CREATE TABLE ADDRESS(
    addressID varchar(100) NOT null UNIQUE,
    streetNo int NOT null,
    postcode int NOT null,
  	city varchar(100) NOT null,
  	state varchar(100) NOT null,
  	country varchar(100) NOT null,
  	customerID varchar(100) NOT null,
    PRIMARY KEY(addressID),
  	FOREIGN KEY(customerID) REFERENCES CUSTOMER(customerID)
);

-- Gender Table
CREATE TABLE GENDER(
    genderID varchar(100) NOT null UNIQUE,
    gender varchar(100) NOT null,
    PRIMARY KEY(genderID)
);

-- Actor Table
CREATE TABLE ACTOR(
    actorID varchar(100) NOT null UNIQUE,
    fName varchar(100) NOT null,
    lName varchar(100) NOT null,
  	aliasName varchar(100),
  	DoB date NOT null,
  	genderID varchar(100) NOT null,
    PRIMARY KEY(actorID),
  	FOREIGN KEY(genderID) REFERENCES GENDER(genderID)
);

-- Director Table
CREATE TABLE DIRECTOR(
    directorID varchar(100) NOT null UNIQUE,
    fName varchar(100) NOT null,
    lName varchar(100) NOT null,
  	aliasName varchar(100),
  	DoB date NOT null,
  	genderID varchar(100) NOT null,
    PRIMARY KEY(directorID),
  	FOREIGN KEY(genderID) REFERENCES GENDER(genderID)
);

-- Review Table
CREATE TABLE REVIEW(
    reviewID varchar(100) NOT null UNIQUE,
    timeStamp date NOT null,
    content varchar(100) NOT null,
  	author varchar(100) NOT null,
  	rating int NOT null,
    PRIMARY KEY(reviewID)
);

-- Classification Table
CREATE TABLE CLASSIFICATION(
    classificationID varchar(100) NOT null UNIQUE,
    classification varchar(100) NOT null,
    PRIMARY KEY(classificationID)
);

-- Movie Table
CREATE TABLE MOVIE(
    movieID varchar(100) NOT null UNIQUE,
    title varchar(100) NOT null,
    description varchar(100) NOT null,
  	releaseYear date NOT null,
  	nonFiction varchar(100) NOT null,
  	sourceInformation varchar(100) NOT null,
  	classificationID varchar(100) NOT null,
    PRIMARY KEY(movieID),
  	FOREIGN KEY(classificationID) REFERENCES CLASSIFICATION(classificationID)
);

-- Series Table
CREATE TABLE SERIES(
    seriesID varchar(100) NOT null UNIQUE,
    title varchar(100) NOT null,
    description varchar(100) NOT null,
  	releaseYear date NOT null,
  	nonFiction varchar(100) NOT null,
  	sourceInformation varchar(100) NOT null,
  	noOfSeasons int NOT null,
  	classificationID varchar(100) NOT null,
    PRIMARY KEY(seriesID),
  	FOREIGN KEY(classificationID) REFERENCES CLASSIFICATION(classificationID)
);

-- Season Table
CREATE TABLE SEASON(
    seasonID varchar(100) NOT null UNIQUE,
    title varchar(100) NOT null,
  	description varchar(100) NOT null,
    rating float NOT null,
  	seriesID varchar(100) NOT null,
    PRIMARY KEY(seasonID),
  	FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID)
);

-- Episode Table
CREATE TABLE EPISODE(
    episodeID varchar(100) NOT null UNIQUE,
    title varchar(100) NOT null,
  	description varchar(100) NOT null,
    duration int NOT null,
  	seasonID varchar(100) NOT null,
    PRIMARY KEY(episodeID),
  	FOREIGN KEY(seasonID) REFERENCES SEASON(seasonID)
);

-- Language Table
CREATE TABLE LANGUAGE(
    languageID varchar(100) NOT null UNIQUE,
    language varchar(100) NOT null,
    PRIMARY KEY(languageID)
);

-- Award Table
CREATE TABLE AWARD(
    awardID varchar(100) NOT null UNIQUE,
    award varchar(100) NOT null,
    PRIMARY KEY(awardID)
);

-- Actor Awards Table
CREATE TABLE ACTOR_AWARD_RELATION(
    actorID varchar(100) NOT null,
    nomination varchar(100) null,
    awarded varchar(100) null,
  	awardID varchar(100) NOT null,
    FOREIGN KEY (actorID) REFERENCES ACTOR(actorID),
    FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Director Awards Table
CREATE TABLE DIRECTOR_AWARD_RELATION(
    directorID varchar(100) NOT null,
    nomination bool NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    FOREIGN KEY (directorID) REFERENCES DIRECTOR(directorID),
  	FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Series Reviews Table
CREATE TABLE SERIES_REVIEW_RELATION(
    reviewID varchar(100) NOT null UNIQUE,
    seriesID varchar(100) NOT null,
    PRIMARY KEY(reviewID),
  	FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID)
);

-- Series Genres Table
CREATE TABLE SERIES_GENRE_RELATION(
    seriesID varchar(100) NOT null,
    genre varchar(100) NOT null,
    FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID)
);

-- Series Languages Table
CREATE TABLE SERIES_LANGUAGE_RELATION(
    seriesID varchar(100) NOT null,
    languageID varchar(100) NOT null,
    FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID),
  	FOREIGN KEY(languageID) REFERENCES LANGUAGE(languageID)
);

-- Series Awards Table
CREATE TABLE SERIES_AWARD_RELATION(
    seriesID varchar(100) NOT null UNIQUE,
    nomination bool NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    PRIMARY KEY(seriesID),
  	FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Movie Reviews Table
CREATE TABLE MOVIE_REVIEW_RELATION(
    reviewID varchar(100) NOT null UNIQUE,
    movieID varchar(100) NOT null,
    PRIMARY KEY(reviewID),
  	FOREIGN KEY(movieID) REFERENCES MOVIE(movieID)
);

-- Movie Genres Table
CREATE TABLE MOVIE_GENRE_RELATION(
    movieID varchar(100) NOT null,
    genre varchar(100) NOT null,
    FOREIGN KEY(movieID) REFERENCES MOVIE(movieID)
);

-- Movie Languages Table
CREATE TABLE MOVIE_LANGUAGE_RELATION(
    movieID varchar(100) NOT null,
    languageID varchar(100) NOT null,
    FOREIGN KEY(movieID) REFERENCES MOVIE(movieID),
  	FOREIGN KEY(languageID) REFERENCES LANGUAGE(languageID)
);

-- Movie Awards Table
CREATE TABLE MOVIE_AWARD_RELATION(
    movieID varchar(100) NOT null UNIQUE,
    nomination bool NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    PRIMARY KEY(movieID),
  	FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Customer and Series Composite Table
CREATE TABLE CUSTOMER_SERIES_RELATION(
    customerID varchar(100) NOT null,
    seriesID varchar(100) NOT null,
    FOREIGN KEY(customerID) REFERENCES CUSTOMER(customerID),
    FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID)
);

-- Customer and Movie Composite Table
CREATE TABLE CUSTOMER_MOVIE_RELATION(
    customerID varchar(100) NOT null,
    movieID varchar(100) NOT null,
    FOREIGN KEY(customerID) REFERENCES CUSTOMER(customerID),
    FOREIGN KEY(movieID) REFERENCES MOVIE(movieID)
);

-- Series and Actor Composite Table
CREATE TABLE SERIES_ACTOR_RELATION(
    seriesID varchar(100) NOT null,
    actorID varchar(100) NOT null,
    FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID),
    FOREIGN KEY(actorID) REFERENCES ACTOR(actorID)
);

-- Series and Director Composite Table
CREATE TABLE SERIES_DIRECTOR_RELATION(
    seriesID varchar(100) NOT null,
    directorID varchar(100) NOT null,
    FOREIGN KEY(seriesID) REFERENCES SERIES(seriesID),
    FOREIGN KEY(directorID) REFERENCES DIRECTOR(directorID)
);

-- Movie and Actor Composite Table
CREATE TABLE MOVIE_ACTOR_RELATION(
    movieID varchar(100) NOT null,
    actorID varchar(100) NOT null,
    FOREIGN KEY(movieID) REFERENCES MOVIE(movieID),
    FOREIGN KEY(actorID) REFERENCES ACTOR(actorID)
);

-- Movie and Director Composite Table
CREATE TABLE MOVIE_DIRECTOR_RELATION(
    movieID varchar(100) NOT null,
    directorID varchar(100) NOT null,
    FOREIGN KEY(movieID) REFERENCES MOVIE(movieID),
    FOREIGN KEY(directorID) REFERENCES DIRECTOR(directorID)
);
----------------------------------------------------------------------------------









----------------------- Insert data into tables -----------------------
-- (An extra row has been added to all tables for deletion later)

-- Customer data
INSERT INTO CUSTOMER (customerID, fName, lName) VALUES 
("C1", "Barry", "Burton"),
("C2", "Carl", "Hickman"),
("C3", "David", "Day"),
("C4", "Adrian", "Cohen"),
("C5", "Troy", "Payne"),
("C6", "Lois", "Blackburn"),
("C7", "Paula", "Guzman"),
("C8", "Nikki", "Meadow"),
("C9", "Cathy", "Blackmore"),
("C10", "Margo", "Lutz"),
("C11", "Douglass", "Rhealom");

-- Payment Details data
INSERT INTO PAYMENT_DETAILS (payDetID, cardNumber, cardName, cardExpiry, cardType, customerid) VALUES 
("PA1", "1111 1111 1111 1111", "Payne", "01/23", "Credit", "C1"),
("PA2", "2222 2222 2222 2222", "Burton", "01/23", "Debit", "C2"),
("PA3", "3333 3333 3333 3333", "Meadow", "01/24", "Credit", "C3"),
("PA4", "4444 4444 4444 4444", "Cohen", "01/25", "Credit", "C4"),
("PA5", "5555 5555 5555 5555", "Blackmore", "01/24", "Debit", "C5"),
("PA6", "6666 6666 6666 6666", "Hickman", "01/23", "Prepaid", "C6"),
("PA7", "7777 7777 7777 7777", "Lutz", "01/23", "Credit", "C7"),
("PA8", "8888 8888 8888 8888", "Guzman", "01/24", "Debit", "C8"),
("PA9", "9999 9999 9999 9999", "Day", "01/23", "Debit", "C9"),
("PA10", "0101 0101 0101 0101", "Blackburn", "01/23", "Debit", "C10"),
("PA11", "1010 1010 1010 1010", "Rhealom", "01/28", "Prepaid", "C11");

-- Subscription Details data
INSERT INTO SUBSCRIPTION_DETAILS (subDetID, planType, screenCount, subExpiry, payDetID) VALUES 
("SUB1", "Basic", 1, "01/23", "PA6"),
("SUB2", "Premium", 4, "06/23", "PA8"),
("SUB3", "Standard", 2, "06/23", "PA4"),
("SUB4", "Premium", 4, "08/23", "PA7"),
("SUB5", "Basic", 1, "12/22", "PA5"),
("SUB6", "Basic", 1, "12/22", "PA1"),
("SUB7", "Standard", 2, "02/23", "PA10"),
("SUB8", "Premium", 4, "05/23", "PA2"),
("SUB9", "Standard", 2, "06/23", "PA9"),
("SUB10", "Standard", 2, "06/23", "PA3"),
("SUB11", "Basic", 1, "01/23", "PA11");

-- Address data
INSERT INTO ADDRESS (addressID, streetNo, postcode, city, state, country, customerID) VALUES 
("ADD1", 54, 4825, "Brisbane", "QLD", "Australia", "C1"),
("ADD2", 22, 4825, "Canberra", "ACT", "Australia", "C1"),
("ADD3", 46, 4825, "Sydney", "NSW", "Australia", "C3"),
("ADD4", 98, 4825, "Brisbane", "QLD", "Australia", "C4"),
("ADD5", 105, 4825, "Brisbane", "QLD", "Australia", "C5"),
("ADD6", 13, 4825, "Sydney", "NSW", "Australia", "C6"),
("ADD7", 43, 4825, "Sydney", "NSW", "Australia", "C6"),
("ADD8", 75, 4825, "Sydney", "NSW", "Australia", "C8"),
("ADD9", 289, 4825, "Brisbane", "QLD", "Australia", "C9"),
("ADD10", 2, 4825, "Canberra", "ACT", "Australia", "C10"),
("ADD11", 1, 4825, "Brisbane", "QLD", "Australia", "C11");

-- Gender data
INSERT INTO GENDER (genderID, gender) VALUES 
("GE1", "male"),
("GE2", "female"),
("GE3", "other"),
("GE4", "alien");

-- Actor data
INSERT INTO ACTOR (actorID, fName, lName, aliasName, DoB, genderID) VALUES 
("AC1", "Aaron", "Welch", "Welchy", "01/11/1992", "GE1"),
("AC2", "Sophia", "Durham", null, "10/09/1998", "GE2"),
("AC3", "Amanda", "McFlame", null, "03/12/1985", "GE3"),
("AC4", "Ricky", "Holden", null, "19/04/1996", "GE1"),
("AC5", "Ian", "Drake", "Dragon", "17/02/2001", "GE1"),
("AC6", "Tylor", "Tang", null, "09/01/1977", "GE1"),
("AC7", "Luther", "Moran", "Lex", "31/07/1976", "GE1"),
("AC8", "Debra", "Archy", null, "07/12/1970", "GE2"),
("AC9", "Ken", "Hog", null, "13/08/1974", "GE1"),
("AC10", "Wendy", "Feather", null, "06/03/1998", "GE2"),
("AC11", "Moris", "Moss", "Moss", "01/01/2000", "GE4");

-- Director data
INSERT INTO DIRECTOR (directorID, fName, lName, aliasName, DoB, genderID) VALUES 
("D1", "Abraham", "Harrison", "Lincoln", "09/09/1975", "GE1"),
("D2", "Alina", "Person", null, "19/02/1983", "GE1"),
("D3", "Kendra", "Avalos", null, "30/03/2000", "GE1"),
("D4", "Shelbie", "Mercer", null, "07/09/1979", "GE1"),
("D5", "Kai", "Webb", "Kaiza", "16/06/1966", "GE1"),
("D6", "Milly", "Li", null, "20/06/1996", "GE1"),
("D7", "Shannon", "Ellwood", null, "09/12/1986", "GE1"),
("D8", "Gertrude", "Nelson", null, "14/03/1996", "GE1"),
("D9", "Axel", "Bryan", "The Axe", "18/09/1990", "GE1"),
("D10", "Cyrus", "Whitworth", null, "01/07/1992", "GE1"),
("D11", "Roy", "Roy", "Roy", "01/01/2000", "GE1");

-- Review data
INSERT INTO REVIEW (reviewID, timeStamp, content, author, rating) VALUES 
("RE1", "9/23/2020, 7:07:27 PM", "it bad", "Honest Crow", 5),
("RE2", "5/9/2020, 5:22:07 AM", "it not bad", "Lamp Shade", 3),
("RE3", "10/2/2020, 11:03:35 PM", "twas shite", "Night Man", 1),
("RE4", "3/1/2020, 4:36:09 AM", "hated it", "Batman Man", 2),
("RE5", "4/27/2020, 2:10:02 AM", "yeah no", "Legend Pasta", 1),
("RE6", "12/1/2020, 11:41:54 PM", "i was bored", "Tiny Tumor", 5),
("RE7", "6/28/2020, 2:20:00 AM", "was cool", "Cupeth Full", 2),
("RE8", "3/5/2019, 11:02:36 PM", "alright", "Babooshka", 3),
("RE9", "8/28/2021, 2:29:15 AM", "im in love", "Little Bell", 1),
("RE10", "5/14/2020, 9:49:47 PM", "didn't like", "Empty Book", 1),
("RE11", "7/23/2021, 6:23:27 PM", "hell yeah", "Delete Me", 5);

-- Classification data
INSERT INTO CLASSIFICATION (classificationID, classification) VALUES 
("CL1", "E"),
("CL2", "G"),
("CL3", "PG"),
("CL4", "M"),
("CL5", "MA"),
("CL6", "R"),
("CL7", "Hypnotic");

-- Movie data
INSERT INTO MOVIE (movieID, title, description, releaseYear, nonFiction, sourceInformation, classificationID) VALUES 
("M1", "The Shape of Water", "Creepy fish beastiality romance", "2017", "false", "myth", "CL5"),
("M2", "The Imitation Game", "Decipher German code", "2014", "true", "book", "CL3"),
("M3", "Her", "AI romance", "2013", "false", "book", "CL5"),
("M4", "TENET", "Weird time movie", "2020", "false", "movie", "CL4"),
("M5", "A Life on Our Planet", "The wonder of life on Earth", "2020", "true", "documentary", "CL3"),
("M6", "Darkest Hour", "Winston Churchill choice", "2017", "true", "book", "CL3"),
("M7", "BlacKkKlansman", "Detective infiltrate Ku Klux Klan", "2018", "true", "book", "CL5"),
("M8", "Deadpool", "Immortal dream hunk", "2016", "false", "movie", "CL6"),
("M9", "Dune", "Paul likes sand", "2021", "false", "book", "CL4"),
("M10", "Joker", "Trippy villain origin story", "2019", "false", "comic", "C6"),
("M11", "Howl's Movie Castle", "Dream boy magician", "2000", "true", "book", "CL7");

-- Series data
INSERT INTO SERIES (seriesID, title, description, releaseYear, nonFiction, sourceInformation, noOfSeasons, classificationID) VALUES 
("SER1", "Breaking Bad", "Chemist level meth cooking", "2018", "false", "series", 5, "CL5"),
("SER2", "Chernobyl", "Chernobyl meltdown disaster", "2019", "true", "true events", 1, "CL5"),
("SER3", "Game of Thrones", "A world of fire, ice and power", "2011", "false", "book", 8, "CL5"),
("SER4", "Rick and Morty", "Crazy dysfunctional adventures", "2013", "false", "comic", 6, "CL3"),
("SER5", "Sherlock", "High-Functioning Sociopath", "2010", "false", "book", 4, "CL4"),
("SER6", "Better Call Saul", "The criminal's lawyer", "2015", "false", "series", 6, "CL5"),
("SER7", "Black Mirror", "Questioning our potential future", "2011", "false", "series", 5, "CL5"),
("SER8", "South Park", "4 irreverent grade-schoolers", "1997", "false", "comic", 25, "CL5"),
("SER9", "The Boys", "Vigilantes take on superheroes", "2019", "false", "comic", 4, "CL6"),
("SER10", "Stranger Things", "Why haven't people left town???", "2016", "false", "comic", 5, "CL5"),
("SER11", "IT Crowd", "IT bros", "2000", "false", "series", 5, "CL3");

-- Season data
INSERT INTO SEASON (seasonID, title, description, rating, seriesID) VALUES 
("SEA1", "Season 1", "Ned stark becomes the hand of the King", 8.38, "SER3"),
("SEA2", "Season 2", "The start of the war of the 5 Kings", 9.1, "SER3"),
("SEA3", "Season 3", "The end of the war of the 5 Kings	", 8.59, "SER3"),
("SEA4", "Season 1", "A struggling lawyer starts breaking rules	", 8.1, "SER6"),
("SEA5", "Season 2", "Jimmy tries to get fired from a job to keep the bonus	", 8.7, "SER6"),
("SEA6", "Season 3", "Jimmy starts his own Law practice	", 8.75, "SER6"),
("SEA7", "Season 4", "Chuk's death turns 'Jimmy' into 'Saul'", 8.9, "SER6"),
("SEA8", "Season 1", "Kids search for will who is stuck in the upside down", 9, "SER10"),
("SEA9", "Season 2", "The upside down is using Will to invade Hawkins", 7, "SER10"),
("SEA10", "Season 3", "Soviets attempt to open a rift into the upside down", 7, "SER10"),
("SEA11", "Season 1", "An introduction to IT shenanigans", 9.99, "SER11");

-- Episode data
INSERT INTO EPISODE (episodeID, title, description, duration, seasonID) VALUES 
("EP1", "Winter is Coming", "Ned stark is chosen to replace the hand of the King", 68, "SEA1"),
("EP2", "The Wolf and the Lion", "King Robbert wastes the Crown's money foolishly", 62, "SEA1"),
("EP3", "The North Remembers", "A Kingdom in chaos ensues due to the King's Death", 61, "SEA2"),
("EP4", "The Ghost of Harrenhal", "Tyrion investigates the weaponised pig shit", 61, "SEA2"),
("EP5", "Valar Dohaeris", "Jon pretends to join the King beyond the wall", 64, "SEA3"),
("EP6", "Kissed by Fire", "Jon and Ygritte's relationship leads to broken vows", 66, "SEA3"),
("EP7", "Uno", "Jimmy hits a scateboarded who is scamming him", 53, "SEA4"),
("EP8", "Mijo", "Tuco is upset at the twins trying to scam his gm", 46, "SEA4"),
("EP9", "Switch", "Jimmy convinces Kim to run a scam with him", 47, "SEA5"),
("EP10", "Cobbler", "Mike convinces Nacho to do the right thing", 47, "SEA5"),
("EP11", "The Work Outing", "A Gay Musical Called 'Gay'", 25, "SEA11");

-- Language data
INSERT INTO LANGUAGE (languageID, language) VALUES 
("L1", "English"),
("L2", "Russian"),
("L3", "French"),
("L4", "Estonian"),
("L5", "Ukrainian"),
("L6", "Mandarin"),
("L7", "Spanish"),
("L8", "Vietnamese"),
("L9", "Martian");

-- Award data
INSERT INTO AWARD (awardID, award) VALUES 
("AW1", "Emmy Award"),
("AW2", "Gloden Globe Award"),
("AW3", "Academy Award"),
("AW4", "People's Choice Award"),
("AW5", "Tony Award"),
("AW6", "Best Picture Award"),
("AW7", "Best Director Award"),
("AW8", "Best Actor Award"),
("AW9", "Best Actress Award"),
("AW10", "Oscar Award"),
("AW11", "Forgotten Award");

-- Actor Awards data
INSERT INTO ACTOR_AWARD_RELATION (actorID, nomination, awarded, awardID) VALUES 
("AC10", "FALSE", "TRUE", "AW1"),
("AC9", "TRUE", "FALSE", "AW1"),
("AC4", "FALSE", "TRUE", "AW2"),
("AC4", "FALSE", "TRUE", "AW3"),
("AC10", "TRUE", "FALSE", "AW3"),
("AC5", "FALSE", "TRUE", "AW3"),
("AC1", "TRUE", "FALSE", "AW8"),
("AC6", "TRUE", "FALSE", "AW8"),
("AC3", "FALSE", "TRUE", "AW9"),
("AC10", "TRUE", "FALSE", "AW9"),
("AC11", "FALSE", "TRUE", "AW11");

-- Director Awards data
INSERT INTO DIRECTOR_AWARD_RELATION (directorID, nomination, awarded, awardID) VALUES 
("D1", "FALSE", "TRUE", "AW4"),
("D2", "TRUE", "TRUE", "AW4"),
("D3", "TRUE", "FALSE", "AW4"),
("D4", "TRUE", "FALSE", "AW4"),
("D1", "TRUE", "FALSE", "AW5"),
("D7", "FALSE", "TRUE", "AW5"),
("D7", "TRUE", "FALSE", "AW7"),
("D1", "FALSE", "TRUE", "AW7"),
("D2", "FALSE", "TRUE", "AW7"),
("D10", "TRUE", "FALSE", "AW7"),
("D11", "FALSE", "TRUE", "AW11");

-- Series Reviews data
INSERT INTO SERIES_REVIEW_RELATION (reviewID, seriesID) VALUES 
("RE1", "SER1"),
("RE2", "SER1"),
("RE3", "SER1"),
("RE4", "SER2"),
("RE5", "SER5"),
("RE6", "SER5"),
("RE7", "SER5"),
("RE8", "SER5"),
("RE9", "SER5"),
("RE10", "SER9"),
("RE11", "SER11");

-- Series Genres data
INSERT INTO SERIES_GENRE_RELATION (seriesID, genre) VALUES 
("SER1", "Crime"),
("SER1", "Drama"),
("SER1", "Thriller"),
("SER3", "Action"),
("SER3", "Adventure"),
("SER3", "Drama"),
("SER4", "Animation"),
("SER4", "Adventure"),
("SER4", "Comedy"),
("SER5", "Mystery"),
("SER11", "cult");

-- Series Languages data
INSERT INTO SERIES_LANGUAGE_RELATION (seriesID, languageID) VALUES 
("SER4", "L1"),
("SER5", "L1"),
("SER6", "L1"),
("SER6", "L7"),
("SER6", "L8"),
("SER7", "L1"),
("SER8", "L1"),
("SER9", "L1"),
("SER10", "L1"),
("SER10", "L2"),
("SER11", "L1");

-- Series Awards data
INSERT INTO SERIES_AWARD_RELATION (seriesID, nomination, awarded, awardID) VALUES 
("SER1", "FALSE", "TRUE", "AW10"),
("SER2", "TRUE", "FALSE", "AW10"),
("SER3", "FALSE", "TRUE", "AW10"),
("SER4", "TRUE", "FALSE", "AW10"),
("SER5", "FALSE", "TRUE", "AW10"),
("SER6", "TRUE", "FALSE", "AW10"),
("SER7", "TRUE", "FALSE", "AW10"),
("SER8", "TRUE", "FALSE", "AW10"),
("SER9", "TRUE", "FALSE", "AW10"),
("SER10", "FALSE", "TRUE", "AW10"),
("SER11", "TRUE", "FALSE", "AW10");

-- Movie Reviews data
INSERT INTO MOVIE_REVIEW_RELATION (reviewID, movieID) VALUES 
("RE11", "M3"),
("RE12", "M3"),
("RE13", "M3"),
("RE14", "M3"),
("RE15", "M3"),
("RE16", "M3"),
("RE17", "M3"),
("RE18", "M8"),
("RE19", "M10"),
("RE20", "M10"),
("RE21", "M11");

-- Movie Genres data
INSERT INTO MOVIE_GENRE_RELATION (movieID, genre) VALUES 
("M1", "Romance"),
("M1", "Fantasy"),
("M2", "War"),
("M2", "Drama"),
("M3", "Comedy"),
("M3", "Sci-Fi"),
("M6", "War"),
("M6", "Drama"),
("M7", "Comedy"),
("M8", "Comedy"),
("M11", "Cult");

-- Movie Languages data
INSERT INTO MOVIE_LANGUAGE_RELATION (movieID, languageID) VALUES 
("M1", "L1"),
("M1", "L2"),
("M1", "L3"),
("M4", "L1"),
("M4", "L4"),
("M4", "L5"),
("M6", "L3"),
("M8", "L1"),
("M9", "L1"),
("M9", "L6"),
("M11", "L1");

-- Movie Awards data
INSERT INTO MOVIE_AWARD_RELATION (movieID, nomination, awarded, awardID) VALUES 
("M1", "TRUE", "FALSE", "AW6"),
("M2", "FALSE", "TRUE", "AW6"),
("M3", "FALSE", "TRUE", "AW6"),
("M4", "TRUE", "FALSE", "AW6"),
("M5", "TRUE", "FALSE", "AW6"),
("M6", "TRUE", "FALSE", "AW6"),
("M7", "FALSE", "TRUE", "AW6"),
("M8", "TRUE", "FALSE", "AW6"),
("M9", "FALSE", "TRUE", "AW6"),
("M10", "TRUE", "FALSE", "AW6"),
("M11", "TRUE", "TRUE", "AW6");

-- Customer and Series Composite data
INSERT INTO CUSTOMER_SERIES_RELATION (customerID, seriesID) VALUES 
("C1", "SER3"),
("C1", "SER4"),
("C1", "SER5"),
("C2", "SER5"),
("C3", "SER1"),
("C3", "SER2"),
("C4", "SER4"),
("C5", "SER4"),
("C8", "SER1"),
("C8", "SER7"),
("C11", "SER11");

-- Customer and Movie Composite data
INSERT INTO CUSTOMER_MOVIE_RELATION (customerID, movieID) VALUES 
("C1", "M2"),
("C1", "M3"),
("C1", "M9"),
("C2", "M9"),
("C3", "M2"),
("C3", "M7"),
("C4", "M7"),
("C5", "M1"),
("C8", "M2"),
("C8", "M3"),
("C11", "M11");

-- Series and Actor Composite data
INSERT INTO SERIES_ACTOR_RELATION (seriesID, actorID) VALUES 
("SER1", "AC4"),
("SER1", "AC5"),
("SER2", "AC5"),
("SER3", "AC1"),
("SER4", "AC2"),
("SER5", "AC3"),
("SER6", "AC3"),
("SER7", "AC9"),
("SER7", "AC10"),
("SER9", "AC2"),
("SER11", "AC11");

-- Series and Director Composite data
INSERT INTO SERIES_DIRECTOR_RELATION (seriesID, directorID) VALUES 
("SER1", "D2"),
("SER1", "D3"),
("SER2", "D3"),
("SER3", "D1"),
("SER4", "D5"),
("SER5", "D10"),
("SER6", "D10"),
("SER7", "D9"),
("SER7", "D4"),
("SER9", "D2"),
("SER11", "D11");

-- Movie and Actor Composite data
INSERT INTO MOVIE_ACTOR_RELATION (movieID, actorID) VALUES 
("M1", "AC2"),
("M1", "AC9"),
("M2", "AC9"),
("M3", "AC1"),
("M4", "AC2"),
("M5", "AC8"),
("M6", "AC8"),
("M7", "AC9"),
("M9", "AC10"),
("M10", "AC2"),
("M11", "AC11");

-- Movie and Director Composite data
INSERT INTO MOVIE_DIRECTOR_RELATION (movieID, directorID) VALUES 
("M1", "D10"),
("M1", "D7"),
("M2", "D7"),
("M3", "D1"),
("M4", "D5"),
("M5", "D1"),
("M6", "D1"),
("M7", "D4"),
("M9", "D4"),
("M10", "D3"),
("M11", "D11");
----------------------------------------------------------------------------------









----------------------- Delete a single row from each table -----------------------
-- (deleting the added rows from each table)

-- Customer Table
DELETE FROM CUSTOMER
WHERE customerID = "C11";

-- Payment Details Table
DELETE FROM PAYMENT_DETAILS
WHERE payDetID = "PA11";

-- Subscription Details Table
DELETE FROM SUBSCRIPTION_DETAILS
WHERE subDetID = "SUB11";

-- Address Table
DELETE FROM ADDRESS
WHERE addressID = "ADD11";

-- Gender Table
DELETE FROM GENDER
WHERE genderID = "GE4";

-- Actor Table
DELETE FROM ACTOR
WHERE actorID = "AC11";

-- Director Table
DELETE FROM DIRECTOR
WHERE directorID = "D11";

-- Review Table
DELETE FROM REVIEW
WHERE reviewID = "RE11";

-- Classification Table
DELETE FROM CLASSIFICATION
WHERE classificationID = "CL7";

-- Movie Table
DELETE FROM MOVIE
WHERE movieID = "M11";

-- Series Table
DELETE FROM SERIES
WHERE seriesID = "SER11";

-- Season Table
DELETE FROM SEASON
WHERE seasonID = "SEA11";

-- Episode Table
DELETE FROM EPISODE
WHERE episodeID = "EP11";

-- Language Table
DELETE FROM LANGUAGE
WHERE languageID = "L9";

-- Award Table
DELETE FROM AWARD
WHERE awardID = "AW11";

-- Actor Awards Table
DELETE FROM ACTOR_AWARD_RELATION
WHERE actorID = "AC11";

-- Director Awards Table
DELETE FROM DIRECTOR_AWARD_RELATION
WHERE directorID = "D11";

-- Series Reviews Table
DELETE FROM SERIES_REVIEW_RELATION
WHERE reviewID = "RE11";

-- Series Genres Table
DELETE FROM SERIES_GENRE_RELATION
WHERE seriesID = "SER11";

-- Series Languages Table
DELETE FROM SERIES_LANGUAGE_RELATION
WHERE seriesID = "SER11";

-- Series Awards Table
DELETE FROM SERIES_AWARD_RELATION
WHERE seriesID = "SER11";

-- Movie Reviews Table
DELETE FROM MOVIE_REVIEW_RELATION
WHERE reviewID = "RE21";

-- Movie Genres Table
DELETE FROM MOVIE_GENRE_RELATION
WHERE movieID = "M11";

-- Movie Languages Table
DELETE FROM MOVIE_LANGUAGE_RELATION
WHERE movieID = "M11";

-- Movie Awards Table
DELETE FROM MOVIE_AWARD_RELATION
WHERE movieID = "M11";

-- Customer and Series Composite Table
DELETE FROM CUSTOMER_SERIES_RELATION
WHERE customerID = "C11";

-- Customer and Movie Composite Table
DELETE FROM CUSTOMER_MOVIE_RELATION
WHERE customerID = "C11";

-- Series and Actor Composite Table
DELETE FROM SERIES_ACTOR_RELATION
WHERE seriesID = "SER11";

-- Series and Director Composite Table
DELETE FROM SERIES_DIRECTOR_RELATION
WHERE seriesID = "SER11";

-- Movie and Actor Composite Table
DELETE FROM MOVIE_ACTOR_RELATION
WHERE movieID = "M11";

-- Movie and Director Composite Table
DELETE FROM MOVIE_DIRECTOR_RELATION
WHERE movieID = "M11";

----------------------------------------------------------------------------------









----------------------- Update a single row from each table -----------------------
-- (updating row 1 of every table, new values won't corelate with the table or attribute)

-- Customer Table
UPDATE CUSTOMER
SET fName = "Jen", lName = "Barber"
WHERE customerID = "C1";

-- Payment Details Table
UPDATE PAYMENT_DETAILS
SET cardNumber = "9696 9696 9696 9696", cardName = "Barber"
WHERE payDetID = "PA1";

-- Subscription Details Table
UPDATE SUBSCRIPTION_DETAILS
SET planType = "Astronomical", screenCount = 99
WHERE subDetID = "SUB1";

-- Address Table
UPDATE ADDRESS
SET streetNo = 900, postcode = 9001
WHERE addressID = "ADD1";

-- Gender Table
UPDATE GENDER
SET gender = "sheep"
WHERE genderID = "GE1";

-- Actor Table
UPDATE ACTOR
SET fName = "Jim", lName = "Moriorioriorioriaty"
WHERE actorID = "AC1";

-- Director Table
UPDATE DIRECTOR
SET fName = "John", lName = "Snow"
WHERE directorID = "D1";

-- Review Table
UPDATE REVIEW
SET content = "wowowowowow", author = "Ferir"
WHERE reviewID = "RE1";

-- Classification Table
UPDATE CLASSIFICATION
SET classification = "F"
WHERE classificationID = "CL1";

-- Movie Table
UPDATE MOVIE
SET title = "Rhymin crap", description = "Debie Mgee and her other 3"
WHERE movieID = "M1";

-- Series Table
UPDATE SERIES
SET title = "A Game", description = "I'm actually not sure"
WHERE seriesID = "SER1";

-- Season Table
UPDATE SEASON
SET title = "Season -1", description = "Time travel is weird"
WHERE seasonID = "SEA1";

-- Episode Table
UPDATE EPISODE
SET title = "Car Adventure", description = "Daylight robery"
WHERE episodeID = "EP1";

-- Language Table
UPDATE LANGUAGE
SET language = "Swarheelee"
WHERE languageID = "L1";

-- Award Table
UPDATE AWARD
SET award = "Big Guns"
WHERE awardID = "AW1";

-- Actor Awards Table
UPDATE ACTOR_AWARD_RELATION
SET nomination = "FALSE", awarded = "FALSE"
WHERE actorID = "AC10";

-- Director Awards Table
UPDATE DIRECTOR_AWARD_RELATION
SET nomination = "FALSE", awarded = "FALSE"
WHERE directorID = "D1";

-- Series Reviews Table
UPDATE SERIES_REVIEW_RELATION
SET seriesID = "SER2"
WHERE reviewID = "RE1";

-- Series Genres Table
UPDATE SERIES_GENRE_RELATION
SET genre = "Magical"
WHERE seriesID = "SER1";

-- Series Languages Table
UPDATE SERIES_LANGUAGE_RELATION
SET languageID = "L2"
WHERE seriesID = "SER4";

-- Series Awards Table
UPDATE SERIES_AWARD_RELATION
SET nomination = "FALSE", awarded = "FALSE"
WHERE seriesID = "SER1";

-- Movie Reviews Table
UPDATE MOVIE_REVIEW_RELATION
SET movieID = "M2"
WHERE reviewID = "RE11";

-- Movie Genres Table
UPDATE MOVIE_GENRE_RELATION
SET genre = "Propblem Child"
WHERE movieID = "M1";

-- Movie Languages Table
UPDATE MOVIE_LANGUAGE_RELATION
SET languageID = "L2"
WHERE movieID = "M1";

-- Movie Awards Table
UPDATE MOVIE_AWARD_RELATION
SET nomination = "FALSE", awarded = "FALSE"
WHERE movieID = "M1";

-- Customer and Series Composite Table
UPDATE CUSTOMER_SERIES_RELATION
SET seriesID = "SER2"
WHERE customerID = "C1";

-- Customer and Movie Composite Table
UPDATE CUSTOMER_MOVIE_RELATION
SET movieID = "M1"
WHERE customerID = "C1";

-- Series and Actor Composite Table
UPDATE SERIES_ACTOR_RELATION
SET actorID = "AC2"
WHERE seriesID = "SER1";

-- Series and Director Composite Table
UPDATE SERIES_DIRECTOR_RELATION
SET directorID = "D1"
WHERE seriesID = "SER1";

-- Movie and Actor Composite Table
UPDATE MOVIE_ACTOR_RELATION
SET actorID = "AC1"
WHERE movieID = "M1";

-- Movie and Director Composite Table
UPDATE MOVIE_DIRECTOR_RELATION
SET directorID = "D1"
WHERE movieID = "M1";
----------------------------------------------------------------------------------









----------------------- Adding a new attribute to each table -----------------------
-- (attribute names won't correlate with the table)

-- Customer Table

-- Payment Details Table

-- Subscription Details Table

-- Address Table

-- Gender Table

-- Actor Table

-- Director Table

-- Review Table

-- Classification Table

-- Movie Table

-- Series Table

-- Season Table

-- Episode Table

-- Language Table

-- Award Table

-- Actor Awards Table

-- Director Awards Table

-- Series Reviews Table

-- Series Genres Table

-- Series Languages Table

-- Series Awards Table

-- Movie Reviews Table

-- Movie Genres Table

-- Movie Languages Table

-- Movie Awards Table

-- Customer and Series Composite Table

-- Customer and Movie Composite Table

-- Series and Actor Composite Table

-- Series and Director Composite Table

-- Movie and Actor Composite Table

-- Movie and Director Composite Table

----------------------------------------------------------------------------------


