package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.service.UserService;

@Tag(name = "CRUD REST API's for User resource",
     description = "CRUD REST APIs - create User, Update user, Get user, Get all User, Delete Uer"
		)
@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

//	@PostMapping("/create")
//	public ResponseEntity<User> createNewUser(@RequestBody User user) {
//		User savedUsed = userService.createUser(user);
//		return new ResponseEntity<>(savedUsed, HttpStatus.CREATED);
//	}

	@Operation(
			summary = "Create User REST API",
			description = "It is used to save user in database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP status 201 CREATED"
			)
	@PostMapping("/create")
	public ResponseEntity<UserDto> createNewUser(@Valid @RequestBody UserDto userDto) {
		UserDto savedUsed = userService.createUser(userDto);
		return new ResponseEntity<>(savedUsed, HttpStatus.CREATED);
	}

//	@GetMapping("/get/{id}")
//	public ResponseEntity<User> fetchUserById(@PathVariable("id") Long uid) {
//		User user = userService.getUserById(uid);
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}

	@Operation(
			summary = "Get User By ID REST API",
			description = "It is used to get the user by ID from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 SUCCESS"
			)
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> fetchUserById(@PathVariable("id") Long uid) {
		UserDto user = userService.getUserById(uid);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

//	@GetMapping("/getAll")
//	public ResponseEntity<List<User>> findAllUsers() {
//		List<User> users = userService.getAllUsers();
//		return new ResponseEntity<>(users, HttpStatus.OK);
//	}

	@Operation(
			summary = "Get All Users REST API",
			description = "It is used to get all the users from the databse"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status code 200 success"
			)
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> findAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

//	@PutMapping("update/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
//		user.setId(userId);
//		User updatedUser = userService.updateUser(user);
//		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//	}

	@Operation(
			summary = "Update User REST API",
			description = "It is used to update the user by id from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status code 200 success"
			)
	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto user) {
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@Operation(
			summary = "Delete USER REST API",
			description = "It is used to delete the user from the database by ID"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 success"
			)
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUserByid(@PathVariable("id") Long uid) {
		userService.deleteUserById(uid);
		return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
	}

}
