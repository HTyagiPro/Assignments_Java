-- Inserting records into Author table
INSERT INTO Author (authorName)
VALUES
    ('John Doe'),
    ('Jane Smith'),
    ('Mark Johnson'),
    ('Emily White'),
    ('Michael Brown'),
    ('Sarah Lee'),
    ('David Miller'),
    ('Emma Taylor'),
    ('Christopher Wilson'),
    ('Olivia Martinez');

-- Inserting records into Publisher table
INSERT INTO Publisher (publisherName)
VALUES
    ('ABC Publications'),
    ('XYZ Books'),
    ('Sunrise Publishing'),
    ('Moonlight Press'),
    ('Star Books'),
    ('Golden Pages'),
    ('Crystal Publishing'),
    ('Harbor Publishers'),
    ('Rainbow Prints'),
    ('Swift Publications');

-- Inserting records into Customer table
INSERT INTO Customer (custName, email, custAddress, contactNo)
VALUES
    ('Alice Johnson', 'alice@example.com', '123 Main St', 1234567890),
    ('Bob Smith', 'bob@example.com', '456 Elm St', 9876543210),
    ('Eve Brown', 'eve@example.com', '789 Oak St', 5678901234),
    ('William Davis', 'william@example.com', '567 Pine St', 4567890123),
    ('Sophia Martinez', 'sophia@example.com', '890 Maple St', 3456789012),
    ('Daniel Thompson', 'daniel@example.com', '123 Cedar St', 2345678901),
    ('Lily Harris', 'lily@example.com', '456 Birch St', 9874567890),
    ('Jackson Adams', 'jackson@example.com', '789 Walnut St', 9876123210),
    ('Ava Miller', 'ava@example.com', '567 Oak St', 8727632109),
    ('Ethan Scott', 'ethan@example.com', '890 Pine St', 7654331998);

-- Inserting records into Books table
INSERT INTO Books (authorID, publisherID, title, category, price, ISBNcode, pageCount, publishedYear, condition)
VALUES
    (1001, 10001, 'The Great Adventure', 'Adventure', 25.99, 1234567890123, 350, 2022, 'New'),
    (1002, 10002, 'Coding Masterclass', 'Programming', 49.99, 9876543210456, 450, 2021, 'New'),
    (1003, 10003, 'Mystery at Midnight', 'Mystery', 19.99, 3456789012345, 280, 2023, 'New');
    -- Add more records here

-- Inserting records into Inventory table
INSERT INTO Inventory (bookID, stockLevelUsed, stockLevelNew)
VALUES
    (1, 5, 25),
    (2, 3, 20),
    (3, 8, 15);
    -- Add more records here

-- Inserting records into Orders table
INSERT INTO Orders (customerID, orderDate, totalAmount, shippingAddress, taxAmount, discountAmount)
VALUES
    (101, '2023-08-30 10:00:00', 30.99, '123 Main St', 3.00, 1.00),
    (102, '2023-08-29 15:30:00', 60.99, '456 Elm St', 6.00, 2.50),
    (103, '2023-08-28 09:45:00', 15.50, '789 Oak St', 1.50, 0.50);
    -- Add more records here

-- Inserting records into OrderItems table
INSERT INTO OrderItems (orderID, bookID, quantity, priceOfUnitQuantity)
VALUES
    (1, 1, 2, 25.99),
    (1, 3, 1, 19.99),
    (2, 2, 3, 49.99);
    -- Add more records here

-- Inserting records into Payments table
INSERT INTO Payments (orderID, customerID, paymentDate, amount, status)
VALUES
    (1, 101, '2023-08-30 11:00:00', 30.99, 'Paid'),
    (3, 102, '2023-08-29 16:00:00', 60.99, 'Paid'),
    (2, 103, '2023-08-28 10:00:00', 15.50, 'Pending');
    -- Add more records here
