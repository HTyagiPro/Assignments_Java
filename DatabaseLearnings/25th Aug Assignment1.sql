--Pre Session Assignment START

--Create database
Create Database HarPro2508;

--Use database 
Use HarPro2508;

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

Select * from StdFeeRecord;


/*
You are managing an employee database. The database contains two tables: Student and Department.
*/

Create Table StdRecord(
	std_ID int Identity(1,1) Primary Key,
	std_name varchar(20) Default('A.'),
	std_course varchar(20) Default('Salvatore'),
	std_age int Default(25) check(std_age >18),
	std_fee money Default(62530),
	std_dept_ID int Foreign Key References DeptInfo(dept_ID),
	recordCreatedOn datetime,
	rowVersion timestamp
);


Create Table DeptInfo(
	dept_ID int Identity(101,1) Primary Key,
	dept_name varchar(20),
	dept_location varchar(15),
	recordCreatedOn datetime Default(GETDATE()),
);

Create Table FeeRecord(
	id int identity(1,1) Primary Key,
	feeAmount money Default(6250),
	monthFeeFor varchar(10),
	std_id int Foreign Key References StdRecord(std_ID)
);

Insert into StdRecord(std_name, std_course, std_age,std_dept_ID) values 
	('Manmohanlal', 'B-Tech', 52, 101),
	('Jyoti', 'B-Pharma', 32, 102),
	('Ajay', 'B.A.', 25, 103),
	('Vijay', 'LLB', 28, 104),
	('Sanjay', 'B.Sc.', 35, 101),
	('Himesh', 'B.C.A.', 45, 101),
	('Rohan', 'M.C.A.', 35, 101),
	('Cheeko', 'M.B.A.', 23, 105),
	('Nikhil', 'B.B.A.', 21, 106);

Insert into DeptInfo(dept_name, dept_location) values
	('Research','Madras'),
	('Computer Science','Delhi'),
	('Medical','Rorkee'),
	('Compliance','Noida'),
	('Legalities','Mumbai'),
	('Technology','Bengalore'),
	('Finance','Noida');

Insert Into FeeRecord(monthFeeFor, std_id) Values
	('Jan', 7),('Jan', 8),('Jan', 9),('Jan', 10),('Feb', 7),('Feb', 8),('Feb', 12),('Feb', 13),('Mar', 8),('Mar', 9)

Select * from StdRecord;
Select * from DeptInfo;
Select * From FeeRecord;

--And
Select * from StdRecord where std_course = 'B-Tech' And std_dept_ID = 101;

--OR
Select * from StdRecord where std_course = 'B-Tech' OR std_dept_ID = 101;

--Dividing primary table into two tables
Select * Into CSE_Dept from StdRecord where std_dept_ID = 101;
Select * Into Other_Dept from StdRecord where std_dept_ID != 101;

--Union Operation
Select * from CSE_Dept UNION Select * from Other_Dept;

--Union with unique value
Select std_dept_ID from CSE_Dept UNION Select std_dept_ID from Other_Dept;

--Union with all value
Select std_dept_ID from CSE_Dept UNION ALL Select std_dept_ID from Other_Dept;

--Using 'in' operator
Select * from StdRecord where std_ID in(1,8,7);

--Using 'Not in' operator
Select * from StdRecord where std_ID not in(1,2,3);

--Using 'Between' operator
Select * from StdRecord where std_ID Between 5 And 9;

--Using 'Not Between' operator
Select * from StdRecord where std_ID Not Between 3 And 7;


--•Update the age of Students with StudentsID 1 to 19.
Update StdRecord Set std_age = 19 where std_ID = 1;

--•Update the age of Students with StudentsID 2 to 29 and also change their deptID to 105.
Update StdRecord Set std_age = 29, std_dept_ID = 105 where std_ID = 2;

--•Delete the Students record with StudentsID 3 from the Students table.
Delete from DeptInfo where std_ID = 3;
Delete from StdRecord where std_ID = 3;

--•Delete all records from the DeptInfo table.
Delete from DeptInfo;

--•Explain the difference between the TRUNCATE and DELETE commands.
	--Delete command allows deletion on the basis of condition while truncate doesn't

--•Retrieve the first 50% of Students data based on their names in ascending order.
Select Top 50 Percent * from StdRecord Order By std_name Asc;
Select Top 50 Percent * from StdRecord Where std_dept_ID = 101 Order By std_name Asc;

--•Retrieve the names of Students whose names start with 'J'.
Select * from StdRecord where std_name like 'A%';

