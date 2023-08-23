--Pre Session Assignment START

--Create database
Create Database HarPro2108;

--Use database 
Use HarPro2108;

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
stdId int Primary Key,
stdName varchar(20) Not Null,
feeRecieptNo int Not Null Unique,
recordCreatedOn datetime
);

--Secondary Table refering to employee via foreign key empId
Create Table Account(
accId int Primary Key,
accNo bigint Unique,
accIfsc varchar(11),
stdId int Foreign Key References StdFeeRecord(stdId),
recordCreatedOn datetime
);

--Secondary table refering to account via foreign key accId
Create Table Fee(
feeRecieptNo int Primary Key,
accId int Foreign Key References Account(accId),
feeAmount money,
monthForFee varchar(10),
creditedOn datetime
);

Insert into StdFeeRecord values
(101, 'Ajay', 1001, SYSDATETIMEOFFSET());

Insert into Account values
(7001, 123456, 'bkid3001', 101, SYSDATETIMEOFFSET()),
(7002, 987323, 'bkid3001', 101, SYSDATETIMEOFFSET());

Insert into Fee values
(1001, 7001, 6200, 'Jan', SYSDATETIMEOFFSET()),
(1002, 7002, 6200, 'Feb', SYSDATETIMEOFFSET());

Select * from StdFeeRecord;
Select * from Account;
Select * from Fee;

-- Pre-Session Assignment End--

--Assignment to manage Employee attendence record along with salary record

--Primary table Employee Record Table
Create Table EmpNew(
	empId int Primary Key,
	empName varchar(20) Not Null,
	recordCreatedOn datetime
);

--Secondary Table for account details with (1 to many relationship) refering to employee via foreign key empId
Create Table Account(
	accId int Primary Key,
	accNo bigint Unique,
	accIfsc varchar(11),
	empId int Foreign Key References EmpNew(empId),
	recordCreatedOn datetime
);

--Secondary table refering to account(1 to many relationship) via foreign key accId
Create Table Salary(
	salaryId int Primary Key,
	accId int Foreign Key References Account(accId),
	salaryAmount money,
	monthSalaried varchar(10),
	creditedOn datetime
);


--Secondary table with (1 to many relationship) with attendence record table employee
Create Table AttendanceRecord(
	attendenceId int Primary Key,
	empId int Foreign Key References EmpNew(empId),
	recordForMonth varchar(10),
	daysPresent int,
	daysAbsent int,
	leaves int,
	avgWorkingHrs float,
	recordedOn datetime
);


/*
--Reference table for Attendence mapping
Create Table MapTable(
	id int Identity(1,1),
	empId int Foreign Key References EmpNew(empId),
	attendenceId int Foreign Key References AttendanceRecord(attendenceId),
	salaryId int
);
*/

--Adding data to record table

Insert into EmpNew values
(101, 'Ajay', SYSDATETIMEOFFSET()),
(102, 'Vijay', SYSDATETIMEOFFSET()),
(103, 'Digvijay', SYSDATETIMEOFFSET());

Insert into Account values
(7001, 123456, 'bkid3001', 101, SYSDATETIMEOFFSET()),
(7002, 987323, 'bkid3001', 101, SYSDATETIMEOFFSET()),
(7003, 654789, 'bkid3001', 102, SYSDATETIMEOFFSET()),
(7004, 123789, 'bkid3001', 103, SYSDATETIMEOFFSET());

Insert into Salary values
(1001, 7001, 62500, 'Jan', SYSDATETIMEOFFSET()),
(1002, 7002, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1003, 7001, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1004, 7003, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1005, 7004, 62500, 'Feb', SYSDATETIMEOFFSET());

Insert into AttendanceRecord values
(5001, 101, 'Jan', 17, 1, 2,9, SYSDATETIMEOFFSET()),
(5002,101, 'Feb', 17, 1, 2, 9.6, SYSDATETIMEOFFSET()),
(5003, 101, 'Mar', 18, 1, 2, 8.9, SYSDATETIMEOFFSET()),
(5004, 102, 'Apr', 20, 1, 2, 7, SYSDATETIMEOFFSET()),
(5005,102, 'Feb', 13, 1, 2, 9.9,SYSDATETIMEOFFSET()),
(5006, 103, 'Mar', 21, 1, 2, 10, SYSDATETIMEOFFSET()),
(5007, 103, 'Apr', 22, 1, 2, 10.6, SYSDATETIMEOFFSET());



Exec sp_columns EmpNew;
Exec sp_columns Account;
Exec sp_columns Salary;
Exec sp_columns AttendanceRecord;



Select * from Account;
Select * from EmpNew;
Select * from Salary;
Select * from AttendanceRecord;

Drop Table EmpNew;
Drop Table Account;
Drop Table Salary;
Drop Table AttendanceRecord;



/* 
Design Employee table(id, emp-code,emp-name), Salary table and salary table should keep employee code and employee name both 
Only store emp_id and emp_name in salary table
*/

Create Table EmpNew(
	empId int ,
	empCode varchar(20) not null Unique,
	empName varchar(20) Not Null,
	empAge int,
	recordCreatedOn datetime,
	
);

Create Table Salary(
	salaryId int Primary Key,
	empId int ,
	empName varchar(20) Not Null,
	salaryAmount money,
	recordCreatedOn datetime,
	Constraint link Foreign Key(empId,empName) References EmpNew(empId,empName)
);

Insert into EmpNew values
(101,'E501', 'Har', 27, SYSDATETIMEOFFSET()),
(102,'E502', 'Dean', 24, SYSDATETIMEOFFSET());

Insert into Salary values
(7002, 101, 'HarShit', 62500, SYSDATETIMEOFFSET());

