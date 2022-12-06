package com.java.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.constants.StatusConstants;
import com.java.constants.UrlConstants;
import com.java.dto.UserDto;
import com.java.service.RoleService;
import com.java.service.TaskService;
import com.java.service.UserService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

/*
 *  Auth: PHẠM VÕ ĐỨC PHONG
 */

@WebServlet(urlPatterns = {UrlConstants.USER_URL, UrlConstants.USER_ADD_URL,
	UrlConstants.USER_DETAIL_URL, UrlConstants.USER_DELETE_URL, UrlConstants.USER_EDIT_URL})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService = null; 
	private RoleService roleService = null;
	private TaskService taskService = null; 
	
	@Override
	public void init() throws ServletException {
		userService = new UserService(); 
		roleService = new RoleService(); 
		taskService = new TaskService(); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath(); 
		
		switch (action) {
		case UrlConstants.USER_URL: 
			req.setAttribute("users", userService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/index.jsp").forward(req, resp);
			break; 
		case UrlConstants.USER_ADD_URL: 
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			break; 
		case UrlConstants.USER_EDIT_URL: 
			String idEdit = req.getParameter("id"); 
			UserDto model = userService.findById(idEdit); 
			req.setAttribute("user", model);
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
			break; 
		case UrlConstants.USER_DELETE_URL:
			String idDel = req.getParameter("id"); 
			userService.delete(idDel); 
			resp.sendRedirect(req.getContextPath() + UrlConstants.USER_URL);
			break; 
		case UrlConstants.USER_DETAIL_URL: 
			String idDetail = req.getParameter("id"); 
			UserDto user = userService.findById(idDetail); 
			req.setAttribute("chuaThucHien", userService.loadStatisticTask(user, StatusConstants.CHUA_THUC_HIEN));
			req.setAttribute("dangThucHien", userService.loadStatisticTask(user, StatusConstants.DANG_THUC_HIEN));
			req.setAttribute("daHoanThanh", userService.loadStatisticTask(user, StatusConstants.DA_HOAN_THANH));
			req.setAttribute("taskChuaThucHien", taskService.findTaskByUser(user, StatusConstants.CHUA_THUC_HIEN));
			req.setAttribute("taskDangThucHien", taskService.findTaskByUser(user, StatusConstants.DANG_THUC_HIEN));
			req.setAttribute("taskDaHoanThanh", taskService.findTaskByUser(user, StatusConstants.DA_HOAN_THANH));
			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/views/user/detail.jsp").forward(req, resp);
			break; 	
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDto model = new UserDto(); 
		model.setEmail(req.getParameter("email"));
		model.setFullname(req.getParameter("fullname"));
		model.setPhone(req.getParameter("phone"));
		model.setAddress(req.getParameter("address"));
		model.setRole_id(Integer.valueOf(req.getParameter("role")));
		
		String action = req.getServletPath(); 
		switch (action) {
			case UrlConstants.USER_EDIT_URL: 
				model.setAvatar(req.getParameter("avatar"));
				model.setId(Integer.valueOf(req.getParameter("id")));
				userService.update(model);
				HttpSession session = req.getSession(); 
				UserDto user = (UserDto)session.getAttribute("USER"); 
				if(user.getId() == model.getId()) {   // nếu user sửa thông tin chính là user đang đăng nhập thì cập nhật lại 
					String id = String.valueOf(model.getId()); 
					session.setAttribute("USER", userService.findById(id));
				}
				break; 
			case UrlConstants.USER_ADD_URL: 
				model.setAvatar(userService.getAvatarUrl(req));
				model.setPassword(req.getParameter("password"));
				userService.uploadFile(req);
				userService.insert(model);
				break;			
			default:
				break; 
		}
	
		resp.sendRedirect(req.getContextPath() + UrlConstants.USER_URL);
	}
}
