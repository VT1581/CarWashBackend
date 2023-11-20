package com.na.userAuthentication.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.na.userAuthentication.models.ERole;
import com.na.userAuthentication.models.Role;
import com.na.userAuthentication.models.User;
import com.na.userAuthentication.payload.request.LoginRequest;
import com.na.userAuthentication.payload.request.SignupRequest;
import com.na.userAuthentication.payload.response.JwtResponse;
import com.na.userAuthentication.payload.response.MessageResponse;
import com.na.userAuthentication.repository.RoleRepository;
import com.na.userAuthentication.repository.UserRepository;
import com.na.userAuthentication.security.JwtUtils;
import com.na.userAuthentication.security.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
     @PostMapping("/role")
     public Role getrole(@RequestBody Role role) {
    	 Role roles = roleRepository.save(role);
    	 return roles;
     }
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 
							 encoder.encode(signUpRequest.getPassword()));

		String strRole = signUpRequest.getRole();
		Set<Role> role = new HashSet<>();

		if (strRole == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			role.add(userRole);
		} else {
		
				switch (strRole) {
				
				case "CUSTOMER":
					Role adminRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
							.orElseThrow(() -> new RuntimeException("Error: CUSTOMER Role is not found."));
					role.add(adminRole);

					break;
				case "CARWASHER":
					Role adminRole1 = roleRepository.findByName(ERole.ROLE_CARWASHER)
							.orElseThrow(() -> new RuntimeException("Error: CARWASHER Role is not found."));
					role.add(adminRole1);

					break;
				
				case "ADMIN":
					Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Admin Role is not found."));
					role.add(userRole);
				}
			
		}

		user.setRoles(role);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	

	// ...

	@PutMapping("/users/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable String userId, @Valid @RequestBody SignupRequest updatedUserData) {
	    // Check if the user exists
	    if (!userRepository.existsById(userId)) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Get the user to update
	    User user = userRepository.findById(userId).orElse(null);
	    if (user == null) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Update user data
	    user.setUsername(updatedUserData.getUsername());
	    user.setEmail(updatedUserData.getEmail());
	    if (!updatedUserData.getPassword().isEmpty()) {
	        user.setPassword(encoder.encode(updatedUserData.getPassword()));
	    }
	    // You may add additional update logic here if needed

	    // Save the updated user (this will update the existing document, not create a new one)
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User data updated successfully!"));
	}
	
	

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
	    // Check if the user exists
	    if (!userRepository.existsById(userId)) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Delete the user
	    userRepository.deleteById(userId);

	    return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
	}

	@GetMapping("/customers")
	public ResponseEntity<List<User>> getAllCustomers() {
	    List<User> allUsers = userRepository.findAll();

	    // Filter users with the role ROLE_CUSTOMERS
	    List<User> customers= allUsers.stream()
	        .filter(user -> user.getRoles().stream().anyMatch(role -> role.getName().equals(ERole.ROLE_CUSTOMER)))
	        .collect(Collectors.toList());

 

	    return ResponseEntity.ok(customers);
	}
	@GetMapping("/carwashers")
	public ResponseEntity<List<User>> getAllCarwashers() {
	    List<User> allUsers = userRepository.findAll();

	    // Filter users with the role ROLE_CARWASHER
	    List<User> carwashers = allUsers.stream()
	        .filter(user -> user.getRoles().stream().anyMatch(role -> role.getName().equals(ERole.ROLE_CARWASHER)))
	        .collect(Collectors.toList());

 

	    return ResponseEntity.ok(carwashers);
	}


	

}