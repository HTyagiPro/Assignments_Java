/*
To Parctice 17 Aug topics

1.Create Database by UI
2.Create Database by code
3.Backup
4.Restore
5.Table Creation by UI
6.Table creation by Code and delete and truncate
7.3 Assignments
8.Insert the data by uI
9.Insert the data by Code
10.Practise on Comment,Id, Created_at

*/

--Creating database
Create database HarProlifics;

--Creating backup
Backup database HarProlifics to disk='C:\Ok_DBbakcup\HarProlifics1.bak';

--using created database
Use HarProlifics;

--creating table in created database
Create table Emp1808(
emp_id int Not Null Unique,
emp_name varchar(20) Null,
emp_dob date Null,
emp_sal money Null,
created_on date Null
);

--Checking table description
EXEC sp_columns Emp1808;

--Inserting data to table
Insert into Emp1808 values
(101,'Ajay Saxena', '2000/12/18',52600, GETUTCDATE()),
(102,'Vijay Saxena', '1997/08/08',62500, GETUTCDATE()),
(103,'Sanjay Saxena', '1999/12/01',25600, GETUTCDATE());

--Reading data from tables
Select * from Emp1808;

--Creating backup
Backup database HarProlifics to disk='C:\Ok_DBbakcup\HarProlifics2.bak';


--Restoring backup
Restore database HarProlifics from disk='C:\Ok_DBbakcup\HarProlifics2.bak';

--Deleting particular record in table
delete Emp1808 where emp_id = 103;

--Delete whole data from table
delete Emp1808;

--Delete table (structure and data)
drop table Emp1808;

--Using another database to Delete current database
drop database HarProlifics;
