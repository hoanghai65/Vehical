package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.AdminManager;
import Controller.JDBC;
import Controller.UserExperience;
import Model.Admin;
import Model.User;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	private JTextField tfUserName;
	private JPasswordField tfPassword;
	private JButton btnLogin,btnRegister;
	private JLabel label;
	private Register rg;
	private MainWindow mw;
	private Manager mg;
	private Container c;
	private JDBC jdbc;
	
	private UserExperience ue;
	private AdminManager am;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		jdbc = new JDBC();
		
		setLayout();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnRegister) {
			this.dispose();
			rg = new Register();
		}
		else if(e.getSource() == btnLogin) {
			String userName = tfUserName.getText();
			String password = tfPassword.getText();
			if(userName.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "The account is not incorrect");
			}else {
				ue = new UserExperience(userName, password);
				am = new AdminManager( userName, password);
				if(am.Login(userName, password)) {
					this.dispose();
					mg = new Manager();
					mg.setVisible(true);
				}else if(ue.Login(userName, password)) {
					this.dispose();
					mw = new MainWindow();
					mw.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "The account is not incorrect");
				}
			}
		}
	}
	


	private void setLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);
        
        tfUserName = new JTextField();
        tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tfUserName.setBounds(481, 170, 281, 68);
        contentPane.add(tfUserName);
        
        tfUserName.setColumns(10);
        tfPassword = new JPasswordField();
        tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tfPassword.setBounds(481, 286, 281, 68);
        contentPane.add(tfPassword);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);
        
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnLogin.setBounds(495, 395, 116, 52);
        btnLogin.addActionListener(this);
        contentPane.add(btnLogin);
        
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        
        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnRegister.setBounds(646, 395, 133, 52);
        btnRegister.addActionListener(this);
        contentPane.add(btnRegister);
        
        setLocationRelativeTo(null);
	}
}
