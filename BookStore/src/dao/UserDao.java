package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eneity.User;
import util.DataSource;

public class UserDao {
	
	//增加用户
	public void addUser(User user){
		
		try{
			Connection connection = DataSource.getConnection();
			String sql = "insert into user (username, password, email, phone, role, registTime)"
					+ "value(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getRole());
			statement.setString(6, user.getRegistTime());
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//根据用户ID删除用户
	public void deleteUser(int id){

		try{
			Connection connection = DataSource.getConnection();
	    	String sql = "delete from user where id=" + id;
	    	PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//修改用户信息
	public void updateUser(User user){
		
		try{
			Connection connection = DataSource.getConnection();
			String sql = "update user set username=?, password=?, email=?, "
					+ "phone=?, role=?, registTime=? where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getRole());
			statement.setString(6, user.getRegistTime());
			statement.setInt(7, user.getId());
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//根据用户名获取用户记录
	public User getUser(String username) {
		User user = null;

		try {
			Connection connection = DataSource.getConnection();
			String sql = "SELECT * from user where username='" + username + "'";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//根据用户ID获取用户记录
	public User getUser(int id) {
		User user = null;
		
		try {
			Connection connection = DataSource.getConnection();
			String sql = "SELECT * from user where id=" + id;
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//获取所有用户记录
	public List<User> getAllUser() {
		List<User> users = null;
		
		try {
			Connection connection = DataSource.getConnection();
			String sql = "SELECT * from user";
			
			users = new ArrayList<User>();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}

}
