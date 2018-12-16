package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;

import controller.Dao;
import model.User;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		ObjectifyService.register(User.class);
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Dao data = new Dao();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("UserName", userName);
		
        
		User user = new User(userName, "", password);

		boolean result=data.loginUser(user);
		System.out.println("result"+result);
		if(result)
		request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
		else
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
