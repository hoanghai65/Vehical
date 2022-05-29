package Controller;

import Model.User;
import Model.Vehical;

public interface AdminController {
	Boolean Login(String userName,String password);
	void addUser(User user);
	void removeUser(User user);
	void addProduct(Vehical vehical);
	void removeProduct(Vehical vehical);
	void update(Vehical vehical);
}
