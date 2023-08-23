/*
Create a user table and add another column 'name' which u forgot to create while creating table
*/

--Creating Registration table
Create table Registration(
userId int Not Null Unique,
username text null,
password text null
);

--Table description
Exec sp_columns Registration;

--Task 1: Adding new column in table
Alter Table Registration Add name varchar(20);

--Task 2: Adding more new columns in table
Alter Table Registration Add dob varchar(20), gender char(5);

--Task 3 : Changing data-type of column
Alter Table Registration Alter Column gender char(1);

--Task 4 : Droping column from table
Alter Table Registration Drop Column dob;

--Droping table
Drop table Registration;

--Creating registration with username, pass, aadharNo
Create table Registration(
aadharId bigint Not Null Unique,
username varchar(20) null,
password text null,
createAt date null,
);

--Table description
Exec sp_columns Registration;

--Inserting data in given table
Insert into Registration values
(511480694928, 'cheekoBoyee', 'cheeko@1234', GETUTCDATE()),
(3225480694928, 'ajaySaxena', 'ajay@1234', GETUTCDATE());

--Reading Data from registration table
Select * from Registration;

/*
Task : Add employee id column which accepts unique value
Task : Remove uniqueness from Aadhar number 
*/

--Add column name employee Id
Alter Table Registration Add empId int ;

--Remove unique constratint from aadharId
Alter Table Registration Drop constraint UQ__Registra__8C651E11237061A8;

--Adding values to newly added columns 
Update Registration Set empId = 101 where username = 'cheekoBoyee';
Update Registration Set empId = 102 where username = 'ajaySaxena';

--Inserting duplicate aadhar value
Insert into Registration values(511480694928, 'cheekoBoyee2', 'cheeko2@1234', GETUTCDATE(), 103);

--Making aadharId unique again
Alter Table Registration Add Unique(aadharId);

--Create table
create table Registration2(id int unique);

--Inserting null value
insert into Registration2 values(null);

--droping table Registration2
drop table Registration2;

--Create table with ptimary key
create table Registration2(id int Primary Key);

--droping table Registration2
drop table Registration2;

--Create table with multiple ptimary key
create table Registration2(id int Primary Key, mobNo bigint not null unique);

--droping table Registration2
drop table Registration2;

--Create table without primary key
create table Registration2(id int not null, mobNo bigint);

--Making primary key using alter command
Alter Table Registration2 Add Primary Key(id);

--droping table Registration2
drop table Registration2;

--Create table without primary key
create table Registration2(id int not null, mobNo bigint);
--Make primary key using UI

/*
Self Approach: Problem statement- Store salary of each employees on monthly basis
*/

--Create a table for salary Credit
Create table SalaryTableMgmt(
empId int Primary Key,
empName varchar(20) Not Null,
empAccNo bigint Not Null Unique,
empSal money,
empWorkHours float,
salaryForDays int,
monthSalried varchar(10),
creditDateTime datetime 
);




--Table Structure
Exec sp_columns SalaryTableMgmt;

--Inserting Records in SalaryTableMgmt
Insert into SalaryTableMgmt values
(101, 'Ajay Saxena', 7001, 62500, 210.6, 31, 'Jan', SYSDATETIMEOFFSET()),
(102, 'Vijay Saxena', 7002, 62500, 208.6, 31, 'Jan', SYSDATETIMEOFFSET()),
(103, 'Sanjay Saxena', 7003, 62500, 213.6, 31, 'Jan', SYSDATETIMEOFFSET()),
(104, 'Digvijay Saxena', 7004, 62500, 227.6, 31, 'Jan', SYSDATETIMEOFFSET()),
(105, 'Dhananjya Saxena', 7005, 62500, 201.6, 31, 'Jan', SYSDATETIMEOFFSET()); 

delete from SalaryTableMgmt;

--Reading data
Select * from SalaryTableMgmt;


--Correct approach Problem statement- Store salary of each employees on monthly basis

--Primary Table 
Create Table EmpNew(
empId int Primary Key,
empName varchar(20) Not Null,
salaryId int Not Null Unique,
recordCreatedOn datetime
);

--Secondary Table refering to employee via foreign key empId
Create Table Account(
accId int Primary Key,
accNo bigint Unique,
accIfsc varchar(11),
empId int Foreign Key References EmpNew(empId),
recordCreatedOn datetime
);

--Secondary table refering to account via foreign key accId
Create Table Salary(
salaryId int Primary Key,
accId int Foreign Key References Account(accId),
salaryAmount money,
monthSalaried varchar(10),
workedHours float,
daysSalaried int,
creditedOn datetime
);

Insert into EmpNew values
(101, 'Ajay', 1001, SYSDATETIMEOFFSET());

Insert into Account values
(7001, 123456, 'bkid3001', 101, SYSDATETIMEOFFSET()),
(7002, 987323, 'bkid3001', 101, SYSDATETIMEOFFSET());

Insert into Salary values
(1001, 7001, 62500, 'Jan', 201.3, 31, SYSDATETIMEOFFSET()),
(1002, 7002, 62500, 'Feb', 198.3, 28, SYSDATETIMEOFFSET());

Select * from EmpNew;
Select * from Account;
Select * from Salary;



Insert into Salary values
(1005, 7007, 62500, 'Jan', 201.3, 31, SYSDATETIMEOFFSET());






