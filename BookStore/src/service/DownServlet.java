package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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

public class DownServlet extends HttpServlet {
	
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
	
		String username = request.getParameter("username");
		String bookname = request.getParameter("bookname");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(username);
		
		if(paydao.findPayRecord(username, bookname)){
			
			ProductDao productdao = new ProductDao();
			
			Product book=productdao.getProduct(bookname);
			
			String path = this.getServletContext().getRealPath("/txt/"+book.getName()+".txt");
			
			FileInputStream fileInputStream = new FileInputStream(path);
			
			String fileName = path.substring(path.lastIndexOf("\\") + 1);
			
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
			
			int len = 0;
	        byte[] bytes = new byte[1024];
	        ServletOutputStream servletOutputStream = response.getOutputStream();

	        while ((len = fileInputStream.read(bytes)) > 0) {
	            servletOutputStream.write(bytes, 0, len);
	        }

	        servletOutputStream.close();
	        fileInputStream.close();
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
