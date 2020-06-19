package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DataSource;

public class PageDao {
	
	//获取总记录数
	public int getTotalRecord(){
		int totalrows=0;
		try{
			Connection connection = DataSource.getConnection();
			String sql = "select count(*) from products";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				totalrows=resultSet.getInt(1);
			}else{
				return totalrows;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalrows;
	}
	
	//获取总页数
	public int totalPage(int totalrows,int pagesize){
		int totalpage=0;
		totalpage=(totalrows+pagesize-1)/pagesize;
		return totalpage;
	}

}
