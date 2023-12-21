package com.example.demo;

import com.example.demo.commands.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("CommandMap")
	private Map<String, CommandHandler> commandHandlerMap;

	public static void main(String[] args) {

		System.out.println("Args:");
		for (int i = 0; i < args.length; i++) {
			System.out.println("\t" + args[i]);
		}
		System.out.println();

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String[] command = scanner.nextLine().trim().split(" ");
			if (command.length == 0 || command[0].isEmpty() || command[0].isBlank())
				continue;
			CommandHandler commandHandler = commandHandlerMap.get(command[0]);
			if (commandHandler != null)
				commandHandler.execute(command);
			else
				System.out.println("\"" + command[0] + "\" is not a command" );
		}
	}
}
