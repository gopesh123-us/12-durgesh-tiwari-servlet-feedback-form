package tech.luv2code.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import tech.luv2code.config.DatabaseConnection;
import tech.luv2code.model.entity.FeedbackEntity;

public class FeedbackDao implements FeedbackDaoInterface {
	// get database connection
	private Connection connection;

	public FeedbackDao(DatabaseConnection dbconn) throws SQLException {
		try {
			this.connection = dbconn.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int saveFeedback(FeedbackEntity feedback) throws SQLException {
		String SQL_QUERY = "INSERT INTO feedback (email, phone, message) VALUES (?, ?, ?);";
		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(SQL_QUERY);
			statement.setString(1, feedback.getEmail());
			statement.setString(2, feedback.getPhone());
			statement.setString(3, feedback.getFeedback());
			result = statement.executeUpdate();
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
