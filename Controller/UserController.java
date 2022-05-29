package Controller;

import Model.User;

public interface UserController {
	final String admin = "admin";
	final String adminPassword = "12345678";
	Boolean Login(String userName, String passWord);
	void Register(User user);	
}
