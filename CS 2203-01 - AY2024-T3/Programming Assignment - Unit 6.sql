-- Build tables for a hospital database

CREATE TABLE Specialty (
    SpecialtyNumber VARCHAR(2) PRIMARY KEY,
    SpecialtyName VARCHAR(255)
);

CREATE TABLE Doctor (
    DoctorID VARCHAR(2) PRIMARY KEY,
    Name VARCHAR(255),
    Phone VARCHAR(255),
    SpecialtyNumber VARCHAR(2),
    Supervisor VARCHAR(2),
    FOREIGN KEY (SpecialtyNumber) REFERENCES Specialty(SpecialtyNumber)
);

CREATE TABLE Patient (
    PatientID VARCHAR(3) PRIMARY KEY,
    DoctorID VARCHAR(2),
    Name VARCHAR(255),
    Phone VARCHAR(255),
    Email VARCHAR(255),
    Address VARCHAR(255),
    AddedDate DATE,
    FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID)
);

CREATE TABLE Appointment (
    AppointmentID VARCHAR(3) PRIMARY KEY,
    PatientID VARCHAR(3),
    DoctorID VARCHAR(2),
    AppointmentDate DATE,
    BloodPressure INT,
    Weight INT,
    TreatmentNotes TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID)
);

CREATE TABLE Allergy (
    AllergyID VARCHAR(3) PRIMARY KEY,
    AllergyName VARCHAR(255)
);

CREATE TABLE PatientAllergy (
    AllergyID VARCHAR(3),
    PatientID VARCHAR(3),
    PRIMARY KEY (AllergyID, PatientID),
    FOREIGN KEY (AllergyID) REFERENCES Allergy(AllergyID),
    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)
);

CREATE TABLE Medicine (
    MedicineID VARCHAR(2) PRIMARY KEY,
    MedicineName VARCHAR(255)
);

CREATE TABLE PatientMedicine (
    AppointmentID VARCHAR(3),
    MedicineID VARCHAR(2),
    PRIMARY KEY (AppointmentID, MedicineID),
    FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID),
    FOREIGN KEY (MedicineID) REFERENCES Medicine(MedicineID)
);

-- Populate the tables with data

INSERT INTO Specialty (SpecialtyNumber, SpecialtyName) VALUES
('S1', 'Dermatology'),
('S2', 'Psychiatry'),
('S3', 'Oncology'),
('S4', 'Cardiology'),
('S5', 'Urology'),
('S6', 'Pediatrics');

INSERT INTO Doctor (DoctorID, Name, Phone, SpecialtyNumber, Supervisor) VALUES
('D1', 'Doctor Karen', '555-1212', 'S6', NULL),
('D2', 'Doctor John', '555-2934', 'S2', 'D1'),
('D3', 'Doctor Robert', '555-6723', 'S6', 'D1'),
('D4', 'Doctor David', '555-1745', 'S4', 'D1'),
('D5', 'Doctor Mary', '555-6565', 'S5', 'D1'),
('D6', 'Doctor Linda', '555-4889', 'S1', 'D1'),
('D7', 'Doctor Susan', '555-4581', 'S3', 'D1'),
('D8', 'Doctor Zeynep', '555-7891', 'S4', 'D1'),
('D9', 'Doctor Mat', '555-7791', 'S1', 'D1');

