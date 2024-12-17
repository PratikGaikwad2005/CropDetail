import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Land_Details extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Land_Details frame = new Land_Details();
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
	public Land_Details() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Admin_Button a = new Admin_Button();
				a.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 394);
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
					String query = "SELECT * FROM land_registration";
					
					ResultSet rs =  statement.executeQuery(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					int cols= rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++) 
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String vil,tal,sur,sub,ten,nao,kha,lof;
					while(rs.next())
					{
						vil=rs.getString(1);
						tal=rs.getString(2);
						sur=rs.getString(3);
						sub=rs.getString(4);
						ten=rs.getString(5);
						nao=rs.getString(5);
						kha=rs.getString(5);
						lof=rs.getString(5);
						String[] row = {vil,tal,sur,sub,ten,nao,kha,lof};
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
		display.setBounds(112, 284, 117, 34);
		contentPane.add(display);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());

			}
		});
		clear.setBounds(342, 284, 117, 34);
		contentPane.add(clear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 24, 530, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
