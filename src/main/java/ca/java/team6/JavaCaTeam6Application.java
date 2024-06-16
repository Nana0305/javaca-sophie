package ca.java.team6;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ca.java.team6.entities.Admin;
import ca.java.team6.repositories.AdminRepository;

@SpringBootApplication
public class JavaCaTeam6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaCaTeam6Application.class, args);
	}
	@Bean
	CommandLineRunner loadAdmin(AdminRepository adminRepo) {
		return args -> {
			System.out.println("---- clear admin table ----");
			adminRepo.deleteAll();
			System.out.println("---- create admin -----");
			adminRepo.save(new Admin("admin123", "password"));
			System.out.println("---- find admin ----");
			List<Admin> admins = adminRepo.findAll();
			admins.forEach(admin -> System.out.println(admin));
		};	
	}

}