INSERT INTO Patient (PatientID, DoctorID, Name, Phone, Email, Address, AddedDate) VALUES
('P1', 'D2', 'Patient Dana', '444-1212', 'P1@email.com', '123 Home St.', '2019-02-01'),
('P2', 'D7', 'Patient Harry', '444-2934', 'P2@email.com', '3435 Main St.', '2011-07-13'),
('P3', 'D6', 'Patient Karl', '444-6723', 'P3@email.com', '2176 Baker St.', '2009-05-10'),
('P4', 'D2', 'Patient Sid', '444-1745', 'P4@email.com', '176 Right St.', '2010-06-20'),
('P5', 'D8', 'Patient Marry', '444-6565', 'P5@email.com', '435 Main St.', '2014-05-18'),
('P6', 'D6', 'Patient Kim', '444-4889', 'P6@email.com', '34 Home St.', '2018-03-15'),
('P7', 'D4', 'Patient Susan', '444-4581', 'P7@email.com', '65 Water St.', '2011-09-07'),
('P8', 'D3', 'Patient Sam', '444-7891', 'P8@email.com', '23 Hill Drive', '2010-11-23'),
('P9', 'D5', 'Patient Peter', '444-7791', 'P9@email.com', '12 River St.', '2008-02-01'),
('P10', 'D7', 'Patient Nick', '123-1212', 'P10@email.com', '335 Bay St.', '2011-07-13'),
('P11', 'D9', 'Patient Kyle', '123-2934', 'P11@email.com', '216 Baker St.', '2016-05-10'),
('P12', 'D9', 'Patient Garcia', '123-6723', 'P12@email.com', '176 Right St.', '2010-06-20'),
('P13', 'D4', 'Patient Alicia', '123-1745', 'P13@email.com', '823 Left St.', '2015-05-18'),
('P14', 'D4', 'Patient Dan', '123-6565', 'P14@email.com', '534 High St.', '2018-03-15');

INSERT INTO Appointment (AppointmentID, PatientID, DoctorID, AppointmentDate, BloodPressure, Weight, TreatmentNotes) VALUES
('A1', 'P1', 'D2', '2019-07-01', 80, 65, 'Dream to success'),
('A2', 'P13', 'D4', '2019-01-04', 77, 88, 'Good heart rate'),
('A3', 'P11', 'D9', '2019-03-22', 82, 95, 'Many spots'),
('A4', 'P7', 'D4', '2020-02-01', 85, 74, 'Fast heart rate'),
('A5', 'P9', 'D5', '2019-04-13', 75, 56, 'Reports checked'),
('A6', 'P3', 'D6', '2019-11-12', 81, 96, 'Sun light spots'),
('A7', 'P10', 'D7', '2020-01-29', 80, 87, 'Early treatment'),
('A8', 'P9', 'D5', '2019-08-12', 86, 92, 'Much better'),
('A9', 'P14', 'D4', '2019-05-18', 75, 75, 'Good heart rate'),
('A10', 'P8', 'D3', '2019-11-18', 76, 79, 'New teeth'),
('A11', 'P11', 'D9', '2019-06-22', 78, 71, 'Much better'),
('A12', 'P2', 'D7', '2020-02-21', 82, 86, 'Early treatment'),
('A13', 'P4', 'D2', '2019-08-17', 81, 101, 'Bad dreams'),
('A14', 'P6', 'D6', '2019-06-27', 79, 49, 'Sun light spots'),
('A15', 'P10', 'D7', '2020-07-29', 80, 83, 'Early treatment'),
('A16', 'P7', 'D4', '2020-08-01', 78, 79, 'Good heart rate');

INSERT INTO Allergy (AllergyID, AllergyName) VALUES
('AL1', 'Drug'),
('AL2', 'Food'),
('AL3', 'Skin'),
('AL4', 'Asthma'),
('AL5', 'Rhinitis');

INSERT INTO PatientAllergy (AllergyID, PatientID) VALUES
('AL4', 'P1'),
('AL2', 'P13'),
('AL3', 'P11'),
('AL4', 'P7'),
('AL5', 'P9'),
('AL1', 'P3');

INSERT INTO Medicine (MedicineID, MedicineName) VALUES
('M1', 'Ativan'),
('M2', 'Ibuprofen'),
('M3', 'Omeprazole'),
('M4', 'Metoprolol'),
('M5', 'Azithromycin'),
('M6', 'Codeine');

INSERT INTO PatientMedicine (AppointmentID, MedicineID) VALUES
('A15', 'M1'),
('A2', 'M6'),
('A8', 'M3'),
('A6', 'M3'),
('A15', 'M2'),
('A10', 'M6'),
('A10', 'M2'),
('A4', 'M5'),
('A3', 'M5'),
('A1', 'M2');

-- Query the tables

SELECT * FROM Specialty;

SELECT * FROM Doctor;

SELECT * FROM Patient;

SELECT * FROM Appointment;

SELECT * FROM Allergy;

SELECT * FROM PatientAllergy;

SELECT * FROM Medicine;

SELECT * FROM PatientMedicine;