--•Retrieve the names of Students whose names end with 'n'.
Select * from StdRecord where std_name like '%n';

--•Retrieve the names of Students whose names contain the letter 'i' at any position.
Select * from StdRecord where std_name like '%i%';

--•Retrieve the names of Students whose names start with 'M' and end with 'l'.
Select * from StdRecord where std_name like 'M%l';

--•Retrieve the names of Students whose names have 'o' as the second character.
Select * from StdRecord where std_name like '__o%';

--•Retrieve the names of Students whose names do not start with 'J'.
Select * from StdRecord where std_name Not Like 'J%';

--Count records
Select Count(dept_ID) from DeptInfo;

--Calculate sum of total fee from students
Select Sum(std_fee) from StdRecord;

--Offset to ignore rows and fetch record (return 5th row)
Select * from StdRecord order by std_ID offset 5 rows fetch next 1 row only;

--Students Studying in Certain Departments
Select StdRecord.std_name, StdRecord.std_course, StdRecord.std_age, DeptInfo.dept_name, DeptInfo.dept_location From StdRecord Inner Join DeptInfo On StdRecord.std_dept_ID = DeptInfo.dept_ID Order By DeptInfo.dept_ID;

--All students who may or may not have paid fees
Select StdRecord.std_name, StdRecord.std_course, StdRecord.std_age, FeeRecord.feeAmount, FeeRecord.monthFeeFor  From StdRecord Left Join FeeRecord On StdRecord.std_ID = FeeRecord.std_id Order By StdRecord.std_ID;

--All The Departments may or may not have students records
Select StdRecord.std_name, StdRecord.std_course, StdRecord.std_age, DeptInfo.dept_name, DeptInfo.dept_location From StdRecord Right Join DeptInfo On StdRecord.std_dept_ID = DeptInfo.dept_ID Order By DeptInfo.dept_ID;

--Department Count Using Group By from StdRecord Table
Select Count(StdRecord.std_ID) As StudentsPerDepartment, StdRecord.std_dept_ID From StdRecord Group By StdRecord.std_dept_ID having std_age >25;

--Student Count Age > 25
Select Count(StdRecord.std_ID) As StudentsPerDepartment, StdRecord.std_dept_ID From StdRecord Group By StdRecord.std_dept_ID having Count(StdRecord.std_ID) <3;

--Display Records using sub Query
Select * from StdRecord where Exists (Select DeptInfo.dept_name from DeptInfo where dept_ID > 103);

--Table Duplication
Select * Into CSE_Dept From StdRecord where std_dept_ID = 101;
Select * from CSE_Dept;

--Insertion into Duplicate table
Insert Into CSE_Dept (std_name, std_course, std_age,std_dept_ID) (Select std_name, std_course, std_age,std_dept_ID from StdRecord where std_dept_ID = 102);
Select * from CSE_Dept;

--Case Statements
Select *, 
CASE 
	When std_dept_ID =101 then 'AKTU'
	When std_dept_ID =106 then 'CCS'
	Else 'Others'
End As university
From StdRecord;

--Pre Session Assignment Ends

Create Table Customer(
	Id int Identity(1,1) Primary Key,
	name varchar(20),
	recordCreatedOn datetime default(Getdate())
);

Insert into Customer(name) Values
	('C1'),
	('C2'),
	('C3'),
	('C4');

Create table Product(
	productID int Identity(1,1) Primary Key,
	productName varchar(20),
	price money Default(120)
);

Insert Into Product Values
	('Book', 10),
	('Pen', 15),
	('Bottle', 90),
	('Knife', 69),
	('Hand Granade', 540),
	('Cocain', 1300),
	('Marijyana', 1890),
	('Gun', 420);

Create Table Orders(
	orderID int identity(101,1),
	productID int Foreign Key References Product(productID),
	customerID int Foreign Key References Customer(id),
	orderDate datetime Default(GETDATE()),
);

Insert Into Orders(customerID,productID) Values
	(1, 1),
	(1, 2),
	(2, 3),
	(2, 4),
	(3, 5),
	(2, 6),
	(1, 7),
	(4, 8);

Select * from Customer;
Select * from Product;
Select * from Orders;

--Creating a View
Create View MyStore As
Select Customer.name, Product.productName, Product.price, Orders.orderDate From Customer Inner Join Orders On Customer.Id = Orders.customerID Inner Join Product On Product.productID = Orders.productID;
Select * from MyStore;

