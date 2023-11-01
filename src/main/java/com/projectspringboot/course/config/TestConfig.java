package com.projectspringboot.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectspringboot.course.entities.User;
import com.projectspringboot.course.repositories.UserRepository;

//classe específica de configuração
@Configuration
//especifica para configuração de teste
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	/**
	 * Na hora que tiver rodando a aplicação, o próprio spring ele vai resolver a dependecia, 
	 * e associar uma instancia de usersRepository
	 * 
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
