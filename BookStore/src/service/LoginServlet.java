package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PageDao;
import dao.ProductDao;
import dao.UserDao;
import eneity.Page;
import eneity.Product;
import eneity.User;

public class LoginServlet extends HttpServlet {
	
	Page page = new Page();
	PageDao pagedao = new PageDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out1 = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();

		User user = userDao.getUser(username);
		if (user == null) {
			out1.println("未注册，2秒后调到注册页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		else if (!user.getPassword().equals(password)) {
			out1.println("密码错误，2秒后调到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
		
		// 判断用户是否是管理员
		String role = user.getRole();
		if (role.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
			return;
		}
		else {
			ProductDao productdao = new ProductDao();
			page.setPagenum(1);
			List<Product> books = productdao.getPageBooks(page.getPagenum(),page.getPagesize());
			request.setAttribute("books", books);
			request.setAttribute("userid", user.getId());
			request.setAttribute("username", user.getUsername());
			request.setAttribute("useremail", user.getEmail());
			request.setAttribute("userphone", user.getPhone());
			request.setAttribute("registertime", user.getRegistTime());
			request.setAttribute("pagenum", page.getPagenum());
			request.setAttribute("totalpage", pagedao.totalPage(pagedao.getTotalRecord(), page.getPagesize()));
			request.getRequestDispatcher("/client/index.jsp").forward(request, response);
		}
	}

}
