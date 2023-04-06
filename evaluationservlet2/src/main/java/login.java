import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        ServletContext servletContext = getServletContext();
        try {
            Class.forName(servletContext.getInitParameter("driver"));
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletjava", "root", "Yash@123");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from login where email = '" + name + "' and pass ='" + pass + "'");
            if(resultSet.next() && resultSet.getString(3).equals("admin")){
                HttpSession session = req.getSession();
                session.setAttribute("user",resultSet.getString(1));
                req.getRequestDispatcher("user-list.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
