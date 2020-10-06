package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController
{
	 @GetMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        String errorPage = "error"; // default
	         System.out.println("------------error------------------");
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	         
	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());
	             
	            if (statusCode == HttpStatus.NOT_FOUND.value()) {
	               System.out.println("------404---------------------------------------");
	                errorPage = "error/404";
	                 
	            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
	                // handle HTTP 403 Forbidden error
	            	System.out.println("------403---------------------------------------");
	                errorPage = "error/403";
	                 
	            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	                // handle HTTP 500 Internal Server error
	            	System.out.println("------500---------------------------------------");
	                errorPage = "error/500";
	                 
	            }
	        }
	        //errorPage = "error";
	         
	        return errorPage;
	    }
	 
	 @RequestMapping("/error1")
	 public String Errorhandle()
	 {
		 return "customers1";
	 }
	 
	 @Override
	    public String getErrorPath() {
	        return "/error";
	    }
	 

}
