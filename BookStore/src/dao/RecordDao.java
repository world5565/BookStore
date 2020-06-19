package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import eneity.Record;
import util.DataSource;

public class RecordDao {
	
	//通过用户名查询用户的所有购买记录
	public List<Record> getRecords(String username){
		Record record = null;
		List<Record> records = new ArrayList<Record>();
		try{
			Connection connection = DataSource.getConnection();
			String sql = "select * from payrecord where username='" + username +"'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				record = new Record();
				record.setId(resultSet.getInt("id"));
				record.setUsername(resultSet.getString("username"));
				record.setBookname(resultSet.getString("bookname"));
				record.setTime(resultSet.getString("time"));
				records.add(record);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return records;
	}
	
	//查询所有购买记录
	public List<Record> getAllrecord(){
		Record record = null;
		List<Record> records = new ArrayList<Record>();
		try{
			Connection connection = DataSource.getConnection();
			String sql = "select * from payrecord";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				record = new Record();
				record.setId(resultSet.getInt("id"));
				record.setUsername(resultSet.getString("username"));
				record.setBookname(resultSet.getString("bookname"));
				record.setTime(resultSet.getString("time"));
				records.add(record);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return records;
	}

}
