package com.emmaobo.expensetracker.verification;

import javax.servlet.http.HttpServletRequest;

import com.emmaobo.expensetracker.model.User;

public class LoginVerification 
{
	
	public static boolean verifyLoggedInUser(HttpServletRequest request)
	{
		User user = (User) request.getServletContext().getAttribute("user");
		if(user != null)
			return true;
		
		return false;
	}
}
