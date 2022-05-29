package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AdminManager;
import Controller.JDBC;
import Model.Admin;
import Model.Car;
import Model.Motorbike;
import Model.Truck;
import Model.User;
import Model.Vehical;
import data.Data;

import javax.swing.ListSelectionModel;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import javax.swing.table.TableModel;

public class Manager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel p1,p2,p3;
	private JTable jtb,jtbProduct;
	private JDBC jdbc;
	private List<User> listuser;
	private JTextField tfuserName;
	private JTextField tfPassword;
	private JTextField tfPhone;
	private JTextField tfSex;
	private JTextField tfBirthday;
	private JTextField tfAddress;
	private Button btnCreate,btnDelete,btnReset,btnSearch
					,btnCreateAdmin,btnSearchAdmin,btnAReset,btnCreateProduct,btnDeleteProduct;
	private AdminManager adminManager;
	private DefaultTableModel model,Amodel;
	private int row =-1 ;
	private List<User> rootList;
	private List<Admin> rootListAdmin;
	private Boolean checkRemove = false,checkRemoveProduct = false;
	private JTextField tfAdminName;
	private JTextField tfAdminPassword;
	private JTextField tfAPhone;
	private JTextField tfASex;
	private JTextField tfABirthday;
	private JTextField tfAAddress;
	private List<Admin> listAdmin;
	private JScrollPane spAdmin;
	private JTable tbAdmin;
	private Button btnLogout;
	private Login li;
	private JComboBox jbTypes;
	private JComboBox jbDate;
	private JComboBox jbColor;
	private JComboBox jbCompany;
	private JButton btnRest;
	private Label lbType;
	private Label lbyear;
	private Label lbColor;
	private Label lbColor_1;
	private JScrollPane scrollPane;
	private DefaultTableModel dtmCar;
	private List<Vehical> listVehicals;
	private Label lbType_1;
	private Label lbType_2;
	private Label lbType_3;
	private Label lbType_4;
	private JTextField tfNos;
	private JTextField tfEt;
	private JTextField tfWg;
	private JTextField tfTg;
	private JTextField tfPrice;
	private int count;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manager() {
		
		jdbc = new JDBC();
		rootList = new LinkedList<>();
		rootList = jdbc.getList();
		
		listAdmin = new LinkedList<>();
		rootListAdmin = jdbc.getListAdmin();
		listAdmin = rootListAdmin;
		adminManager = new AdminManager();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		p1=new JPanel();  
		insertTableUser();
		
		 
		
		JTabbedPane tp=new JTabbedPane(); 
		tp.add("Users",p1);
		p1.setLayout(null);
		
		Label lbphone = new Label("Phone");
		lbphone.setBounds(55, 167, 96, 30);
		p1.add(lbphone);
		
		Label lbuserName = new Label("UserName");
		lbuserName.setBounds(55, 66, 96, 30);
		p1.add(lbuserName);
		
		Label lbuserPassword = new Label("Password");
		lbuserPassword.setBounds(55, 112, 96, 30);
		p1.add(lbuserPassword);
		
		Label lbsex = new Label("Sex");
		lbsex.setBounds(55, 219, 50, 30);
		p1.add(lbsex);
		
		Label lbbirthday = new Label("Birthday");
		lbbirthday.setBounds(55, 268, 96, 30);
		p1.add(lbbirthday);
		
		Label lbaddress = new Label("Address");
		lbaddress.setBounds(55, 323, 96, 30);
		p1.add(lbaddress);
		
		tfuserName = new JTextField();
		tfuserName.setBounds(158, 66, 150, 30);
		p1.add(tfuserName);
		tfuserName.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(157, 112, 150, 30);
		p1.add(tfPassword);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(157, 167, 150, 30);
		p1.add(tfPhone);
		
		tfSex = new JTextField();
		tfSex.setColumns(10);
		tfSex.setBounds(158, 219, 96, 30);
		p1.add(tfSex);
		
		tfBirthday = new JTextField();
		tfBirthday.setColumns(10);
		tfBirthday.setBounds(157, 268, 150, 30);
		p1.add(tfBirthday);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(157, 323, 150, 30);
		p1.add(tfAddress);
		
		btnCreate = new Button("Create");
		btnCreate.setBackground(Color.CYAN);
		btnCreate.setBounds(39, 420, 66, 21);
		btnCreate.addActionListener(this);
		p1.add(btnCreate);
		
		btnDelete = new Button("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(174, 420, 66, 21);
		btnDelete.addActionListener(this);
		p1.add(btnDelete);
		
		btnReset = new Button("Reset");
		btnReset.setBackground(Color.CYAN);
		btnReset.setBounds(298, 420, 66, 21);
		btnReset.addActionListener(this);
		p1.add(btnReset);
		
		btnSearch = new Button("Search");
		btnSearch.setActionCommand("");
		btnSearch.setBackground(Color.CYAN);
		btnSearch.setBounds(328, 29, 66, 21);
		btnSearch.addActionListener(this);
		p1.add(btnSearch);
		
		btnLogout = new Button("Log out");
		btnLogout.setBackground(Color.CYAN);
		btnLogout.setBounds(874, 645, 66, 21);
		btnLogout.addActionListener(this);
		p1.add(btnLogout);
		
	
		p2=new JPanel(); 
		insertTableAdmin(rootListAdmin);
		tp.add("Admin",p2);
		p2.setLayout(null);
		
		Label lbuserName_1 = new Label("UserName");
		lbuserName_1.setBounds(38, 84, 96, 30);
		p2.add(lbuserName_1);
		
		tfAdminName = new JTextField();
		tfAdminName.setColumns(10);
		tfAdminName.setBounds(141, 84, 150, 30);
		p2.add(tfAdminName);
		
		Label lbAdminPassword = new Label("Password");
		lbAdminPassword.setBounds(38, 130, 96, 30);
		p2.add(lbAdminPassword);
		
		tfAdminPassword = new JTextField();
		tfAdminPassword.setColumns(10);
		tfAdminPassword.setBounds(140, 130, 150, 30);
		p2.add(tfAdminPassword);
		
		tfAPhone = new JTextField();
		tfAPhone.setColumns(10);
		tfAPhone.setBounds(140, 185, 150, 30);
		p2.add(tfAPhone);
		
		Label lbphone_1 = new Label("Phone");
		lbphone_1.setBounds(38, 185, 96, 30);
		p2.add(lbphone_1);
		
		Label lbsex_1 = new Label("Sex");
		lbsex_1.setBounds(38, 237, 50, 30);
		p2.add(lbsex_1);
		
		tfASex = new JTextField();
		tfASex.setColumns(10);
		tfASex.setBounds(141, 237, 96, 30);
		p2.add(tfASex);
		
		Label lbbirthday_1 = new Label("Birthday");
		lbbirthday_1.setBounds(38, 286, 96, 30);
		p2.add(lbbirthday_1);
		
		tfABirthday = new JTextField();
		tfABirthday.setColumns(10);
		tfABirthday.setBounds(140, 286, 150, 30);
		p2.add(tfABirthday);
		
		tfAAddress = new JTextField();
		tfAAddress.setColumns(10);
		tfAAddress.setBounds(140, 341, 150, 30);
		p2.add(tfAAddress);
		
		Label lbaddress_1 = new Label("Address");
		lbaddress_1.setBounds(38, 341, 96, 30);
		p2.add(lbaddress_1);
		
		btnSearchAdmin = new Button("Search");
		btnSearchAdmin.setBackground(Color.CYAN);
		btnSearchAdmin.setBounds(311, 47, 66, 21);
		btnSearchAdmin.addActionListener(this);
		p2.add(btnSearchAdmin);

		
		btnCreateAdmin = new Button("Create");
		btnCreateAdmin.setBackground(Color.CYAN);
		btnCreateAdmin.setBounds(141, 413, 66, 21);
		btnCreateAdmin.addActionListener(this);
		p2.add(btnCreateAdmin);
		
		btnAReset = new Button("Reset");
		btnAReset.setBackground(Color.CYAN);
		btnAReset.setBounds(225, 413, 66, 21);
		btnAReset.addActionListener(this);
		p2.add(btnAReset);
		
		spAdmin = new JScrollPane((Component) null);
		spAdmin.setBounds(435, 35, 505, 560);
		
		tbAdmin = new JTable((TableModel) null);
		tbAdmin.setBounds(435, 35, 505, 560);
		spAdmin.setViewportView(tbAdmin);
		tp.setBounds(50,50,200,200); 
		
		p3=new JPanel(); 
		tp.add("Product",p3);
		p3.setLayout(null);
		
		jdbc = new JDBC();
		listVehicals = new LinkedList<>();
		jbTypes = new JComboBox(new Object[]{});
		jbTypes.setModel(new DefaultComboBoxModel(new String[] {"Car", "Motorbike", "Truck"}));
		jbTypes.setBounds(105, 56, 101, 25);
		jbTypes.addActionListener(this);
		p3.add(jbTypes);
		
		jbDate = new JComboBox(new Object[]{});
		jbDate.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		jbDate.setBounds(250, 56, 129, 25);
		jbDate.addActionListener(this);
		p3.add(jbDate);
		
		jbColor = new JComboBox(new Object[]{});
		jbColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "White", "Red", "Yellow", "Blue", "Green", "Grey"}));
		jbColor.setBounds(416, 56, 110, 25);
		jbColor.addActionListener(this);
		p3.add(jbColor);
		
		jbCompany = new JComboBox(new Object[]{});
		jbCompany.setModel(new DefaultComboBoxModel(new String[] {"Honda", "Audi", "Lexus"}));
		jbCompany.setBounds(582, 56, 110, 25);
		jbCompany.addActionListener(this);
		p3.add(jbCompany);
		
		btnRest = new JButton("Reset");
		btnRest.setBounds(754, 56, 80, 25);
		btnRest.addActionListener(this);
		p3.add(btnRest);
		
		lbType = new Label("Types");
		lbType.setBounds(103, 29, 59, 21);
		p3.add(lbType);
		
		lbyear = new Label("YearOfManufacture");
		lbyear.setBounds(250, 29, 129, 21);
		p3.add(lbyear);
		
		lbColor = new Label("Color");
		lbColor.setBounds(416, 29, 59, 21);
		p3.add(lbColor);
		
		lbColor_1 = new Label("Company");
		lbColor_1.setBounds(582, 29, 59, 21);
		p3.add(lbColor_1);
		listVehicals = getListCars();
		initTableProduct();
		initDatatoTable(listVehicals);
		
		setContentPane(contentPane);
		getContentPane().add(tp);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnCreate) {
			String userName = tfuserName.getText();
			String password = tfPassword.getText();
			String phone = tfPhone.getText();
			String sex = tfSex.getText();
			String birthday = tfBirthday.getText();
			String address = tfAddress.getText();
			
			if(userName.equals("")||password.equals("")||phone.equals("") 
					||sex.equals("") ||birthday.equals("") ||address.equals("")) {
				JOptionPane.showMessageDialog(null, "Don't let information empty");
			}
			else {
				if(checkUser(userName)) {
					JOptionPane.showMessageDialog(null, "The account is really exist");
				}
				else {
					User user = new User(userName, password, phone, birthday, sex, address);
					addUser(user);
				}
			}
			
		}
		else if (e.getSource() == btnDelete) {
			if(checkRemove) {
				removeUser(row);
			}
		}
		else if(e.getSource() == btnReset) {
			reset();
		}
		else if(e.getSource() == btnSearch) {
			if(tfuserName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "UserName can't be empty");
			}
			else {
				searchUser(tfuserName.getText());
			}
		}
		else if(e.getSource() == btnCreateAdmin) {
			String userName = tfAdminName.getText();
			String password = tfAdminPassword.getText();
			String phone = tfAPhone.getText();
			String sex = tfASex.getText();
			String birthday = tfABirthday.getText();
			String address = tfAAddress.getText();
			
			if(userName.equals("")||password.equals("")||phone.equals("") 
					||sex.equals("") ||birthday.equals("") ||address.equals("")) {
				JOptionPane.showMessageDialog(null, "Don't let information empty");
			}
			else {
				if(checkAdmin(userName)) {
					JOptionPane.showMessageDialog(null, "The account is really exist");
				}
				else {
					Admin admin = new Admin(userName, password, phone, birthday, sex, address);
					addAdmin(admin);
				}
			}
			
		}
		else if(e.getSource() == btnSearchAdmin){
			if(tfAdminName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "UserName can't be empty");
			}
			else {
				searchAdmin(tfAdminName.getText());
			}
		}
		else if (e.getSource() == btnAReset) {
			resetTableAdmin();
		}
		else if(e.getSource() == btnLogout) {
			int result = JOptionPane.showConfirmDialog(contentPane, 
					"Do you really want log out?"
					,"Confirm"
					,JOptionPane.YES_OPTION
					,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				this.dispose();
				li = new Login();
				li.setVisible(true);
			}
			else {
			}
		}
		else if(e.getSource() == jbTypes) {
			
			setTypes();
		}
		else if(e.getSource() == jbDate){
			setDate();
					
		}
		else if(e.getSource() == jbColor) {
			setColor();
		}
		else if(e.getSource() == jbCompany) {
			setCompany();
		}
		else if(e.getSource() == btnRest) {
			resetProduct();
		}
		else if(e.getSource() == btnCreateProduct) {
			System.out.println(jbTypes.getSelectedItem().toString());
			createProduct(jbTypes.getSelectedItem().toString());
		}
		else if(e.getSource() == btnDeleteProduct) {
			String type = jbTypes.getSelectedItem().toString();
			String company = jbCompany.getSelectedItem().toString();
			String date = jbDate.getSelectedItem().toString();
			String color = jbColor.getSelectedItem().toString();
			if(type.equals("Car")) {
				
				if(!tfPrice.getText().equals("") && !tfNos.getText().equals("")) {
					int numberOfSeats = Integer.parseInt(tfNos.getText());
					String engineType = tfEt.getText();
					double price = Double.parseDouble(tfPrice.getText());
	
					Car car = new Car(company, date, price, color, numberOfSeats, engineType);
					if(checkRemoveProduct) {
						deleteProduct(car, type);
						dtmCar.removeRow(row);
					}
				}
			}
			else if(type.equals("Motorbike")) {
				if(!tfWg.getText().equals("")) {
					String wattage = tfWg.getText();
					double price = Double.parseDouble(tfPrice.getText());
	
					Motorbike mb = new Motorbike(company, date, price, color, wattage);
					if(checkRemoveProduct) {
						deleteProduct(mb, type);
						dtmCar.removeRow(row);
					}
				}
			}
			else {
				if(!tfTg.getText().equals("")) {
					double price = Double.parseDouble(tfPrice.getText());
					int tonnage = Integer.parseInt(tfTg.getText());
					Truck truck = new Truck(company, date, price, color, tonnage);
					if(checkRemoveProduct) {
						deleteProduct(truck, type);
						dtmCar.removeRow(row);
					}
				}
			}
		}
		
		
	}
	private void insertTableAdmin(List<Admin> listAdmin) {
		
		Amodel = new DefaultTableModel();
		tbAdmin = new JTable(Amodel);
		System.out.println(rootListAdmin.size());
		
		tbAdmin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      row = target.getSelectedRow();
			      getInfoAdmin(row,listAdmin);
			     // do some stuff
			    }
			  }
		});
		
