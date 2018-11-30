-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema asg
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `asg` ;

-- -----------------------------------------------------
-- Schema asg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asg` DEFAULT CHARACTER SET latin1 ;
USE `asg` ;

-- -----------------------------------------------------
-- Table `asg`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`address` ;

CREATE TABLE IF NOT EXISTS `asg`.`address` (
  `AddressID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Postcode` VARCHAR(7),
  `City` VARCHAR(80) NULL DEFAULT NULL,
  `Street` VARCHAR(150) NOT NULL,
  `HouseNumber` INT(11) NULL DEFAULT NULL,
  `HouseName` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`AddressID`),
  UNIQUE INDEX `AddressID_UNIQUE` (`AddressID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`login`
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `asg`.`login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`login` ;

CREATE TABLE IF NOT EXISTS `asg`.`login` (
  `LoginID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Access` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`LoginID`),
  UNIQUE INDEX `LoginID_UNIQUE` (`LoginID` ASC),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`administrator` ;

CREATE TABLE IF NOT EXISTS `asg`.`administrator` (
  `AdminID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`AdminID`),
  UNIQUE INDEX `AdminID_UNIQUE` (`AdminID` ASC),
  INDEX `fk_administrator_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_administrator_login1_idx` (`login_LoginID` ASC),
  CONSTRAINT `fk_administrator_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrator_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`instructor` ;
CREATE TABLE IF NOT EXISTS `asg`.`instructor` (
  `InstructorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `PhoneNumber` CHAR(11) NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`InstructorID`),
  UNIQUE INDEX `InstructorID_UNIQUE` (`InstructorID` ASC),
  INDEX `fk_Instructor_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_instructor_login1_idx` (`login_LoginID` ASC),
  CONSTRAINT `fk_Instructor_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`course` ;
CREATE TABLE IF NOT EXISTS `asg`.`course` (
  `CourseID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CourseName` VARCHAR(45) NOT NULL,
  `CourseType` VARCHAR(45) NOT NULL,
  `CourseLocation` VARCHAR(45) NOT NULL,
  `CourseDate` DATE NULL,
  `Instructor_InstructorID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`CourseID`),
  UNIQUE INDEX `CourseID_UNIQUE` (`CourseID` ASC),
  INDEX `fk_course_Instructor1_idx` (`Instructor_InstructorID` ASC),
  CONSTRAINT `fk_course_Instructor1`
    FOREIGN KEY (`Instructor_InstructorID`)
    REFERENCES `asg`.`instructor` (`InstructorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`drone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`drone` ;

CREATE TABLE IF NOT EXISTS `asg`.`drone` (
  `DroneID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Manufacturer` VARCHAR(45) NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DroneID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `asg`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`customer` ;
CREATE TABLE IF NOT EXISTS `asg`.`customer` (
  `CandidateReferenceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Dob` DATE NOT NULL,
  `Email` VARCHAR(128) NOT NULL,
  `PhoneNumber` CHAR(11) NOT NULL,
  `Paid` TINYINT(1) NOT NULL,
  `HoursOfFlying` INT(11) NOT NULL,
  `Disability` TINYTEXT NULL DEFAULT NULL,
  `EnglishSpeakingLevel` FLOAT NULL DEFAULT NULL,
  `PreferredGSLocation` TEXT NOT NULL,
  `Insured` TINYINT(1) NOT NULL,
  `drone_DroneID` INT(10) UNSIGNED NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `course_CourseID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`CandidateReferenceID`),
  UNIQUE INDEX `CandidateReferenceID_UNIQUE` (`CandidateReferenceID` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  INDEX `fk_customer_drone1_idx` (`drone_DroneID` ASC),
  INDEX `fk_customer_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_customer_course1_idx` (`course_CourseID` ASC),
  INDEX `fk_customer_login1_idx` (`login_LoginID` ASC),
  CONSTRAINT `fk_customer_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_course1`
    FOREIGN KEY (`course_CourseID`)
    REFERENCES `asg`.`course` (`CourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_drone1`
    FOREIGN KEY (`drone_DroneID`)
    REFERENCES `asg`.`drone` (`DroneID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`qualification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`qualification` ;
CREATE TABLE IF NOT EXISTS `asg`.`qualification` (
  `QualificationID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `QualificationName` VARCHAR(128) NOT NULL,
  `Instructor_InstructorID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`QualificationID`),
  INDEX `fk_qualification_Instructor1_idx` (`Instructor_InstructorID` ASC),
  CONSTRAINT `fk_qualification_Instructor1`
    FOREIGN KEY (`Instructor_InstructorID`)
    REFERENCES `asg`.`instructor` (`InstructorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`results`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`results` ;
CREATE TABLE IF NOT EXISTS `asg`.`results` (
  `ResultID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Mark` INT(11) NOT NULL,
  `PassFail` TINYINT(1) NOT NULL,
  `TypeOfTest` TEXT NOT NULL,
  `customer_CandidateReferenceID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ResultID`),
  UNIQUE INDEX `ResultID_UNIQUE` (`ResultID` ASC),
  INDEX `fk_Results_customer1_idx` (`customer_CandidateReferenceID` ASC),
  CONSTRAINT `fk_Results_customer1`
    FOREIGN KEY (`customer_CandidateReferenceID`)
    REFERENCES `asg`.`customer` (`CandidateReferenceID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

drop procedure if exists `ErrorHandling`;
Delimiter $$
create procedure ErrorHandling()
BEGIN

DECLARE CONTINUE HANDLER 
    FOR 1292
    SELECT 'The DATE that you provided is in an incorrect format.';
    
DECLARE CONTINUE HANDLER 
	FOR 1062
    SELECT 'You already have a row with this ID in the table.';
    
DECLARE CONTINUE HANDLER 
	FOR 1146
    SELECT 'This table does not exist ';
    
DECLARE CONTINUE HANDLER 
	FOR 1071
    SELECT 'Data entry is too large'; 

DECLARE CONTINUE HANDLER 
	FOR 1059
    SELECT 'Data entry is too long'; 
end$$

DELIMITER ;
  

SELECT * FROM address;
select * from customer;
select * from results;
select * from instructor;
select * from administrator;
select * from qualification;
select * from course;
select * from drone;
select * from login;