package tech.luv2code.servlets.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "counterServlet", urlPatterns = { "/counter" })
public class CounterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int visitCount = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null) {
			if (session.getAttribute("count") == null || session.getAttribute("count") == "") {
				session.setAttribute("count", visitCount + 1);
			} else {
				int visits = Integer.parseInt(session.getAttribute("count").toString());
				visitCount = visits + 1;
				session.setAttribute("count", visitCount);
			}
		}

		resp.setContentType("text/html");
		var writer = resp.getWriter();
		writer.print("times servlet visited: " + session.getAttribute("count"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
