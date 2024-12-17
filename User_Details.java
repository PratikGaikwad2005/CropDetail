import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.ResultSetMetaData;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class User_Details extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton clear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Details frame = new User_Details();
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
	public User_Details()
	{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Admin_Button a = new Admin_Button();
				a.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
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
					String query = "SELECT * FROM user_registration";
					
					ResultSet rs =  statement.executeQuery(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					int cols= rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++) 
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String username,mob,pmt,mail,password;
					while(rs.next())
					{
						username=rs.getString(1);
						mob=rs.getString(2);
						pmt=rs.getString(3);
						mail=rs.getString(4);
						password=rs.getString(5);
						String[] row = {username,mob,pmt,mail,password};
						model.addRow(row);
						System.out.println("Fetching...");
					}
					statement.close();
					connection.close();
					System.out.println("Closing...");
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		display.setBounds(151, 313, 89, 23);
		contentPane.add(display);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 24, 575, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			table.setModel(new DefaultTableModel());
			}
		});
		clear.setBounds(340, 313, 89, 23);
		contentPane.add(clear);
		
	}
}