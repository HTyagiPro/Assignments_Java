--Pre Session Assignment START

--Create database
Create Database HarPro2408;

--Use database 
Use HarPro2408;

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

Insert into StdRecord(std_name, std_course, std_age,std_dept_ID) values 
	('Manmohanlal', 'B-Tech', 52, 101),
	('Jyoti', 'B-Pharma', 32, 102),
	('Ajay', 'B.A.', 25, 103),
	('Vijay', 'LLB', 28, 104),
	('Sanjay', 'B.Sc.', 35, 101),
	('Himesh', 'B.C.A.', 15, 101),
	('Rohan', 'M.C.A.', 35, 101),
	('Cheeko', 'M.B.A.', 23, 105),
	('Nikhil', 'B.B.A.', 21, 106);

Insert into DeptInfo(dept_name, dept_location) values
	('Computer Science','Delhi'),
	('Medical','Rorkee'),
	('Compliance','Noida'),
	('Legalities','Mumbai'),
	('Technology','Bengalore'),
	('Finance','Noida');

Select * from StdRecord;
Select * from DeptInfo;

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

--Pre Session assignment ends 


-- Customer-Order Management Systum

Create Table Customer(
	Id int Identity(1,1) Primary Key,
	name varchar(20),
	contactNo bigint,
	recordCreatedOn datetime default(Getdate())
);

Create Table Orders(
	Id int Identity(101,1) Primary Key,
	cust_ID int Foreign Key References Customer(Id),
	item varchar(20),
	quantity int Default(1),
	cost money,
	recordCreatedOn datetime default(Getdate()),
	rowVersion timestamp
);

Insert into Customer(name, contactNo) Values
	('C1', 147852369),
	('C2', 147852369),
	('C3', 147852369),
	('C4', 147852369);

Insert Into Orders(cust_ID, item, cost) Values
	(1, 'Book', 10),
	(1, 'Pen', 15),
	(2, 'Bottle', 90),
	(2, 'Pen', 15),
	(3, 'Book', 10),
	(2, 'Book', 10),
	(1, 'Knife', 69),
	(4, 'Gun', 420);

Select * from Orders Inner Join Customer on  Customer.Id = Orders.cust_ID;
Select Customer.Id, Customer.name,Customer.contactNo, Orders.Id,Orders.item, Orders.quantity, Orders.cost from Customer Inner Join Orders On Customer.Id = Orders.cust_ID Order by Customer.Id;
Select * from Orders;

Create Table Emp(
	Id int Identity(5001, 1) Primary Key,
	name varchar(20),
	trainingId int Foreign Key References Training(Id)
);

Create Table Training(
	Id int Identity(1, 1) Primary Key,
	training_name varchar(20),
	duration varchar(10)
);


Create Table TrainingStatusRecord(
	Id int Identity(1,1) Primary Key,
	emp_id int Foreign Key References Emp(Id),
	train_id int Foreign Key References Training(Id),
	t_status varchar(15)
);

Insert Into Emp Values
	('Ajay',1),
	('Vijay',1),
	('Sanjay',2),
	('Digvijay',2),
	('Dhananjay',1);

Insert Into Training Values
	('SoftSkils','15 days'),
	('Tech_Java','3 Months'),
	('Tech_Database','1 Month'),
	('Tech_Cloud','2 Month'),
	('Tech_.Net','2 Month');

Insert Into TrainingStatusRecord Values
	(5003,1, 'Completed'),
	(5003,2, 'Not Completed'),
	(5004,3, 'Completed');

Select * from Emp;
Select * from Training;
Select * from TrainingStatusRecord;

--Left Join
--Inner Join
--right Join


Select TrainingStatusRecord.emp_id, Training.training_name, Training.duration From TrainingStatusRecord right Join Training  On  TrainingStatusRecord.train_id = Training.id ;

Select * from Customer;
select * from Orders

/*
Problem Statement: Online Store Inventory Analysis

You are working for an online store that sells various products. The store has two main tables in their database: products and orders.

products Table:

Columns: product_id (unique identifier), product_name, category, price

orders Table:

Columns: order_id (unique identifier), product_id (references product_id in products), customer_name, order_date
*/

Create table Product(
	productID int Identity(1,1) Primary Key,
	productName varchar(20),
	productCategory varchar(20),
	price money
);

Insert Into Product Values
	('Book','Cat_1', 10),
	('Pen','Cat_2', 15),
	('Bottle','Cat_3', 90),
	('Knife','Cat_4', 69),
	('Gun','Cat_5', 420);

Create Table Orders2(
	orderID int Identity(1,1) Primary Key,
	productID int Foreign Key References Product(productID),
	customerName varchar(20),
	orderDate datetime Default(GETDATE()),
);

Insert Into Orders2(productID, customerName) Values
	(1, 'C1'),
	(1, 'C2'),
	(2, 'C2'),
	(2, 'C4'),
	(3, 'C5'),
	(2, 'C6'),
	(1, 'C4'),
	(4, 'C3');
/*
Task 1:  Find out which products have been ordered by customers. Retrieve the product name, category, price, customer name, and order date for all the products that have been ordered.
Include only the records where there are matching orders for the products.

Task 2: List all products, along with their product name, category, price, and any available order information. Retrieve all product records, including those that have not been ordered yet.
Include order information if available.

Task 3:  Display all orders made by customers, including those for products that are no longer available in the store. Retrieve the order ID, customer name, order date, product name, category, and price. 
Include all orders, and display product information if available.
*/

