create Database IF NOT EXISTS  intership;
use intership;
create table if not exists sys_user(
	id INT NOT NULL primary key,
    name varchar(256) NOT NULL,
    password varchar(256) NOT NULL,
    email varchar(256) NOT NULL
);

