package Controller;

import java.util.LinkedList;
import java.util.List;

import Model.Admin;
import Model.User;

public class UserExperience implements UserController{
	private String userName;
	private String passWord;
	private JDBC jdbc;
	
	
	
	public UserExperience() {
		// TODO Auto-generated constructor stub
		jdbc = new JDBC();
	}
	public UserExperience( String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		jdbc = new JDBC();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public Boolean Login(String userName, String passWord) {
		// TODO Auto-generated method stub
		List<User> listUser = new LinkedList<>();
		listUser = jdbc.getList();
		for(User u : listUser) {
			if(u.getUserName().equals(userName) && u.getPassWord().equals(passWord)) {
				return true;
			}
		}
		return false;
		
		
	}
	@Override
	public void Register(User user) {
		// TODO Auto-generated method stub
		jdbc.insertUser(user);
		
	}
	
	
}
