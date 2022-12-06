package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.constants.UrlConstants;
import com.java.dto.RoleDto;
import com.java.service.RoleService;
/*
 *  Auth: PHẠM VÕ ĐỨC PHONG
 */

@WebServlet(urlPatterns = { UrlConstants.ROLE_URL , UrlConstants.ROLE_ADD_URL ,UrlConstants.ROLE_DELETE_URL, 
		UrlConstants.ROLE_EDIT_URL })
public class RoleController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private RoleService roleService = null; 
	
	@Override
	public void init() throws ServletException {
		roleService = new RoleService(); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath(); 
		switch (action) {
		case UrlConstants.ROLE_URL: 
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_ADD_URL : 
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_EDIT_URL : 
			String idEdit =  req.getParameter("id");
			RoleDto model = roleService.findById(idEdit); 
			req.setAttribute("role", model);
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			break;
		case UrlConstants.ROLE_DELETE_URL: 
			String idDelete = req.getParameter("id");
			roleService.deleteById(idDelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.ROLE_URL);
			break;
		default:
			break; 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RoleDto model = new RoleDto(); 
		model.setName(req.getParameter("name"));
		model.setDesc(req.getParameter("description"));
		
		String action = req.getServletPath(); 
		switch (action) {
			case UrlConstants.ROLE_ADD_URL: 
				roleService.insert(model);
				break; 
			case UrlConstants.ROLE_EDIT_URL:
				model.setId(Integer.valueOf(req.getParameter("id")));	
			try {
				roleService.update(model);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				break; 
			default:
				break; 
		}
		resp.sendRedirect(req.getContextPath() + UrlConstants.ROLE_URL);
	}
}

// ADMIN: full quyền
// LEADER: không được vào trang role, vào được /user
// USER : chỉ được vào xem công việc, trang cá nhân