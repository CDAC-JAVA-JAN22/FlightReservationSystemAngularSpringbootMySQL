package com.ofrs.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ofrs.service.RegisterUserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegisterUserController.class) //secure=false
public class RegisterUserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RegisterUserService registerUserService;
	
	@Test
	public void testLoginUser() {
		
	}

	@Test
	public void testAddUser() throws Exception{
		
	}

	@Test
	public void testGetAllUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByuserEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByuserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBycontactNumber() {
		fail("Not yet implemented");
	}
}