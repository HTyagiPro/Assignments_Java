
--Procedure to User Registration
ALTER PROCEDURE RegisterUser
    @username VARCHAR(50),
    @password VARCHAR(255),
    @email VARCHAR(100)
AS
BEGIN
    DECLARE @passcode VARCHAR(100);
    
    -- Hash the password (use appropriate hashing algorithm)
    SET @passcode = HASHBYTES('SHA2_512', @password);

    -- Insert user data into Users table
    INSERT INTO Users (username, passcode, email)
    VALUES (@username, @password, @email);
END;

EXEC RegisterUser
    @username = 'user1',
    @password = 'hello1',
    @email = 'user1@example.com';
