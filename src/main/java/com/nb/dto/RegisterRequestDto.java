package com.nb.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequestDto {

	@NotBlank(message = "Name is required")
	private String name;

	@Email(message = "Invalid Email")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Enter a valid 10-digit mobile number")
	private String phone;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotBlank(message = "Blood Group is required")
	private String bloodGroup;

	@NotBlank(message = "Address is required")
	private String address;

	@NotNull(message = "Date of Birth is required")
	private LocalDate dob;

}
