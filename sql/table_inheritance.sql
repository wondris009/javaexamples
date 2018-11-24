create table child_table_january (
	check (hashtime >= date '2015-01-01' and hashtime <= '2015-01-31')
) inherits (mother_table);

create table child_table_february (
	check (hashtime >= date '2015-02-01' and hashtime <= '2015-02-28')
) inherits (mother_table);

create table child_table_march (
	check (hashtime >= date '2015-03-01' and hashtime <= '2015-03-31')
) inherits (mother_table);

create table child_table_april (
	check (hashtime >= date '2015-04-01' and hashtime <= '2015-04-30')
) inherits (mother_table);


