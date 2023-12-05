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
import com.ofrs.model.Feedback;
import com.ofrs.model.RegisterUser;
import com.ofrs.repository.FeedbackRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest {

	@Autowired
	private FeedbackService feedbackService;
	
	@MockBean
	private FeedbackRepository feedbackRepository;
	
	@Test
	public void testGetAllFeedback() {
		
		Feedback feedback = new Feedback();
		RegisterUser user = new RegisterUser();
		
		user.setUserId(1);
		feedback.setFeebackId(1);
		feedback.setFeedbackDetails("Feedback dummy");
		feedback.setRating(2);
		feedback.setUser(user);
		
		Feedback feedback1 = new Feedback();
		user.setUserId(1);
		feedback1.setFeebackId(2);
		feedback1.setFeedbackDetails("Feedback dummy");
		feedback1.setRating(2);
		feedback1.setUser(user);
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.add(feedback);
		feedbackList.add(feedback1);
		
		Mockito.when(feedbackRepository.findAll()).thenReturn(feedbackList);
		assertThat(feedbackService.getAllFeedback()).isEqualTo(feedbackList);
		
	}

	@Test
	public void testGetFeedback() {
		
		Feedback feedback = new Feedback();
		RegisterUser user = new RegisterUser();
		
		user.setUserId(1);
		feedback.setFeebackId(1);
		feedback.setFeedbackDetails("Feedback dummy");
		feedback.setRating(2);
		feedback.setUser(user);
		
		Mockito.when(feedbackRepository.getById(1)).thenReturn((Feedback)feedback);
		assertThat(feedbackService.getFeedback(1)).isEqualTo(feedback);
	}

	@Test
	public void testDeleteFeedback() {
		
		Feedback feedback = new Feedback();
		RegisterUser user = new RegisterUser();
		
		user.setUserId(1);
		feedback.setFeebackId(1);
		feedback.setFeedbackDetails("Feedback dummy");
		feedback.setRating(2);
		feedback.setUser(user);
		
		Mockito.when(feedbackRepository.existsById(1)).thenReturn(false);
		assertFalse(feedbackRepository.existsById(1));	
	}

	@Test
	public void testUpdateFeedback() {
		
		Feedback feedback = new Feedback();
		RegisterUser user = new RegisterUser();
		
		user.setUserId(1);
		feedback.setFeebackId(1);
		feedback.setFeedbackDetails("Feedback dummy");
		feedback.setRating(2);
		feedback.setUser(user);
		
		Mockito.when(feedbackRepository.getById(1)).thenReturn(feedback);
		feedback.setRating(1);
		Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);
		// assertThat(feedbackService.updateFeedback(1, feedback)).isEqualTo(feedback);

	}

	@Test
	public void testAddFeedback() {

		Feedback feedback = new Feedback();
		RegisterUser user = new RegisterUser();
		
		user.setUserId(1);
		feedback.setFeebackId(1);
		feedback.setFeedbackDetails("Feedback dummy");
		feedback.setRating(2);
		feedback.setUser(user);
		
		Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);
		assertThat(feedbackService.addFeedback(feedback)).isEqualTo(feedback);

	}

}
