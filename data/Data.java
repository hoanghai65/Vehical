package data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Data {
	private String UserName;
	private String Password;
	private List<ArrayList<String>> info;
	public List<ArrayList<String>> readfile(String fileName) {
		List<ArrayList<String>> list = new LinkedList<>();
		try {
			Scanner sc = new Scanner(new File(fileName));
			while (sc.hasNextLine()) {
				String userName = sc.next();
				String password = sc.next();
				ArrayList<String> al = new ArrayList<>();
				al.add(userName);
				al.add(password);
				list.add(al);
			}
			sc.close();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return list;
	}
	public void writeFile(String userName,String password) {
		try {
			FileWriter fw = new FileWriter("users",true);
			fw.write("\n"+userName+" "+password);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	public void writeFileAdmin(String userName,String password) {
		try {
			FileWriter fw = new FileWriter("admins",true);
			fw.write("\n"+userName+" "+password);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	public Data() {
		// TODO Auto-generated constructor stub
		info = new LinkedList<>();
	}
	public Data(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
		info = new LinkedList<>();
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String toString() {
		return UserName + " " + Password + "\n";
	}
	public List<ArrayList<String>> getInfo() {
		return info;
	}
	public void setInfo(List<ArrayList<String>> info) {
		this.info = info;
	}

}
