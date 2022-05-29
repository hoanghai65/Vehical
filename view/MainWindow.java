package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.JDBC;
import Model.Car;
import Model.Motorbike;
import Model.Truck;
import Model.Vehical;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import java.awt.Label;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Frame frame;
	private JMenu menu;
	private JPanel panel;
	private JMenuItem home,logout;
	private Login li;
	private JTable jtb;
	private DefaultTableModel dtmCar;
	private JScrollPane scrollPane;
	private int row;
	private List<Vehical> listVehicals;
	private List<Car> listCar;
	private JDBC jdbc;
	private JComboBox jbTypes,jbCompany,jbDate,jbColor;
	private JButton btnRest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		jdbc = new JDBC();
		listVehicals = new LinkedList<>();
		listCar = new LinkedList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));


		contentPane = (JPanel) getContentPane();
		getContentPane().setLayout(null);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 111, 24);
		JMenu Menu = new JMenu("Menu");
		
		
		home = new JMenuItem("Home");
		logout = new JMenuItem("Logout");
		home.addActionListener(this);
		logout.addActionListener(this);
		
		Menu.add(home);
		Menu.add(logout);
		mb.add(Menu);
		
		contentPane.add(mb);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 713);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		jbTypes = new JComboBox(new Object[]{});
		jbTypes.setBounds(171, 55, 101, 25);
		jbTypes.setModel(new DefaultComboBoxModel(new String[] {"Car", "Motorbike", "Truck"}));
		jbTypes.addActionListener(this);
		panel.add(jbTypes);
		
		jbDate = new JComboBox(new Object[]{});
		jbDate.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		jbDate.setBounds(316, 55, 129, 25);
		jbDate.addActionListener(this);
		panel.add(jbDate);
		
		jbColor = new JComboBox(new Object[]{});
		jbColor.setBounds(482, 55, 110, 25);
		jbColor.addActionListener(this);
		jbColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "White", "Red", "Yellow", "Blue", "Green", "Grey"}));
		panel.add(jbColor);
		
		jbCompany = new JComboBox(new Object[]{});
		jbCompany.setBounds(648, 55, 110, 25);
		jbCompany.addActionListener(this);
		jbCompany.setModel(new DefaultComboBoxModel(new String[] {"Honda", "Audi", "Lexus"}));
		panel.add(jbCompany);
		
		btnRest = new JButton("Reset");
		btnRest.setBounds(820, 55, 80, 25);
		btnRest.addActionListener(this);
		panel.add(btnRest);
		listVehicals = getListCars();
		initTable();
		initDatatoTable(listVehicals);
		
		Label lbType = new Label("Types");
		lbType.setBounds(169, 28, 59, 21);
		panel.add(lbType);
		
		Label lbyear = new Label("YearOfManufacture");
		lbyear.setBounds(316, 28, 129, 21);
		panel.add(lbyear);
		
		Label lbColor = new Label("Color");
		lbColor.setBounds(482, 28, 59, 21);
		panel.add(lbColor);
		
		Label lbColor_1 = new Label("Company");
		lbColor_1.setBounds(648, 28, 59, 21);
		panel.add(lbColor_1);
		
		setLocationRelativeTo(null);
	}
	
	private List<Vehical> getListCars(){
		List<Vehical> list = new LinkedList<>();
		list = jdbc.getListProductType("car");
		
		System.out.println(list.get(0).getDate());
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
	private void initTable() {
		dtmCar = new DefaultTableModel();
		jtb = new JTable(dtmCar);
		jtb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      row = target.getSelectedRow();
			     // do some stuff
			    }
			  }
		});
		
		String[] columnNames = { "Company","yearOfManufacture", "Price","Color"};
		dtmCar.setColumnIdentifiers(columnNames);
		scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(22, 103, 920, 504);
		panel.add(scrollPane);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == home) {
			panel.setVisible(true);
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
			reset();
		}
		else if(e.getSource() == logout){
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
	private void reset() {
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
		dtmCar.setColumnCount(4);
		dtmCar.fireTableDataChanged();
		list = getListCars();
		initDatatoTable(list);
	}
}
