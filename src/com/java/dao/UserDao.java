package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.java.connection.MysqlConnection;
import com.java.dto.UserDto;
import com.java.model.User;


public class UserDao {
	
	public List<UserDto> findAll(){
		List<UserDto> models = new LinkedList<UserDto>(); // them xoa dung linked list toc do toi uu 
		try {
			
			Connection connection = MysqlConnection.getConnection(); 
			String query = "SELECT * FROM users as u JOIN roles as r ON u.role_id = r.id"; 
		
			PreparedStatement statement = connection.prepareStatement(query); 
		
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				UserDto model = new UserDto(); 	
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setPhone(resultSet.getString("phone"));
				model.setAddress(resultSet.getString("address"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRole_id(resultSet.getInt("role_id"));
				model.setRoleName(resultSet.getString("r.name"));
				
				models.add(model); 
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return models;
	}
	
	public int insert(User model) {
		String query =  "INSERT INTO users (email,password,fullname,phone,address,avatar,role_id) VALUES (?,?,?,?,?,?,?)";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getEmail());
			statement.setString(2, model.getPassword());
			statement.setString(3, model.getFullname());
			statement.setString(4, model.getPhone());
			statement.setString(5, model.getAddress());
			statement.setString(6, model.getAvatar());
			statement.setInt(7, model.getRole_id());
		
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public int delete(String id) {
		String query =  "DELETE FROM users WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	public UserDto findById(String id) {
		String query = "SELECT * FROM users as u JOIN roles as r ON u.role_id = r.id WHERE u.id = ?";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				UserDto model = new UserDto(); 
				
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setPhone(resultSet.getString("phone"));
				model.setAddress(resultSet.getString("address"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRole_id(resultSet.getInt("role_id"));
				model.setRoleName(resultSet.getString("r.name"));
				
				return model; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserDto() ; 
	}
	
	public int update(User model) {
		String query = "UPDATE users SET email = ? , "
				+ "fullname = ? , phone = ?, address = ?, avatar = ?, role_id = ? WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, model.getEmail());
			statement.setString(2, model.getFullname());
			statement.setString(3, model.getPhone());
			statement.setString(4, model.getAddress());
			statement.setString(5, model.getAvatar());
			statement.setInt(6, model.getRole_id());
			statement.setInt(7, model.getId());
			
			return statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}
	
	// TÌM USER THEO EMAIL
	public UserDto findByEmail(String email) {
		String query = "SELECT * FROM users as u JOIN roles as r ON u.role_id = r.id WHERE u.email = ? ";
		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setString(1, email);
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				UserDto model = new UserDto(); 
				
				model.setId(resultSet.getInt("id"));
				model.setEmail(resultSet.getString("email"));
				model.setPassword(resultSet.getString("password"));
				model.setFullname(resultSet.getString("fullname"));
				model.setPhone(resultSet.getString("phone"));
				model.setAddress(resultSet.getString("address"));
				model.setAvatar(resultSet.getString("avatar"));
				model.setRole_id(resultSet.getInt("role_id"));
				model.setRoleName(resultSet.getString("r.name"));
				
				return model; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 
	
	// TRẢ VỀ THỐNG KÊ CÔNG VIỆC CỦA USER THEO STATUS ID 
	public double loadStatisticTask(UserDto model ,int status_id) {
		String query = "select count(u.id) / su.sum as statistic\r\n" + 
				"from tasks as t\r\n" + 
				"join users as u\r\n" + 
				"on t.user_id = u.id\r\n" + 
				"join status as s \r\n" + 
				"on t.status_id = s.id\r\n" + 
				"join (\r\n" + 
				"	select  u.id as id,  count(u.id) as sum\r\n" + 
				"	from tasks as t\r\n" + 
				"	join users as u\r\n" + 
				"	on t.user_id = u.id\r\n" + 
				"	where t.user_id = ?\r\n" + 
				") as su on su.id = u.id\r\n" + 
				" where t.user_id = ? and s.id = ? ;"; 

		try(Connection connection = MysqlConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setInt(1, model.getId());
			statement.setInt(2, model.getId());
			statement.setInt(3, status_id);
			
			ResultSet resultSet = statement.executeQuery(); 
			
			while(resultSet.next()) {
				return resultSet.getDouble("statistic"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0 ; 
	}
	
	// CHANGE PASSWORD OF USER 
	public int changePassword(String id, String password) {
		String query = "UPDATE users SET password = ? WHERE id = ?";
		try(Connection connection = MysqlConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query); 
			
			statement.setString(1,password);
			statement.setInt(2, Integer.valueOf(id));
			
			return statement.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; 
	}	
	
}
