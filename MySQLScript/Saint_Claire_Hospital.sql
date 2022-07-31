
-- -----------------------------------------------------
-- Schema Saint_Claire_Hospital
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS Saint_Claire_Hospital ;
CREATE SCHEMA IF NOT EXISTS Saint_Claire_Hospital DEFAULT CHARACTER SET utf8 ;
USE Saint_Claire_Hospital ;

-- -----------------------------------------------------
-- Table physician
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS physician (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table medical_speciality
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS medical_speciality (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  physician_id INT NOT NULL,
  PRIMARY KEY (id, physician_id),
  UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE,
  INDEX fk_medical_speciality_physician1_idx (physician_id ASC) VISIBLE,
  CONSTRAINT fk_medical_speciality_physician1
    FOREIGN KEY (physician_id)
    REFERENCES physician (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table patient
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS patient (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  numb_of_appoints INT NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table appointment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS appointment (
  id INT NOT NULL AUTO_INCREMENT,
  date VARCHAR(300) NULL,
  reason VARCHAR(100) NULL,
  medical_speciality_id INT NOT NULL,
  patient_id INT NOT NULL,
  physician_id INT NOT NULL,
  PRIMARY KEY (id, medical_speciality_id, patient_id, physician_id),
  INDEX fk_appointment_medical_speciality_idx (medical_speciality_id ASC) VISIBLE,
  INDEX fk_appointment_patient1_idx (patient_id ASC) VISIBLE,
  INDEX fk_appointment_physician1_idx (physician_id ASC) VISIBLE,
  CONSTRAINT fk_appointment_medical_speciality
    FOREIGN KEY (medical_speciality_id)
    REFERENCES medical_speciality (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_appointment_patient1
    FOREIGN KEY (patient_id)
    REFERENCES patient (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_appointment_physician1
    FOREIGN KEY (physician_id)
    REFERENCES physician (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



