Use BookStores;

--Search Book Procedures

--Search Book By Id
Create Procedure SearchBookByID
	@id int
As 
Begin
	Select * from Books where bookID = @id;
End

--Test Procedure Search Book By Id
EXEC SearchBookByID 3;


--Search Book By Title
Create Procedure SearchBookByTitle
	@title varchar(255)
As 
Begin
	Select * from Books where title = @title;
End

--Test Procedure Search Book By Id
EXEC SearchBookByTitle 'Coding Masterclass';

--Search Book By AuthorName
Create Procedure SearchBookByAuthor
	@Author varchar(255)
As 
Begin
	Declare @authorID int;
	Select @authorID = authorID from Author where authorName = @Author;
	Select * from Books where authorID = @authorID;
End

--Test Search Book By AuthorName
EXEC SearchBookByAuthor 'Mark Johnson';

