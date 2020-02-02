package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDBServlet
 * TEST connection, only serves to test, its not the real connection 
 */
@WebServlet("/testDBServlet")
public class testDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "springstudent";
		String pass="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to db"+ jdbcUrl);
			Class.forName(driver);
			Connection con= DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("coneection succesfull");
			con.close();
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
