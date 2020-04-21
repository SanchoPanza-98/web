drop database if exists shop;
create database shop;
use shop;

create table roles(
id int(9) not null auto_increment,
name ENUM('BUYER','ADMIN') not null,
primary key(id)
)default charset ='utf8';

create table user(
id int(9) not null auto_increment,
login varchar(50) not null,
password varchar(50) not null,
roleid int(9) not null,
foreign key(roleid) references roles(id),
primary key(id)
)default charset ='utf8';

create table buyer(
id int(9) not null auto_increment,
firstName varchar(45) not null,
secondName varchar(45) not null,
patronymic varchar(45) default null,
birthday date not null,
telephoneNumber varchar(20) default null,
email varchar(50) not null,
userId int(9) not null,
foreign key(userId) references user(id),
primary key(id),
unique(email),
unique(telephoneNumber)
)default charset='utf8';

create table product(
id int(9) not null auto_increment,
productName varchar(45) not null,
cost int not null,
primary key(id)
)default charset='utf8';

create table basket(
id int(9) not null auto_increment,
buyerid int(9) default null,
primary key(id),
foreign key(buyerid) references buyer(id) on delete cascade
)default charset='utf8';

create table purchase(
id int(9) not null auto_increment,
buyerid int(9) default null,
purchaseDate datetime default null,
payment enum('BANKCARD','EWALLET'),
sum int not null,
primary key(id),
foreign key(buyerid) references buyer(id) on delete cascade
)default charset='utf8';


create table selectedProductsInBasket(
id int(9) not null auto_increment,
basketid int(9) not null,
productid int(9) default null,
quantity int not null,
primary key(id),
foreign key(basketid) references basket(id) on delete cascade,
foreign key(productid) references product(id) on delete cascade
)default charset='utf8';

create table selectedProductsInPurchase(
id int(9) not null auto_increment,
purchaseid int(9) not null,
productid int(9) not null,
quantity int not null,
primary key(id),
foreign key(purchaseid) references purchase(id) on delete cascade,
foreign key(productid) references product(id) on delete cascade
)default charset='utf8';

select*from buyer;
select*from product;
select*from purchase;
select*from basket;
select* from selectedProductsInPurchase;
select * from selectedProductsInBasket;

insert into roles values(1,'BUYER'),(2,'ADMIN');
select * from roles;
insert into product values (1,'Computer',25000);
insert into product values (2,'Computer2',45000);

insert into user values(1,'login1','1*2*3*4',1);
insert into buyer value(1,'Ivan','Ivanov',null,'1999-01-21','88889898988','ivanIvan@mail.ru',1);
insert into basket value(1,1);

select*from buyer;
select *from product;
