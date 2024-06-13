package rf.aleksper.diplomproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rf.aleksper.diplomproject.entities.UserEntity;
import rf.aleksper.diplomproject.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("userService")
@RequiredArgsConstructor
public class UserService {
	public final int MIN_PASS_LENGTH = 8;
	private final UserRepository userRepository;
	
	public List<UserEntity> findAll() {
		ArrayList<UserEntity> users = new ArrayList(userRepository.findAll());
		users.forEach(element -> {
			element.setPassword(null);
		});
		return users;
	}
	
	public UserEntity addUser(UserEntity user) {
		if (userRepository
				.findByUsername(user.getUsername()).isPresent() ||
				user.getUsername().isEmpty() || passwordIfCorrect(user.getPassword())) {
			log.info("Username/password is not correct. User not added.");
			return null;
		} else {
			log.info("User {} added", user.getUsername());
			return userRepository.save(user);
		}
	}
	
	public UserEntity updateUser(UserEntity user) {
		log.info("User {} edited", user.getUsername());
		return userRepository.save(user);
	}
	
	public UserEntity findById(Long id) {
		return userRepository.findById(id).stream().findFirst().orElse(null);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public boolean passwordIfCorrect(String password) {
		return password == null || password.length() < MIN_PASS_LENGTH || password.contains(" ");
	}
}

