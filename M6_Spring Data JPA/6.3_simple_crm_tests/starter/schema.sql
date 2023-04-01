create schema simple_crm;
use simple_crm;

create table customer (
	id int not null auto_increment primary key,
    company varchar(50) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone varchar(50) not null
);

create table note (
	id int not null auto_increment primary key,
    content varchar(255) not null,
    customer_id int not null
);

/* Foreign Keys: note */
alter table note add constraint fk_note_customer foreign key (customer_id) references customer(id);
