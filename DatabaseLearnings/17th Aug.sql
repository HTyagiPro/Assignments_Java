/* 
create database HarProlifics;
create database HarPro;

use HarPro;
drop database HarProlifics;

backup database HarPro to disk='C:\Ok_DBbakcup\HarPro.bak';

restore database HarPro from disk='C:\Ok_DBbakcup\HarPro.bak';

Create table EmployeeDetails(
emp_id int Not Null,
emp_name varchar(15) null, 
emp_age int null
);

//assignment 2

create table orders(
order_id int Not Null,
order_date date null,
customer_id int Not Null
);


create table customers(
customer_id int Not Null,
customer_phone bigint null,
customer_email text null
);

create table order_items(
customer_id int Not Null,
item_id int Not null
);

create table items(
item_id int Not Null,
item_name varchar(15) null,
item_price money null
);

// Assignment 2

create table property(
location geography Not Null,
budget money null,
type text null
);

//assignment 3

create table buyer(
consumer_id int not null,
dateofDemand date,
consumerName varchar(15),
location geography Null,
budget money null,
type text null
);

//assignment 4
Problem Statement: Inventory Management System

Scenario: You are working on building an inventory management system for a
retail store. The system needs to track product information, stock levels, 
suppliers, and orders.

Assignment Task: Design and create the necessary database tables to store
information about products, suppliers, stock levels, and orders.

create table orders(
order_id int Not Null,
order_date date null,
supplier_id int Not Null
);


create table supplier(
supplier_id int Not Null,
supplier_name varchar(15) null,
supplier_phone bigint null,
supplier_email text null
);

create table order_items(
supplier_id int Not Null,
product_id int Not null
);

create table product(
product_id int Not Null,
product_name varchar(15) null,
product_stockLevel int,
product_price money null
);


select * from Registration;
truncate TABLE Registration;
select * from Registration;

// insertion in table
insert into Registration values('Cheeko', 'cheeko','boyee',1239874560,'2023/2/20','2023/3/30');

// read the data
select username, dob from HarPro.dbo.Registration;

// delete table with data
drop table Registration;

//user table for logIn

Create Table users(
username varchar(20) Not Null Unique,
password text Not Null
);

--inserting values in table


/*
Create a user table and add another column 'name' which u forgot to create while creating table
*/

--Creating Registration table
Create table Registration(
userId int Not Null Unique,
username text null,
password text null
);

--Table description
Exec sp_columns Registration;

--Adding new column in table
Alter Table Registration Add name varchar(20);

--Table description
Exec sp_columns Registration;


*/

