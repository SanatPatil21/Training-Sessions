--29th Jan, working with JDBC
/*
CLASSPATH COMMAND
set classpath=driver/postgresql-42.7.4.jar;.;%classpath%

*/
create table employee2(name varchar(20),age int);
	
select * from employee2;
delete from employee2;

create or replace procedure dummy_record()
language plpgsql
as $$
begin
	insert into  EMPLOYEE2 values('Guest',21);

end;
$$