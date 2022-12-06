package com.java.service;

import java.util.List;

import com.java.dao.TaskDao;
import com.java.dto.JobDto;
import com.java.dto.TaskDto;
import com.java.dto.UserDto;
import com.java.model.Task;

public class TaskService {
	
	private TaskDao taskDao = null; 
	
	public TaskService() {
		taskDao = new TaskDao(); 
	}
	
	public List<TaskDto> findAll(){ 
		List<TaskDto> dtos = taskDao.findAll();
		
		return dtos; 
	}
	
	public void insert(TaskDto dto) {
		Task model = new Task(); 
		
		model.setName(dto.getName());
		model.setStart_date(dto.getStart_date());
		model.setEnd_date(dto.getEnd_date());
		model.setUser_id(dto.getUser_id());
		model.setJob_id(dto.getJob_id());
		model.setStatus_id(dto.getStatus_id());
		
		taskDao.insert(model); 
	}
	
	public void delete(String id) {
		taskDao.delete(id); 
	}
	
	public TaskDto findById(String id) {
		TaskDto model = taskDao.findById(id); 
		
		return model; 
	}
	
	public void update(TaskDto dto) {
		Task model = new Task(); 
		
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setStart_date(dto.getStart_date());
		model.setEnd_date(dto.getEnd_date());
		model.setUser_id(dto.getUser_id());
		model.setJob_id(dto.getJob_id());
		model.setStatus_id(dto.getStatus_id());
		
		taskDao.update(model); 
	}
	
	public List<TaskDto> findByUserId(String id){
		return taskDao.findByUserId(id);
	}
	
	public List<TaskDto> findTaskByUser(UserDto userDto, int status){
		return taskDao.findTaskByUser(userDto, status);
	}
	
	public List<TaskDto> findTaskByJob(JobDto job, int status){
		return taskDao.findTaskByJob(job, status);
	}
}	

