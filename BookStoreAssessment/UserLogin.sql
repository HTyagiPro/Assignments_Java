ALTER PROCEDURE UserLogin
    @username VARCHAR(50),
    @password VARCHAR(100)
AS
BEGIN
    DECLARE @storedPasswordHash VARCHAR(100);

    -- Get the stored password hash for the provided username
    SELECT @storedPasswordHash = passcode
    FROM Users
    WHERE username = @username;

    -- Hash the provided password using the same algorithm
    DECLARE @inputPasswordHash VARCHAR(100);
    --SET @inputPasswordHash = CONVERT(VARCHAR(100), HASHBYTES('SHA2_512', @password), 2);



    -- Check if the provided password hash matches the stored password hash
    IF @storedPasswordHash = @password
    BEGIN
        PRINT 'Login successful';
        -- You might add additional actions here, like setting a session token or updating login history.
    END
    ELSE
    BEGIN
        PRINT 'Login failed';
    END;
END;


Alter Function UserLogInFun(@username INT, @password BIGINT)
RETURNS bit
As
Begin
 DECLARE @storedPasswordHash VARCHAR(100);

    -- Get the stored password hash for the provided username
    SELECT @storedPasswordHash = passcode
    FROM Users
    WHERE username = @username;

    -- Hash the provided password using the same algorithm
    DECLARE @inputPasswordHash BIGINT;
    --SET @inputPasswordHash = CONVERT(VARCHAR(100), HASHBYTES('SHA2_512', @password), 2);



    -- Check if the provided password hash matches the stored password hash
    IF @storedPasswordHash = @password
    BEGIN
        --PRINT 'Login successful';
        -- You might add additional actions here, like setting a session token or updating login history.
		return 1;
    END
    ELSE
    BEGIN
        --PRINT 'Login failed';
		return 0;
    END;
	return 0;
End


--Test User Login
EXEC UserLogin 111, 1295136396;

PRINT (dbo.UserLogInFun(171, 1295136396));