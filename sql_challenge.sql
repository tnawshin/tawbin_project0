--1. Create and Add 3 records in each table:

create table Products(
productID int identity(1,1) not null primary key,
productName varchar(max) not null,
productCategory varchar(30) null,
productColor varchar(20) null,
price int not null
);


create table Customers(
customerID int identity(1,1) not null primary key,
FirstName varchar(50) not null,
LastName varchar(50) not null,
Address_Line1 varchar(50) null,
City varchar(20) null,
provinceState varchar(20) null,
zipCode int null,
cardNumber int not null
);


create table Orders(
orderID int identity(1,1) not null primary key,
orderDate datetime not null,
qtyAvailable int null,
qtySold int null,
dateSold datetime,
customerID int not null,
productID int not null

constraint FK_Product_Orders foreign Key (productId)
		references Products(productID)
	on delete cascade 
	on update cascade

constraint FK_Customer_Orders foreign Key (customerId)
		references Customers(customerID)
	on delete cascade 
	on update cascade
);


--2. Add product iPhone priced $200: 

insert into Products(productName,Price) 
values ('iPhone',200)

--3. Add customer Tina Smith. Added the card number becuase the field is not null

insert into Customers(FirstName,LastName,cardNumber) 
values ('Tina','Smith', 489750015550)

--4. Create order for Tina Smith bought an iPhone
create procedure sp_CreateCustOrder
@id int, @qtySold int, @custID int, @prodID int
as 
begin
	begin try		
		begin transaction
			update order
			set qtyAvailable=qtyAvailable-@qtysold
			where orderId=@id and 
				  customerID = @custID and
				  productID = @prodID

			insert into Orders (orderid,qtysold,datesold, customerid, productid)
			values (@id,v@qtysold, getdate(), @custID, @prodID)
			
		commit transaction;
	end try
	begin catch 
		rollback transaction;
	end catch
end

--Execute the transaction/procedure
exec sp_CreateCustOrder 1


--5. Report all orders by Tina Smith

select c.firstName, c.LastName, ord.orderId, ord.qtySold
from orders as ord
Left Join customers as c
where c.firstName = 'Tina' and
	c.LastName = 'Smith'
group by c.firstName, c.LastName
order by c.firstName, c.LastName


--6. Report all revenue genetrated by sales of iPhone and increase the price of iPhone to $250

select sum(ord.qtySold) as RevenueFromSales, p.productName
from orders as ord, products as p
where p.productID = ord.ProductID

update products
set products.price = 250
where productName = 'iPhone'













