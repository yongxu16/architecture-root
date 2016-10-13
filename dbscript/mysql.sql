CREATE DATABASE arch1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into tb_customer (customerId,pwd,showName,trueName,registerTime)
 values ('c1','1','c1s','c1t',11);


drop table if exists tb_customer;
create table tb_customer
(
   uuid                    int not null auto_increment,
   customerId              varchar(20),
   pwd                     varchar(20),
   showName                varchar(100),
   trueName                varchar(100),
   registerTime            varchar(100),
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_goods;
create table tb_goods
(
   uuid                    int not null auto_increment,
   name                    varchar(200),
   imgPath                 varchar(500),
   description             varchar(2000),
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_cart;
create table tb_cart
(
   uuid                    int not null auto_increment,
   customerUuid            int,
   goodsUuid               int,
   buyNum                  int,
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_order;
create table tb_order
(
   uuid                    int not null auto_increment,
   customerUuid            int,
   orderTime               varchar(100),
   totalMoney              float,
   saveMoney               float,
   state                   smallint,
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_orderDetail;
create table tb_orderDetail
(
   uuid                    int not null auto_increment,
   orderUuid               int,
   goodsUuid               int,
   orderNum                int,
   price                   float,
   money                   float,
   saveMoney               float,
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_store;
create table tb_store
(
   uuid                    int not null auto_increment,
   goodsUuid               int,
   storeNum                int,
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb_file;
create table tb_file
(
   uuid                    int not null auto_increment,
   fileName                varchar(1000),
   remotePaths             varchar(1000),
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;
