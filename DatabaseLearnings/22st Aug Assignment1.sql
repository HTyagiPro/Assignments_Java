--Pre Session Assignment START

--Create database
Create Database HarPro2208;

--Use database 
Use HarPro2208;

/*
Create a Student table and add another column 'name' which u forgot to create while creating table
*/

--Creating Student table
Create table Student(
userId int Not Null Unique,
username text null,
password text null
);

--Table description
Exec sp_columns Student;

--Task 1: Adding new column in table
Alter Table Student Add name varchar(20);

--Task 2: Adding more new columns in table
Alter Table Student Add dob varchar(20), gender char(5);

--Task 3 : Changing data-type of column
Alter Table Student Alter Column gender char(1);

--Task 4 : Droping column from table
Alter Table Student Drop Column dob;

--Droping table
Drop table Student;

--Creating Student table with username, pass, aadharNo
Create table Student(
regNo bigint Not Null Unique,
username varchar(20) null,
password text null,
createAt date null,
);

--Table description
Exec sp_columns Student;

--Inserting data in given table
Insert into Student values
(51190475, 'cheekoBoyee', 'cheeko@1234', GETUTCDATE()),
(51190476, 'ajaySaxena', 'ajay@1234', GETUTCDATE());

--Reading Data from registration table
Select * from Student;

/*
Task : Add employee id column which accepts unique value
Task : Remove uniqueness from Aadhar number 
*/

--Add column name Student Id
Alter Table Student Add stdId int ;

--Remove unique constratint from aadharId
Alter Table Student Drop constraint UQ__Student__184B2E39E96284B9;

--Adding values to newly added columns 
Update Student Set stdId = 101 where username = 'cheekoBoyee';
Update Student Set stdId = 102 where username = 'ajaySaxena';

--Inserting duplicate Student Id value
Insert into Student values(51190475, 'cheekoBoyee2', 'cheeko2@1234', GETUTCDATE(), 103);

--Making Student Id unique again
Alter Table Student Add Unique(stdId);

--Create table
create table Student2(id int unique);

--Inserting null value
insert into Student2 values(null);

--droping table Student2
drop table Student2;

--Create table with ptimary key
create table Student2(id int Primary Key);

--droping table Student2
drop table Student2;

--Create table without primary key
create table Student2(id int not null, mobNo bigint);

--Making primary key using alter command
Alter Table Student2 Add Primary Key(id);

--droping table Student2
drop table Student2;

--Create table without primary key
create table Student2(id int not null, mobNo bigint);
--Make primary key using UI


--Correct approach Problem statement- Students fee record

--Primary Table 
Create Table StdFeeRecord(
stdId int Identity(100,1),
stdName varchar(20) Not Null Default('Prolifics'),
feeRecieptNo int  Not Null Unique,
recordCreatedOn datetime,
Primary Key(stdId,stdName)
);

--Secondary Table refering to employee via foreign key empId
Create Table Account(
accId int identity(1000,1) Primary Key,
stdId int,
stdName varchar(20) Not Null Default('Prolifics'),
accNo bigint Unique,
accIfsc varchar(11),
recordCreatedOn datetime,
constraint link Foreign Key (stdId,stdName) References StdFeeRecord(stdId,stdName)
);

--Secondary table refering to account via foreign key accId
Create Table Fee(
feeRecieptNo int identity(10000,1) Primary Key,
accId int Foreign Key References Account(accId),
feeAmount money check(feeAmount >5000) default(6200),
monthForFee varchar(10),
creditedOn datetime
);

Insert into StdFeeRecord values
('Ajay', 1001, SYSDATETIMEOFFSET());

--Inserting Valid data with default value
Insert into StdFeeRecord(feeRecieptNo, recordCreatedOn) values
(1002, SYSDATETIMEOFFSET());


--Inserting Valid data
Insert into Account values
(100, 'Ajay', 123456, 'bkid3001', SYSDATETIMEOFFSET()),
(100, 'Ajay', 987323, 'bkid3001', SYSDATETIMEOFFSET());

--Inserting Valid data with default value
Insert into Account(stdId, accNo, accIfsc, recordCreatedOn) values
(101, 456123, 'bkid3001', SYSDATETIMEOFFSET());

--Invalid cases
Insert into Account values
(101, 'Vijay', 123456, 'bkid3001', SYSDATETIMEOFFSET());

--Inserting Valid data
Insert into Fee values
(1001, 6200, 'Jan', SYSDATETIMEOFFSET()),
(1002, 6200, 'Feb', SYSDATETIMEOFFSET());

--Inserting Valid data with default value
Insert into Fee(accId, monthForFee, creditedOn) values
(1002, 'Jan', SYSDATETIMEOFFSET());

--Inserting Invalid data
Insert into Fee values
(1003, 7002, 4200, 'Jan', SYSDATETIMEOFFSET());



Select * from StdFeeRecord;
Select * from Account;
Select * from Fee;


--Droping above tables
Drop table StdFeeRecord;
Drop table Account;
Drop table Fee;

--Remove link constraint
Alter table Account Drop Constraint link;

--Pre-session assignment end--

--Using timestamp to create the versions on update
Create Table StdFeeRecord(
stdId int Identity(100,1),
stdName varchar(20) Not Null Default('Prolifics'),
feeRecieptNo int  Not Null Unique,
recordCreatedOn timestamp,
Primary Key(stdId,stdName)
);

Insert into StdFeeRecord(stdName, feeRecieptNo) values('Vijay', 1002);

SELECT CURRENT_TIMESTAMP AS Date; 

--Using DateTimeOffSet

CREATE TABLE EventLogs(
	EventId int IDENTITY(101,1) PRIMARY KEY,
	EventTime DATETIMEOFFSET,
	EventDesc VARCHAR(255)
	);

INSERT INTO EventLogs VALUES
	(SYSDATETIMEOFFSET(), 'Event 3');

Select * from EventLogs;

 --Using OR operator
Select * from EventLogs where EventId = 101 or EventId = 103;


--Using OrderBy Clause
Create Table StdFeeRecord(
	stdId int Identity(100,1),
	stdName varchar(20) Not Null Default('Prolifics'),
	stdAge int,
	recordCreatedOn datetime,
	Primary Key(stdId,stdName)
);

Insert Into StdFeeRecord(stdName, stdAge, recordCreatedOn) Values
	( 'Sanjay', 25, SYSDATETIMEOFFSET());




Select * Into ProlificsEmp From StdFeeRecord where stdName = 'Prolifics';
Select * Into Emp From StdFeeRecord where stdName !='Prolifics';


Select * from StdFeeRecord;
Select * from ProlificsEmp;
Select * from Emp;

Select * From StdFeeRecord Order By stdAge ASC;
select * from StdFeeRecord where stdId = 101 AND stdName = 'Prolifics'
select * from StdFeeRecord where stdName Not like  'Prolifics';


Drop Table ProlificsEmp;
Drop Table Emp;
