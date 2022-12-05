/*



*/


----------------------- Creation of tables in order (for referential integrity) -----------------------
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
  	aliasName varchar(100) NOT null,
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
  	aliasName varchar(100) NOT null,
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
  	noOfSeason int NOT null,
  	classificationID varchar(100) NOT null,
    PRIMARY KEY(seriesID),
  	FOREIGN KEY(classificationID) REFERENCES CLASSIFICATION(classificationID)
);

-- Season Table
CREATE TABLE SEASON(
    seasonID varchar(100) NOT null UNIQUE,
    title varchar(100) NOT null,
  	description varchar(100) NOT null,
    rating int NOT null,
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
    actorID varchar(100) NOT null UNIQUE,
    nomination varchar(100) NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    PRIMARY KEY(actorID),
  	FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Director Awards Table
CREATE TABLE DIRECTOR_AWARD_RELATION(
    directorID varchar(100) NOT null UNIQUE,
    nomination varchar(100) NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    PRIMARY KEY(directorID),
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
    seriesID varchar(100) NOT null UNIQUE,
    genre varchar(100) NOT null,
    PRIMARY KEY(seriesID)
);

-- Series Languages Table
CREATE TABLE SERIES_LANGUAGE_RELATION(
    seriesID varchar(100) NOT null UNIQUE,
    languageID varchar(100) NOT null,
    PRIMARY KEY(seriesID),
  	FOREIGN KEY(languageID) REFERENCES LANGUAGE(languageID)
);

-- Series Awards Table
CREATE TABLE SERIES_AWARD_RELATION(
    seriesID varchar(100) NOT null UNIQUE,
    nomination varchar(100) NOT null,
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
    movieID varchar(100) NOT null UNIQUE,
    genre varchar(100) NOT null,
    PRIMARY KEY(movieID)
);

-- Movie Languages Table
CREATE TABLE MOVIE_LANGUAGE_RELATION(
    movieID varchar(100) NOT null UNIQUE,
    languageID varchar(100) NOT null,
    PRIMARY KEY(movieID),
  	FOREIGN KEY(languageID) REFERENCES LANGUAGE(languageID)
);

-- Movie Awards Table
CREATE TABLE MOVIE_AWARD_RELATION(
    movieID varchar(100) NOT null UNIQUE,
    nomination varchar(100) NOT null,
    awarded bool NOT null,
  	awardID varchar(100) NOT null,
    PRIMARY KEY(movieID),
  	FOREIGN KEY(awardID) REFERENCES AWARD(awardID)
);

-- Customer and Series Composite Table
CREATE TABLE CUSTOMER_SERIES_RELATION(
    customerID varchar(100) NOT null,
    seriesID varchar(100) NOT null,
    PRIMARY KEY(customerID, seriesID)
);

-- Customer and Movie Composite Table
CREATE TABLE CUSTOMER_MOVIE_RELATION(
    customerID varchar(100) NOT null,
    movieID varchar(100) NOT null,
    PRIMARY KEY(customerID, movieID)
);

-- Series and Actor Composite Table
CREATE TABLE SERIES_ACTOR_RELATION(
    seriesID varchar(100) NOT null,
    actorID varchar(100) NOT null,
    PRIMARY KEY(seriesID, actorID)
);

-- Series and Director Composite Table
CREATE TABLE SERIES_DIRECTOR_RELATION(
    seriesID varchar(100) NOT null,
    directorID varchar(100) NOT null,
    PRIMARY KEY(seriesID, directorID)
);

-- Movie and Actor Composite Table
CREATE TABLE MOVIE_ACTOR_RELATION(
    movieID varchar(100) NOT null,
    actorID varchar(100) NOT null,
    PRIMARY KEY(movieID, actorID)
);

-- Movie and Director Composite Table
CREATE TABLE MOVIE_DIRECTOR_RELATION(
    movieID varchar(100) NOT null,
    directorID varchar(100) NOT null,
    PRIMARY KEY(movieID, directorID)
);

