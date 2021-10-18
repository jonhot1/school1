package pt.iade.school1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.iade.school1.models.StudentRepository;

@SpringBootApplication
public class School1Application {

	public static void main(String[] args) {
		SpringApplication.run(School1Application.class, args);
		StudentRepository.populate();
	}

}
