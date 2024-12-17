import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
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
	public Admin_Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Home_Page h = new Home_Page();
				h.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_Registration a3 = new Admin_Registration();
				a3.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(379, 358, 105, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(269, 24, 159, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel_1.setBounds(21, 94, 281, 205);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(356, 116, 89, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(356, 216, 89, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel error_message = new JLabel("");
		error_message.setForeground(new Color(255, 0, 0));
		error_message.setBounds(249, 305, 251, 22);
		contentPane.add(error_message);
		
		textField = new JTextField();
		textField.setBounds(478, 113, 129, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JLabel message = new JLabel("");
		message.setBounds(312, 189, 46, 14);
		contentPane.add(message);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:mysql://localhost:3306/project_xander";
				String user = "root";
				String pass = "root";
				
				String Admin_Name1 = textField.getText();
				String Password1 = passwordField.getText();
				if(Admin_Name1.equals(""))
				{
					JOptionPane.showMessageDialog(message, "Please Enter Admin Name...");
				}
				else if(Password1.equals(""))
				{
					JOptionPane.showMessageDialog(message, "Please Enter Password...");
				}
				else
				{
					try 
					{
						Connection connection = DriverManager.getConnection(url, user, pass);
						System.out.println("Connection Successfull");
						Statement statement = connection.createStatement();
						System.out.println("statement");
						String query = "SELECT User_name , Password FROM admin_registration WHERE User_Name = '"+textField.getText()+"' AND Password = '"+passwordField.getText()+"'";
						
						ResultSet rs =  statement.executeQuery(query);
						
						if(rs.next()) {
							String user_name = rs.getString(1);
							String password = rs.getString(2);
							System.out.println(user_name+" "+password);
							
							Admin_Button b1 =new Admin_Button();
							b1.setVisible(true);
							dispose();
	
						}
						else {
							
							error_message.setText("UserName or Password doesn't match");
							System.out.println("Admin Name or Password doesn't match");
							
							
						}
						connection.close();
						
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setBounds(247, 357, 92, 34);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(478, 216, 129, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Forgot Password ?");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_forgot f3 = new Admin_forgot();
				f3.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewLabel_4.setBackground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(520, 280, 129, 33);
		contentPane.add(lblNewLabel_4);
		
		

	}
}
