package Controller;

import java.util.List;

import Model.Admin;
import Model.User;
import Model.Vehical;

public interface JDBCController {
	static final String url = "jdbc:mysql://localhost:3306/vehical";
	static final String root = "root";
	static final String password = "hai142857bn"; 
	void selectUserInformation(String userName);
	void insertUser(User user);
	void insertAdmin(Admin admin);
	void insertProduct(Vehical vehical,String types,int id);
	User getUser(String userName);
	Vehical getProduct(String id);
	void deleteProduct(Vehical vehical, String type);
	void deleteUser(String userName);
	void updateProduct(String id);
	List<Vehical> getListProductType(String type);
	
}
