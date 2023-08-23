--Pre Session Assignment START

--Create database
Create Database HarPro2308;

--Use database 
Use HarPro2308;

/*
Create a Student table and add another column 'name' which u forgot to create while creating table
*/

--Creating Student table
Create table Student(
userId int Not Null Unique,
username text null,
password text null,
dob Date Default(GetDate())
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
	dob Date Default(GetDate()),
	recordCreatedOn datetimeoffset,
	rowVersion timestamp,
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
	creditedOn smalldatetime
);

Insert into StdFeeRecord(stdName, feeRecieptNo, dob, recordCreatedOn) values
('Sanjay', 1004,'2002-05-30', SYSDATETIMEOFFSET());

--Inserting Valid data with default value
Insert into StdFeeRecord(feeRecieptNo, recordCreatedOn) values
(1007, SYSDATETIMEOFFSET());


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


Select * Into ProlificsEmp From StdFeeRecord where stdName = 'Prolifics';

--NOT 
Select * Into Emp From StdFeeRecord where stdName !='Prolifics';

--Logical Operators
--OR
Select * From StdFeeRecord Where stdName = 'Prolifics' OR dob = GETDATE();

--AND
Select * From StdFeeRecord Where stdName = 'Prolifics' AND feeRecieptNo = 1006;

--Order By Clause
Select * From StdFeeRecord Order By dob asc;

Select * from StdFeeRecord;
Select * from ProlificsEmp;
Select * from Emp;

Select * From StdFeeRecord Order By stdAge ASC;
select * from StdFeeRecord where stdId = 101 AND stdName = 'Prolifics';
select * from StdFeeRecord where stdName Not like  'Prolifics';

Drop Table ProlificsEmp;
Drop Table Emp;

--Pre Session assignment ends 

--During Session Tasks

--Using Update command for one column
Update StdFeeRecord Set stdName = 'Cheeko' Where stdId = 106;

--Using update command for more than one column
Update ProlificsEmp Set stdName = 'Cheeko' ,dob = '2001-01-30' Where stdId = 106;

--Using Delete command to drop specific record
Delete from Emp where stdId = 104;

--Using Delete command to delete whole record
Delete from Emp;


--All records
Select * from StdFeeRecord;

--Using TOP clause 
Select Top 5 *  from StdFeeRecord;

--Using TOP Percent clause 
Select Top 25 Percent *  from StdFeeRecord;

--Using TOP Percent and Where clause 
Select Top 50 Percent *  from StdFeeRecord Where stdName = 'Prolifics'; 


-- Table 
Create Table StdRecord2(
	stdId int Identity(100,1),
	stdName varchar(20) Not Null ,
	dob Date Default(GetDate()),
	recordCreatedOn datetimeoffset Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp,
	Primary Key(stdId)
);



drop table StdRecord2;

Alter Table StdRecord2 Alter Column stdName text;


--Substring Compherision
insert into StdRecord2(stdName) values('Ritesh');

--Returns records with name ends with 'jay'
Select * from StdRecord2 Where stdName Like '%jay';

--Returns records with name ends with 'y'
Select * from StdRecord2 Where stdName Like '%y';

--Returns records with name starts with D and ends with 'y'
Select * from StdRecord2 Where stdName Like 'D%y';

--Returns records with name ends with 'h'
Select * from StdRecord2 Where stdName Like '%h';

--Only one character before J
Select * from StdRecord2 Where stdName Like '_j%';


Select * from StdRecord2;

--Offset to ignore rows and fetch record (return 3rd row)
Select * from StdRecord2 order by stdId offset 2 rows fetch next 1 row only;

--Using Count function
Select COUNT(stdId) from StdRecord2;

--Using Sum Function
Select Sum(feeAmount) from Fee;

--Using 'in' operator
Select * from StdRecord2 where stdId in(103,105,106);

--Using 'Not in' operator
Select * from StdRecord2 where stdId not in(103,105,106);

--Using 'Between' operator
Select * from StdRecord2 where stdId Between 102 And 107;

--Using 'Not Between' operator
Select * from StdRecord2 where stdId Not Between 102 And 107;

