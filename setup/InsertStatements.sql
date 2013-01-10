INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (1, "Hans", "Schuster", "Hschuster", "123456", "hschuster@sks.com");

INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (2, "Lukas", "Heinrich", "Lheinrich", "lheinrich123", "lheinrich@hotmail.com");

INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (3, "Manfred", "Hosentisch", "Mhosentisch", "mhose123", "mhosen@gmail.com");

INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (4, "Stefa", "Pietkovic", "spietko", "123d212", "spietko@hotmail.com");

INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (5, "Richard", "Wagner", "rwagner", "12345551", "rwagner@gmail.com");

INSERT INTO Person (PersonID, Firstname, Nachname, Username, Password, Email)
VALUES (6, "Maximilia", "Voicek", "mvoicek", "123456", "mv@usenet.com");



INSERT INTO Technician (PersonID,
TechnicianID) VALUES (1, 1);

INSERT INTO Technician (PersonID,
TechnicianID) VALUES (2, 2);

INSERT INTO Technician (PersonID,
TechnicianID) VALUES (3, 3);

INSERT INTO MeasurementType (MeasurementTypeID, Minimum, Maximum, Unit)
VALUES (1, -40, 40, "Grad");

INSERT INTO MeasurementType (MeasurementTypeID, Minimum, Maximum, Unit)
VALUES (2, 0, 100, "Liter");

INSERT INTO MeasurementType (MeasurementTypeID, Minimum, Maximum, Unit)
VALUES (3, 0, 100, "Ampere");

INSERT INTO MeasurementType (MeasurementTypeID, Minimum, Maximum, Unit)
VALUES (4, 0, 1000, "Volt");

INSERT INTO Measurement (MeasurementID, Wert, Time, SiteID,
MeasurementTypeID) VALUES (1, 20, CAST(0x00000000000007D1 AS DateTime), 3, 1);

INSERT INTO Measurement (MeasurementID, Wert, Time, SiteID,
MeasurementTypeID) VALUES (3, 3, CAST(0x00009F9800000000 AS DateTime), 2, 2);

INSERT INTO Measurement (MeasurementID, Wert, Time, SiteID,
MeasurementTypeID) VALUES (4, 100, CAST(0x0000A0DF00000000 AS DateTime), 4,
3);

INSERT INTO Measurement (MeasurementID, Wert, Time, SiteID,
MeasurementTypeID) VALUES (5, 721, CAST(0x0000A01100000000 AS DateTime), 4,
4);

INSERT INTO Customer (CustomerID, PersonID, TechnicianID) VALUES (1, 4, 1);

INSERT INTO Customer (CustomerID, PersonID, TechnicianID) VALUES (2, 5, 2);

INSERT INTO Customer (CustomerID, PersonID, TechnicianID) VALUES (3, 6, 1);

INSERT INTO Site (SiteID, Serialnumber, Longitude, Latitude,
Description, CustomerID) VALUES (1, "1", 46.03331, 43.01122, "Gas ASite",
1);

INSERT INTO Site (SiteID, Serialnumber, Longitude, Latitude,
Description, CustomerID) VALUES (2, "2", 41.01112, 40.30331, "Diesel Site",
2);

INSERT INTO Site (SiteID, Serialnumber, Longitude, Latitude,
Description, CustomerID) VALUES (3, "3", 40.0123, 40.1444, "Wasser Boiler",
1);

INSERT INTO Site (SiteID, Serialnumber, Longitude, Latitude,
Description, CustomerID) VALUES (4, "4", 40.0221, 41.2214, "Strom Site", 3);



-- INSERTS INTO MEASUREMENT TABLE FOR SOME DATA
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (1, 1, 1, '2012-11-12 18:50:24.0', 10.0);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (2, 4, 1, '2012-11-12 18:51:09.0', 100.0);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (3, 2, 2, '2013-01-10 16:59:03.0', 4.0);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (4, 1, 1, '2013-01-10 16:59:53.0', 11.0);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (5, 2, 3, '2013-01-10 18:02:56.0', 232.7);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (6, 1, 1, '2013-01-10 19:08:48.0', 50.3);
INSERT INTO sksdb.measurement (`MeasurementID`, `MeasurementTypeID`, `SiteID`, `Time`, `Wert`) VALUES (7, 1, 1, '2013-02-10 19:25:55.0', 1000.0);
