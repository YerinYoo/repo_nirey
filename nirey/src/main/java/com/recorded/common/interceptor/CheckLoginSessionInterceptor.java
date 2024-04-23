package com.recorded.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.recorded.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getSession().getAttribute("sessSeqUsr") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINADMFORM);
	        return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}



//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		if (request.getSession().getAttribute("sessSeq") != null) {
//			// by pass
//		} else {
//			response.sendRedirect(Constants.URL_LOGINFORM);
//            return false;
//		}
//		return true;
//	}
	
	
}