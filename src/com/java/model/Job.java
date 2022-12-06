package com.java.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Job {
	private int id; 
	private String name;
	private Date start_date;
	private Date end_date;
	
	public Job() {
		super();
	}
	
	public Job(int id, String name, Date start_date, Date end_date) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
		}
		public Date getEnd_date() {
			return end_date;
		}
		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		} 
		
		public String dateFormat(Date date) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(date);	
		return stringDate; 
		}
}
