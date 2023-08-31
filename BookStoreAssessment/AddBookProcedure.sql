Use BookStores;

--Creating Stored procedure to Add Book
CREATE Procedure AddBook
	@authorID int ,
	@publisherID int ,
	@title varchar (255),
	@category varchar (127),
	@price money,
	@ISBNcode bigint,
	@pageCount int,
	@condition varchar(5),
	@publishedYear int
AS
BEGIN
Insert Into Books(authorID, publisherID, title, category, price, ISBNcode, pageCount, publishedYear, condition) 
values
	(@authorID, @publisherID, @title, @category, @price, @ISBNcode, @pageCount, @publishedYear, @condition)
END
GO

--Test Stored procedure to Add Book
EXEC AddBook
	@authorID = 1001 ,
	@publisherID = 10001 ,
	@title = 'The Vampire Diaries',
	@category = 'Super Naturals',
	@price = 1500,
	@ISBNcode = 1472361,
	@pageCount = 650,
	@condition = 'New',
	@publishedYear = 2016;




