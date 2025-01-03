# SpringDataREST_ExploreMN
SpringBoot RESTful microservices project for managing and rating tour packages and tours 
<br> Tools:
Java 21, Maven, MySQL, Spring JPA, Spring MVC, Docker
Swagger, Open API, JSON, Lombok 
<br> Fat jar deployed localy exposes endpoints that can be tested with Swagger 

1) copy previous H2 based project 

2) init new git repo

3) install docker desktop locally

4) containerize ExploremnJPA application 
<br>a) add JIB maven plugin to POM
<br>b) add jib/ExploreMN.json -> this file is referenced from @SprinBootApplication
annnotated CommandLineRunner class when starting Docker image 
<br>c) mvn jib:dockerBuild -> build docker image
<br>d) docker images
<br>e) docker run -p 8080:8080 exploremn-jpa:0.0.1-SNAPSHOT
<br>f) http://localhost:8080/swagger-ui/index.html
<br>g) docker ps -a (list containers)
<br>h) docker stop guid (stop container)
<br>i) docker rm guid (remove container)
<br>j) docker rmi exploremn-jpa:0.0.1-SNAPSHOT (remove image)

5) to orchestrate interaction between exploremn-jpa and mysql 
<br>a) include spring-boot-docker-compose into POM
<br>b) add mysql-connector-j driver to POM
<br>c) add compose.yml with mysql configuration/env vars

6) to use flywaydb for incremental updates of the mysql DB
<br>a) add flyway-core, flyway-mysql to pom.xml (automatically manages triggering of inc schema updates)
<br>b) add schema update scripts to resources/db/migration
<br>c) application.properties -> dont allow hibernate to create DDL -> use flyway instead
<br>d) update ExploremnJpaApplication.java to remove loading from JSON file
<br>e) mvn install spring-boot:run
<br>f) mvn spring-boot:run



