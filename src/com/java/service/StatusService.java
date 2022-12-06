package com.java.service;

import java.util.List;

import com.java.dao.StatusDao;
import com.java.model.Status;

public class StatusService {
	private StatusDao statusDao = null; 
	
	public StatusService() {
		statusDao = new StatusDao(); 
	}
	
	public List<Status> findAll(){
		return statusDao.findAll(); 
	}
	
}