--Droping key constraints
Alter Table salary Drop constraint link;


/*
Create emploee table whch has salary column 
Then add check constraint
And all allow salary to store more than 50000
*/

--Creating table
Create Table EmpNew(
	empId int ,
	empCode varchar(20) not null Unique,
	empName varchar(20) Not Null,
	empSal money,
	empAge int,
	recordCreatedOn datetime,
);

--Adding constrait to accept salary > 50k
Alter Table EmpNew Add Constraint Law Check(empSal > 50000);

Insert into EmpNew values
(101,'E501', 'Har',50001, 27, SYSDATETIMEOFFSET()),
(102,'E502', 'Dean', 50010, 24, SYSDATETIMEOFFSET());

--Adding constraint that empName should have default value as 'Prolifics'
Alter Table EmpNew Add Constraint NOTNULL Default('Prolifics') For empName;
 
/* 
Task : 
Create emplloyee table where we have salary column and which accept more than 50k
but if we dont pass salary amount then it should take 70k in system
*/
--Adding Constraint that empSal have default value as 70,000
Alter Table EmpNew Add Constraint EmpZeroSal Default(70000) For empSal;

Insert into EmpNew(empId, empCode, empAge, recordCreatedOn) values
(104,'E504', 27, SYSDATETIMEOFFSET());


--Assignment to manage Employee attendence record along with salary record along with checking age, salary, Setting default empName 

--Primary table Employee Record Table
Create Table EmpNew(
	empId int,
	empName varchar(20) Not Null Default('Prolifics'),
	empAge int check(empAge Between 18 and 60),
	recordCreatedOn datetime,
	Primary Key(empId, empName)
);

--Secondary Table for account details with (1 to many relationship) refering to employee via foreign key empId
Create Table Account(
	accId int Primary Key,
	accNo bigint Unique,
	accIfsc varchar(11),
	empId int ,
	empName varchar(20),
	recordCreatedOn datetime,
	Constraint link Foreign key(empId, empName) References EmpNew(empId, empName)
);

--Secondary table refering to account(1 to many relationship) via foreign key accId
Create Table Salary(
	salaryId int Primary Key,
	accId int Foreign Key References Account(accId),
	salaryAmount money Default(25000) check(salaryAmount >10000),
	monthSalaried varchar(10),
	creditedOn datetime
);


--Secondary table with (1 to many relationship) with attendence record table employee
Create Table AttendanceRecord(
	attendenceId int Primary Key,
	empId int ,
	empName varchar(20) Default('Prolifics'),
	recordForMonth varchar(10),
	daysPresent int,
	daysAbsent int,
	leaves int,
	avgWorkingHrs float,
	recordedOn datetime,
	Constraint link2 Foreign key(empId, empName) References EmpNew(empId, empName)
);

Insert into EmpNew values
(101, 'Ajay', 26, SYSDATETIMEOFFSET()),
(102, 'Vijay', 25, SYSDATETIMEOFFSET()),
(103, 'Digvijay', 32, SYSDATETIMEOFFSET());
Insert into EmpNew(empId, empAge, recordCreatedOn) values
(101, 23, SYSDATETIMEOFFSET());


Insert into Account values
(7001, 123456, 'bkid3001', 101, 'Ajay', SYSDATETIMEOFFSET()),
(7002, 987323, 'bkid3001',101, 'Ajay', SYSDATETIMEOFFSET()),
(7003, 654789, 'bkid3001', 102, 'Vijay', SYSDATETIMEOFFSET()),
(7004, 123789, 'bkid3001', 103, 'Digvijay', SYSDATETIMEOFFSET());

Insert into Salary values
(1001, 7001, 62500, 'Jan', SYSDATETIMEOFFSET()),
(1002, 7002, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1003, 7001, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1004, 7003, 62500, 'Feb', SYSDATETIMEOFFSET()),
(1005, 7004, 62500, 'Feb', SYSDATETIMEOFFSET());
Insert into Salary values
(1006, 7004, 1500, 'Feb', SYSDATETIMEOFFSET());
Insert into Salary(salaryId, accId, monthSalaried,creditedOn) values
(1006, 7004, 'Feb', SYSDATETIMEOFFSET());

Insert into AttendanceRecord values
(5001, 101, 'Ajay', 'Jan', 17, 1, 2,9, SYSDATETIMEOFFSET()),
(5002,101, 'Ajay', 'Feb', 17, 1, 2, 9.6, SYSDATETIMEOFFSET()),
(5003, 101, 'Ajay', 'Mar', 18, 1, 2, 8.9, SYSDATETIMEOFFSET()),
(5004, 102, 'Vijay', 'Apr', 20, 1, 2, 7, SYSDATETIMEOFFSET()),
(5005,102, 'Vijay', 'Feb', 13, 1, 2, 9.9,SYSDATETIMEOFFSET()),
(5006, 103, 'Digvijay', 'Mar', 21, 1, 2, 10, SYSDATETIMEOFFSET()),
(5007, 103, 'Digvijay', 'Apr', 22, 1, 2, 10.6, SYSDATETIMEOFFSET());
Insert into AttendanceRecord(attendenceId, empId, recordForMonth, daysPresent, daysAbsent, leaves, avgWorkingHrs, recordedOn) values
(5008, 101, 'Jan', 17, 1, 2,9, SYSDATETIMEOFFSET());


Exec sp_columns EmpNew;
Exec sp_columns Account;
Exec sp_columns Salary;
Exec sp_columns AttendanceRecord;



Select * from Account;
Select * from EmpNew;
Select * from Salary;
Select * from AttendanceRecord;