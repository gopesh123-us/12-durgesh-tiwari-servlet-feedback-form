package tech.luv2code.model.service;

import java.util.List;

import tech.luv2code.model.entity.Feedback;

public interface FeedbackServiceInterface {
	Feedback saveFeedback(Feedback feedback);

	Feedback getFeedback(int feedbackId);

	List<Feedback> getAllFeedback();

	Feedback updateFeedback(Feedback feedback);

	void deleteFeedback(int feedbackId);

	public boolean existsById(int feedbackId);
}
