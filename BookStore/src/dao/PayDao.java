package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.DataSource;

public class PayDao {
	
	//通过用户名和书名增加交易记录
	public boolean addPayRecord(String username,String bookname){
		Connection connection = DataSource.getConnection();
		try{
			//先查询是否有相同的购买记录
			String sql = "SELECT * from payrecord where username='" + username + "' and bookname='" + bookname +"'";
			Statement statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery(sql);
			if (resultSet.next()){
				return false;
			}
			else{
				sql="INSERT payrecord (username, bookname,time)"
					+ "value(?, ?, ?)";
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String time = dateFormat.format(new Date());
				PreparedStatement statement2 = connection.prepareStatement(sql);
				statement2.setString(1, username);
				statement2.setString(2, bookname);
				statement2.setString(3, time);
				statement2.executeUpdate();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	//查询交易记录
	public boolean findPayRecord(String username,String bookname){
		Connection connection = DataSource.getConnection();
		
		try{
			String sql = "SELECT * from payrecord where username='" + username + "' and bookname='" + bookname +"'";
			Statement statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery(sql);
			if (resultSet.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