Select * from Emp;
Select * from ProlificsEmp;

--Using Union Operator
Select stdName from Emp Union all Select StdName from ProlificsEmp;

--Saving Data of both table into single table
Select * Into StdRecord1 from Emp Union Select * from ProlificsEmp;
Select * from StdRecord2;

Select * from StdFeeRecord;
/*
You are managing an employee database. The database contains two tables: Employees and EmployeeContacts.

•

•| EmployeeID | FirstName | LastName | Age | Salary |

•|------------|-----------|----------|-----|--------|

•| 1          | John      | Smith    | 30  | 60000  |

•| 2          | Emily     | Johnson  | 28  | 55000  |

•| 3          | Michael   | Williams | 32  | 62000  |

•| ...        | ...       | ...      | ... | ...    |


•ContactID   | EmployeeID | Email               | Phone        |

•|-----------|------------|---------------------|--------------|

•| 1         | 1          | john@example.com    | 555-123-4567 |

•| 2         | 2          | emily@example.com   | 555-987-6543 |

•| 3         | 3          | michael@example.com | 555-555-1234 |

•| ...       | ...        | ...                 | ...          |




*/

Create Table EmpNew(
	emp_id int Identity(1,1) Primary Key,
	f_name varchar(20) Default('A.'),
	l_name varchar(20) Default('Salvatore'),
	emp_age int Default(25),
	emp_sal money
);

Create Table ContactInfo(
	contact_id int Identity(1,1) Primary Key,
	emp_id int Foreign Key References EmpNew(emp_id),
	email varchar(15),
	phone bigint
);

Insert into EmpNew values 
	('Manmohanlal', 'Tiwari', 52, 90500),
	('Jyoti', 'Saxena', 32, 62500),
	('Ajay', 'Saxena', 25, 62500),
	('Vijay', 'Jha', 28, 61200),
	('Sanjay', 'Singh', 35, 42500),
	('Himesh', 'Sharma', 15, 52500),
	('Rohan', 'Mishra', 35, 62500),
	('Cheeko', 'Boyee', 23, 35000),
	('Nikhil', 'Rajput', 21, 80500);

Insert into ContactInfo values
	(1, 'abc@example.com', 123456789),
	(2, 'pqr@example.com', 147852369),
	(3, 'xyz@example.com', 987456321),
	(4, 'klm@example.com', 456321789),
	(5, 'ijk@example.com', 369147852),
	(5, 'def@example.com', 963258741),
	(6, 'fun@example.com', 123654789),
	(7, 'var@example.com', 987123654);

Select * from EmpNew;
Select * from ContactInfo;

--•Update the salary of employee with EmployeeID 1 to 65000.
Update EmpNew Set emp_sal = 65000 where emp_id = 1;

--•Update the age of employee with EmployeeID 2 to 29 and also increase their salary to 58000.
Update EmpNew Set emp_age = 29, emp_sal = 5800 where emp_id = 1;

--•Delete the employee record with EmployeeID 3 from the Employees table.
Delete from ContactInfo where emp_id = 3;
Delete from EmpNew where emp_id = 3;

--•Delete all records from the EmployeeContacts table.
Delete from ContactInfo;

--•Explain the difference between the TRUNCATE and DELETE commands.
	--Delete command allows deletion on the basis of condition while truncate doesn't

--•Retrieve the first 50% of employee data based on their names in ascending order.
Select Top 50 Percent * from EmpNew Order By f_name Asc;

--•Retrieve the names of employees whose names start with 'J'.
Select * from EmpNew where f_name like 'J%';

--•Retrieve the names of employees whose names end with 'n'.
Select * from EmpNew where f_name like '%n';

--•Retrieve the names of employees whose names contain the letter 'i' at any position.
Select * from EmpNew where f_name like '%i%';

--•Retrieve the names of employees whose names start with 'M' and end with 'l'.
Select * from EmpNew where f_name like 'M%l';

--•Retrieve the names of employees whose names have 'o' as the second character.
Select * from EmpNew where f_name like '__o%';

--•Retrieve the names of employees whose names do not start with 'J'.
Select * from EmpNew where f_name Not Like 'J%';