package rf.aleksper.diplomproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rf.aleksper.diplomproject.entities.UserEntity;
import rf.aleksper.diplomproject.services.UserService;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
@Slf4j
public class UserController {
	private final UserService userService;
	
	@GetMapping(value = "/all")
	public String all(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "user/all";
	}
	
	@GetMapping(value = {"/add"})
	public String showAddUserPage(Model model) {
		UserEntity newUser = new UserEntity();
		model.addAttribute("newUser", newUser);
		return "user/add";
	}
	
	@PostMapping(value = {"/add"})
	public String saveUser(Model model, @ModelAttribute("newUser") UserEntity newUser) {
		if (userService.passwordIfCorrect(newUser.getPassword()) || newUser.getUsername() != null) {
			userService.addUser(newUser);
			return "redirect:/user/all";
		}
		return "redirect:/";
	}
	
	
	@GetMapping(value = {"delete/{id}"})
	public String showDeleteUserPage(Model model, @ModelAttribute("id") Long id) {
		UserEntity userDel = userService.findById(id);
		model.addAttribute("userDel", userDel);
		return "user/delete";
	}
	
	@PostMapping(value = {"delete/{id}"})
	public String deleteUserPage(Model model, @ModelAttribute("id") Long id) {
		if (!Objects.equals(userService.findById(id).getUsername(), "admin")) {
			log.info("Delete user (userName) : " + userService.findById(id).getUsername());
			userService.deleteUser(id);
		}
		return "redirect:/user/all";
	}
	
	@GetMapping(value = {"/edit/{id}"})
	public String showEditUser(Model model, @ModelAttribute("id") Long id) {
		log.info("Start edit user (userName) : " + userService.findById(id).getUsername());
		UserEntity editUser = userService.findById(id);
		model.addAttribute("editUser", editUser);
		return "user/edit";
	}
	
	@PostMapping(value = {"/edit/{id}"})
	public String updateUser(Model model, @ModelAttribute("id") Long id, @ModelAttribute("editUser") UserEntity editUser) {
		UserEntity userEntity = userService.findById(id);
		if (userService.passwordIfCorrect(editUser.getPassword())) {
			log.info("Password is not correct. Password not edit.");
		} else {
			userEntity.setPassword(editUser.getPassword());
		}
		userEntity.setRole(editUser.getRole());
		userEntity.setFirstName(editUser.getFirstName());
		userEntity.setLastName(editUser.getLastName());
		userEntity.setEmail(editUser.getEmail());
		userEntity.setPhone(editUser.getPhone());
		userService.updateUser(userEntity);
		return "redirect:/user/all";
	}
}
