package com.gcu;

/**
 * Part 2: Creating Data Services using Spring Data JDBC
Overview
Goal and Directions:
In this activity, you will code a data service using the Repository design pattern to persist data to
a relational MySQL database using Spring Data JDBC. We will use the standard CRUD
Repository that is built into Spring Data JDBC, which provides an ORM like interface that
allows you to easily persist object to and from the database without having to write SQL and is
mapped to an existing database schema. The proper design and separation of both application
object models and entity object models will also be demonstrated, such that the presentation
layer is not polluted with data persistence technologies.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.gcu"})
@SpringBootApplication
public class Topic43Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic43Application.class, args);
	}

}
