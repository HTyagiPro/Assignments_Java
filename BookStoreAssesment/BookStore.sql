--Creating Bookstore database
Create Database BookStores;

--Using Bookstore Database
Use BookStores;

--Creating Books Table
Create Table Books(
	bookID int Identity(1,1) Primary Key,
	authorID int Foreign Key References Author(authorID),
	publisherID int Foreign Key References Publisher(publisherID),
	title varchar (255)  Not Null Unique,
	category varchar (127) Not Null,
	price money Not Null,
	ISBNcode bigint Not Null Unique,
	pageCount int Not Null,
	publishedYear int Not Null,
	condition varchar (5) Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp 
);


--Creating Author Table
Create Table Author(
	authorID int Identity(1001,1) Primary Key,
	authorName varchar(50) Default('Anonymous'),
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating Publisher Table
Create Table Publisher(
	publisherID int Identity(10001,1) Primary Key,
	publisherName varchar(50) Default('Prolifics'),
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating Inventory Table
Create Table Inventory(
	inventoryID int Identity(1,1) Primary Key,
	bookID int Foreign Key References Books(bookID),
	stockLevelUsed int Not Null,
	stockLevelNew int Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating Customer Table
Create Table Customer(
	customerID int Identity(101,1) Primary Key,
	custName varchar(255) Not Null,
	email varchar(100) Not Null Unique,
	custAddress varchar(100) Not Null,
	contactNo bigint Not Null Unique,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);



--Creating Orders Table
Create Table Orders(
	orderID int Identity(1,1) Primary Key,
	customerID int Foreign Key References Customer(customerID),
	orderDate datetime Not Null,
	totalAmount money Not Null,
	shippingAddress varchar(100) Not Null,
	taxAmount money Not Null,
	discountAmount money Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating Order Items Table
Create Table OrderItems(
	ID int Identity(1,1) Primary Key,
	orderID int Foreign Key References Orders(orderID),
	bookID int Foreign Key References Books(bookID),
	quantity int Default(0) Not Null,
	priceOfUnitQuantity money Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating Payments Table
Create Table Payments(
	paymentID int Identity(1,1) Primary Key,
	orderID int Foreign Key References Orders(orderID),
	customerID int Foreign Key References Customer(customerID),
	paymentDate datetime Not Null,
	amount money Not Null,
	status varchar(120) Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);

--Creating CustomerActivity log table
Create Table CustomerActivity(
	id int Identity Primary Key,
	customerID int Foreign Key References Customer(customerID),
	activity text Not Null,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET()),
	rowVersion timestamp
);


Select * from OrderItems

Select bookID, count(bookID) from OrderItems group by bookID;

--Drop Sequence
Drop Table Inventory;
Drop Table Publisher;
Drop Table Author;
Drop Table OrderItems;
Drop Table Books;
Drop Table Orders;
Drop Table Customer;
Drop Table Books;

--To Drop Whole database
Use db;
Drop database BookStores;
