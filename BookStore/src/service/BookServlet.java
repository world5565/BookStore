package service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PageDao;
import dao.ProductDao;
import dao.UserDao;
import eneity.Page;
import eneity.Product;
import eneity.User;

public class BookServlet extends HttpServlet {
	
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
		
		String username = request.getParameter("username");
		String bookname = request.getParameter("bookname");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(username);
		
		ProductDao productdao = new ProductDao();
		
		Product book=productdao.getProduct(bookname);
		
		if(book.getId()!=0){
			request.setAttribute("bookimgurl", book.getImgurl());
			request.setAttribute("username", username);
			request.setAttribute("bookname", book.getName());
			request.setAttribute("bookprice", book.getPrice());
			request.setAttribute("bookdescription", book.getDescription());
			
			request.getRequestDispatcher("/client/book.jsp").forward(request, response);
		}
		else{
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
