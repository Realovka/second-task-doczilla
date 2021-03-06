-- MySQL Script generated by MySQL Workbench
-- Sun May 22 09:47:43 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema students
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema students
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `students` DEFAULT CHARACTER SET utf8 ;
USE `students` ;

-- -----------------------------------------------------
-- Table `students`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students`.`students` (
                                                     `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    `birthday` DATE NOT NULL,
    `student_group` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
