package tech.luv2code.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "feedbackServlet", urlPatterns = {"/feedback"})
public class FeedbackServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phone");
		String message = req.getParameter("feedback_message");
		// process form data

		// send response
		resp.setContentType("text/html");
		resp.getWriter().print("received");
		resp.getWriter().print(email + " " + phoneNumber + " " + message);
	}

}
