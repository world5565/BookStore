package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import eneity.User;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		UserDao userDao = new UserDao();
		if (userDao.getUser(username) != null) {
			out.println("该用户已存在");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		user.setRegistTime(dateFormat.format(new Date()));
		userDao.addUser(user);

		out.println("注册成功，2秒后跳转到登录页面");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
		
	}

}
