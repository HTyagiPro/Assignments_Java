Use BookStores;

ALTER PROCEDURE PlaceOrder
    @customerID INT,
    @orderDate DATETIME,
    @shippingAddress VARCHAR(100),
    @bookID INT,
    @quantity INT,
    @priceOfUnitQuantity MONEY,
    @taxAmount MONEY,
    @discountAmount MONEY,
	@bookType VARCHAR(16)
	
AS
BEGIN
    DECLARE @orderID INT;
	DECLARE @presentStockLevelNew INT;
	DECLARE @presentStockLevelUsed INT;
	DECLARE @passcode varchar(100)
	Select @presentStockLevelNew = stockLevelNew, @presentStockLevelUsed = stockLevelUsed from Inventory where bookID = @bookID;
	Select @passcode = passcode from Users where username = @customerID;
	
	If((dbo.UserLogInFun(@customerID,@passcode)) = 1)
	Begin
--	PRINT @presentStockLevelNew;
--	PRINT @presentStockLevelUsed;

	If (@bookType like 'New')
		Begin
			--Print @bookType;
			If(@presentStockLevelNew >= @quantity)
			Begin
				--PRINT @presentStockLevelUsed;
				Declare @i int;
				Set @i = 1;
				While (@i <=@quantity)
				Begin
						EXEC SubstractToStockLevelNew @bookID;
						Set @i = @i +1;
				End
			 -- Insert into Orders table
				INSERT INTO Orders (customerID, orderDate, totalAmount, shippingAddress, taxAmount, discountAmount)
				VALUES (@customerID, @orderDate, @quantity * @priceOfUnitQuantity, @shippingAddress, @taxAmount, @discountAmount);

				-- Get the generated orderID
				SET @orderID = SCOPE_IDENTITY();

				-- Insert into OrderItems table
				INSERT INTO OrderItems (orderID, bookID, quantity, priceOfUnitQuantity)
				VALUES (@orderID, @bookID, @quantity, @priceOfUnitQuantity);

				-- Insert into Payments table
				INSERT INTO Payments (orderID, customerID, paymentDate, amount, status)
				VALUES (@orderID, @customerID, @orderDate, @quantity * @priceOfUnitQuantity - @discountAmount + @taxAmount, 'Pending');
			End
				Else
					PRINT 'The order Quantity is not available.';
		End

		--If Orderd Used Books
		If (@bookType like 'Used')
		Begin
			--Print @bookType;
			If(@presentStockLevelUsed >= @quantity)
			Begin
				--PRINT @presentStockLevelUsed;
				Declare @j int;
				Set @j = 1;
				While (@j <=@quantity)
				Begin
						EXEC SubstractToStockLevelUsed @bookID;
						Set @j = @j +1;
				End
			 -- Insert into Orders table
				INSERT INTO Orders (customerID, orderDate, totalAmount, shippingAddress, taxAmount, discountAmount)
				VALUES (@customerID, @orderDate, @quantity * @priceOfUnitQuantity, @shippingAddress, @taxAmount, @discountAmount);

				-- Get the generated orderID
				SET @orderID = SCOPE_IDENTITY();

				-- Insert into OrderItems table
				INSERT INTO OrderItems (orderID, bookID, quantity, priceOfUnitQuantity)
				VALUES (@orderID, @bookID, @quantity, @priceOfUnitQuantity);

				-- Insert into Payments table
				INSERT INTO Payments (orderID, customerID, paymentDate, amount, status)
				VALUES (@orderID, @customerID, @orderDate, @quantity * @priceOfUnitQuantity - @discountAmount + @taxAmount, 'Pending');
			End
				Else
					PRINT 'The order Quantity is not available.';
		End
		End 
			Else
				PRINT 'Customer Need to be added';
END;



EXEC PlaceOrder
    @customerID = 111,
    @orderDate = '2023-08-30 10:00:00',
    @shippingAddress = '123 Main St',
    @bookID = 3,
    @quantity = 1,
    @priceOfUnitQuantity = 25.99,
    @taxAmount = 3.00,
    @discountAmount = 1.00,
	@bookType = 'Used';

