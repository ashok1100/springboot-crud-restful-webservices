package net.javaguides.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(
		description = "UserDTO Model information"
		)
public class UserDto {

	private Long id;
	
	@Schema(description = "User first_name")
	@NotEmpty(message = "user first name must not be null and empty")
	private String firstName;
	
	@Schema(description = "User last_name")
	@NotEmpty(message = "user last name must not be null and empty")
	private String lastName;
	
	@Schema(description = "User email")
	@NotEmpty(message = "user email must not be null and empty")
	@Email(message = "please enter valid email")
	private String email;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
