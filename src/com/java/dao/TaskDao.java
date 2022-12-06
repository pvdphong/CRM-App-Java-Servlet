	package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.dto.JobDto;
import com.java.dto.TaskDto;
import com.java.dto.UserDto;
import com.java.model.Task;

public class TaskDao {
	
	public List<TaskDto> findAll(){
		List<TaskDto> models = new LinkedList<TaskDto>();
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.user_id, t.job_id, t.status_id, j.name, st.name,  u.fullname\r\n" + 
				"from tasks as t \r\n" + 
				"join users as u on t.user_id = u.id\r\n" + 
				"join jobs as j on t.job_id = j.id\r\n" + 
				"join status as st on t.status_id = st.id"; 
		try{
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				TaskDto model = new TaskDto(); 	
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				model.setUser_id(resultSet.getInt("t.user_id"));
				model.setJob_id(resultSet.getInt("t.job_id"));
				model.setStatus_id(resultSet.getInt("t.status_id"));
				model.setUser_name(resultSet.getString("u.fullname"));
				model.setJob_name(resultSet.getString("j.name"));
				model.setStatus_name(resultSet.getString("st.name"));
				
				models.add(model); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
	
	public TaskDto findById(String id) {
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.user_id, t.job_id, t.status_id, j.name, st.name,  u.fullname\r\n" + 
				"from tasks as t \r\n" + 
				"join users as u on t.user_id = u.id\r\n" + 
				"join jobs as j on t.job_id = j.id\r\n" + 
				"join status as st on t.status_id = st.id "
				+ " WHERE t.id = ?"; 
		
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				TaskDto model = new TaskDto();
				
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				model.setUser_id(resultSet.getInt("t.user_id"));
				model.setJob_id(resultSet.getInt("t.job_id"));
				model.setStatus_id(resultSet.getInt("t.status_id"));
				model.setUser_name(resultSet.getString("u.fullname"));
				model.setJob_name(resultSet.getString("j.name"));
				model.setStatus_name(resultSet.getString("st.name"));
				
				return model;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TaskDto(); 
	}
	
	public int delete(String id) {
		String query = "DELETE FROM tasks WHERE id = ?" ;
		try{
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			return statement.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int insert(Task model) {
		String query = "INSERT INTO tasks (name, start_date, end_date, user_id, job_id, status_id) VALUES (?,?,?,?,?,?)" ;
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setDate(2, model.getStart_date());
			statement.setDate(3, model.getEnd_date());
			statement.setInt(4, model.getUser_id());
			statement.setInt(5, model.getJob_id()); 
			statement.setInt(6, model.getStatus_id());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0; 
	}
	
	public int update(Task model) {
		
		String query = "UPDATE tasks SET name = ? , start_date = ?, end_date = ? , user_id = ? , "
				+ " job_id = ? , status_id = ? WHERE id = ?" ;
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setDate(2, model.getStart_date());
			statement.setDate(3, model.getEnd_date());
			statement.setInt(4, model.getUser_id());
			statement.setInt(5, model.getJob_id()); 
			statement.setInt(6,model.getStatus_id());
			statement.setInt(7, model.getId());
			
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public List<TaskDto> findByUserId(String id){
		List<TaskDto> models = new LinkedList<TaskDto>();
		

		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.user_id, t.job_id, t.status_id, j.name, st.name,  u.fullname\r\n" + 
				"from tasks as t \r\n" + 
				"join users as u on t.user_id = u.id\r\n" + 
				"join jobs as j on t.job_id = j.id\r\n" + 
				"join status as st on t.status_id = st.id "
				+ "WHERE u.id = ? "; 
		
		try{
			Connection connection = MysqlConnection.getConnection();
			
		
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				TaskDto model = new TaskDto(); 	
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				model.setUser_id(resultSet.getInt("t.user_id"));
				model.setJob_id(resultSet.getInt("t.job_id"));
				model.setStatus_id(resultSet.getInt("t.status_id"));
				model.setUser_name(resultSet.getString("u.fullname"));
				model.setJob_name(resultSet.getString("j.name"));
				model.setStatus_name(resultSet.getString("st.name"));
				
				models.add(model); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
	
	public List<TaskDto> findTaskByUser(UserDto userDto, int status){
		String query = "SELECT * \r\n" + 
				"FROM tasks as t JOIN users as u \r\n" + 
				"on t.user_id = u.id\r\n" + 
				"JOIN jobs as j \r\n" + 
				"on t.job_id = j.id\r\n" + 
				"WHERE u.id = ? and t.status_id = ?; "; 
		
		List<TaskDto> models = new LinkedList<TaskDto>();
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setInt(1, userDto.getId());
			statement.setInt(2, status);
			
			ResultSet resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				TaskDto model = new TaskDto();
				
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				model.setUser_id(resultSet.getInt("t.user_id"));
				model.setJob_id(resultSet.getInt("t.job_id"));
				model.setStatus_id(resultSet.getInt("t.status_id"));
				model.setUser_name(resultSet.getString("u.fullname"));
				model.setJob_name(resultSet.getString("j.name"));
				
				models.add(model);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models; 
	}
	
	public List<TaskDto> findTaskByJob(JobDto job, int status){
		String query = "SELECT *\r\n" + 
				"FROM  tasks as t JOIN jobs as j\r\n" + 
				"ON j.id = t.job_id\r\n" + 
				"JOIN users as u \r\n" + 
				"ON t.user_id = u.id\r\n" + 
				"WHERE j.id = ? and t.status_id = ? ;"; 
		
		List<TaskDto> models = new LinkedList<TaskDto>();
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setInt(1, job.getId());
			statement.setInt(2, status);
			
			ResultSet resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				TaskDto model = new TaskDto();
				
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setStart_date(resultSet.getDate("start_date"));
				model.setEnd_date(resultSet.getDate("end_date"));
				model.setUser_id(resultSet.getInt("t.user_id"));
				model.setJob_id(resultSet.getInt("t.job_id"));
				model.setStatus_id(resultSet.getInt("t.status_id"));
				model.setUser_name(resultSet.getString("u.fullname"));
				model.setJob_name(resultSet.getString("j.name"));
				
				models.add(model);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models; 
	}
}
		