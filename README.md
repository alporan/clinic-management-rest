# Clinic Management Appication - Backend

## How to run

You can clone this repository run it from Maven directly using the Spring Boot Maven plugin.
```
./mvnw spring-boot:run
```
Then access application here: http://localhost:8080/


## Database configuration

```
CREATE DATABASE IF NOT EXISTS `clinicdatabase`;


CREATE TABLE IF NOT EXISTS `clinicdatabase`.`patient` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `clinicdatabase`.`doctor` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  

CREATE TABLE IF NOT EXISTS `clinicdatabase`.`appointment` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `patientid` INT NOT NULL,
  `doctorid` INT NOT NULL,
  `appointmentdate` DATE NOT NULL,
  PRIMARY KEY (`id`));
  

ALTER TABLE `appointment` 
    ADD FOREIGN KEY (patientid) REFERENCES `patient`(id);


ALTER TABLE `appointment` 
    ADD FOREIGN KEY (doctorid) REFERENCES `doctor`(id);

```
