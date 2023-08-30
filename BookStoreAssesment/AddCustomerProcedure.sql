Use BookStores;

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