--Creating Stored Procedure
Create Procedure InsertOrders As
Insert Into Orders(customerID,productID) Values
	(1, 1),
	(1, 2),
	(2, 3),
	(2, 4),
	(3, 5),
	(2, 6),
	(1, 7),
	(4, 8);

Select * from Orders;

--For Calling a Stored Procedure
EXEC InsertOrders;

Select * from Orders;

--To Called predefined stored Procedure
Select CHARINDEX('o', 'Cheeko') As IndexRes;

--To create a variable
Declare @var varchar(20);

--To assign a value to a variable
Set @var = 'Customer'

--Working with Variable
Select CHARINDEX('o', @var) As IndexRes;

--Concat Function
Select CONCAT('Hello', 'World') As Result;

--Length
Select Len('Hello') As Result;

--Lower
Select Lower('HeLLo') As Result;

--Upper
Select Upper('HeLLo') As Result;

--Trim
Select Trim('      hello World How Are u        ') As Result;

--Floor
Select Floor(12.235) As Result;

--Ceil
Select Ceiling(12.354) As Result;

--Square
Select Square(35) As Result;

--DateDiff
Select DATEDIFF(year, '2023-08-25', '2002-05-19') As Result

--Datename
Select DATENAME(MONTH, '2023-08-25') AS Result;

--Creating Table with 1Million Records

Create Table T1(
	Id int identity,
	[Name] nvarchar(50),
	Email nvarchar(50),
	Department nvarchar(50)
);

Create Table T1_With_Index(
	Id int primary key identity,
	[Name] nvarchar(50),
	Email nvarchar(50),
	Department nvarchar(50)
);

Go
SET NOCOUNT ON
Declare @counter int = 1
While(@counter <= 1000000)
Begin
Declare @Name nvarchar(50) = 'ABC ' + RTRIM(@counter)
Declare @Email nvarchar(50) = 'abc' + RTRIM(@counter) + '@pragimtech.com'
Declare @Dept nvarchar(10) = 'Dept ' + RTRIM(@counter)
Insert into T1 values (@Name, @Email, @Dept)
Set @counter = @counter +1
If(@Counter%100000 = 0)
Print RTRIM(@Counter) + ' rows inserted'
End


Select * From T1 where Id =15;
Select * From T1_With_Index where Id =15;


Declare @var Float;
Set @var = 125.26;

Create Table MarksRecord(
	id int identity primary key,
	marks int
);

--CAST

Insert into MarksRecord Values (80),(40),(50),(60),(70);
--Conditional IIF
Select id, IIF(marks >50,'Pass', 'Fail') As Result from MarksRecord; 

--ISNUMERIC function
Select ISNUMERIC(MarksRecord.marks) as IsNumerical from MarksRecord where id = 3;

--Functions
Create Function adding(@a int , @b int) 
Returns Int As
Begin
Return @a + @b
End

Select dbo.adding(5,3) as Added;

Create Function Resulting(@total int)
Returns Varchar(20) AS
Begin
	IF (@total >150)
		return 'Pass'
	return 'Fail'
End

--Using functions in table
Create Table MarksRecord2(
	id int identity Primary Key,
	name varchar(20),
	historyMarks int,
	chemistryMarks int
);

Insert Into MarksRecord2 Values
	('Sanjay', 90,75), ('Dhananjya', 73,92);

Select *, dbo.adding(historyMarks,chemistryMarks) As Total, dbo.Resulting(dbo.adding(historyMarks,chemistryMarks)) as Result from MarksRecord2;

--Alter a Function
Alter Function adding(@a int , @b int) 
Returns Int As
Begin
Return @a * @b
End

Select dbo.adding(5,3) as Multiplied;

--Droping Function
Drop Function dbo.Operation;


Create Table Students(
	id int identity Primary Key,
	name varchar(20)
);

Insert Into Students Values ('Ajay'), ('Vijay'), ('Sanjay'), ('Digvijay'), ('Dhananjay'), ('Nitesh'), ('Cheeko');


Create Table Courses(
	id int identity Primary Key,
	course_name varchar(20)
);

Insert Into Courses Values ('B.Tech'), ('B.Pharma'), ('BDMS'), ('MS');

Create Table Enrollments(
	id int identity Primary Key,
	courseID int Foreign Key References Courses(id),
	studentID int Foreign Key References Students(id),
	grades char(2)
);

Insert Into Enrollments(studentID, courseID, grades) Values
	(1,1, 'A'),
	(1,2, 'B'),
	(1,3, 'C'),
	(2,1, 'C'),
	(2,2, 'D'),
	(2,3, 'A'),
	(2,4, 'E'),
	(3,1, 'F'),
	(4,2, 'F'),
	(5,1, 'E');

