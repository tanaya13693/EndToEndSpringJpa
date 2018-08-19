create table studenttab(
    ID Integer not null PRIMARY KEY,
    sname varchar(20),
    scourse varchar(30),
    sfee int    
);

select * from studenttab;

select * from location;
select type,count(type) from location group by type;
delete from location;
commit;


