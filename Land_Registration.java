import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Land_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Land_Registration frame = new Land_Registration();
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
	public Land_Registration() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Xander_Button x = new Xander_Button();
				x.setVisible(true);
				dispose();
			}
		});
		setTitle("form 1");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 561);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Land Registration");
		lblNewLabel.setBounds(266, 11, 186, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(588, 67, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(588, 112, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(588, 162, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(588, 259, 129, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(588, 306, 129, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Village ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(403, 70, 98, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Taluka ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(403, 115, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Survey no.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(403, 165, 98, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tenure");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(403, 262, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Name of Occupant");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(403, 309, 126, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel_6.setBounds(43, 134, 296, 222);
		contentPane.add(lblNewLabel_6);
		
		JLabel message = new JLabel("");
		message.setBounds(349, 213, 46, 14);
		contentPane.add(message);
		
		
		JButton btnNewButton_1 = new JButton("Register");

		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(128, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url ="jdbc:mysql://localhost:3306/project_xander";
				String user ="root";
				String pass="root";
				
				String Village = textField.getText();
				String Taluka = textField_1.getText();
				String Survey_no = textField_2.getText();
				String Sub_division = textField_3.getText();
				String Tenure = textField_4.getText();
				String Name_of_occupant = textField_4.getText();
				String khata = textField_5.getText();
				String Local_field = textField_6.getText();
				
				try 
				{
					if(Village.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Vilage Name...");
					}
					else if(Taluka.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Taluka Name...");
					}
					else if(Survey_no.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Survey Number...");
					}
					else if(Sub_division.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Sub Division...");
					}
					else if(Tenure.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Tenure...");
					}
					else if(Name_of_occupant.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Name of occupant...");
					}
					else if(khata.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Khata...");
					}
					else if(Local_field.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Local field...");
					}
					else
					{
						Connection connection = DriverManager.getConnection(url,user,pass);
						
						String insert="insert into Land_registration values('"+Village+"','"+Taluka+"','"+Survey_no+"','"+Sub_division+"','"+Tenure+"','"+Name_of_occupant+"','"+khata+"','"+Local_field+"')"; 
						
						Statement stat = connection.createStatement();
						
						stat.executeUpdate(insert);
						
						System.out.println("data is sucessfull inserted");
						
						stat.close();
						
						connection.close();
						
						Xander_Button x4 = new Xander_Button();
						x4.setVisible(true);
						dispose();
					}
					

				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1.setBounds(309, 458, 119, 31);
		contentPane.add(btnNewButton_1);
		

		JLabel lblNewLabel_7 = new JLabel("Sub Division");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(403, 216, 98, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(588, 213, 129, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(588, 353, 129, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(588, 401, 129, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Khata");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(403, 356, 126, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Local field");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(403, 403, 126, 14);
		contentPane.add(lblNewLabel_9);
		

	}
}
