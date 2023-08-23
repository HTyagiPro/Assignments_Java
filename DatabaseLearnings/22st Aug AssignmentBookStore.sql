--Creating Bookstore database
Create Database BookStores;

--Using Bookstore Database
Use BookStore;

Create Table Books(
	bookID int Primary Key,
	authorID int,
	publisherID int,
	title varchar(50),
	genre varchar(20),
	publicationYear int,
	price money,
	condition varchar(5),
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET())
);

Create Table Author(
	authorID int Identity(1001,1) Primary Key,
	authorName varchar(20) Default('Anonymous'),
	bookID int Foreign Key References Books(bookID)
);


Create Table Publisher(
	publisherID int Identity(10001,1) Primary Key,
	publisherName varchar(20) Default('Prolifics'),
	country varchar(15),
	bookID int Foreign Key References Books(bookID)
);

Create Table Inventory(
	bookID int Foreign Key References Books(bookID) Primary Key,
	stockLevelUsed int,
	stockLevelNew int,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET())
);


Create Table Customer(
	customerID int Identity(101,1) Primary Key,
	custName varchar(20),
	custAddress varchar(100),
	postalCode bigint,
	contactNo bigint,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET())
);

/*
Create Table OrderItems(
	orderID int Identity(1,1) Primary Key,
	customerID int Foreign Key References Customer(customerID),
	bookID int Foreign Key References Books(bookID),
	quantity int,
	price money,
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET())
);
*/

Create Table Orders(
	orderID int,
	customerID int Foreign Key References Customer(customerID),
	bookID int Foreign Key References Books(bookID),
	quantity int,
	orderDate date,
	subtotal money,
	shippingStatus varchar(20),
	recordCreatedOn datetime Default(SYSDATETIMEOFFSET())
);


--Drop Table Sequence to avoid Foreign Key Dependency Conflict
Drop Table Inventory;
Drop Table Publisher;
Drop Table Author;
--Drop Table OrderItems;
Drop Table Orders;
Drop Table Customer;
Drop Table Books;

Select * from Inventory;
Select * from Publisher;
Select * from Author;
--Select * from OrderItems;
Select * from Orders;
Select * from Customer;
Select * from Books;

EXEC sp_columns 'Inventory';
EXEC sp_columns 'Publisher';
EXEC sp_columns 'Author';
--EXEC sp_columns 'OrderItems';
EXEC sp_columns 'Orders';
EXEC sp_columns 'Customer';
EXEC sp_columns 'Books';

--Inserting Data
INSERT INTO Books VALUES
    (1, 1, 1, 'Book 1', 'Fiction', 2020, 19.99, 'New', SYSDATETIMEOFFSET()),
    (2, 2, 2, 'Book 2', 'Mystery', 2018, 15.99, 'Used', SYSDATETIMEOFFSET()),
    (3, 3, 3, 'Book 3', 'Science Fiction', 2021, 24.99, 'New', SYSDATETIMEOFFSET()),
    (4, 4, 4, 'Book 4', 'Romance', 2019, 12.99, 'Used', SYSDATETIMEOFFSET()),
    (5, 5, 5, 'Book 5', 'Fantasy', 2022, 29.99, 'Used', SYSDATETIMEOFFSET());

INSERT INTO Author (authorName, bookID)VALUES
    ('Author 1', 1),
    ('Author 2', 2),
    ('Author 3', 3),
    ('Author 4', 4),
    ('Author 5', 5);

INSERT INTO Publisher (country, bookID)VALUES
    ('Country 1', 1),
    ('Country 2', 2),
    ('Country 3', 3),
    ('Country 4', 4),
    ('Country 5', 5);

INSERT INTO Inventory (bookID, stockLevelUsed, stockLevelNew)VALUES
    (1, 5, 10),
    (2, 3, 8),
    (3, 8, 15),
    (4, 2, 7),
    (5, 10, 20);

INSERT INTO Customer (custName, custAddress, postalCode, contactNo)VALUES
    ('Customer 1', 'Address 1', 12345, 1234567890),
    ('Customer 2', 'Address 2', 23456, 2345678901),
    ('Customer 3', 'Address 3', 34567, 3456789012),
    ('Customer 4', 'Address 4', 45678, 4567890123),
    ('Customer 5', 'Address 5', 56789, 5678901234),
    ('Customer 6', 'Address 6', 67890, 6789012345),
    ('Customer 7', 'Address 7', 78901, 7890123456),
    ('Customer 8', 'Address 8', 89012, 8901234567),
    ('Customer 9', 'Address 9', 90123, 9012345678),
    ('Customer 10', 'Address 10', 12345, 1234567890);

INSERT INTO Orders (orderID, customerID, bookID, quantity, orderDate, subtotal, shippingStatus)VALUES
    (1, 101, 1, 2, '2023-08-01', 39.98, 'Processing'),
    (2, 102, 2, 3, '2023-08-02', 47.97, 'Shipped'),
    (3, 103, 3, 1, '2023-08-03', 24.99, 'Delivered'),
    (4, 104, 4, 2, '2023-08-04', 25.98, 'Processing'),
    (5, 105, 5, 4, '2023-08-05', 119.96, 'Shipped'),
    (6, 106, 5, 1, '2023-08-06', 18.99, 'Delivered'),
    (7, 107, 4, 2, '2023-08-07', 43.98, 'Processing'),
    (8, 108, 3, 1, '2023-08-08', 16.99, 'Shipped'),
    (9, 109, 2, 3, '2023-08-09', 80.97, 'Delivered'),
    (10, 110, 1, 2, '2023-08-10', 29.98, 'Processing');

/*
INSERT INTO OrderItems (bookID, quantity, price)VALUES
    (1, 2, 19.99),
    (2, 3, 15.99),
    (3, 1, 24.99),
    (4, 2, 12.99),
    (5, 4, 29.99),
    (1, 1, 18.99),
    (2, 2, 21.99),
    (3, 1, 16.99),
    (4, 3, 26.99),
    (5, 2, 14.99);
*/
