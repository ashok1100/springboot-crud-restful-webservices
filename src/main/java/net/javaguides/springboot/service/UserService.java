package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.EmailAlreadyExistsException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

//	public User createUser(User user) {
//		return userRepository.save(user);
//	}

	public UserDto createUser(UserDto userDto) {

		// Converting UserDto into JPA Entity
		// User user = UserMapper.mapToUser(userDto);

		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists for the user, try with deffrent email");
		}

		User user = modelMapper.map(userDto, User.class);

		User savedUser = userRepository.save(user);

		// Converting JPA Entity to UserDto

//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

		return savedUserDto;
	}

//	public User getUserById(Long id) {
//		return userRepository.findById(id).get();
//	}

	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		// User user = OptionalUser.get();
		// return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}

	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		// return
		// users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

//	public User updateUser(User user) {
//		User existingUser = userRepository.findById(user.getId()).get();
//		existingUser.setFirstName(user.getFirstName());
//		existingUser.setLastName(user.getLastName());
//		existingUser.setEmail(user.getEmail());
//		User updatedUser = userRepository.save(existingUser);
//		return updatedUser;
//	}

	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		// return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	public void deleteUserById(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
		System.out.println(existingUser);
	}
}
