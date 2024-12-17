import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Admin_Registration extends JFrame {

	private JPanel contentPane;
	public JTextField text_Field;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Registration frame = new Admin_Registration();
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
	public Admin_Registration() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Admin_Login  f = new Admin_Login();
				f.setVisible(true);
				dispose();
			}
		});
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(250, 26, 189, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel_1.setBounds(34, 90, 289, 194);
		contentPane.add(lblNewLabel_1);
		
		text_Field = new JTextField();
		text_Field.setBounds(498, 94, 133, 23);
		contentPane.add(text_Field);
		text_Field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(371, 93, 95, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(371, 155, 95, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(371, 216, 86, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(371, 269, 86, 20);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(498, 155, 133, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(498, 216, 133, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel message = new JLabel("");
		message.setBounds(313, 197, 46, 14);
		contentPane.add(message);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				String Admin_Name = text_Field.getText() ;
				String Mobile_no = textField_1.getText() ;
				String Email = textField_2.getText();
				String Password =	passwordField.getText();
				  if(Admin_Name.equals("")) 
				  {
					  JOptionPane.showMessageDialog(message, "Please Enter Admin Name...");
				  }
				  else if(Mobile_no.equals(""))
				  {
					  JOptionPane.showMessageDialog(message, " Please Enter Mobile Number...");
				  }
				  else if(Email.equals("")) {
					  JOptionPane.showMessageDialog(message, "Please Enter Email...");
					  
				  }
				  else if(Password.equals(""))
				  {
					  JOptionPane.showMessageDialog(message, "Please Enter Password...");
				  }
				
				  else 
				  {
					String url ="jdbc:mysql://localhost:3306/project_xander";
					String user="root";
					String pass="root";
						
					try 
					{
						
						Connection connection = DriverManager.getConnection(url,user,pass);
						System.out.println("connection sucessfull");
						
						String insert ="insert into admin_registration values('"+Admin_Name+"','"+Mobile_no+"','"+Email+"','"+Password+"')";
							
						Statement stat = connection.createStatement();
						int row = stat.executeUpdate(insert);
						
						System.out.println("Number of Rows Affected : "+row);
						
						stat.close();
						connection.close();
						
						System.out.println("Closing..");
					}
					catch(Exception e1) {
					System.out.println(e1);	
					}
				    Admin_Login a2 =new Admin_Login();
				    a2.setVisible(true);
				    dispose();
				  }
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(286, 354, 117, 31);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(498, 271, 133, 20);
		contentPane.add(passwordField);
		
	
	}
}
