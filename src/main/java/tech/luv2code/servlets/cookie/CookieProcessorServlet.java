package tech.luv2code.servlets.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "getCookieServlet", urlPatterns = { "/getCookie" })
public class CookieProcessorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var content = new StringBuffer();
		HttpSession session = req.getSession();
		content.append("Session id: " + session.getId().toString() + "</br>");
		content.append("UUID: " + session.getAttribute("secret") + "</br>");
		// check cookies
		var cookies = req.getCookies();
		resp.setContentType("text/html");
		var writer = resp.getWriter();

		if (cookies != null) {
			boolean hasCookie = false;
			for (Cookie c : cookies) {
				String user = c.getName();
				if (user.equals("username")) {
					hasCookie = true;
					content.append("Welcome: " + c.getValue() + "<br/>");
				} else if (user.equals("userid")) {
					content.append("Your id is: " + c.getValue() + "<br/>");
				}
			}
			if (hasCookie) {
				writer.print(content);
			}
			if (hasCookie == false) {
				writer.print("no cookie information available.");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
