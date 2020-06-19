package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eneity.Product;
import util.DataSource;

public class ProductDao {
	//增加图书记录
	public void addProduct(Product product){
		try {
			Connection connection = DataSource.getConnection();
			String sql = "INSERT products (name, price, imgurl, txturl, description)"
					+ "value(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getImgurl());
			statement.setString(4, product.getTxturl());
			statement.setString(5, product.getDescription());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//根据ID删除图书记录
	public void deleteProduct(int id){

		try{
			Connection connection = DataSource.getConnection();
	    	String sql = "delete from products where id=" + id;
	    	PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//修改图书记录
	public void updateProduct(Product product){
		try {
			Connection connection = DataSource.getConnection();
			String sql = "update products set name=?, price=?, imgurl=?, txturl=?, description=?"
					+ "where id=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getImgurl());
			statement.setString(4, product.getTxturl());
			statement.setString(5, product.getDescription());
			statement.setInt(6, product.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//根据图书名(name)查询图书记录
	public Product getProduct(String productname){
		Product product = new Product();
		try{
			Connection connection = DataSource.getConnection();
			String sql = "SELECT * from products where name='" + productname + "'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setTxturl(resultSet.getString("txturl"));
				product.setDescription(resultSet.getString("description"));
			}
			else{
				return product;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return product;
	}
	//分页查询所有图书
	public List<Product> getPageBooks(int pagenum, int pagesize){
		Product book = null;
		List<Product> books = new ArrayList<Product>();
		try {
			Connection connection = DataSource.getConnection();
			String sql = "select * from products limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (pagenum-1)*pagesize);
			statement.setInt(2, pagesize);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				book = new Product();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setPrice(resultSet.getDouble("price"));
				book.setImgurl(resultSet.getString("imgurl"));
				book.setTxturl(resultSet.getString("txturl"));
				book.setDescription(resultSet.getString("description"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	//查询所有图书
	public List<Product> getAllBooks(){
		Product book = null;
		List<Product> books = new ArrayList<Product>();
		try {
			Connection connection = DataSource.getConnection();
			String sql = "select * from products";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				book = new Product();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setPrice(resultSet.getDouble("price"));
				book.setImgurl(resultSet.getString("imgurl"));
				book.setTxturl(resultSet.getString("txturl"));
				book.setDescription(resultSet.getString("description"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

}
