Use BookStores;

--Stored Procedure To Get Popular Books
Create Procedure GeneratePopularBook
	@topPopular int
As
Begin
	Select Top (@topPopular)  Books.title, Books.category, Books.ISBNcode, Books.price, Author.authorName, Publisher.publisherName, COUNT(OrderItems.bookID) as OrderedTimes
	From Books Join Author
	On Books.authorID = Author.authorID Inner Join Publisher
	On Books.publisherID = Publisher.publisherID Left Join OrderItems
	On OrderItems.bookID = Books.bookID
	Group By OrderItems.bookID, Books.title, Books.category, Books.ISBNcode, Books.price, Author.authorName, Publisher.publisherName
	Order By OrderedTimes Desc;
End

--Test Stored Procedure To Get Popular Books
EXEC GeneratePopularBook 2;


