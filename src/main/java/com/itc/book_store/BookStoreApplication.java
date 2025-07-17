package com.itc.book_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		System.out.println("Starting BookStore Application...");
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
