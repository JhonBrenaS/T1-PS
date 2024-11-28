if not exists (select * from sysobjects where name='tipocliente' and xtype='U')
    create table tipocliente (tipocliente_id int primary key, tipocliente_nombre varchar(255));
