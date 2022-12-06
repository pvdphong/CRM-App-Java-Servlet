package com.java.dto;

import java.sql.Date;

public class JobDto {
	private int id; 
	private String name;
	private Date start_date;
	private Date end_date;
	private int chuaThucHien; 
	private int dangThucHien; 
	private int daHoanThanh;
	
	public JobDto() {
		
	}
	
	public JobDto(int id, String name, Date start_date, Date end_date, int chuaThucHien, int dangThucHien,
			int daHoanThanh) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.chuaThucHien = chuaThucHien;
		this.dangThucHien = dangThucHien;
		this.daHoanThanh = daHoanThanh;
	}



	public int getChuaThucHien() {
		return chuaThucHien;
	}



	public void setChuaThucHien(int chuaThucHien) {
		this.chuaThucHien = chuaThucHien;
	}



	public int getDangThucHien() {
		return dangThucHien;
	}



	public void setDangThucHien(int dangThucHien) {
		this.dangThucHien = dangThucHien;
	}



	public int getDaHoanThanh() {
		return daHoanThanh;
	}

	public void setDaHoanThanh(int daHoanThanh) {
		this.daHoanThanh = daHoanThanh;
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

	
	
	
}
