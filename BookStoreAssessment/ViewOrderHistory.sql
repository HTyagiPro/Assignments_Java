Use BookStoresProject;

--Stored Procedure To Generate ViewOrderHistory

CREATE PROCEDURE ViewOrderHistory
    @customerID INT,
	@SumAmount money
AS
BEGIN 
	Select @SumAmount = SUM(amount) from Payments where customerID = @customerID and status = 'Paid' Group By customerID;

	If(@SumAmount is Null)
		Set @SumAmount = 0;

	SELECT Customer.custName,Orders.orderID, Orders.orderDate, @SumAmount as TotalPaid , Orders.shippingAddress, Orders.taxAmount, Orders.discountAmount
    FROM Orders inner join Customer On Customer.customerID=Orders.customerID
    WHERE Customer.customerID = @customerID
    ORDER BY orderDate DESC;

END;