Select * from Students;
Select * from Courses;
Select * from Enrollments;

/*

Problem Statement: Calculating GPA

You are given a database schema with the following tables:

students table:
Columns: student_id, student_name
courses table:
Columns: course_id, course_name
enrollments table:
Columns: enrollment_id, student_id, course_id, grade

Write an SQL function named calculate_gpa that takes a student_id as input and calculates the Grade Point Average (GPA) for that student. The GPA is calculated as follows:

Each course has a grade associated with it (e.g., 'A', 'B', 'C', 'D', 'F').
The GPA is calculated on a 4.0 scale: 'A' is 4.0, 'B' is 3.0, 'C' is 2.0, 'D' is 1.0, and 'F' is 0.0.
The GPA is calculated by taking the average of the course GPAs, weighted by the number of credits each course carries. All courses are assumed to have the same number of credits.

You need to implement the following steps in your function:

Calculate the total GPA points earned by the student.
Calculate the total credits earned by the student.
Calculate the GPA by dividing the total GPA points by the total credits.

Your function should return the GPA as a decimal value rounded to two decimal places

*/


Create Function calculatin_gpa(@grades char(2))
Returns float
Begin	
	if(@grades = 'A')
		return 5.0
	else if(@grades = 'B')
		return 4.0
	else if(@grades = 'C')
		return 3.0
	else if(@grades = 'D')
		return 2.0
	else if(@grades = 'E')
		return 1.0
	return 0.0
End

Create Function cgpa(@sgps float, @countNo int)
Returns decimal(5,2)
Begin
	return Cast(@sgps / @countNo AS decimal(5,2)) 
End

Create View Gpa_table AS
Select Students.name, Courses.course_name, Enrollments.grades, dbo.calculatin_gpa(Enrollments.grades) as GPA  from Students Inner Join Enrollments on Students.id = Enrollments.studentID inner join Courses On Courses.id = Enrollments.courseID; 

Create View Agg_GpA_table AS
Select Students.name, dbo.cgpa(sum(dbo.calculatin_gpa(Enrollments.grades)), count(Students.name)) As  Avg_CGPA, sum(dbo.calculatin_gpa(Enrollments.grades)) As Total_GPA from Students Inner Join Enrollments on Students.id = Enrollments.studentID inner join Courses On Courses.id = Enrollments.courseID Group By Students.name; 

Select * from Gpa_table;
Select * from Agg_GpA_table;

--Correct Approach By sir
CREATE FUNCTION calculate_gpa (@student_id INT) 
RETURNS DECIMAL(4, 2)
BEGIN
    DECLARE @total_points DECIMAL(10, 2);
    DECLARE @total_credits INT;
    DECLARE @gpa DECIMAL(4, 2);

    SELECT @total_points = COALESCE(SUM(
        CASE grades
            WHEN 'A' THEN 4.0
            WHEN 'B' THEN 3.0
            WHEN 'C' THEN 2.0
            WHEN 'D' THEN 1.0
            WHEN 'F' THEN 0.0
            ELSE 0.0
        END), 0)
    FROM Enrollments
    WHERE studentID = @student_id;

 

    SELECT @total_credits = COUNT(*)
    FROM Enrollments
    WHERE Enrollments.studentID = @student_id;

 

    IF @total_credits > 0
        SET @gpa = @total_points / @total_credits;
    ELSE
        SET @gpa = 0.0;

 

    RETURN @gpa;
END;


--My Modifications
CREATE FUNCTION calculate_gpa_mine (@student_id INT) 
RETURNS DECIMAL(4, 2)
BEGIN
    DECLARE @total_points DECIMAL(10, 2);
    DECLARE @total_credits INT;
    DECLARE @gpa DECIMAL(4, 2);

    SELECT @total_points =sum(dbo.calculatin_gpa(Enrollments.grades))
    FROM Enrollments
    WHERE studentID = @student_id Group By Enrollments.studentID;

    SELECT @total_credits = COUNT(*)
    FROM Enrollments
    WHERE Enrollments.studentID = @student_id Group By Enrollments.studentID;

    IF @total_credits > 0
        SET @gpa = @total_points / @total_credits;
    ELSE
        SET @gpa = 0.0;

    RETURN @gpa;
END;


Select Students.name, dbo.calculate_gpa_mine(Students.id) as GPA_out_of_4 from Students;



