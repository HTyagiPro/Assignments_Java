Use BookStoresProject;

--Stored Procedure to Generate Report 
Create Procedure GetReports
	@bookID int 
As
Begin
	Select Books.title,Books.category,Books.ISBNcode, Books.price, Author.authorName, Publisher.publisherName, COUNT(OrderItems.bookID) As TotalOrders, Inventory.stockLevelNew, Inventory.stockLevelUsed
	From Books Inner Join Author 
	On Books.authorID = Author.authorID Inner Join Publisher
	On Books.publisherID = Publisher.publisherID Inner Join OrderItems
	On Books.bookID = OrderItems.bookID Inner Join Inventory
	On Books.bookID = Inventory.bookID
	Where Books.bookID = @bookID
	Group By OrderItems.bookID, Books.title, Books.category, Books.ISBNcode, Books.price, Author.authorName, Publisher.publisherName, Inventory.stockLevelNew, Inventory.stockLevelUsed;

End


--Testing Stored Procedure to Generate Report
EXEC GetReports 3;
