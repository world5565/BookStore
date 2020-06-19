package service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONArray;

import dao.PageDao;
import dao.ProductDao;
import eneity.Page;
import eneity.Product;

public class IndexServlet extends HttpServlet {
	
	Page page = new Page();
	PageDao pagedao = new PageDao();
	
	Product book = new Product();
	ProductDao productdao = new ProductDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("operation");
		
		if("startpage".equals(type)){
			startpage(request, response);
        } 
		if("lastpage".equals(type)){
			lastpage(request, response);
        } 
		if("nextpage".equals(type)){
			nextpage(request, response);
        } 
		if("endpage".equals(type)){
			endpage(request, response);
        } 
		if("nowpage".equals(type)){
			nowpage(request, response);
        } 
	}
	
	public void startpage(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		ProductDao productdao = new ProductDao();
		page.setPagenum(1);
		List<Product> books = productdao.getPageBooks(page.getPagenum(),page.getPagesize());
		String thinglist=JSONArray.toJSONString(books);
		response.getWriter().write(thinglist);
	}
	
	public void lastpage(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		ProductDao productdao = new ProductDao();
		page.setPagenum(page.getPagenum()-1);
		
		if(page.getPagenum()<1){
			startpage(request,response);
		}else{
			List<Product> books = productdao.getPageBooks(page.getPagenum(),page.getPagesize());
			String thinglist=JSONArray.toJSONString(books);
			response.getWriter().write(thinglist);
		}
		
	}
	
	public void nextpage(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		ProductDao productdao = new ProductDao();
		page.setPagenum(page.getPagenum()+1);
		
		if(page.getPagenum()>pagedao.totalPage(pagedao.getTotalRecord(), page.getPagesize())){
			endpage(request,response);
		}else{
			List<Product> books = productdao.getPageBooks(page.getPagenum(),page.getPagesize());
			String thinglist=JSONArray.toJSONString(books);
			response.getWriter().write(thinglist);
		}
		
	}
	
	public void endpage(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		ProductDao productdao = new ProductDao();
		page.setPagenum(pagedao.totalPage(pagedao.getTotalRecord(), page.getPagesize()));
		List<Product> books = productdao.getPageBooks(page.getPagenum(),page.getPagesize());
		String thinglist=JSONArray.toJSONString(books);
		response.getWriter().write(thinglist);
	}
	
	public void flip(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		
	}
	
	public void nowpage(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException{
		String nowpage="当前第"+String.valueOf(page.getPagenum())+"/"
				+pagedao.totalPage(pagedao.getTotalRecord(), page.getPagesize())+"页";
		response.getWriter().write(nowpage);
	}

}
