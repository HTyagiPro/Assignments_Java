Use BookStores;

CREATE PROCEDURE PlaceOrder
    @customerID INT,
    @orderDate DATETIME,
    @shippingAddress VARCHAR(100),
    @bookID INT,
    @quantity INT,
    @priceOfUnitQuantity MONEY,
    @taxAmount MONEY,
    @discountAmount MONEY
AS
BEGIN
    DECLARE @orderID INT;

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
END;



EXEC PlaceOrder
    @customerID = 109,
    @orderDate = '2023-08-30 10:00:00',
    @shippingAddress = '123 Main St',
    @bookID = 7,
    @quantity = 2,
    @priceOfUnitQuantity = 25.99,
    @taxAmount = 3.00,
    @discountAmount = 1.00;

