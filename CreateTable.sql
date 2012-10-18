CREATE TABLE Person(
	PersonID bigint PRIMARY KEY NOT NULL,
	Firstname varchar(255) NOT NULL,
	Nachname varchar(255) NOT NULL,
	Username varchar(15) NOT NULL,
	Password varchar(15) NOT NULL,
	Email varchar(255) NOT NULL
);



CREATE TABLE MeasurementType(
	MeasurementTypeID int PRIMARY KEY NOT NULL,
	Minimum bigint NOT NULL,
	Maximum bigint NOT NULL,
	Unit varchar(255) NOT NULL
);



CREATE TABLE Measurement(
	MeasurementID bigint PRIMARY KEY NOT NULL,
	Wert float NOT NULL,
	Time datetime NOT NULL,
	SiteID bigint NOT NULL,
	MeasurementTypeID int NOT NULL
	);



CREATE TABLE Customer(
	CustomerID bigint PRIMARY KEY NOT NULL,
	TechnicianID bigint NOT NULL,
	PersonID bigint NOT NULL
	);



CREATE TABLE Technician(
	TechnicianID bigint PRIMARY KEY NOT NULL,
	PersonID bigint NOT NULL
	);



CREATE TABLE Site(
	Serialnumber varchar(255) NOT NULL,
	Longitude float NOT NULL,
	Latitude float NOT NULL,
	Description varchar(255) NOT NULL,
	CustomerID bigint NOT NULL,
	SiteID bigint PRIMARY KEY NOT NULL
	);

ALTER TABLE Site   ADD  CONSTRAINT FK_Anlage_Kunde FOREIGN KEY(CustomerID)
REFERENCES Customer (CustomerID);

ALTER TABLE Customer   ADD  CONSTRAINT FK_Kunde_Person FOREIGN KEY(PersonID)
REFERENCES Person (PersonID);

ALTER TABLE Customer   ADD  CONSTRAINT FK_Kunde_Techniker FOREIGN KEY(TechnicianID)
REFERENCES Technician (TechnicianID);

ALTER TABLE Measurement   ADD  CONSTRAINT FK_Messwert_Anlage FOREIGN KEY(SiteID)
REFERENCES Site (SiteID);

ALTER TABLE Measurement   ADD  CONSTRAINT FK_Messwert_MesswertTyp FOREIGN KEY(MeasurementTypeID)
REFERENCES MeasurementType (MeasurementTypeID);

ALTER TABLE Technician   ADD  CONSTRAINT FK_Techniker_Person FOREIGN KEY(PersonID)
REFERENCES Person (PersonID);
