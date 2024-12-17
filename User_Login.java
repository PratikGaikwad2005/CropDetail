import java.awt.Cursor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
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
	public User_Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Home_Page H = new Home_Page();
				H.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		message = new JLabel("");
		message.setForeground(new Color(255, 0, 0));
		message.setBounds(322, 166, 76, 24);
		contentPane.add(message);
		
		JButton Login_Button = new JButton("Login");
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String url = "jdbc:mysql://localhost:3306/project_xander";
				String user = "root";
				String pass = "root";
				
				try 
				{
					Connection connection = DriverManager.getConnection(url, user, pass);
					System.out.println("Connection Successfull");
					Statement statement = connection.createStatement();
					System.out.println("statement");
					String query = "SELECT User_Name , Password FROM user_registration WHERE User_Name = '"+textField.getText()+"' AND Password = '"+textField_1.getText()+"'";
					
					ResultSet rs =  statement.executeQuery(query);
					
					if(rs.next()) {
						String user_name = rs.getString(1);
						String password = rs.getString(2);
						System.out.println(user_name+" "+password);
						
						Xander_Button b1 =new Xander_Button();
						b1.setVisible(true);
						dispose();

					}
					else if(textField.getText().equals("")||textField_1.getText().equals(""))
					{
						 JOptionPane.showMessageDialog(message, " Field is empty...");

					}
					else {
						
						 JOptionPane.showMessageDialog(message, " Username and Password doesn't exit...");

						
						
					}
					connection.close();
					
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		Login_Button.setForeground(new Color(0, 0, 0));
		Login_Button.setFont(new Font("Tahoma", Font.BOLD, 18));
		Login_Button.setBackground(new Color(64, 224, 208));
		Login_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Login_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Login_Button.setBounds(249, 308, 89, 39);
		contentPane.add(Login_Button);
		
		JLabel Forgot_Password = new JLabel("Forgot Password?");
		Forgot_Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Forgot_Password.setForeground(new Color(0, 0, 255));
		Forgot_Password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Forgot_Password f1 = new Forgot_Password();
				f1.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Forgot_Password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Forgot_Password.setBounds(550, 219, 125, 31);
		contentPane.add(Forgot_Password);
		
		JButton Registration_Button = new JButton("Registration");
		Registration_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User_Registration u1 = new User_Registration();
				u1.setVisible(true);
				dispose();
			}
		});
		Registration_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Registration_Button.setForeground(new Color(0, 0, 0));
		Registration_Button.setBackground(new Color(127, 255, 0));
		Registration_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		Registration_Button.setBounds(384, 309, 125, 39);
		contentPane.add(Registration_Button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel.setBounds(27, 77, 285, 173);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(315, 24, 89, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(360, 77, 86, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(360, 160, 86, 30);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(487, 77, 145, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(487, 160, 145, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}
