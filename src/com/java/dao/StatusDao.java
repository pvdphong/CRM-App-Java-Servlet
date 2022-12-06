package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.model.Status;

public class StatusDao {
	public List<Status> findAll(){
		List<Status> models = new LinkedList<Status>();
		try(Connection connection = MysqlConnection.getConnection()) {
			
			
			String query = "SELECT * FROM status"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Status model = new Status(); 	
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				
				models.add(model); 
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
}