//		jtb.setBounds(30, 40, 911, 300);
		
		String[] columnNames = { "UserName","Phone", "Sex", "Birthday","Address" };
		Amodel.setColumnIdentifiers(columnNames);
		for(int i = 0; i < listAdmin.size();i++) {
			String userName = listAdmin.get(i).getUserName();
			String phone = listAdmin.get(i).getPhone();
			String sex = listAdmin.get(i).getSex();
			String birthday = listAdmin.get(i).getBirthday();
			String address = listAdmin.get(i).getAddress();
			
			Amodel.addRow(new Object[] {
					userName,phone,sex,birthday,address
			});
		}
		spAdmin = new JScrollPane(tbAdmin);
		spAdmin.setBounds(435, 50, 505, 530);
		p2.add(spAdmin);
	}
	private void insertTableUser() {
		model = new DefaultTableModel();
		jtb = new JTable(model);
		jtb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      row = target.getSelectedRow();
			      getInfoUser(row);
			      checkRemove = true;
			     // do some stuff
			    }
			  }
		});
		
		listuser = rootList;
//		jtb.setBounds(30, 40, 911, 300);
		String[] columnNames = { "UserName","Phone", "Sex", "Birthday","Address" };
		model.setColumnIdentifiers(columnNames);
		for(int i = 0; i < listuser.size();i++) {
			String userName = listuser.get(i).getUserName();
			String phone = listuser.get(i).getPhone();
			String sex = listuser.get(i).getSex();
			String birthday = listuser.get(i).getBirthday();
			String address = listuser.get(i).getAddress();
			
			model.addRow(new Object[] {
					userName,phone,sex,birthday,address
			});
		}
		JScrollPane sp = new JScrollPane(jtb);
		sp.setBounds(435, 49, 505, 533);
		p1.add(sp);
	}
	private void resetTable() {
		for(int i = 0; i < listuser.size();i++) {
			String userName = listuser.get(i).getUserName();
			String phone = listuser.get(i).getPhone();
			String sex = listuser.get(i).getSex();
			String birthday = listuser.get(i).getBirthday();
			String address = listuser.get(i).getAddress();
			model.addRow(new Object[] {
					userName,phone,sex,birthday,address
			});
		}
	}
	private Boolean checkUser(String userName) {
		for(User u : listuser) {
			if(userName.equals(u.getUserName())){
				return true;
			}
		}
		return false;
	}
	private Boolean checkAdmin(String AdminName) {
		for(Admin u : listAdmin) {
			if(AdminName.equals(u.getUserName())){
				return true;
			}
		}
		return false;
	}
	private void addUser(User user) {
		String userName = user.getUserName();
		String phone = user.getPhone();
		String sex = user.getSex();
		String birthday = user.getBirthday();
		String address = user.getAddress();
		adminManager.addUser(user);
		Data data = new Data();
		data.writeFile(userName, user.getPassWord());
		listuser.add(user);
		model.addRow(new Object[] {
					userName,phone,sex,birthday,address});
		JOptionPane.showMessageDialog(null, "add user sucessfully");
	}
	private void addAdmin(Admin admin) {
		String userName = admin.getUserName();
		String phone = admin.getPhone();
		String sex = admin.getSex();
		String birthday = admin.getBirthday();
		String address = admin.getAddress();
		jdbc.insertAdmin(admin);
		Data data = new Data();
		data.writeFileAdmin(userName, admin.getPassWord());
		listAdmin.add(admin);
		Amodel.addRow(new Object[] {
					userName,phone,sex,birthday,address});
		JOptionPane.showMessageDialog(null, "add user sucessfully");
	}
	private void getInfoUser(int row) {
		String userName = listuser.get(row).getUserName();
		String phone = listuser.get(row).getPhone();
		String sex = listuser.get(row).getSex();
		String birthday = listuser.get(row).getBirthday();
		String address = listuser.get(row).getAddress();
		
		tfuserName.setText(userName);
		tfPhone.setText(phone);
		tfSex.setText(sex);
		tfBirthday.setText(birthday);
		tfAddress.setText(address);
	}
	private void getInfoAdmin(int row,List<Admin> list) {
		String userName = list.get(row).getUserName();
		String phone = list.get(row).getPhone();
		String sex = list.get(row).getSex();
		String birthday = list.get(row).getBirthday();
		String address = list.get(row).getAddress();
		
		tfAdminName.setText(userName);
		tfAPhone.setText(phone);
		tfASex.setText(sex);
		tfABirthday.setText(birthday);
		tfAAddress.setText(address);
	}
	
	private void removeUser(int row) {
		System.out.println(row);
		if(row > -1 && row < listuser.size()) {
			adminManager.removeUser(listuser.get(row));
			listuser.remove(row);
			model.removeRow(row);
			checkRemove = false;
			JOptionPane.showMessageDialog(null, "Delete user is success");
		}
	}
	private void reset() {
		tfuserName.setText("");
		tfPhone.setText("");
		tfPassword.setText("");
		tfSex.setText("");
		tfBirthday.setText("");
		tfAddress.setText("");
		if(listuser.size() != rootList.size()) {
			int rowCount = model.getRowCount();
			//Remove rows one by one from the end of the table
			for (int i = rowCount - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			for(int i= 0; i<listuser.size();i++) {
				listuser.remove(i);
			}
			listuser = rootList;
			System.out.println(rootList.size());
			resetTable();
		}
		
	}
	private void searchUser(String userName) {
		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		List<User> temp = new LinkedList<>();
		
		for(int i = 0; i < listuser.size();i++) {
			if(userName.equals(listuser.get(i).getUserName())) {
				String phone = listuser.get(i).getPhone();
				String sex = listuser.get(i).getSex();
				String birthday = listuser.get(i).getBirthday();
				String address = listuser.get(i).getAddress();
				temp.add(listuser.get(i));
				model.addRow(new Object[] {
					userName,phone,sex,birthday,address});
			}
		}
		listuser = temp;
	}
	private void searchAdmin(String adminName) {
		int rowCount = Amodel.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			Amodel.removeRow(i);
		}
		List<Admin> temp = new LinkedList<>();
		
		for(int i = 0; i < listAdmin.size();i++) {
			if(adminName.equals(listAdmin.get(i).getUserName())) {
				String phone = listAdmin.get(i).getPhone();
				String sex = listAdmin.get(i).getSex();
				String birthday = listAdmin.get(i).getBirthday();
				String address = listAdmin.get(i).getAddress();
				temp.add(listAdmin.get(i));
				Amodel.addRow(new Object[] {
						adminName,phone,sex,birthday,address});
			}
		}
		insertTableAdmin(temp);
	}
	private void resetTableAdmin() {
		tfAdminName.setText("");
		tfAdminPassword.setText("");
		tfAPhone.setText("");
		tfASex.setText("");
		tfABirthday.setText("");
		tfAAddress.setText("");
		insertTableAdmin(rootListAdmin);
	}
	
	private List<Vehical> getListCars(){
		List<Vehical> list = new LinkedList<>();
		list = jdbc.getListProductType("car");
		
		return list;
		
	}
	private List<Vehical> getListMotorbikes(){
		List<Vehical> list = new LinkedList<>();
		list = jdbc.getListProductType("motorbike");
		
		System.out.println(list.get(0).getDate());
		return list;
		
	}
	private List<Vehical> getListTruck(){
		List<Vehical> list = new LinkedList<>();
		list = jdbc.getListProductType("truck");
		
		System.out.println(list.get(0).getDate());
		return list;
		
	}
	private List<Vehical> getListToDate(List<Vehical> list, String Date){
		List<Vehical> temp = new LinkedList<>();
		for(Vehical v : list) {
			if(v.getDate().equals(Date)) {
				temp.add(v);
			}
		}
		return temp;
	}
	private List<Vehical> getListToColor(List<Vehical> list, String color){
		List<Vehical> temp = new LinkedList<>();
		for(Vehical v : list) {
			if(v.getColor().equals(color)) {
				temp.add(v);
			}
		}
		return temp;
	}
	private List<Vehical> getListToCompany(List<Vehical> list, String company){
		List<Vehical> temp = new LinkedList<>();
		for(Vehical v : list) {
			if(v.getCompany().equals(company)) {
				temp.add(v);
			}
		}
		return temp;
	}
	private void initTableProduct() {
		dtmCar = new DefaultTableModel();
		jtbProduct = new JTable(dtmCar);
		jtbProduct.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      
			      String type = jbTypes.getSelectedItem().toString();
			      if(type.equals("Car")) {
			    	  row = target.getSelectedRow();
			    	  getInforProduct(type, row, getListCars());
			    	  checkRemoveProduct = true;
			      }
			      else if(type.equals("Motorbike")) {
			    	  row = target.getSelectedRow();
			    	  getInforProduct(type, row, getListMotorbikes());
			    	  checkRemoveProduct = true;
			      }
			      else {
			    	  row = target.getSelectedRow();
			    	  getInforProduct(type, row, getListTruck());
			    	  checkRemoveProduct = true;
			      }
			     // do some stuff
			    }
			  }
		});
		
		String[] columnNames = { "Company","yearOfManufacture", "Price","Color"};
		dtmCar.setColumnIdentifiers(columnNames);
		scrollPane = new JScrollPane(jtbProduct);
		scrollPane.setBounds(34, 180, 920, 473);
		p3.add(scrollPane);
		
		lbType_1 = new Label("NumberOfSeats");
		lbType_1.setBounds(105, 98, 101, 21);
		p3.add(lbType_1);
		
		lbType_2 = new Label("EngineType");
		lbType_2.setBounds(105, 137, 101, 21);
		p3.add(lbType_2);
		
		lbType_3 = new Label("Wattage");
		lbType_3.setBounds(370, 98, 59, 21);
		p3.add(lbType_3);
		
		lbType_4 = new Label("Tonnage");
		lbType_4.setBounds(370, 137, 59, 21);
		p3.add(lbType_4);
		
		tfNos = new JTextField();
		tfNos.setBounds(218, 100, 96, 19);
		p3.add(tfNos);
		tfNos.setColumns(10);
		
		tfEt = new JTextField();
		tfEt.setColumns(10);
		tfEt.setBounds(218, 137, 96, 19);
		p3.add(tfEt);
		
		tfWg = new JTextField();
		tfWg.setColumns(10);
		tfWg.setBounds(438, 100, 96, 19);
		p3.add(tfWg);
		
		tfTg = new JTextField();
		tfTg.setColumns(10);
		tfTg.setBounds(438, 137, 96, 19);
		p3.add(tfTg);
		
		btnCreateProduct = new Button("Create");
		
		btnCreateProduct.setBounds(754, 98, 80, 25);
		btnCreateProduct.addActionListener(this);
		p3.add(btnCreateProduct);
		
		btnDeleteProduct = new Button("Delete");
		btnDeleteProduct.setBackground(Color.RED);
		btnDeleteProduct.setBounds(754, 137, 80, 25);
		btnDeleteProduct.addActionListener(this);
		p3.add(btnDeleteProduct);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(652, 100, 96, 19);
		p3.add(tfPrice);
		
		Label lbPrice = new Label("Price");
		lbPrice.setBounds(584, 98, 59, 21);
		p3.add(lbPrice);
	}
	private void initDatatoTable(List<Vehical> list) {
		
			
			for(int i = 0; i < list.size();i++) {
				Vehical vh = list.get(i);
				if(vh != null && vh instanceof Car) {
					if(dtmCar.getColumnCount() != 6) {
						dtmCar.addColumn("NumberOfSeats");
						dtmCar.addColumn("EngineType");
					}
					
					Car cars = (Car) list.get(i);
					String company = cars.getCompany();
					String date = cars.getDate();
					double price = cars.getPrice();
					String color = cars.getColor();
					int numberOfSeats = cars.getNumberOfSeats();
					String engineType = cars.getEngineType();
					dtmCar.addRow(new Object[] {
							company,date,price,color,numberOfSeats,engineType
					});
				}
				else if(vh != null && vh instanceof Motorbike) {
					Motorbike mb = (Motorbike) list.get(i);
					if(dtmCar.getColumnCount() != 5) {
						dtmCar.addColumn("Wattage");
					}
					String company = mb.getCompany();
					String date = mb.getDate();
					double price = mb.getPrice();
					String color = mb.getColor();
					String wattage = mb.getWattage();
					dtmCar.addRow(new Object[] {
							company,date,price,color,wattage
					});
				}
				else {
					if(dtmCar.getColumnCount() != 5) {
						dtmCar.addColumn("Tonnage");
					}
					Truck truck = (Truck) list.get(i);
					String company = truck.getCompany();
					String date = truck.getDate();
					double price = truck.getPrice();
					String color = truck.getColor();
					int tonnage = truck.getTonnage();
					dtmCar.addRow(new Object[] {
							company,date,price,color,tonnage
					});
				}
			}
			
	}
	private void setTypes() {
		String type = jbTypes.getSelectedItem().toString();
		List<Vehical> list = new LinkedList<>();
		int rowCount = dtmCar.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtmCar.removeRow(i);
		}
		if(type.equals("Car")) {
			dtmCar.setColumnCount(4);
			dtmCar.fireTableDataChanged();
			list = getListCars();
			initDatatoTable(list);
			
		}else if(type.equals("Motorbike")) {
			dtmCar.setColumnCount(4);
			dtmCar.fireTableDataChanged();
			list = getListMotorbikes();
			initDatatoTable(list);
		}else {
			dtmCar.setColumnCount(4);
			dtmCar.fireTableDataChanged();
			list = getListTruck();
			initDatatoTable(list);
		}
	}
	private void setDate() {
		int rowCount = dtmCar.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtmCar.removeRow(i);
		}
		String type = jbTypes.getSelectedItem().toString();
		List<Vehical> list = new LinkedList<>();
		if(type.equals("Car")) {
			
			list = getListToDate(getListCars(), jbDate.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else if(type.equals("Motorbike")) {
			list = getListToDate(getListMotorbikes(), jbDate.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else {
			list = getListToDate(getListTruck(), jbDate.getSelectedItem().toString());
			initDatatoTable(list);
		}
	}
	private void setColor() {
		int rowCount = dtmCar.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtmCar.removeRow(i);
		}
		String type = jbTypes.getSelectedItem().toString();
		List<Vehical> list = new LinkedList<>();
		if(type.equals("Car")) {
			
			list = getListToColor(getListCars(), jbColor.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else if(type.equals("Motorbike")) {
			list = getListToColor(getListMotorbikes(), jbColor.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else {
			list = getListToColor(getListTruck(), jbColor.getSelectedItem().toString());
			initDatatoTable(list);
		}
	}
	private void setCompany() {
		int rowCount = dtmCar.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtmCar.removeRow(i);
		}
		String type = jbTypes.getSelectedItem().toString();
		List<Vehical> list = new LinkedList<>();
		if(type.equals("Car")) {
			
			list = getListToCompany(getListCars(), jbCompany.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else if(type.equals("Motorbike")) {
			list = getListToCompany(getListMotorbikes(), jbCompany.getSelectedItem().toString());
			initDatatoTable(list);
		}
		else {
			list = getListToCompany(getListTruck(), jbCompany.getSelectedItem().toString());
			initDatatoTable(list);
		}
	}
	private void resetProduct() {
		int rowCount = dtmCar.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtmCar.removeRow(i);
		}
		jbTypes.setSelectedIndex(0);
		jbCompany.setSelectedIndex(0);
		jbColor.setSelectedIndex(0);
		jbDate.setSelectedIndex(0);
		List<Vehical> list = new LinkedList<>();
		list = getListCars();
		System.out.println(rowCount);
		initDatatoTable(list);
		dtmCar.removeRow(0);
	}
	
	private void createProduct(String type) {
		String company = jbCompany.getSelectedItem().toString();
		String date = jbDate.getSelectedItem().toString();
		String color = jbColor.getSelectedItem().toString();
		if(type.equals("Car")) {
						if(tfNos.getText().equals("") || tfEt.getText().equals("") || tfPrice.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "numberOfSeats,engineType or Price are not empty");
			}else {
				int numberOfSeats = Integer.parseInt(tfNos.getText());
				String engineType = tfEt.getText();
				double price = Double.parseDouble(tfPrice.getText());

				Car car = new Car(company, date, price, color, numberOfSeats, engineType);
				jdbc.insertProduct(car, "car", getListCars().size()+1);
				dtmCar.addRow(new Object[] {
						company, date, price, color, numberOfSeats, engineType
				});
				dtmCar.fireTableDataChanged();
			}
		}else if(type.equals("Motorbike")) {
			if(tfWg.getText().equals("")|| tfPrice.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Wattage or Price is not empty");
			}
			else {
				double price = Double.parseDouble(tfPrice.getText());
				String wattage = tfWg.getText();
				Motorbike motorbike = new Motorbike(company, date, price, color, wattage);
				jdbc.insertProduct(motorbike, "motorbike", getListMotorbikes().size()+1);
				dtmCar.addRow(new Object[] {
						company, date, price, color, wattage
				});
				dtmCar.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "Add product is success");
			}
		}
		else {
			if(tfTg.getText().equals("")|| tfPrice.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Tonnage or Price is not empty");
			}
			else {
				double price = Double.parseDouble(tfPrice.getText());
				int tonnage = Integer.parseInt(tfTg.getText());
				Truck truck = new Truck(company, date, price, color, tonnage);
				jdbc.insertProduct(truck, "truck", getListTruck().size()+1);
				dtmCar.addRow(new Object[] {
						company, date, price, color, tonnage
				});
				dtmCar.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "Add product is success");
			}
		}
	}
	private void getInforProduct(String type,int row, List<Vehical> list) {
		String company = list.get(row).getCompany();
		String date = list.get(row).getDate();
		String color = list.get(row).getColor();
		double price = list.get(row).getPrice();
//		jbCompany.setSelectedItem(company);
//		jbDate.setSelectedItem(date);
//		jbColor.setSelectedItem(color);
		tfPrice.setText(String.valueOf(price));
		if(type.equals("Car")) {
			Car car = (Car) list.get(row);
			tfWg.setText("");
			tfTg.setText("");
			String engineType = car.getEngineType();
			int numberOfSeats = car.getNumberOfSeats();
			tfEt.setText(engineType);
			tfNos.setText(String.valueOf(numberOfSeats));
		}
		else if(type.equals("Motorbike")) {
			Motorbike mb = (Motorbike) list.get(row);
			tfEt.setText("");
			tfNos.setText("");
			tfTg.setText("");
			String wattage = mb.getWattage();
			tfWg.setText(wattage);
		}
		else {
			Truck truck = (Truck) list.get(row);
			tfEt.setText("");
			tfNos.setText("");
			tfWg.setText("");
			int tonnage = truck.getTonnage();
			tfTg.setText(String.valueOf(tonnage));
		}
		
	}
	private void deleteProduct(Vehical vehical,String type) {
		
			jdbc.deleteProduct(vehical, type);
			JOptionPane.showMessageDialog(null, "Delete product is success");
			checkRemoveProduct = false;
		
	}
}
