import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Forgot_Password extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	public JTextField textField;
//	private final Action action = new SwingAction();

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_Password frame = new Forgot_Password();
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
	public Forgot_Password() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				User_Login U = new User_Login();
				U.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(423, 106, 130, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 215, 130, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel message = new JLabel("");
		message.setBounds(319, 166, 156, 19);
		contentPane.add(message);
		
		
		
		JButton OTP_Button = new JButton("Get OTP");
		OTP_Button.addMouseListener(new MouseAdapter() {
			
					});
		OTP_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String url = "jdbc:mysql://localhost:3306/project_xander";
				String user = "root";
				String pass = "root";
				
				String Number = textField.getText();
				if(Number.equals(""))
				{
					JOptionPane.showMessageDialog(message, "Please Enter Phone Number ...");
				}
				else
				{
					try 
					{
						Connection connection = DriverManager.getConnection(url, user, pass);
						System.out.println("Connection Successfull");
						Statement statement = connection.createStatement();
						System.out.println("statement");
						
						String query = "SELECT Mobile_no FROM user_registration WHERE Mobile_no = '"+Number+"'";
						
						ResultSet rs =  statement.executeQuery(query);
						
						if(rs.next()) {
							String mobile_no= rs.getString(1);
							System.out.println(mobile_no);
							Random rn = new Random();
							int otp = rn.nextInt(999999);
							String sotp = Integer.toString(otp);
							message.setText("OTP : "+sotp);
						}
						else 
						{
							JOptionPane.showMessageDialog(message, "Phone Number is not exits...");
						}
						connection.close();
						System.out.println("Closing...");
						
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				}
				
				
			}
		});
//		OTP_Button.setAction(action);
		OTP_Button.setBackground(new Color(240, 240, 240));
		OTP_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		OTP_Button.setBounds(580, 106, 114, 33);
		contentPane.add(OTP_Button);
		
		JButton Verify_Button = new JButton("Verify");
		Verify_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String Otp = textField_1.getText();
				String verify = message.getText();

				if(Otp.equals(""))
				{
					JOptionPane.showMessageDialog(message, "Please Enter OTP...");
				}
				else if(Otp.equals(verify))
				{
					JOptionPane.showMessageDialog(message, "Please OTP is invalid...");
				}
				else 
				{
					Verify_Code v1 = new Verify_Code();
					dispose();
				}
			}
		});
		Verify_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		Verify_Button.setBounds(580, 215, 114, 33);
		contentPane.add(Verify_Button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel.setBounds(22, 87, 282, 197);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Verifying The Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(229, 11, 215, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(314, 106, 104, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("OTP");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(314, 217, 87, 25);
		contentPane.add(lblNewLabel_3);
		


		

	}
}
