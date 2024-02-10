### DB console 작성
```
show databases;

create database board;

create user 'discipline'@'localhost' identified by 'Discipline1999!';

select `user` from `mysql`.user;

show grants for 'discipline'@'localhost';

grant all on `board`.* to 'discipline'@'localhost';

flush privileges;
```
