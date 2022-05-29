package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.JDBC;
import Controller.UserExperience;
import Model.User;
import data.Data;

import javax.swing.DefaultComboBoxModel;

public class Register extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tfName;
    private JLabel mno;
    private JTextField tfPassword;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel lbBrithday;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tfAddress;
    private JButton btnSub;
    private JButton btnReset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private UserExperience ue;
    private JDBC jdbc;
    private List<ArrayList<String>> accout;
    private List<User> listuser;
    private Data data;
    private Login li;
    
	/**
	 * Launch the application.
	 */
    
    private String dates[]
            = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
        
        private JTextField tfCfPassword;
        private JLabel lbPhone;
        private JTextField tfPhone;
        private JButton btnLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		jdbc = new JDBC();
		ue = new UserExperience();
		listuser = new LinkedList<>();
		accout = new LinkedList<>();
		listuser = jdbc.getList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
        contentPane.setLayout(null);
 
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
        
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);
 
        tfName = new JTextField();
        tfName.setSize(190, 20);
        tfName.setLocation(200, 100);
        c.add(tfName);
        
        mno = new JLabel("Password");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);
 
        tfPassword = new JTextField();
        tfPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tfPassword.setSize(150, 20);
        tfPassword.setLocation(200, 150);
        c.add(tfPassword);
        
        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 290);
        c.add(gender);
 
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 290);
        c.add(male);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 290);
        c.add(female);
 
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
 
        lbBrithday = new JLabel("Birthday");
        lbBrithday.setFont(new Font("Arial", Font.PLAIN, 20));
        lbBrithday.setSize(100, 20);
        lbBrithday.setLocation(100, 340);
        c.add(lbBrithday);
        
        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 340);
        c.add(date);
 
        month = new JComboBox();
        month.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 340);
        c.add(month);
 
        year = new JComboBox();
        year.setModel(new DefaultComboBoxModel(new String[] {"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(65, 20);
        year.setLocation(320, 340);
        c.add(year);
        
        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 390);
        c.add(add);
 
        tfAddress = new JTextArea();
        tfAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        tfAddress.setSize(200, 75);
        tfAddress.setLocation(200, 390);
        tfAddress.setLineWrap(true);
        c.add(tfAddress);
 
        btnSub = new JButton("Submit");
        btnSub.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSub.setSize(100, 20);
        btnSub.setLocation(141, 505);
        btnSub.addActionListener(this);
        c.add(btnSub);
 
        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
        btnReset.setSize(100, 20);
        btnReset.setLocation(280, 505);
        btnReset.addActionListener(this);
        c.add(btnReset);
        
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(499, 86);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);
 
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);
        
        JLabel cfPassword = new JLabel("Confirm Password");
        cfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        cfPassword.setBounds(24, 197, 176, 20);
        contentPane.add(cfPassword);
        
        tfCfPassword = new JTextField();
        tfCfPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tfCfPassword.setBounds(200, 197, 150, 20);
        contentPane.add(tfCfPassword);
        
        lbPhone = new JLabel("Phone");
        lbPhone.setFont(new Font("Arial", Font.PLAIN, 20));
        lbPhone.setBounds(100, 244, 100, 20);
        contentPane.add(lbPhone);
        
        tfPhone = new JTextField();
        tfPhone.setFont(new Font("Arial", Font.PLAIN, 15));
        tfPhone.setBounds(200, 244, 150, 20);
        contentPane.add(tfPhone);
        
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        btnLogin.setBounds(763, 506, 100, 20);
        btnLogin.addActionListener(this);
        contentPane.add(btnLogin);
        
        setVisible(true);
        setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnSub) {
			String userName = tfName.getText();
			String password = tfPassword.getText();
			String phone = tfPhone.getText();
			String sex = "";
			if(male.isSelected()) {
				sex = "male";
			}else {
				sex = "female";
			}
				
			
			
			String d = date.getSelectedItem().toString();
			String m = month.getSelectedItem().toString();
			String y = year.getSelectedItem().toString();
			String birthday = d+"/"+m+"/"+y;
			String address = tfAddress.getText();
//			
			if(userName.equals("")||password.equals("")||phone.equals("") 
					||sex.equals("") ||birthday.equals("") ||address.equals("")) {
				JOptionPane.showMessageDialog(null, "Don't let information empty");
			}
			else {
				if(checkUser(userName)) {
					JOptionPane.showMessageDialog(null, "The account is really exist");
				}
				else {
					if(tfCfPassword.getText().equals(password)) {
						User user = new User(userName, password, phone, birthday, sex, address);
						userRegister(user);
					}else {
						JOptionPane.showMessageDialog(null, "Confirm password is not inconrrect");
					}
				}
			}
		}
		else if(e.getSource() == btnReset) {
			reset();
		}
		else if(e.getSource() == btnLogin) {
			this.dispose();
			li = new Login();
			li.setVisible(true);
		}
		
	}
	private void reset() {
		tfName.setText("");
		tfPassword.setText("");
		tfCfPassword.setText("");
		tfAddress.setText("");
		tfPhone.setText("");
		male.setSelected(true);
		female.setSelected(false);
		date.setSelectedIndex(0);
		month.setSelectedIndex(0);
		year.setSelectedIndex(0);
		tout.setText("");
	}

	private Boolean checkUser(String userName) {
		for(User u : listuser) {
			if(userName.equals(u.getUserName())){
				return true;
			}
		}
		return false;
	}
	private void userRegister(User user) {
		ue.Register(user);
		data = new Data();
		data.writeFile(user.getUserName(), user.getPassWord());
		JOptionPane.showMessageDialog(null, "Register is success");
		writeNotice(user);
		
	}

	private void writeNotice(User user) {
		// TODO Auto-generated method stub
		String notice = user.toString();
		tout.setText(notice);
	}
}
