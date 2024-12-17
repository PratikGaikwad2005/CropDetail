import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class User_Registration extends JFrame {
   
	String url ="jdbc:mysql://localhost:3306/project_xander";
	String user="root";
	String pass="root";
	
   
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    
   
	ImageIcon im=new ImageIcon("xanderimg.jpg");
	private JPasswordField passwordField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Registration frame = new User_Registration();
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
	public User_Registration() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				User_Login U = new User_Login();
				U.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("");
		message.setBounds(300, 176, 46, 14);
		contentPane.add(message);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
			
				User_Login u3 =new User_Login();
				u3.setVisible(true);
				dispose();
			}
	
		 
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String User_name  = textField.getText();
				String Mobile_no  = textField_1.getText();
				String PMT_no     = textField_2.getText();
				String Email      = textField_3.getText();
				String Password   = passwordField.getText();
				 
				try {
					
					if(User_name.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter User Name...");
					}
					else if(Mobile_no.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Mobile Number...");
					}
					else if(PMT_no.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter PMT Number...");
					}
					else if(Email.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Email Address...");
					}
					else if(Password.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Password...");
					}
					else 
					{
						Connection connection = DriverManager.getConnection(url,user,pass);
						System.out.println("connection sucessfull");
						
						String insert ="insert into user_registration values('"+User_name+"','"+Mobile_no+"','"+PMT_no+"','"+Email+"','"+Password+"')";
							
						Statement stat = connection.createStatement();
						int row = stat.executeUpdate(insert);
						
						System.out.println("No. of Rows Affected : "+row);
						stat.close();
						connection.close();
						System.out.println("Closing");
						
					}
					
				
				}
				catch(Exception e1) {
				System.out.println(e1);	
				}
				
				
			}
		});
		btnNewButton.setBounds(284, 340, 112, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 22, 153, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(481, 86, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(481, 139, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(481, 191, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(481, 241, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(353, 83, 76, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile No. ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(353, 136, 76, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PMT No. ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(353, 190, 76, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(353, 238, 64, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel imageLb = new JLabel("");
		imageLb.setBounds(10, 83, 319, 224);
		contentPane.add(imageLb);
		
		imageLb.setIcon(new ImageIcon("F:\\xander.jpg"));
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(353, 293, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(481, 287, 126, 20);
		contentPane.add(passwordField);
		
	
	}
}
