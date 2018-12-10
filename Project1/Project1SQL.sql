create extension pgcrypto;

drop table trmsgrading;
drop table trmsreqs;
drop table trmsfiles;

create table TRMSEvents (
ev_id serial primary key,
ev_name varchar,
ev_cov integer --event coverage--
);

create table TRMSGrading (
g_id serial primary key,
g_type integer,
pass varchar
);

create table TRMSEmp (
emp_id serial primary key,
fname varchar,
lname varchar,
username varchar,
pass varchar,
super integer,
depthead integer,
balance numeric,
emp_type integer
);

create table TRMSReqs (
req_id serial primary key,
emp_id integer,
s_date date not null,
s_time time not null,
a_date timestamptz,
s_location varchar not null,
description varchar not null,
s_cost numeric not null,
g_format integer,
ev_type integer,
just varchar,
t_missed varchar,	
status integer,
urgency integer,
finalg varchar,
foreign key  (emp_id) references TRMSEmp (emp_id),
foreign key (g_format) references TRMSGrading (g_id),
foreign key (ev_type) references TRMSEvents (ev_id)
);

create table TRMSFiles (
file_id serial primary key,
req_id integer,
file varchar not null,
foreign key (req_id) references TRMSReqs (req_id)
);

create table TRMSLogs (
log_id serial primary key,
logdesc varchar,
logtime timestamptz
);

create table TRMSAlerts (
a_id serial primary key,
emp_id integer,
toEmp_id integer,
msg varchar,
checked integer,
foreign key (emp_id) references TRMSEmp (emp_id),
foreign key (toEmp_id) references TRMSEmp (emp_id)
);

insert into TRMSEvents (ev_name, ev_cov) values ('University Course', 80), ('Seminar', 60), ('Certification Preparation Class', 75), 
('Certification', 100), ('Technical Training', 90), ('Other', 30);
select * from TRMSEvents;
	select * from TRMSgrading;
insert into TRMSgrading (g_type, pass) values (1, 'C'), (0, 'C');
insert into TRMSgrading (g_type, pass) values (1, 'C-'), (0, 'C-');
insert into TRMSgrading (g_type, pass) values (1, 'D'), (0, 'D');
insert into TRMSgrading (g_type, pass) values (1, 'C+'), (0, 'C+');
insert into TRMSgrading (g_type, pass) values (1, 'D-'), (0, 'D-');
insert into TRMSgrading (g_type, pass) values (1, 'D+'), (0, 'D+');
insert into TRMSgrading (g_type, pass) values (1, 'B'), (0, 'B');
insert into TRMSgrading (g_type, pass) values (1, 'B-'), (0, 'B-');
insert into TRMSgrading (g_type, pass) values (1, 'B+'), (0, 'B+');
insert into TRMSgrading (g_type, pass) values (1, 'A'), (0, 'A');
insert into TRMSgrading (g_type, pass) values (1, 'A-'), (0, 'A-');
insert into TRMSgrading (g_type, pass) values (1, 'A+'), (0, 'A+');
insert into TRMSgrading (g_type, pass) values (1, 'F'), (0, 'F');
insert into TRMSgrading (g_type, pass) values (1, 'F-'), (0, 'F-');
insert into TRMSgrading (g_type, pass) values (1, 'F+'), (0, 'F+');
select * from trmsalerts;
select * from trmsemp;
select * from trmslogs;
select * from trmsfiles;
select * from trmsreqs;
select * from trmsemp;
select * from trmsgrading;
select * from trmsevents;
insert into TRMSEmp (fname,lname,username,pass,super,depthead,balance, emp_type) values ('Tim', 'Timothy', 'timmy', crypt('pass',gen_salt('bf')), 1, 1, 1000, 1), ('Ben', 'Co', 'benco', crypt('pass',gen_salt('bf')), 1, 2, 1000, 0),
('Joel', 'Joelstar', 'joel', crypt('pass',gen_salt('bf')), 1, 1, 1000, 2), ('Jaron', 'Noraj', 'jaron', crypt('pass',gen_salt('bf')), 3, 1, 1000, 3);
--to check password do crypt('entered_password', pass_in_table)--
update trmsemp set balance=1000 where emp_id = 4;

update trmsemp set balance=1000 where emp_id = 3;

select * from trmsreqs;

select * from trmsreqs order by a_date desc limit 1;

select * from trmsreqs where emp_id in (select emp_id from trmsemp where (super=1 or depthead=1) and emp_id!=1 and (status between 0 and 418));

select * from trmsreqs where status between 0 and 3;

select * from trmsreqs;

select * from trmsreqs where status between 0 and 3;

insert into trmslogs (logtime) values ('now');

select setval('trmsalerts_a_id_seq', 1, false);
delete from trmsalerts;