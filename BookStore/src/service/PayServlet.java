package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PageDao;
import dao.PayDao;
import dao.ProductDao;
import dao.UserDao;
import eneity.Page;
import eneity.Product;
import eneity.User;

public class PayServlet extends HttpServlet {
	
	Page page = new Page();
	PageDao pagedao = new PageDao();
	PayDao paydao = new PayDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("operation");
		
		if("payment".equals(type)){
			payment(request, response);
        } 
		if("paysuccess".equals(type)){
			paysuccess(request, response);
        } 
	}
	
	public void payment(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		String username=request.getParameter("username");
		String bookname=request.getParameter("bookname");
		
		request.setAttribute("username", username);
		request.setAttribute("bookname", bookname);
		
		request.getRequestDispatcher("/client/payment.jsp").forward(request, response);
		
	}
	
	public void paysuccess(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
		String username=request.getParameter("username");
		String bookname=request.getParameter("bookname");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(username);
		
		if(paydao.addPayRecord(username, bookname)){
			ProductDao productdao = new ProductDao();
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
		else{
			ProductDao productdao = new ProductDao();
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
