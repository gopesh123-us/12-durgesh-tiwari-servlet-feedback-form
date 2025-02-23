package tech.luv2code.model.dao;

import java.sql.SQLException;
import java.util.List;

import tech.luv2code.model.entity.FeedbackEntity;

public interface FeedbackDaoInterface {
	int saveFeedback(FeedbackEntity feedback) throws SQLException;

	FeedbackEntity getFeedback(int feedbackId);

	List<FeedbackEntity> getAllFeedback();

	FeedbackEntity updateFeedback(FeedbackEntity feedback);

	void deleteFeedback(int feedbackId);

	public boolean existsById(int feedbackId);
}
