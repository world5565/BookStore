package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.RecordDao;
import dao.UserDao;
import eneity.Product;
import eneity.Record;
import eneity.User;

public class AdminServlet extends HttpServlet {
	
	Product book = new Product();
	ProductDao productdao = new ProductDao();
	
	Record record = new Record();
	RecordDao recorddao = new RecordDao();
	
	User user = new User();
	UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("operation");
		
		if("adduser".equals(type)){
			adduser(request, response);
        } 
		if("deleteuser".equals(type)){
			deleteuser(request, response);
        } 
		if("getalluser".equals(type)){
			getalluser(request, response);
        } 
		if("addbook".equals(type)){
			addbook(request, response);
        } 
		if("deletebook".equals(type)){
			deletebook(request, response);
        } 
		if("getallbook".equals(type)){
			getallbook(request, response);
        }
		if("getallrecord".equals(type)){
			getallrecord(request, response);
        } 
	}
	
	public void adduser(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
	}
	
	public void deleteuser(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		getalluser(request,response);
		
	}

	public void getalluser(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
		List<User> list = userDao.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
		
	}

	public void addbook(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
	}

	public void deletebook(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		productdao.deleteProduct(id);
		getallrecord(request,response);
		
	}

	public void getallbook(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
		List<Product> list = productdao.getAllBooks();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/books.jsp").forward(request, response);
		
	}

	public void getallrecord(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
		List<Record> list = recorddao.getAllrecord();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/records.jsp").forward(request, response);
		
	}

}
