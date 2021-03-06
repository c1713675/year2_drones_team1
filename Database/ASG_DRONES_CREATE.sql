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
  `Postcode` VARCHAR(10) NULL DEFAULT NULL,
  `City` VARCHAR(80) NULL DEFAULT NULL,
  `Street` VARCHAR(150) NOT NULL,
  `HouseNumber` INT(11) NULL DEFAULT NULL,
  `HouseName` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`AddressID`),
  UNIQUE INDEX `AddressID_UNIQUE` (`AddressID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`creation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`creation` ;

CREATE TABLE IF NOT EXISTS `asg`.`creation` (
  `CreationID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CreationDate` DATETIME NOT NULL,
  `DeletionDate` DATETIME NOT NULL,
  PRIMARY KEY (`CreationID`),
  UNIQUE INDEX `CreationID_UNIQUE` (`CreationID` ASC))
  AUTO_INCREMENT = 9
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


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
  `creation_CreationID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`AdminID`),
  UNIQUE INDEX `AdminID_UNIQUE` (`AdminID` ASC),
  INDEX `fk_administrator_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_administrator_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_administrator_creation1_idx` (`creation_CreationID` ASC),
  CONSTRAINT `fk_administrator_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrator_creation1`
    FOREIGN KEY (`creation_CreationID`)
    REFERENCES `asg`.`creation` (`CreationID`)
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
-- Table `asg`.`qualification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`qualification` ;

CREATE TABLE IF NOT EXISTS `asg`.`qualification` (
  `QualificationID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `QualificationName` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`QualificationID`))
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
  `qualification_QualificationID` INT(10) UNSIGNED NULL DEFAULT NULL,
  `creation_CreationID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`InstructorID`),
  UNIQUE INDEX `InstructorID_UNIQUE` (`InstructorID` ASC),
  INDEX `fk_Instructor_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_instructor_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_instructor_qualification1_idx` (`qualification_QualificationID` ASC),
  INDEX `fk_instructor_creation1_idx` (`creation_CreationID` ASC),
  CONSTRAINT `fk_Instructor_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_creation1`
    FOREIGN KEY (`creation_CreationID`)
    REFERENCES `asg`.`creation` (`CreationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_qualification1`
    FOREIGN KEY (`qualification_QualificationID`)
    REFERENCES `asg`.`qualification` (`QualificationID`)
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
  `CourseDate` DATE NULL DEFAULT NULL,
  `Instructor_InstructorID` INT(10) UNSIGNED NULL DEFAULT NULL,
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
  `Manufacturer` VARCHAR(45) NULL DEFAULT NULL,
  `Model` VARCHAR(45) NULL DEFAULT NULL,
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
  `Disability` TEXT NULL DEFAULT NULL,
  `EnglishSpeakingLevel` FLOAT NULL DEFAULT NULL,
  `PreferredGSLocation` TEXT NULL DEFAULT NULL,
  `Insured` TINYINT(1) NULL DEFAULT NULL,
  `drone_DroneID` INT(10) UNSIGNED NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `course_CourseID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  `creation_CreationID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`CandidateReferenceID`, `creation_CreationID`),
  UNIQUE INDEX `CandidateReferenceID_UNIQUE` (`CandidateReferenceID` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  INDEX `fk_customer_drone1_idx` (`drone_DroneID` ASC),
  INDEX `fk_customer_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_customer_course1_idx` (`course_CourseID` ASC),
  INDEX `fk_customer_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_customer_creation1_idx` (`creation_CreationID` ASC),
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
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_creation1`
    FOREIGN KEY (`creation_CreationID`)
    REFERENCES `asg`.`creation` (`CreationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`materialised_view_user_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`materialised_view_user_report` ;

CREATE TABLE IF NOT EXISTS `asg`.`materialised_view_user_report` (
  `Admins` INT(128) NULL DEFAULT '0',
  `Instructors` INT(128) NULL DEFAULT '0',
  `Customers` INT(128) NULL DEFAULT '0',
  `Updatedon` DATETIME NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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


-- -----------------------------------------------------
-- Table `asg`.`version`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`version` ;

CREATE TABLE IF NOT EXISTS `asg`.`version` (
  `dbversion` INT(10) UNSIGNED NOT NULL,
  `active` TINYINT(4) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`dbversion`),
  UNIQUE INDEX `dbversion_UNIQUE` (`dbversion` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `asg` ;

-- -----------------------------------------------------
-- Placeholder table for view `asg`.`adminadetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`adminadetails` (`Username` INT, `Access` INT, `AdminID` INT, `FirstName` INT, `LastName` INT);

-- -----------------------------------------------------
-- Placeholder table for view `asg`.`customerdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`customerdetails` (`Username` INT, `Access` INT, `CandidateReferenceID` INT, `FirstName` INT, `LastName` INT);

-- -----------------------------------------------------
-- Placeholder table for view `asg`.`instructordetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`instructordetails` (`Username` INT, `Access` INT, `InstructorID` INT, `FirstName` INT, `LastName` INT);

-- -----------------------------------------------------
-- procedure ErrorHandling
-- -----------------------------------------------------

USE `asg`;
DROP procedure IF EXISTS `asg`.`ErrorHandling`;

DELIMITER $$
USE `asg`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ErrorHandling`()
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

-- -----------------------------------------------------
-- View `asg`.`adminadetails`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `asg`.`adminadetails` ;
DROP TABLE IF EXISTS `asg`.`adminadetails`;
USE `asg`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `asg`.`adminadetails` AS select `l`.`Username` AS `Username`,`l`.`Access` AS `Access`,`a`.`AdminID` AS `AdminID`,`a`.`FirstName` AS `FirstName`,`a`.`LastName` AS `LastName` from (`asg`.`administrator` `a` join `asg`.`login` `l` on((`l`.`LoginID` = `a`.`login_LoginID`))) group by `a`.`AdminID`;

-- -----------------------------------------------------
-- View `asg`.`customerdetails`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `asg`.`customerdetails` ;
DROP TABLE IF EXISTS `asg`.`customerdetails`;
USE `asg`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `asg`.`customerdetails` AS select `l`.`Username` AS `Username`,`l`.`Access` AS `Access`,`c`.`CandidateReferenceID` AS `CandidateReferenceID`,`c`.`FirstName` AS `FirstName`,`c`.`LastName` AS `LastName` from (`asg`.`customer` `c` join `asg`.`login` `l` on((`l`.`LoginID` = `c`.`CandidateReferenceID`))) group by `c`.`CandidateReferenceID`;

-- -----------------------------------------------------
-- View `asg`.`instructordetails`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `asg`.`instructordetails` ;
DROP TABLE IF EXISTS `asg`.`instructordetails`;
USE `asg`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `asg`.`instructordetails` AS select `l`.`Username` AS `Username`,`l`.`Access` AS `Access`,`i`.`InstructorID` AS `InstructorID`,`i`.`FirstName` AS `FirstName`,`i`.`LastName` AS `LastName` from (`asg`.`instructor` `i` join `asg`.`login` `l` on((`l`.`LoginID` = `i`.`login_LoginID`))) group by `i`.`InstructorID`;
USE `asg`;

DELIMITER $$

USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`address_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`address_AFTER_INSERT`
AFTER INSERT ON `asg`.`address`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into address table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`address_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`address_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`address`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in address table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`login_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`login_AFTER_INSERT`
AFTER INSERT ON `asg`.`login`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into login table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`login_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`login_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`login`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in login table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`administrator_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`administrator_AFTER_INSERT`
AFTER INSERT ON `asg`.`administrator`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into administrator table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`administrator_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`administrator_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`administrator`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in administrator table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`qualification_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`qualification_AFTER_INSERT`
AFTER INSERT ON `asg`.`qualification`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into qualification table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`qualification_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`qualification_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`qualification`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in qualification table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`instructor_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`instructor_AFTER_INSERT`
AFTER INSERT ON `asg`.`instructor`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into instructor table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`instructor_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`instructor_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`instructor`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in instructor table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`course_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`course_AFTER_INSERT`
AFTER INSERT ON `asg`.`course`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into course table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`course_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`course_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`course`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in course table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`drone_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`drone_AFTER_INSERT`
AFTER INSERT ON `asg`.`drone`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into drone table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`drone_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`drone_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`drone`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in drone table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`customer_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`customer_AFTER_INSERT`
AFTER INSERT ON `asg`.`customer`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into customer table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`customer_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`customer_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`customer`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in customer table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`results_AFTER_INSERT` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`results_AFTER_INSERT`
AFTER INSERT ON `asg`.`results`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Inserting new data into results table');
END IF;

END$$


USE `asg`$$
DROP TRIGGER IF EXISTS `asg`.`results_AFTER_UPDATE` $$
USE `asg`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `asg`.`results_AFTER_UPDATE`
AFTER UPDATE ON `asg`.`results`
FOR EACH ROW
BEGIN

DECLARE oldVersion INTEGER DEFAULT (SELECT dbversion FROM version WHERE active = true);
DECLARE newVersion INTEGER DEFAULT 2;

IF EXISTS (SELECT dbversion FROM version WHERE dbversion = oldVersion AND active = true)
THEN
SET newVersion = oldVersion + 1;
UPDATE version SET active = false WHERE dbversion = oldVersion AND active = true;
INSERT INTO version (dbversion, active, description) VALUES (newversion, true, 'Updating data in results table');
END IF;

END$$CreationID


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


SELECT * FROM address;
select * from creation;
select * from customer;
select * from results;
select * from instructor;
select * from administrator;
select * from qualification;
select * from course;
select * from drone;
select * from login;

