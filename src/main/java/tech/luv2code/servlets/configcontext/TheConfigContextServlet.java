package tech.luv2code.servlets.configcontext;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TheConfigContextServlet extends HttpServlet {
	private ServletConfig config = null;
	private ServletContext context = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		var writer = resp.getWriter();
		writer.print("""
				<h1>App Name: </h1> is %s
				<h2>Context Path: </h2> is %s
				<h2>Servlet Name: </h2> is %s
				""".formatted(this.context.getInitParameter("AppName"), this.context.getContextPath(),
				this.config.getInitParameter("ServletName")));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	public void init(ServletConfig theConfig) throws ServletException {
		this.config = theConfig;
		this.context = theConfig.getServletContext();
	}

}
