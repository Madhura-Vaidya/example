package com.example;

import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {
	@Autowired
	BookService bookservice;

	public static void main(String[] args) {

		SpringApplication.run(ExampleApplication.class, args);
	}



	private void createBooks(){
		bookservice.saveBook("The Monk who sold his ferrari",
				"Robin Sharma", LocalDate.now(),false);
		bookservice.saveBook("Reboot",
				"Satya Nadella", LocalDate.now(),false);
		bookservice.saveBook("My Life in full",
				"Indra Nooyi", LocalDate.now(),false);
		bookservice.saveBook("Sunny Days",
				"Sunil Gavaskar", LocalDate.now(),true);
		bookservice.saveBook("Playing it My way",
				"Sachin Tendulkar", LocalDate.now(),true);
		bookservice.saveBook("The General's Dog",
				"Frank Murphy", LocalDate.now(),true);
	}

	@Override
	public void run(String... args) throws Exception {
		createBooks();
		System.out.println("The number of books are" + bookservice.count());
	}
}
