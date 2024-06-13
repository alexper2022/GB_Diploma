http://localhost:8080/computer/all  
http://localhost:8080/monitor/all  
http://localhost:8080/printer/all  
http://localhost:8080/ups/all  
http://localhost:8080/user/all

Default admin:  
login: _**admin**_  
password: _**admin2024**_


__DOCKER__

Create diplom PostgreSQL container:  
_**docker run --name diplom -d -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=1 -e
PGDATA=/var/lib/postgresql/data/pgdata -e POSTGRES_DB=diplomdb -v D:\DBPGSQL:/var/lib/postgresql/data/pgdata postgres:
16.2**_

Default postgresql:  
login: _**admin**_  
password: _**1**_

Mount local folder _**D:\DBPGSQL**_ in container folder _**/var/lib/postgresql/data/pgdata**_

Manipulation in diplom container - **_docker exec -it diplom bash_**

_**docker start diplom**_ - start container  
_**docker restart diplom**_ - restart container  
_**docker stop diplom**_ - stop container  
