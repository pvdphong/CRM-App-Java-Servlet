package com.java.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.constants.UrlConstants;
import com.java.dto.TaskDto;
import com.java.dto.UserDto;
import com.java.service.StatusService;
import com.java.service.TaskService;
import com.java.service.UserService;

/*
 * SERVLET QUẢN LÝ CÁC REQ, RESP LIÊN QUAN ĐẾN PROFILE 
 *  Auth: PHẠM VÕ ĐỨC PHONG
 * */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

@WebServlet(urlPatterns = {UrlConstants.PROFILE_URL, UrlConstants.PROFILE_EDIT , 
		UrlConstants.PROFILE_CHANGEPW , UrlConstants.PROFILE_TASK, UrlConstants.PROFILE_TASK_UPDATE})
public class ProfileController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private TaskService taskService = null; 
	private UserService userService = null;  
	private StatusService statusService = null; 

	@Override
	public void init() throws ServletException {
		taskService = new TaskService();
		userService = new UserService(); 
		statusService = new StatusService(); 
	}	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath(); 
		
		switch (action) {
			case UrlConstants.PROFILE_URL:  // load trang profile
				req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
				break; 
			case UrlConstants.PROFILE_EDIT: // load trang chỉnh sửa thông tin cá nhân
				req.getRequestDispatcher("/WEB-INF/views/profile/editProfile.jsp").forward(req, resp);	
				break; 
			case UrlConstants.PROFILE_CHANGEPW:  // load trang chỉnh sửa mật khẩu	
				req.getRequestDispatcher("/WEB-INF/views/profile/changePassword.jsp").forward(req, resp);	
				break; 
			case UrlConstants.PROFILE_TASK :  // load trang danh sách công việc cá nhân
				HttpSession session = req.getSession(); 
				UserDto userDto = (UserDto)session.getAttribute("USER"); 
				String id = String.valueOf(userDto.getId()); 
				req.setAttribute("tasks", taskService.findByUserId(id));
				req.setAttribute("chuaThucHien", userService.loadStatisticTask(userDto, 1));
				req.setAttribute("dangThucHien", userService.loadStatisticTask(userDto, 2));
				req.setAttribute("daHoanThanh", userService.loadStatisticTask(userDto, 3));
				req.getRequestDispatcher("/WEB-INF/views/profile/task.jsp").forward(req, resp);
				break; 	
			case UrlConstants.PROFILE_TASK_UPDATE:   // load trang update trạng thai công việc 
				String taskId = req.getParameter("id"); 
				TaskDto taskDto = taskService.findById(taskId); 
				req.setAttribute("task", taskDto);
				req.setAttribute("status", statusService.findAll());
				req.getRequestDispatcher("/WEB-INF/views/profile/taskUpdate.jsp").forward(req, resp);
				break; 
			default:
				break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String action = req.getServletPath(); 
		HttpSession session = req.getSession(); 
		switch (action) {
			case UrlConstants.PROFILE_EDIT: 	
				UserDto model = new UserDto(); 
				UserDto user = (UserDto)session.getAttribute("USER");  
				
				String urlSaveAvatar = userService.getAvatarUrl(req); 
				if(urlSaveAvatar.equals("")) {     // nếu người dùng không tải ảnh mới lên thì dùng vẫn dùng ảnh cũ
					model.setAvatar(user.getAvatar());
				}
				else {
					model.setAvatar(urlSaveAvatar);   // nếu người dùng tải ảnh mới lên thì lưu url ảnh mới xuống db
				}
				model.setId(Integer.valueOf(req.getParameter("id")));
				model.setEmail(req.getParameter("email"));
				model.setPassword(req.getParameter("password"));
				model.setFullname(req.getParameter("fullname"));
				model.setPhone(req.getParameter("phone"));
				model.setAddress(req.getParameter("address"));
				model.setRole_id(Integer.valueOf(req.getParameter("role")));
				userService.uploadFile(req);     // upload ảnh nếu có tải ảnh mới lên
				userService.update(model);   // update thông tin xuống db
				if(user.getId() == model.getId()) {
					String id = String.valueOf(model.getId()); 
					session.setAttribute("USER", userService.findById(id));
				}
				resp.sendRedirect(req.getContextPath() + UrlConstants.PROFILE_URL);
				break; 
			case UrlConstants.PROFILE_CHANGEPW :
				String id = req.getParameter("id");
				String oldPassword = req.getParameter("oldPassword"); 
				String newPassword = req.getParameter("newPassword");
				if(userService.checkPassword(id, oldPassword) > 0) { // nếu password cũ nhập đúng, 
					userService.changePassword(id, newPassword);    // tiến hành thay đối password cũ thành password mới  
					String success = "Thay đổi mật khẩu thành công!"; 
					req.setAttribute("success", success);
					session.removeAttribute("USER");     // bắt người dùng đăng nhập lại với mật khẩu mới 
				}
				else {
					String message = "Mật khẩu cũ không đúng!";   // nếu không thì hiển thị thông báo
					req.setAttribute("message", message);		
				}
				req.getRequestDispatcher("/WEB-INF/views/profile/changePassword.jsp").forward(req, resp);
				break; 
			case UrlConstants.PROFILE_TASK_UPDATE:   // cập nhật trạng thái công việc
				TaskDto dto = new TaskDto(); 
				dto.setId(Integer.valueOf(req.getParameter("id")));
				dto.setName(req.getParameter("name"));
				dto.setStart_date(Date.valueOf(req.getParameter("start_date")));
				dto.setEnd_date(Date.valueOf(req.getParameter("end_date")));
				dto.setUser_id(Integer.valueOf(req.getParameter("user")));
				dto.setJob_id(Integer.valueOf(req.getParameter("job")));
				dto.setStatus_id(Integer.valueOf(req.getParameter("status")));
				taskService.update(dto);
				resp.sendRedirect(req.getContextPath() + UrlConstants.PROFILE_TASK);
				break; 
			default:
				break; 
		}

	}
}
