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
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`login`
-- -----------------------------------------------------
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
-- Table `asg`.`Creation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`Creation` (
  `CreationID` INT NOT NULL AUTO_INCREMENT,
  `CreationDate` DATETIME NOT NULL,
  `DeletionDate` DATETIME NOT NULL,
  PRIMARY KEY (`CreationID`),
  UNIQUE INDEX `CreationID_UNIQUE` (`CreationID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asg`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`administrator` (
  `AdminID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  `Creation_CreationID` INT NOT NULL,
  PRIMARY KEY (`AdminID`),
  UNIQUE INDEX `AdminID_UNIQUE` (`AdminID` ASC),
  INDEX `fk_administrator_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_administrator_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_administrator_Creation1_idx` (`Creation_CreationID` ASC),
  CONSTRAINT `fk_administrator_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrator_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrator_Creation1`
    FOREIGN KEY (`Creation_CreationID`)
    REFERENCES `asg`.`Creation` (`CreationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`qualification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`qualification` (
  `QualificationID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `QualificationName` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`QualificationID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`instructor` (
  `InstructorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `PhoneNumber` CHAR(11) NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  `Creation_CreationID` INT NOT NULL,
  `qualification_QualificationID` INT(10) UNSIGNED NULL,
  PRIMARY KEY (`InstructorID`),
  UNIQUE INDEX `InstructorID_UNIQUE` (`InstructorID` ASC),
  INDEX `fk_Instructor_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_instructor_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_instructor_Creation1_idx` (`Creation_CreationID` ASC),
  INDEX `fk_instructor_qualification1_idx` (`qualification_QualificationID` ASC),
  CONSTRAINT `fk_Instructor_address1`
    FOREIGN KEY (`address_AddressID`)
    REFERENCES `asg`.`address` (`AddressID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_login1`
    FOREIGN KEY (`login_LoginID`)
    REFERENCES `asg`.`login` (`LoginID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_Creation1`
    FOREIGN KEY (`Creation_CreationID`)
    REFERENCES `asg`.`Creation` (`CreationID`)
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
CREATE TABLE IF NOT EXISTS `asg`.`course` (
  `CourseID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `CourseName` VARCHAR(45) NOT NULL,
  `CourseType` VARCHAR(45) NOT NULL,
  `CourseLocation` VARCHAR(45) NOT NULL,
  `CourseDate` DATE NULL DEFAULT NULL,
  `Instructor_InstructorID` INT(10) UNSIGNED NULL,
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
CREATE TABLE IF NOT EXISTS `asg`.`drone` (
  `DroneID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Manufacturer` VARCHAR(45) NULL,
  `Model` VARCHAR(45) NULL,
  PRIMARY KEY (`DroneID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asg`.`customer` (
  `CandidateReferenceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Dob` DATE NOT NULL,
  `Email` VARCHAR(128) NOT NULL,
  `PhoneNumber` CHAR(11) NOT NULL,
  `Paid` TINYINT(1) NOT NULL,
  `HoursOfFlying` INT(11) NOT NULL,
  `Disability` TEXT NULL,
  `EnglishSpeakingLevel` FLOAT NULL,
  `PreferredGSLocation` TEXT NULL,
  `Insured` TINYINT(1) NULL,
  `drone_DroneID` INT(10) UNSIGNED NOT NULL,
  `address_AddressID` INT(10) UNSIGNED NOT NULL,
  `course_CourseID` INT(10) UNSIGNED NOT NULL,
  `login_LoginID` INT(10) UNSIGNED NOT NULL,
  `Creation_CreationID` INT NOT NULL,
  PRIMARY KEY (`CandidateReferenceID`),
  UNIQUE INDEX `CandidateReferenceID_UNIQUE` (`CandidateReferenceID` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  INDEX `fk_customer_drone1_idx` (`drone_DroneID` ASC),
  INDEX `fk_customer_address1_idx` (`address_AddressID` ASC),
  INDEX `fk_customer_course1_idx` (`course_CourseID` ASC),
  INDEX `fk_customer_login1_idx` (`login_LoginID` ASC),
  INDEX `fk_customer_Creation1_idx` (`Creation_CreationID` ASC),
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
  CONSTRAINT `fk_customer_Creation1`
    FOREIGN KEY (`Creation_CreationID`)
    REFERENCES `asg`.`Creation` (`CreationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `asg`.`results`
-- -----------------------------------------------------
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

DROP TABLE If EXISTS materialised_view_user_report;
 
 CREATE TABLE `materialised_view_user_report` (
  `Admins` INT(128) DEFAULT 0,
  `Instructors` Int(128) DEFAULT 0,
  `Customers` Int(128) DEFAULT 0,
  `Updatedon` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO materialised_view_user_report
select (select sum(Access) from login where Access = 'Admin') as Admin,
(select sum(Access) from login where Access = 'Instructor') as Instructor,
(select sum(Access) from login where Access = 'Customer') as Customer,
now();

Select * from materialised_view_user_report;


USE `asg` ;

-- -----------------------------------------------------
-- procedure ErrorHandling
-- -----------------------------------------------------

DELIMITER $$
USE `asg`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ErrorHandling`()
BEGIN

DECLARE EXIT HANDLER 
    FOR 1292
    SELECT 'The DATE that you provided is in an incorrect format.'
    ROLLBACK;
    
DECLARE EXIT HANDLER 
	FOR 1062
    SELECT 'You already have a row with this ID in the table.'
    ROLLBACK;
    
DECLARE EXIT HANDLER 
	FOR 1146
    SELECT 'This table does not exist '
    ROLLBACK;
    
DECLARE EXIT HANDLER 
	FOR 1071
    SELECT 'Data entry is too large'
    ROLLBACK; 

DECLARE EXIT HANDLER 
	FOR 1059
    SELECT 'Data entry is too long'
    ROLLBACK; 
end$$

DELIMITER ;

-- -----------------------------------------------------
-- Table `asg`.`version`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `asg`.`version`;
CREATE TABLE `asg`.`version` (
  `dbversion` INT UNSIGNED NOT NULL,
  `active` TINYINT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`dbversion`),
  UNIQUE INDEX `dbversion_UNIQUE` (`dbversion` ASC));


###################################################
#####################TRIGGERS######################
###################################################


###################################################
######################INSERT#######################
###################################################
DELIMITER $$
DROP TRIGGER IF EXISTS asg.address_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`address_AFTER_INSERT`
AFTER INSERT ON `address`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.administrator_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`administrator_AFTER_INSERT`
AFTER INSERT ON `administrator`
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
DELIMITER ;


DELIMITER $$
DROP TRIGGER IF EXISTS asg.course_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`course_AFTER_INSERT`
AFTER INSERT ON `course`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.customer_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`customer_AFTER_INSERT`
AFTER INSERT ON `customer`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.drone_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`drone_AFTER_INSERT`
AFTER INSERT ON `drone`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.instructor_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`instructor_AFTER_INSERT`
AFTER INSERT ON `instructor`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.login_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`login_AFTER_INSERT`
AFTER INSERT ON `login`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.qualification_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`qualification_AFTER_INSERT`
AFTER INSERT ON `qualification`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.results_AFTER_INSERT$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`results_AFTER_INSERT`
AFTER INSERT ON `results`
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
DELIMITER ;


###################################################
#####################UPDATE######################
###################################################
DELIMITER $$
DROP TRIGGER IF EXISTS asg.address_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`address_AFTER_UPDATE`
AFTER UPDATE ON `address`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.administrator_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`administrator_AFTER_UPDATE`
AFTER UPDATE ON `administrator`
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
DELIMITER ;


DELIMITER $$
DROP TRIGGER IF EXISTS asg.course_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`course_AFTER_UPDATE`
AFTER UPDATE ON `course`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.customer_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`customer_AFTER_UPDATE`
AFTER UPDATE ON `customer`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.drone_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`drone_AFTER_UPDATE`
AFTER UPDATE ON `drone`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.instructor_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`instructor_AFTER_UPDATE`
AFTER UPDATE ON `instructor`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.login_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`login_AFTER_UPDATE`
AFTER UPDATE ON `login`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.qualification_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`qualification_AFTER_UPDATE`
AFTER UPDATE ON `qualification`
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
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS asg.results_AFTER_UPDATE$$
CREATE DEFINER = CURRENT_USER
TRIGGER `asg`.`results_AFTER_UPDATE`
AFTER UPDATE ON `results`
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

END$$
DELIMITER ;

INSERT INTO version (dbversion, active, description) VALUES (1, true, 'Creating first version');
SELECT * FROM version;


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
select * from creation;
select * from customer;
select * from results;
select * from instructor;
select * from administrator;
select * from qualification;
select * from course;
select * from drone;
select * from login;

CREATE VIEW adminadetails  AS SELECT l.Username, l.Access, a.AdminID, a.FirstName, a.LastName
FROM administrator a
INNER JOIN login l ON l.LoginID=a.login_LoginID
GROUP BY a.AdminID;

DROP procedure IF EXISTS AdministratorAccess;

DELIMITER 

CREATE PROCEDURE AdministratorAccess (login_LoginID int)
IF ISNULL(login_LoginID) THEN


SELECT admindetails

ELSE

CALL AdministratorAccess(loginID);

END IF;


END

DELIMITER ;



CREATE VIEW instructordetails AS SELECT l.Username, l.Access, i.InstructorID, i.FirstName, i.LastName
FROM instructor i
INNER JOIN login l ON l.LoginID=i.login_LoginID
GROUP BY i.InstructorID;

DROP procedure IF EXISTS InstrcutorAccess;

DELIMITER 

CREATE PROCEDURE InstrcutorAccess (login_LoginID int)
IF ISNULL(login_LoginID) THEN


SELECT instructordetails

ELSE

CALL InstructorAccess(loginID);

END IF;


END

DELIMITER ;



CREATE VIEW customerdetails AS SELECT l.Username, l.Access, c.CandidateReferenceID, c.FirstName, c.LastName
FROM customer c
INNER JOIN login l ON l.LoginID=c.login_LoginID
GROUP BY c.CandidateReferenceID;

DROP procedure IF EXISTS CustomerAccess;

DELIMITER 

CREATE PROCEDURE CustomerAccess (login_LoginID int)
IF ISNULL(login_LoginID) THEN


SELECT customerdetails

ELSE

CALL CustomerAccess(loginID);

END IF;


END

DELIMITER ;
