import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  resp.getWriter();
		ServletContext servletContext = getServletContext();
		try {
			Class.forName(servletContext.getInitParameter("driver"));
			Connection connection = DriverManager.getConnection(servletContext.getInitParameter("url"),servletContext.getInitParameter("username"),servletContext.getInitParameter("password"));
			PreparedStatement preparedStatement = connection.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1,req.getParameter("email"));
			preparedStatement.setString(2,req.getParameter("password"));
			preparedStatement.setString(3,req.getParameter("first-name"));
			preparedStatement.setString(4,req.getParameter("last-name"));
			preparedStatement.setString(5,req.getParameter("dob"));
			preparedStatement.setString(6,req.getParameter("address"));
			preparedStatement.setInt(7,Integer.parseInt(req.getParameter("phone")));
			Part part = req.getPart("profile-image");
			String fileName = part.getSubmittedFileName();
			String uploadPath = "C:\\Users\\Coditas\\IdeaProjects\\registeration\\src\\main\\webapp\\images"+ File.separator + fileName;
			part.write(uploadPath + File.separator);
			String dbImageName = "images" + File.separator + fileName;
			preparedStatement.setString(8,dbImageName);

			preparedStatement.execute();
			resp.sendRedirect(req.getContextPath() + "/login.html");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
