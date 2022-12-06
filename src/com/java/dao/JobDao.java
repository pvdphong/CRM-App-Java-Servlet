package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.model.Job;

public class JobDao {
	public List<Job> findAll(){
		List<Job> models = new LinkedList<Job>();
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM crm_app.Jobs"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Job model = new Job(); 	
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		return models;
	}
	
	public Job findById(String id) {
		String query = "SELECT * FROM jobs WHERE id = ?" ;
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				Job model = new Job(); 
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				
				return model; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Job(); 
	}
	
	public int delete(String id) {
		String query = "DELETE FROM jobs WHERE id = ?" ;
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			return statement.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int insert(Job model) {
		String query = "INSERT INTO jobs (name,start_date,end_date) VALUES (?,?,?)" ;
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setDate(2, model.getStart_date());
			statement.setDate(3, model.getEnd_date());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int update(Job model) {
		String query = "UPDATE jobs SET name = ? , start_date = ?, end_date = ? WHERE id = ?" ;
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setDate(2, model.getStart_date());
			statement.setDate(3, model.getEnd_date());
			statement.setInt(4, model.getId());
			
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public double loadStatisticJob(int id, int status) {
		String query = "SELECT count(j.id) / su.sum  as statistic\r\n" + 
				"FROM jobs as j JOIN tasks as t\r\n" + 
				"ON j.id = t.job_id\r\n" + 
				"JOIN (\r\n" + 
				"	SELECT j.id as id , count(j.id) as sum\r\n" + 
				"	FROM  tasks as t JOIN jobs as j\r\n" + 
				"	ON j.id = t.job_id\r\n" + 
				"	WHERE j.id = ?\r\n" + 
				") as su ON su.id = j.id \r\n" + 
				"WHERE j.id = ? and t.status_id = ? ;"; 
		
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setInt(1, id);
			statement.setInt(2, id);
			statement.setInt(3, status);
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				return resultSet.getDouble("statistic"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0 ; 
	}	
	
}
