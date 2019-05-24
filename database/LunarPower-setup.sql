/*
    SET UP FILE FOR LUNAR POWER DATASET

    DROP TABLE USERS;
*/


create database lunarpower;
use lunarpower ;

-- DROP TABLE USERS;

/*table for users.csv*/
CREATE TABLE USERS (
    Id BIGINT  AUTO_INCREMENT NOT NULL,
    Username VARCHAR(50),
    Password VARCHAR(50),
    PRIMARY KEY (Id)
);

/*table for devices.csv*/
CREATE TABLE DEVICES (
    Id BIGINT  AUTO_INCREMENT NOT NULL,
    Device_id BIGINT NOT NULL,
    Type ENUM('Roomba', 'Lights'),
    Name VARCHAR(50),
    PRIMARY KEY (Id)
);

/*table for tasks.csv*/
CREATE TABLE TASKS (
    Id BIGINT  AUTO_INCREMENT NOT NULL,
    Device_id BIGINT NOT NULL,
    Type ENUM('Roomba', 'Lights'),
    Name VARCHAR(50),
    PRIMARY KEY (Id)
);