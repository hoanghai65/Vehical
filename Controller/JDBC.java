package Controller;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Model.Admin;
import Model.Car;
import Model.Motorbike;
import Model.Truck;
import Model.User;
import Model.Vehical;
public class JDBC implements JDBCController{
	public  Connection con;
	public  PreparedStatement ps;
	private String url = JDBCController.url;
	private String root = JDBCController.root;
	private  String password = JDBCController.password;
	private List<User> listUser ;
	private List<Admin> listAdmin ;
	private List<Vehical> listVehical;
	
	public JDBC() {
		// TODO Auto-generated constructor stub
		connectionQuery();
		listUser = new LinkedList();
		listAdmin = new LinkedList<>();
		listVehical = new LinkedList<>();
		
	}
	public  void connectionQuery() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,root,password);
	            System.out.println("Remote DB connection established");
	            System.out.println("Connection created");  
                System.out.println("Connection closed");
                
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.toString());  
		}
	}
	public static void main(String[] args) {
		JDBC jdbc = new JDBC();
		jdbc.selectUserInformation("hoanghai");
		
	}
	@Override
	public void selectUserInformation(String userName) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM users where userName ="+"'"+userName+"'";
		
		try {
			 ps = con.prepareStatement(query);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) {
                 System.out.println(rs.getString(1) + "  " + rs.getString(2) 
                         + "  " + rs.getString(3) + " " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(5) 
                         );
             }
 			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		String query = "insert into admins(userName,userPassword,phone,sex,birthday,address)"
				+ "value (?,?,?,?,?,?)";
		String userName = admin.getUserName();
		String userPassword = admin.getPassWord();
		String phone = admin.getPhone();
		String sex = admin.getSex();
		String birthday = admin.getBirthday();
		String address = admin.getAddress();
		System.out.println(admin.toString());
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ps.setString(3, phone);
			ps.setString(4, sex);
			ps.setString(5, birthday);
			ps.setString(6, address);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("error insert user");
		}
		
	}
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
		
		String query = "insert into users(userName,userPassword,phone,sex,birthday,address)"
				+ "value (?,?,?,?,?,?)";
		String userName = user.getUserName();
		String userPassword = user.getPassWord();
		String phone = user.getPhone();
		String sex = user.getSex();
		String birthday = user.getBirthday();
		String address = user.getAddress();
		System.out.println(user.toString());
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ps.setString(3, phone);
			ps.setString(4, sex);
			ps.setString(5, birthday);
			ps.setString(6, address);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("error insert user");
		}
	}
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM users where userName ="+"'"+userName+"'";
		
		try {
			ps = con.prepareStatement(query);
 			ResultSet rs = ps.executeQuery();
 			String userPassword = rs.getString(2);
 			String phone = rs.getString(3);
 			String sex = rs.getString(4);
 			String birthday = rs.getString(5);
 			String address = rs.getString(6);
 			User user = new User(userName, userPassword, phone, birthday, sex, address);
 			ps.close();
 			return user;
 			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public void deleteProduct(Vehical vehical, String type) {
		// TODO Auto-generated method stub
		String company = vehical.getCompany();
		String date = vehical.getDate();
		double price = vehical.getPrice();
		String color = vehical.getColor();
		if(type.equals("Car")) {
			Car car = (Car) vehical;
			String query = "delete from car where company = ? and birthday = ? and price = ?"
					+ "and color = ? and numberOfSeats = ? and  engineType =?";
			int numberOfSeats = car.getNumberOfSeats();
			String engineType = car.getEngineType();
			
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, company);
				ps.setString(2, date);
				ps.setDouble(3, price);
				ps.setString(4, color);
				ps.setInt(5, numberOfSeats);
				ps.setString(6, engineType);
				System.out.println(query);
				ps.executeUpdate();
				
				System.out.println("Delete product success");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}else if(type.equals("Motorbike")) {
			Motorbike mb = (Motorbike) vehical;
			String query = "delete from motorbike where company = ? and birthday = ? and price = ?"
					+ "and color = ? and wattage = ?";
			String wattage = mb.getWattage();
			
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, company);
				ps.setString(2, date);
				ps.setDouble(3, price);
				ps.setString(4, color);
				ps.setString(5, wattage);
				System.out.println(query);
				ps.executeUpdate();
				
				System.out.println("Delete product success");
		}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		else {
			Truck truck = (Truck) vehical;
			String query = "delete from truck where company = ? and birthday = ? and price = ?"
					+ "and color = ? and tonnage = ?";
			int tonnage = truck.getTonnage();
			
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, company);
				ps.setString(2, date);
				ps.setDouble(3, price);
				ps.setString(4, color);
				ps.setInt(5, tonnage);
				System.out.println(query);
				ps.executeUpdate();
				
				System.out.println("Delete product success");
		}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		String query = "delete from users where userName ="+"'"+userName+"'";
		try {
			ps = con.prepareStatement(query);
			System.out.println("Deleted userName " + userName);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void updateProduct(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Vehical getProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> getList(){
		String query = "SELECT * FROM users";
		
		try {
			 ps = con.prepareStatement(query);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) {
 				String userName = rs.getString(1);
 				String userPassword = rs.getString(2);
 				String phone = rs.getString(3);
 	 			String sex = rs.getString(4);
 	 			String birthday = rs.getString(5);
 	 			String address = rs.getString(6);
 	 			
 	 			User user = new User(userName, userPassword,phone, birthday, sex, address);
 	 			listUser.add(user);
 	 			
 	 			
             }
 			
 			ps.close();
 			return listUser;
		} catch (Exception e) {
			System.out.println("error get data to database");
			
		}
		
		return null;
	}
	public List<Admin> getListAdmin(){
		String query = "SELECT * FROM admins";
		
		try {
			 ps = con.prepareStatement(query);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) {
 				String userName = rs.getString(1);
 				String userPassword = rs.getString(2);
 				String phone = rs.getString(3);
 	 			String sex = rs.getString(4);
 	 			String birthday = rs.getString(5);
 	 			String address = rs.getString(6);
 	 			
 	 			Admin admin = new Admin(userName, userPassword,phone, birthday, sex, address);
 	 			listAdmin.add(admin);
 	 			
 	 			
             }
 			
 			ps.close();
 			return listAdmin;
		} catch (Exception e) {
			System.out.println("error get data to database");
			
		}
		
		return null;
	}
	@Override
	public List<Vehical> getListProductType(String type) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM "+type;
		System.out.println(query);
		List<Vehical> list = new LinkedList<>();
		
		try {
			 ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String company = rs.getString(2);
				String date = rs.getString(3);
				double price = rs.getDouble(4);
				String color = rs.getString(5);
	 			
	 			if(type.equals("car")) {
	 				int numberOfSeats = rs.getInt(6);
	 				String engineType = rs.getString(7);
	 				Car cars = new Car(company, date, price, color, numberOfSeats, engineType);
	 				list.add(cars);
	 			}
	 			else if(type.equals("motorbike")) {
	 				String wattage = rs.getString(6);
	 				Motorbike mb = new Motorbike(company, date, price, color, wattage);
	 				list.add(mb);
	 			}
	 			else {
	 				int tonnage = rs.getInt(6);
	 				Truck truck = new Truck(company, date, price, color, tonnage);
	 				list.add(truck);
	 			}
	 			
	 			
	 			
            }
			
			ps.close();
			return list;
		} catch (Exception e) {
			System.out.println("error get data to database");
			
		}
		
		return null;
	}
	@Override
	public void insertProduct(Vehical vehical,String types,int id) {
		// TODO Auto-generated method stub
		String company = vehical.getCompany();
		String date = vehical.getDate();
		double price = vehical.getPrice();
		String color = vehical.getColor();
		if(types.equals("car")) {
			Car car = (Car) vehical;
			String query = "insert into car(idCar,company,birthday,price,color,numberOfSeats,engineType)"
					+ "value (?,?,?,?,?,?,?)";
			
			int numberOfSeats = car.getNumberOfSeats();
			String engineType = car.getEngineType();
			
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ps.setString(2, company);
				ps.setString(3, date);
				ps.setDouble(4, price);
				ps.setString(5, color);
				ps.setInt(6, numberOfSeats);
				ps.setString(7, engineType);
				ps.executeUpdate();
				
				System.out.println("Add product success");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if(types.equals("motorbike")) {
			Motorbike mb = (Motorbike) vehical;
			String query = "insert into motorbike(idCar,company,birthday,price,color,wattage)"
					+ "value (?,?,?,?,?,?)";
			String wattage = mb.getWattage();
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ps.setString(2, company);
				ps.setString(3, date);
				ps.setDouble(4, price);
				ps.setString(5, color);
				ps.setString(6, wattage);
				ps.executeUpdate();
				System.out.println("Add product success");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		else {
			Truck truck = (Truck) vehical;
			String query = "insert into truck(idCar,company,birthday,price,color,tonnage)"
					+ "value (?,?,?,?,?,?)";
			int tonnage = truck.getTonnage();
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ps.setString(2, company);
				ps.setString(3, date);
				ps.setDouble(4, price);
				ps.setString(5, color);
				ps.setInt(6,tonnage);
				ps.executeUpdate();
				System.out.println("Add product success");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}
