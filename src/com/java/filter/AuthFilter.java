package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.UserDto;
	
	@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse resp = (HttpServletResponse)response; 
		
		// -----===== KIỂM TRA SESSION =====-----
		if( req.getServletPath().startsWith("/login") || req.getServletPath().startsWith("/static") 
				|| req.getServletPath().startsWith("/logout") || req.getServletPath().startsWith("/error")  ) {
			chain.doFilter(request, response);
			return; 
		}
			
		 // -----===== KIỂM TRA ĐĂNG NHẬP =====-----
		HttpSession session = req.getSession(); 
		if(session.getAttribute("USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return; 
		}
		
		//  -----===== PHÂN QUYỀN NGƯỜI DÙNG =====-----
		UserDto userDto = (UserDto) session.getAttribute("USER"); 
		String roleName = userDto.getRoleName(); 
		
		// th1: nếu là /role thì phải có rolename là ROLE_ADMIN
		if(req.getServletPath().startsWith("/role") && !roleName.equals("ROLE_ADMIN")) {
				resp.sendRedirect(req.getContextPath() + "/error/403");	 
				return; 
			
		}
		
		// th2: nếu là /user thì phải có rolename là ROLE_ADMIN hoặc ROLE_LEADER
		if(req.getServletPath().startsWith("/user") && !roleName.equals("ROLE_ADMIN") && !roleName.equals("ROLE_MANAGER")) {
				resp.sendRedirect(req.getContextPath() + "/error/403");	 
				return; 
		
		}
		
		// th3: nếu là /task thì phải có rolename là ROLE_ADMIN hoặc ROLE_LEADER
		if(req.getServletPath().startsWith("/task") && !roleName.equals("ROLE_ADMIN") && !roleName.equals("ROLE_MANAGER")) {
				resp.sendRedirect(req.getContextPath() + "/error/403");	 
				return; 
		}	
		
		// th4: nếu là /job thì phải có rolename là ROLE_ADMIN hoặc ROLE_LEADER
		if(req.getServletPath().startsWith("/job") && !roleName.equals("ROLE_ADMIN") && !roleName.equals("ROLE_MANAGER")) {
				resp.sendRedirect(req.getContextPath() + "/error/403");	 
				return; 
		}	
	
		// các trường hợp còn lại
		chain.doFilter(request, response);
	}
}
