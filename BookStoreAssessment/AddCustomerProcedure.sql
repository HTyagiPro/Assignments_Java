Use BookStores;

-- Stored Procedure to add Customer
ALTER PROCEDURE AddCustomer
    @custName varchar(50),
    @email varchar(50),
    @custAddress varchar(100),
    @contactNo bigint,
	@existing_username int,
	@existing_passcode Bigint
AS
BEGIN
	If((dbo.UserLogInFun(@existing_username, @existing_passcode)) = 1)
	Begin
    INSERT INTO Customer (custName, email, custAddress, contactNo)
    VALUES (@custName, @email, @custAddress, @contactNo);
	END
	Else 
		PRINT 'Log In with valid credentials.'
END;


Create Trigger AddCustomerAsUser 
On Customer
AFTER INSERT
AS
BEGIN
	DECLARE @username varchar(255);
	DECLARE @passcode varchar(100);
	DECLARE @email varchar(100);

	Select @username = inserted.customerID, @passcode = inserted.contactNo, @email = inserted.email From inserted;

	INSERT INTO Users (username, passcode, email)
	VALUES(@username, @passcode,@email) 
END


--Testing Stored Procedure to add Customer
EXEC AddCustomer 'A', 'a@example.com', '123 Main St', 2305136396;
