create schema if not exists car_lot;
use car_lot;

create table car (
	id		INT NOT NULL,
    make	VARCHAR(50),
    model	VARCHAR(50),
    model_year	VARCHAR(4),
    color	VARCHAR(50),
	PRIMARY KEY (id)
);