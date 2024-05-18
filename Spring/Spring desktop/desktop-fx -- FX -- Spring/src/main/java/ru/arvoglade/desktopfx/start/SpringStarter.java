package ru.arvoglade.desktopfx.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.arvoglade.desktopfx")
public class SpringStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
