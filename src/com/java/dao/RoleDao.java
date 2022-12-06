	package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.model.Role;

public class RoleDao {
	public List<Role> findAll(){
		List<Role> models = new LinkedList<Role>();
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM crm_app.Roles"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				Role model = new Role(); 
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setDescription(resultSet.getString("description"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}

	public Role findById(String id) {
		String query = "SELECT * FROM roles WHERE id = ?"; 
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				Role model = new Role();
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setDescription(resultSet.getString("description"));
				
				return model; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Role(); 
	}
	
	public int insert(Role model) {
		String query = "INSERT INTO roles (name,description) VALUES (?,?)"; 
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setString(2, model.getDescription());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int delete(String id) {
		String query = "DELETE FROM roles WHERE id = ?"; 
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			return statement.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int update(Role model) throws SQLException {
		String query = "UPDATE roles SET name = ?, description = ? WHERE id = ? "; 
		
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getName());
			statement.setString(2, model.getDescription());
			statement.setInt(3, model.getId());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0; 
	}
			
}
