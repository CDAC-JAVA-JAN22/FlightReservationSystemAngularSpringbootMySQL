package com.ofrs.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ofrs.model.RegisterUser;
import com.ofrs.repository.RegisterUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterUserServiceTest {

	@Autowired
	private RegisterUserService registerUserService;
	
	@MockBean
	private RegisterUserRepository registerUserRepository;
	
//	@Test
//	public void testAddUser() {
//		RegisterUser user = new RegisterUser();
//		user.setUserId(11);
//		user.setUserName("Aniket");
//		user.setUserEmail("aniket@mail.com");
//		user.setImagePath("/../../assets/images");
//		user.setPassword("aniket");
//		user.setContactNumber("9897657433");
//		
//		Mockito.when(registerUserRepository.save(user)).thenReturn(user);
//		assertThat(registerUserService.addUser(user)).isEqualTo(user);
//	}

	@Test
	public void testGetAllUser() {
		RegisterUser user13 = new RegisterUser();
		user13.setUserId(13);
		user13.setUserName("Aniket");
		user13.setUserEmail("aniket@mail.com");
		user13.setImagePath("/../../assets/images");
		user13.setPassword("aniket");
		user13.setContactNumber("9897657433");
		
		RegisterUser user14 = new RegisterUser();
		user14.setUserId(14);
		user14.setUserName("Pranit");
		user14.setUserEmail("pranit@mail.com");
		user14.setImagePath("/../../assets/images");
		user14.setPassword("pranit");
		user14.setContactNumber("7297657433");
		
		List<RegisterUser> userList = new ArrayList<>();
		userList.add(user13);
		userList.add(user14);
		
		Mockito.when(registerUserRepository.findAll()).thenReturn(userList);
		assertThat(registerUserService.getAllUser()).isEqualTo(userList);
	}

	@Test
	public void testGetUser() {
		RegisterUser user15 = new RegisterUser();
		user15.setUserId(15);
		user15.setUserName("Ronit");
		user15.setUserEmail("ronit@mail.com");
		user15.setImagePath("/../../assets/images");
		user15.setPassword("ronit");
		user15.setContactNumber("7797657433");
		
		Mockito.when(registerUserRepository.getById(15)).thenReturn(user15);
		assertThat(registerUserService.getUser(15)).isEqualTo(user15);
	}

	@Test
	public void testDeleteUser() {
		RegisterUser user15 = new RegisterUser();
		user15.setUserId(15);
		user15.setUserName("Ronit");
		user15.setUserEmail("ronit@mail.com");
		user15.setImagePath("/../../assets/images");
		user15.setPassword("ronit");
		user15.setContactNumber("7797657433");
		Mockito.when(registerUserRepository.existsById(user15.getUserId())).thenReturn(false);
		assertFalse(registerUserRepository.existsById(user15.getUserId()));		
	}

	@Test
	public void testUpdateUser() {
		RegisterUser user15 = new RegisterUser();
		user15.setUserId(15);
		user15.setUserName("Ronit");
		user15.setUserEmail("ronit@mail.com");
		user15.setImagePath("/../../assets/images");
		user15.setPassword("ronit");
		user15.setContactNumber("7797657433");
		
		Mockito.when(registerUserRepository.findByUserEmail("ronit@mail.com")).thenReturn(user15);
		user15.setPassword("ronitNewPassword");
		Mockito.when(registerUserRepository.save(user15)).thenReturn(user15);
		assertThat(registerUserService.updateUser(15, user15)).isEqualTo(user15);
	}

	@Test
	public void testFindByuserEmail() {
		RegisterUser user15 = new RegisterUser();
		user15.setUserId(15);
		user15.setUserName("Ronit");
		user15.setUserEmail("ronit@mail.com");
		user15.setImagePath("/../../assets/images");
		user15.setPassword("ronit");
		user15.setContactNumber("7797657433");
		
		Mockito.when(registerUserRepository.findByUserEmail("ronit@mail.com")).thenReturn(user15);
		assertThat(registerUserService.findByuserEmail("ronit@mail.com")).isEqualTo(user15);
	}
}