--Task 1
Select Product.productName, Product.productCategory, Product.price, Orders2.customerName, Orders2.orderDate From Product Inner Join Orders2 On Product.productID = Orders2.productID Order By Orders2.customerName;

--Task 2
Select Product.productName, Product.productCategory, Product.price, Orders2.customerName, Orders2.orderDate From Product Left Join Orders2 On Product.productID = Orders2.productID Order By Orders2.customerName;

--Task 2
Alter Table Orders2 Drop Constraint FK__Orders2__product__7B5B524B;
Insert Into Orders2(productID, customerName, orderDate) Values(7, 'C3', GETDATE()),(8, 'C2', GETDATE());
Select Product.productName, Product.productCategory, Product.price, Orders2.customerName, Orders2.orderDate From Product Right Join Orders2 On Product.productID = Orders2.productID Order By Orders2.customerName;


--Customer-Staff-Payment Management Database

Create Table Staff(
	Id int Identity(1,1) Primary Key,
	name varchar(20),
	storeId int,
	recordCreatedOn datetime default(Getdate())
);
Insert into Staff(name, storeId) Values
	('S1', 123),
	('S2',234),
	('S3',123),
	('S4',345);	


Create Table Payments(
	Id int Identity(1,1) Primary Key,
	customerID int Foreign Key References Customer2(Id),
	staffId int Foreign Key References Staff(Id),
	amount money Default(5000),
	paymentDate date Default(Getdate())
);

Insert into Payments(customerID, staffId) Values
	(1, 1),
	(2, 2),
	(1, 3),
	(3, 1);	

Create Table Customer2(
	Id int Identity(1,1) Primary Key,
	name varchar(20),
	contactNo bigint,
	storeId int ,
	recordCreatedOn datetime default(Getdate())
);

Insert into Customer2(name, contactNo, storeId) Values
	('C1', 147852369, 123),
	('C2', 147852369,234),
	('C3', 147852369,123),
	('C4', 147852369,345);	



--Task 1: Show me the customer information with Payment ID , date and amount	
Select Customer2.name, Customer2.contactNo, Customer2.storeId, Payments.Id, Payments.paymentDate, Payments.amount From Customer2 Left Join Payments On Payments.customerID = Customer2.Id;

--Task 2: Show Me staff Information with payment Id and date
Select Staff.name, Staff.storeId, Payments.Id, Payments.paymentDate From Staff Left Join Payments On Payments.staffId = Staff.Id Order by Staff.name;

Create Table Tourists(
	id int Identity(1,1) Primary Key,
	name varchar(20),
	country varchar(20)
);

delete from Tourists;

insert into Tourists values 
	('Ajay', 'India'),
	('Vijay', 'Nepal'),
	('Sanjay', 'Indiana'),
	('Dhananjya', 'Sri Lanka'),
	('Digvijay', 'Poland'),
	('Ramcharan', 'Nepal'),
	('Ram', 'Indiana'),
	('Ram', 'Nepal'),
	('Lakhan', 'Indiana');


Select Count(id) as CountOFCountry, country from Tourists Group By country having  Count(id) >1;

Create Table Supplier(
	id int Identity(1,1) Primary Key,
	name varchar(20)
);

insert into Supplier values 
	('Ajay'),
	('Vijay'),
	('Sanjay'),
	('Dhananjya'),
	('Digvijay'),
	('Ramcharan'),
	('Ram'),
	('Lakhan');


Create Table Products(
	id int Identity(1,1) Primary Key,
	productName varchar(20),
	supplierID int Foreign Key References Supplier(id),
	cost money
);

Insert Into Products Values 
	('Kokain', 1, 15000),
	('Marijuana', 2, 13000),
	('Books', 3, 230),
	('Pens', 4, 270),
	('Notebooks',4, 350),
	('NotePads', 3, 370),
	('Highlighter', 2, 420);

Select * from Supplier;
Select * from Products;
--Select Supplier.name from Supplier inner Join Products On Supplier.id = Products.supplierID Where Products.cost <= 350;
Select * from Supplier Where EXISTS (Select id from Products where Products.supplierID = Supplier.id AND cost <= 350); 

--Duplicate table
Select * from Tourists;
Select * from Tourist2;
Select top 5 * into Tourist2 from Tourists;
Select * from Tourist2;

--Insertion with sub-query

Insert into Tourist2( name, country) Select name, country from Tourists where id >26;

--Case Statements
Select *, 
CASE 
	When country ='Nepal' then 'Neighbour'
	When country ='India' then 'Indian'
	Else 'Foreigner'
End As origin
From Tourist2;


--Create a table to store Batch information and training information.
Select * from Emp;
Select * from Training;
Select * from TrainingStatusRecord;
Select Emp.name, Training.training_name, Training.duration, TrainingStatusRecord.t_status from Emp Inner Join TrainingStatusRecord on Emp.id = TrainingStatusRecord.emp_id Inner Join Training On Training.id = TrainingStatusRecord.train_id;


--Retrieve all product records along with:Product name, Category, Price, Order information (if available)
Select * from Product;
Select * From Customer;
Select * from Orders2;

Select Product.productName, Product.productCategory, Product.price, Orders2.customerName, Orders2.orderDate from Product Left Join Orders2 On Product.productID = Orders2.productID Order By Orders2.customerName;

