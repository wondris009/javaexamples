-- add some entry to original table
insert into student(name) values('Jose Manilla');

-- create table from existing table
-- CREATE TABLE 'NEW_TABLE_NAME' AS SELECT * FROM 'TABLE_NAME_YOU_WANT_COPY';
 
-- select data from table to create another table
-- SELECT * INTO 'NEW_TABLE_NAME' FROM 'TABLE_NAME_YOU_WANT_COPY' ;

-- examples
	create table student_bk as select * from student;
	
	select * into student_bk2 from student;