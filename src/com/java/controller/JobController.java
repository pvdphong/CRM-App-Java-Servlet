package com.java.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.constants.StatusConstants;
import com.java.constants.UrlConstants;
import com.java.dto.JobDto;
import com.java.service.JobService;
import com.java.service.TaskService;

/*
 * SERVELET XỬ LÝ LIÊN QUAN ĐẾN TRANG DỰ ÁN 
 *  Auth: PHẠM VÕ ĐỨC PHONG
 * */

@WebServlet(urlPatterns = { UrlConstants.JOB_URL, UrlConstants.JOB_ADD_URL, UrlConstants.JOB_DETAIL_URL 
		, UrlConstants.JOB_DELETE_URL , UrlConstants.JOB_EDIT_URL})

public class JobController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private JobService jobService = null; 
	private TaskService taskService = null;
	
	@Override
	public void init() throws ServletException {
		jobService = new JobService(); 
		taskService = new TaskService(); 
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath(); 
		
		switch (action) {
		case UrlConstants.JOB_URL: 
			req.setAttribute("jobs",jobService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/job/index.jsp").forward(req, resp);
			break; 
		case UrlConstants.JOB_ADD_URL: 
			req.getRequestDispatcher("/WEB-INF/views/job/add.jsp").forward(req, resp);
			break; 
		case UrlConstants.JOB_DELETE_URL: 
			String idDelete = req.getParameter("id");
			jobService.delete(idDelete);
			resp.sendRedirect(req.getContextPath() + "/job");
			break; 
		case UrlConstants.JOB_EDIT_URL: 
			String idEdit = req.getParameter("id"); 
			JobDto model = jobService.findById(idEdit);
			req.setAttribute("job", model);
			req.getRequestDispatcher("/WEB-INF/views/job/edit.jsp").forward(req, resp);
			break; 
		case UrlConstants.JOB_DETAIL_URL: 
			String idDetail = req.getParameter("id"); 
			JobDto jobDetail = jobService.findById(idDetail);
			req.setAttribute("job", jobDetail);
			req.setAttribute("chuaTH", jobService.loadStatisticJob(jobDetail.getId(),StatusConstants.CHUA_THUC_HIEN));
			req.setAttribute("dangTH", jobService.loadStatisticJob(jobDetail.getId(),StatusConstants.DANG_THUC_HIEN));
			req.setAttribute("daHT", jobService.loadStatisticJob(jobDetail.getId(),StatusConstants.DA_HOAN_THANH));
			req.setAttribute("chuaThucHien", taskService.findTaskByJob(jobDetail, StatusConstants.CHUA_THUC_HIEN));
			req.setAttribute("dangThucHien", taskService.findTaskByJob(jobDetail, StatusConstants.DANG_THUC_HIEN));
			req.setAttribute("daHoanThanh", taskService.findTaskByJob(jobDetail, StatusConstants.DA_HOAN_THANH));	
			req.getRequestDispatcher("/WEB-INF/views/job/detail.jsp").forward(req, resp);
			break; 
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JobDto model = new JobDto(); 
		model.setName(req.getParameter("name"));
		model.setStart_date(Date.valueOf(req.getParameter("start_date")));
		model.setEnd_date(Date.valueOf(req.getParameter("end_date")));
	
		String action = req.getServletPath(); 
		
		switch (action) {
		case UrlConstants.JOB_ADD_URL: 
			jobService.insert(model); 
			break; 
		case UrlConstants.JOB_EDIT_URL: 
			model.setId(Integer.valueOf(req.getParameter("id")));
			jobService.update(model); 
			break; 
		default:
			break; 
		}
		resp.sendRedirect(req.getContextPath() + UrlConstants.JOB_URL);
	}
}
