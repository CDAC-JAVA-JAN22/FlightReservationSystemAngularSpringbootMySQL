package com.ofrs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ofrs.model.Feedback;
import com.ofrs.model.RegisterUser;
import com.ofrs.service.FeedbackService;
import com.ofrs.service.RegisterUserService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	RegisterUserService registerUserService;

	Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(FeedbackController.class);

	@GetMapping("/getAllFeedback")
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		logger.info("***Get all feedback controller is called***");
		List<Feedback> list = feedbackService.getAllFeedback();

		if (list.isEmpty()) {
			throw new RecordNotFoundException("No feedbacks Found");
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/authenticate/addFeedback")
	public ResponseEntity<?> addFeedback(@Valid @RequestBody Feedback feedback) {

//		if (feedback == null) {
//			throw new InputNotProvidedException("Feedback fields are missing");
//		}
//
//		RegisterUser isRegistered = feedback.getUser();
//
//		if (isRegistered == null) {
//			throw new RecordNotFoundException("You cannot submit feedback as you are not registered with us");
//		}
//
//		RegisterUser isRegisteredUser = registerUserService.getUser(feedback.getUser().getUserId());
//
//		if (isRegisteredUser == null) {
//			throw new RecordNotFoundException("You cannot submit feedback as you are not registered with us");
//		}

		if (feedback.getFeedbackDetails().isEmpty() || feedback.getFeedbackDetails().length() == 0) {
			throw new InputNotProvidedException("Feedback is empty");
		}
		if (feedback.getRating() <= 0 || feedback.getRating() > 5) {
			throw new InvalidInputProvidedException("Insert value between 1 and 5");
		}

		logger.info("***Add feedback controller is called***");

		Feedback feedback_new = feedbackService.addFeedback(feedback);
		return new ResponseEntity<Feedback>(feedback_new, HttpStatus.OK);
	}

	@GetMapping("/getFeedback/{id}")
	public ResponseEntity<Feedback> getFeedback(@PathVariable int id) {
		if (id < 1) {
			throw new InvalidInputProvidedException("Invalid input");
		}

		logger.info("***Get feedback controller is called***");

		Feedback feedback = feedbackService.getFeedback(id);
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

	@DeleteMapping("/deleteFeedback/{id}")
	public ResponseEntity<?> deleteFeedback(@PathVariable int id) {

		if (id < 1) {
			throw new InvalidInputProvidedException("Invalid input");
		}

		logger.info("***Delete feedback controller is called***");

		feedbackService.deleteFeedback(id);
		return new ResponseEntity<>("Feedback deleted", HttpStatus.OK);
	}

	@PutMapping("/updateFeedback/{id}")
	public ResponseEntity<?> updateFeedback(@PathVariable int id, @Valid @RequestBody Feedback feedback) {
		if (feedback == null || id < 1) {
			throw new InvalidInputProvidedException("Invalid input provided");
		}

		logger.info("***Update feedback controller is called***");

		feedbackService.updateFeedback(id, feedback);
		return new ResponseEntity<>("Feedback updated", HttpStatus.OK);
	}
}