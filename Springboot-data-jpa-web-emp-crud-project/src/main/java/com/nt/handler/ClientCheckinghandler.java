
package com.nt.handler;



import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ClientCheckinghandler implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler) throws Exception {
		//get System date and time
		if(req.getServletPath().equalsIgnoreCase("/"))
			return true;
		
		LocalDateTime ldt = LocalDateTime.now();
		//GGet current hour of the day
		int time = ldt.getHour();
		
		if(time<9 ||time>17) {
			RequestDispatcher rd  = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}
	
}
