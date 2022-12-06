package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.constants.UrlConstants;
import com.java.dto.UserDto;
import com.java.service.JobService;
import com.java.service.TaskService;
import com.java.service.UserService;

/*
 * SERVLET TRANG HOME 
 *  Auth: PHẠM VÕ ĐỨC PHONG
 * */

@WebServlet( urlPatterns = { UrlConstants.HOME_URL } )

public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private TaskService taskService = null; 
	private UserService userService = null;  
	private JobService jobService = null;  

	@Override
	public void init() throws ServletException {
		taskService = new TaskService();
		userService = new UserService(); 
		jobService = new JobService();
	}	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action = req.getServletPath(); 
			switch (action) {
				case UrlConstants.HOME_URL:
					HttpSession session = req.getSession(); 
					UserDto userDto = (UserDto)session.getAttribute("USER"); 
					String roleName = userDto.getRoleName(); 
					
					if(roleName.equals("ROLE_USER")) {
						String id = String.valueOf(userDto.getId()); 
						req.setAttribute("tasks", taskService.findByUserId(id));
						req.setAttribute("chuaThucHien", userService.loadStatisticTask(userDto, 1));
						req.setAttribute("dangThucHien", userService.loadStatisticTask(userDto, 2));
						req.setAttribute("daHoanThanh", userService.loadStatisticTask(userDto, 3));
						req.getRequestDispatcher("/WEB-INF/views/profile/task.jsp").forward(req, resp);
					}
					else {
						req.setAttribute("jobs", jobService.findAll());
						req.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(req, resp);
					}			
					break; 
				default:
					break; 
		}	
	}
}
