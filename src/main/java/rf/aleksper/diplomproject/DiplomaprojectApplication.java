package rf.aleksper.diplomproject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rf.aleksper.diplomproject.entities.UserEntity;
import rf.aleksper.diplomproject.services.UserService;

@SpringBootApplication
public class DiplomaprojectApplication {
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DiplomaprojectApplication.class, args);
	}
	
	@Bean
	InitializingBean initUserIfNoUserInDatabase() {
		//check if the user is in the database, if not, then add
		return () -> {
			if (userService.findAll().isEmpty()) {
				userService.addUser(new UserEntity("admin", "admin2024", "admin",
						"admin", "2024", "admin@admin", "+73222233322"));
			}
		};
	}
}
