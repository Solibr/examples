package com.example.SpringDataH2Connection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataH2ConnectionApplication implements CommandLineRunner {

	private final PersonRepository personRepository;

	public SpringDataH2ConnectionApplication(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataH2ConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nBefore update");
		personRepository.findAll().forEach(System.out::println);

		Person person = new Person("Sam", 35);
		personRepository.save(person);

		System.out.println("\nAfter update");
		personRepository.findAll().forEach(System.out::println);
		System.out.println("\n");
	}
}
