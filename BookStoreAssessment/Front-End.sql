--For User Registration
EXEC RegisterUser
    @username = 'user',
    @password = 'hello',
    @email = 'user@example.com';

--To Add Book
EXEC AddBook
	@authorID = 1004 ,
	@publisherID = 10004 ,
	@title = 'How to become rich',
	@category = 'Pleasure reading',
	@price = 1600,
	@ISBNcode = 1472366,
	@pageCount = 657,
	@condition = 'New',
	@publishedYear = 2022;

--To Search Book By Id
EXEC SearchBookByID 3;

--To Search Book By Id
EXEC SearchBookByTitle 'Coding Masterclass';

--To Search Book By AuthorName
EXEC SearchBookByAuthor 'Mark Johnson';

--To Get Popular Books
EXEC GeneratePopularBook 5;

--To Place Order
EXEC PlaceOrder
    @customerID = 111,
    @orderDate = '2023-08-30 10:00:00',
    @shippingAddress = '123 Main St',
    @bookID = 3,
    @quantity = 15,
    @priceOfUnitQuantity = 25.99,
    @taxAmount = 3.00,
    @discountAmount = 1.00,
	@bookType='New';

--To add Customer
EXEC AddCustomer 'C', 'c@example.com', '123 Main St', 97989879897, 111, 1295136396;

--To add to StockLevelNew
EXEC AddToStockLevelNew 5;

--To add to StockLevelUsed
EXEC AddToStockLevelUsed 5;

--To substract to StockLevelUsed
EXEC SubstractToStockLevelUsed 5;

--To substract to StockLevelNew
EXEC SubstractToStockLevelNew 5;

--To Generate Report
EXEC GetReports 3;

--To View Order History Of a Customer
EXEC ViewOrderHistory @customerID=102

