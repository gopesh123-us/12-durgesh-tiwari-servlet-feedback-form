package tech.luv2code.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.luv2code.config.DatabaseConnection;
import tech.luv2code.model.dao.FeedbackDao;
import tech.luv2code.model.entity.FeedbackEntity;
import tech.luv2code.model.service.FeedbackService;

@WebServlet(name = "FeedbackServlet", urlPatterns = { "/processFeedback" })
public class FeedbackController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// get service
	private FeedbackService service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			DatabaseConnection connection = new DatabaseConnection();
			FeedbackDao dao = new FeedbackDao(connection);
			service = new FeedbackService(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0;
		StringBuffer content = new StringBuffer();
		String emailString = req.getParameter("email");
		String phoneString = req.getParameter("phone");
		String messageString = req.getParameter("feedback_message");
		FeedbackEntity entity = new FeedbackEntity();
		entity.setEmail(emailString);
		entity.setPhone(phoneString);
		entity.setFeedback(messageString);
		try {
			result = service.saveFeedback(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		content.append("""
				<h1>Feedback Received</h1>
				<p>Saved to database with result: %s</p>
				<p>Your feedback is: %s</p>
				""".formatted(result, messageString));
		writer.print(content);
	}

}
