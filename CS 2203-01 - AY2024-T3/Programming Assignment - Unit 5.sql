CREATE DATABASE Hospital;

USE Hospital;

CREATE TABLE Specialty (
  Specialty_Number INT AUTO_INCREMENT PRIMARY KEY,
  Specialty_Name VARCHAR(255) NOT NULL
);

CREATE TABLE Doctor (
  Doctor_ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(255) NOT NULL,
  Phone VARCHAR(20),
  Specialty_Number INT,
  FOREIGN KEY (Specialty_Number) REFERENCES Specialty(Specialty_Number)
);

CREATE TABLE Patient (
  Patient_ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(255) NOT NULL,
  Phone VARCHAR(20),
  Email VARCHAR(255),
  Address VARCHAR(255),
  Date_Added DATE NOT NULL
);

CREATE TABLE Appointment (
  Appointment_ID INT AUTO_INCREMENT PRIMARY KEY,
  Appointment_Date DATE NOT NULL,
  Doctor_ID INT NOT NULL,
  Patient_ID INT NOT NULL,
  Blood_Pressure VARCHAR(10),
  Pulse INT,
  Treatment_Notes TEXT,
  FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID),
  FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID)
);

CREATE TABLE Medicine (
  Medicine_ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(255) NOT NULL,
  Description TEXT,
  Cost DECIMAL(10, 2)
);

CREATE TABLE PatientMedicine (
  Patient_ID INT,
  Medicine_ID INT,
  FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
  FOREIGN KEY (Medicine_ID) REFERENCES Medicine(Medicine_ID),
  PRIMARY KEY (Patient_ID, Medicine_ID)
);

CREATE TABLE Allergy (
  Allergy_ID INT AUTO_INCREMENT PRIMARY KEY,
  Allergen VARCHAR(255) NOT NULL,
  Description TEXT
);

CREATE TABLE PatientAllergy (
  Patient_ID INT,
  Allergy_ID INT,
  FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
  FOREIGN KEY (Allergy_ID) REFERENCES Allergy(Allergy_ID),
  PRIMARY KEY (Patient_ID, Allergy_ID)
);
