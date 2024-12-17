import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Crop_registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crop_registration frame = new Crop_registration();
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
	public Crop_registration() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Xander_Button x = new Xander_Button();
				x.setVisible(true);
				dispose();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\pratikeclipse-workspace\\Xander\\xanderimg.jpg"));
		setTitle("Crop Registration");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crop Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(324, 11, 194, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(81, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name of Crop");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(81, 139, 95, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type of Crop");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(81, 198, 95, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type of Soil");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(81, 253, 80, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("River");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(79, 360, 117, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Location");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(81, 312, 80, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Temperature");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(472, 88, 80, 20);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Temperature of Soil");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(472, 139, 131, 20);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Humidity");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(477, 198, 80, 20);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Type of Fungus");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(472, 253, 107, 20);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Weather");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(472, 312, 80, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Rain");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(472, 363, 46, 15);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Date");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(472, 416, 46, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Task");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(472, 465, 46, 14);
		contentPane.add(lblNewLabel_17);
		
		textField = new JTextField();
		textField.setBounds(273, 90, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 141, 125, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(273, 200, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(273, 255, 125, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(273, 311, 125, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(654, 90, 125, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(654, 141, 125, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(654, 200, 125, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(654, 255, 125, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(654, 311, 125, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(654, 362, 125, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(654, 410, 125, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(654, 464, 125, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		
		JLabel message = new JLabel("");
		message.setBounds(415, 233, 46, 14);
		contentPane.add(message);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Xander_Button x4 = new Xander_Button();
				x4.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = "jdbc:mysql://localhost:3306/project_xander";
				String user ="root";
				String pass ="root";
				 
				String id=textField.getText();
	             String Name_of_crop =textField_1 .getText();
	             String Type_of_crop=textField_2.getText();
	             String Type_of_soil=textField_3.getText();
	             String  Location=textField_4.getText();
	             
	             
	             String Temperature=textField_5.getText();
	             String Temperature_of_soil=textField_6.getText();
	             String Humidity=textField_7.getText();
	             String Type_of_fungus=textField_8.getText();
	             String Weather=textField_9.getText();
	             String Rain=textField_10.getText();
	             String Date=textField_11.getText();
	             String Task=textField_12.getText();
	             
	             String River=textField_13.getText();
	             String Lake=textField_14.getText();
	             String Pump=textField_15.getText();
	             String Bore=textField_16.getText();
				
				
				try {
					
					if(id.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Id...");
					}
					else if(Name_of_crop.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Name of crop...");
					}
					else if(Type_of_crop.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Type of crop...");
					}
					else if(Type_of_soil.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Type of soil...");
					}
					else if(Location.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Location...");
					}
					else if(Temperature.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Temperature...");
					}
					else if(Temperature_of_soil.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Temperature of soil...");
					}
					else if(Humidity.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Humidity...");
					}
					else if(Type_of_fungus.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Type of fungus...");
					}
					else if(Weather.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Weather...");
					}
					else if(Rain.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Rain...");
					}
					else if(Date.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Date...");
					}
					else if(Task.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Task...");
					}
					else if(River.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter River...");
					}
					else if(Lake.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Lake...");
					}
					else if(Pump.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Pump...");
					}
					else if(Bore.equals(""))
					{
						JOptionPane.showMessageDialog(message, "Please Enter Bore...");
					}
					else
					{
						Connection connection = DriverManager.getConnection(url,user,pass);
						
						String insert ="insert into crop_registration values('"+id+"','"+Name_of_crop+"','"+Type_of_crop+"','"+Type_of_soil+"','"+Location+"','"+River+"','"+Lake+"','"+Pump+"','"+Bore+"','"+Temperature+"','"+Temperature_of_soil+"','"+Humidity+"','"+Type_of_fungus+"','"+Weather+"','"+Rain+"','"+Date+"','"+Task+"') ";
						
						Statement stat = connection.createStatement();
						
						stat.executeUpdate(insert);
						System.out.println("data is safe inserted");
						
						stat.close();
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(366, 593, 95, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Lake");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(81, 413, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Bore");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(81, 467, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Pump");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(81, 521, 46, 19);
		contentPane.add(lblNewLabel_8);
		
		textField_13 = new JTextField();
		textField_13.setBounds(273, 362, 125, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(273, 410, 125, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(273, 464, 125, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(273, 520, 125, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		
	}
}
