package tech.luv2code.servlets.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "cookieSetter", urlPatterns = { "/setCookie" })
public class CookieSetterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get user data or create one
		// TODO get these values from database;
		String user = "Sam_Bahadhur";
		String userId = "7898";
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			boolean hasUserCookie = false;
			boolean hasUserIdCookie = false;
			for (Cookie c : cookies) {
				String cookieNameString = c.getName();
				if (cookieNameString.equals("username")) {
					System.out.println("user cookie already present");
					hasUserCookie = true;
				} else if (cookieNameString.equals("userid")) {
					System.out.println("userid cookie already present");
					hasUserIdCookie = true;
				} else {
					hasUserCookie = false;
					hasUserIdCookie = false;
				}
			}
			if (hasUserCookie == false) {
				Cookie cookie = new Cookie("username", user);
				cookie.setMaxAge(60);
				resp.addCookie(cookie);

			}
			if (hasUserIdCookie == false) {
				Cookie cookie = new Cookie("userid", userId);
				cookie.setMaxAge(60);
				resp.addCookie(cookie);
			}
		}
		resp.setContentType("text/html");
		var writer = resp.getWriter();
		writer.print("""
				<h1>Cookie set</h1>
				<a href="index.jsp">Home</a>
				""");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
