package Controller;

import java.util.LinkedList;
import java.util.List;

import Model.Admin;
import Model.User;
import Model.Vehical;

public class AdminManager implements AdminController{
	private String adminName;
	private String adminPassword;
	private JDBC jbdc;
	
	public AdminManager() {
		// TODO Auto-generated constructor stub
		jbdc = new JDBC();
	}
	public AdminManager( String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		jbdc = new JDBC();
		
	}
	

	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		jbdc.insertUser(user);
		
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		jbdc.deleteUser(user.getUserName());
	}

	@Override
	public void addProduct(Vehical vehical) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Vehical vehical) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vehical vehical) {
		// TODO Auto-generated method stub
		
	}
	public Boolean Login(String userName,String password) {
		List<Admin> listAdmin = new LinkedList<>();
		listAdmin = jbdc.getListAdmin();
		for(Admin a : listAdmin) {
			if(a.getUserName().equals(userName) && a.getPassWord().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
