-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema login1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema login1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `login1` DEFAULT CHARACTER SET utf8 ;
USE `login1` ;

-- -----------------------------------------------------
-- Table `login1`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login1`.`user` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login1`.`Language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login1`.`Language` (
  `idlanguage` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idlanguage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login1`.`code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login1`.`code` (
  `idcode` INT NOT NULL,
  `user_username` VARCHAR(45) NOT NULL,
  `Language_idlanguage` VARCHAR(20) NOT NULL,
  `input` VARCHAR(500) NULL,
  `output` VARCHAR(500) NULL,
  `title` VARCHAR(100) NULL,
  PRIMARY KEY (`idcode`, `user_username`, `Language_idlanguage`),
  INDEX `fk_diagram_user_idx` (`user_username` ASC),
  INDEX `fk_diagram_Language1_idx` (`Language_idlanguage` ASC),
  CONSTRAINT `fk_diagram_user`
    FOREIGN KEY (`user_username`)
    REFERENCES `login1`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagram_Language1`
    FOREIGN KEY (`Language_idlanguage`)
    REFERENCES `login1`.`Language` (`idlanguage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login1`.`row`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login1`.`row` (
  `idrow` INT NOT NULL AUTO_INCREMENT,
  `mark` TINYINT(1) NULL DEFAULT 0,
  `content` VARCHAR(400) NOT NULL,
  `code_idcode` INT NOT NULL,
  `code_user_username` VARCHAR(45) NOT NULL,
  `code_Language_idlanguage` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idrow`, `code_idcode`, `code_user_username`, `code_Language_idlanguage`),
  INDEX `fk_row_code1_idx` (`code_idcode` ASC, `code_user_username` ASC, `code_Language_idlanguage` ASC),
  CONSTRAINT `fk_row_code1`
    FOREIGN KEY (`code_idcode` , `code_user_username` , `code_Language_idlanguage`)
    REFERENCES `login1`.`code` (`idcode` , `user_username` , `Language_idlanguage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login1`.`diagram`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login1`.`diagram` (
  `iddiagrama` INT NOT NULL AUTO_INCREMENT,
  `code_idcode` INT NOT NULL,
  `code_user_username` VARCHAR(45) NOT NULL,
  `code_Language_idlanguage` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`iddiagrama`, `code_idcode`, `code_user_username`, `code_Language_idlanguage`),
  CONSTRAINT `fk_diagram_code1`
    FOREIGN KEY (`code_idcode` , `code_user_username` , `code_Language_idlanguage`)
    REFERENCES `login1`.`code` (`idcode` , `user_username` , `Language_idlanguage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
