Use BookStores;

--Trigger on Books Table to add book to inventory table
CREATE TRIGGER AfterInsertBook
ON Books
AFTER INSERT
AS
BEGIN
    -- Insert the new book into the Inventory table with default stock levels
    INSERT INTO Inventory (bookID, stockLevelUsed, stockLevelNew)
    SELECT inserted.bookID, 0, 0
    FROM inserted;
END;

--Test Trigger
INSERT INTO Books (authorID, publisherID, title, category, price, ISBNcode, pageCount, publishedYear, condition)
VALUES
    (1001, 10001, 'The Gods Eye', 'Adventure', 25.99, 1234567951123, 350, 2022, 'New');


-- Stored Procedure to add Customer
CREATE PROCEDURE AddCustomer
    @custName varchar(50),
    @email varchar(50),
    @custAddress varchar(100),
    @contactNo bigint
AS
BEGIN
    INSERT INTO Customer (custName, email, custAddress, contactNo)
    VALUES (@custName, @email, @custAddress, @contactNo);
END;

--Testing Stored Procedure to add Customer
EXEC AddCustomer 'John Doe', 'john@example.com', '123 Main St', 123852396;


--Stored Procedure to increase stock levels
Create Procedure AddToStockLevelNew 
	@bookID int
AS
BEGIN
	Declare @oldStock int;
	Select @oldStock = stockLevelNew from Inventory where bookID = @bookID;
	Update Inventory Set stockLevelNew = @oldStock+1 where bookID = @bookID;
END

--Test Stored Procedure to add to StockLevelNew
select * from Inventory;
EXEC AddToStockLevelNew 5;
select * from Inventory;


--Stored Procedure to increase stock levels
Create Procedure AddToStockLevelUsed 
	@bookID int
AS
BEGIN
	Declare @oldStock int;
	Select @oldStock = stockLevelUsed from Inventory where bookID = @bookID;
	Update Inventory Set stockLevelUsed = @oldStock+1 where bookID = @bookID;
END

--Test Stored Procedure to add to StockLevelUsed
select * from Inventory;
EXEC AddToStockLevelUsed 5;
select * from Inventory;


--Stored Procedure to Decrease stock levels
Create Procedure SubstractToStockLevelUsed 
	@bookID int
AS
BEGIN
	Declare @oldStock int;
	Select @oldStock = stockLevelUsed from Inventory where bookID = @bookID;
	Update Inventory Set stockLevelUsed = @oldStock-1 where bookID = @bookID And @oldStock >0;
END

--Stored Procedure to Decrease stock levels
Create Procedure SubstractToStockLevelNew 
	@bookID int
AS
BEGIN
	Declare @oldStock int;
	Select @oldStock = stockLevelNew from Inventory where bookID = @bookID;
	Update Inventory Set stockLevelNew = @oldStock-1 where bookID = @bookID And @oldStock >0;
END


--Test Stored Procedure to sybstract to StockLevelUsed
select * from Inventory;
EXEC SubstractToStockLevelNew 5;
select * from Inventory;
