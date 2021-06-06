## Start new project

mvn io.quarkus:quarkus-maven-plugin:1.13.1.Final:create -DprojectGroupId=edu.pingpong -DprojectArtifactId=activerecordmultipletables -DclassName="edu.pingpong.activerecordmultipletables.MoviesResource" -Dpath="/movies"

## Extensions

.\mvnw quarkus:list-extensions

.\mvnw quarkus:add-extension -Dextensions="quarkus-jdbc-mysql"

## Docker

docker pull mysql:latest

docker run -it --rm --name mysql_container -e MYSQL_ROOT_PASSWORD=developer -e MYSQL_USR=developer -e MYSQL_PASSWORD=developer -e MYSQL_DATABASE=movies -p 7777:3306 -d mysql:latest

cd src/main/docker

docker build -f Dockerfile.mysql --no-cache -t mysql-container .

docker run -d --name orders-db -p 7777:3306 mysql-container

docker container rm <container name>

## Run

.\mvnw clean compile quarkus:dev -Dquarkus.profile=dev

## Quarkus Dependencies

```
<dependencies>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-jackson</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-arc</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-junit5</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <scope>test</scope>
    </dependency>
    <!-- AssertJ Core -->
    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>3.19.0</version>
      <scope>test</scope>
    </dependency>
    <!-- Hibernate Validator -->
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-validator</artifactId>
    </dependency>
    <!-- Hibernate ORM specific dependencies -->
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-orm-panache</artifactId>
    </dependency>
    <!-- MYSQL extension -->
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-jdbc-mysql</artifactId>
    </dependency>
    <!-- MYSQL test container extension -->
    <dependency>
      <groupId>org.testcontainers</groupId>
      <artifactId>mysql</artifactId>
      <version>1.15.3</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```