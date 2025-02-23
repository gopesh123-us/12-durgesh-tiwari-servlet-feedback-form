package tech.luv2code.model.service;

import java.sql.SQLException;
import java.util.List;

import tech.luv2code.model.dao.FeedbackDao;
import tech.luv2code.model.entity.FeedbackEntity;

public class FeedbackService implements FeedbackServiceInterface {
	// use dao
	private FeedbackDao dao;

	public FeedbackService(FeedbackDao theDao) {
		this.dao = theDao;
	}

	@Override
	public int saveFeedback(FeedbackEntity feedback) throws SQLException {
		int result = 0;
		try {
			result = dao.saveFeedback(feedback);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public FeedbackEntity getFeedback(int feedbackId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedbackEntity> getAllFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeedbackEntity updateFeedback(FeedbackEntity feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFeedback(int feedbackId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(int feedbackId) {
		// TODO Auto-generated method stub
		return false;
	}

}
