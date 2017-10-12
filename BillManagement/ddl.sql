create table BILL_INFORMATION (ID integer not null auto_increment, AMOUNT integer not null, BILL_NUMBER bigint, BILLING_DATE datetime, CUSTOMER_ID integer, primary key (ID)) engine=InnoDB;
create table CUSTOMER (ID integer not null auto_increment, ADDRESS varchar(255), NAME varchar(255), PHONE_NUMBER varchar(255), primary key (ID)) engine=InnoDB;
create table DISTRIBUTOR (ID integer not null auto_increment, ADDRESS varchar(255), NAME varchar(255), PHONE_NUMBER varchar(255), primary key (ID)) engine=InnoDB;
create table PAYMENT_INFORMATION (ID integer not null auto_increment, AMOUNT integer not null, APPROVED bit not null, PAYMENT_DATE datetime, CUSTOMER_ID integer, primary key (ID)) engine=InnoDB;
alter table BILL_INFORMATION add constraint FKb4hmtv7ax996te7l8wfxu321b foreign key (CUSTOMER_ID) references CUSTOMER (ID);
alter table PAYMENT_INFORMATION add constraint FKqb2qjpkpwrxvl7l29hlv1hd9p foreign key (CUSTOMER_ID) references CUSTOMER (ID);