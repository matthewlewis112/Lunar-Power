/*
    POPULATION FOR LUNARPOWER DATASET
*/

/*populate USERS with users.csv*/
INSERT INTO USERS (Username, Password)
    VALUES ('Matt002','*****');
INSERT INTO USERS (Username, Password)
    VALUES ('Rutu98','*******');

/*populate DEVICES with devices.csv*/
INSERT INTO DEVICES (Device_id, Type, Name)
    VALUES (7, 'Roomba', 'Kelsi"s Roomba');
INSERT INTO DEVICES (Device_id, Type, Name)
    VALUES (5, 'Roomba', 'Rutu"s Roomba');

/*populate TASKS with tasks.csv*/
INSERT INTO TASKS (Device_id, Type, Name)
    VALUES (7, 'Roomba', 'Run Living Room');
INSERT INTO TASKS (Device_id, Type, Name)
    VALUES (7, 'Roomba', 'Run Whole House');

