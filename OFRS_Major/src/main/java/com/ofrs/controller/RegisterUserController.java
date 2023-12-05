package com.ofrs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ofrs.exception.InputNotProvidedException;
import com.ofrs.exception.InvalidInputProvidedException;
import com.ofrs.exception.RecordNotFoundException;
import com.ofrs.model.RegisterUser;
import com.ofrs.service.RegisterUserService;
import com.ofrs.util.JwtUtil;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class RegisterUserController {

	Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(RegisterUserController.class);

	@Autowired
	RegisterUserService registerUserService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/")
	public String welcome() {
		return "Welcome to OFRS !!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody RegisterUser authRequest) throws InvalidInputProvidedException {
		System.out.println(authRequest);

		if (authRequest == null) {
			throw new InputNotProvidedException("Please enter username/password");
		}
		RegisterUser verifiedUser = registerUserService.findByuserEmail(authRequest.getUserEmail());  
		System.out.println(verifiedUser);     /////
		System.out.println(authRequest);
		if(verifiedUser == null) {
			throw new RecordNotFoundException("Please verify your account");
		} 
		if(verifiedUser.isEnabled()) {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserEmail(), authRequest.getPassword())
			);
		} catch (Exception ex) {
			throw new InvalidInputProvidedException("Inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserEmail());
		}
		else {
			throw new RecordNotFoundException("Please verify your account!");						/////
		}
	}

	
//	@PostMapping("/authenticate/registerUser")
//	public ResponseEntity<?> addUser(@Valid @RequestBody RegisterUser registerUser) {
//		RegisterUser userNew = registerUserService.findByuserEmail(registerUser.getUserEmail());
//
//		System.out.println(userNew);
//
//		if (userNew == null) {
//			String password = registerUser.getPassword();
//			System.out.println(password);
//			String encryptedPwd = passwordEncoder.encode(password);
//			registerUser.setPassword(encryptedPwd);
//			registerUserService.addUser(registerUser);
//			logger.info("***Add user controller is called***");
//			return new ResponseEntity<String>("User added successfully...", HttpStatus.OK);
//		} else {
//			throw new RecordAlreadyPresentException("User already registered");
//		}
//	}
//------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/authenticate/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody RegisterUser registerUser, HttpServletRequest request) {

		if (registerUser != null) {

			String password = registerUser.getPassword();
			System.out.println(password);
			String encryptedPwd = passwordEncoder.encode(password);
			registerUser.setPassword(encryptedPwd);
			registerUserService.registerUser(registerUser, getSiteURL(request));
			logger.info("************************Register Successfully*****************************");
			return new ResponseEntity<>("User Added Succesfully", HttpStatus.CREATED);
		}
		logger.error("***************************Registration Failed*******************************");
		return new ResponseEntity<>("Please Enter All the Information ", HttpStatus.NOT_ACCEPTABLE);

	}

	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (registerUserService.verify(code)) {
			System.out.println("user verified");
			return "verify_success";
		} else {
			System.out.println("user not verified");
			return "verify_fail";
		}
	}

	
//------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/getAllUser")
	public ResponseEntity<List<RegisterUser>> getAllUser() {
		List<RegisterUser> userList = new ArrayList<RegisterUser>();
		userList = registerUserService.getAllUser();

		if (userList.isEmpty()) {
			throw new RecordNotFoundException("No users Found");
		}

		logger.info("***Get all user controller is called***");
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/getUser/{userId}")
	public ResponseEntity<RegisterUser> getUser(@PathVariable int userId) {
		RegisterUser user = registerUserService.getUser(userId);

		if (user == null) {
			throw new RecordNotFoundException("No user Found");
		}

		logger.info("***Get user controller is called***");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {

		if (userId <= 0) {
			throw new InvalidInputProvidedException("Invalid Input Provided");
		}

		registerUserService.deleteUser(userId);
		logger.info("***Delete user controller is called***");
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<RegisterUser> updateUser(@PathVariable int userId, @Valid @RequestBody RegisterUser user) {

		if (user == null) {
			throw new InputNotProvidedException("User is empty");
		}
		if (user.getUserId() <= 0) {
			throw new InvalidInputProvidedException("Invalid Input Provided");
		}

		RegisterUser user_new = registerUserService.updateUser(userId, user);
		logger.info("***Update user controller is called***");
		return new ResponseEntity<>(user_new, HttpStatus.OK);
	}

	@GetMapping("/authenticate/findByuserEmail/{userEmail}")
	public ResponseEntity<RegisterUser> findByuserEmail(@Valid @PathVariable String userEmail) {
		if (userEmail == null) {
			throw new InputNotProvidedException("User email is empty");
		}
		RegisterUser user = registerUserService.findByuserEmail(userEmail);
		logger.info("***Find by email user controller is called***");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/findByUserName/{userName}")
	public ResponseEntity<?> findByUserName(@Valid @PathVariable String userName) {
		if (userName == null) {
			throw new InputNotProvidedException("Username is empty");
		}
		RegisterUser user = registerUserService.findByUserName(userName);
		logger.info("***Find by username controller is called***\n" + user + "\n");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}