import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Crop_Details extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crop_Details frame = new Crop_Details();
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
	public Crop_Details() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Admin_Button a = new Admin_Button();
				a.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 531);
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
					String query = "SELECT * FROM crop_registration";
					
					ResultSet rs =  statement.executeQuery(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					int cols= rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++) 
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String id,noc,toc,tos,loc,riv,lak,pum,bor,tem,tps,hum,tof,wea,rai,dat,tas;
					while(rs.next())
					{
						id=rs.getString(1);
						noc=rs.getString(2);
						toc=rs.getString(3);
						tos=rs.getString(4);
						loc=rs.getString(5);
						riv=rs.getString(6);
						lak=rs.getString(7);
						pum=rs.getString(8);
						bor=rs.getString(9);
						tem=rs.getString(10);
						tps=rs.getString(11);
						hum=rs.getString(12);
						tof=rs.getString(13);
						wea=rs.getString(14);
						rai=rs.getString(15);
						dat=rs.getString(16);
						tas=rs.getString(17);
						
						String[] row = {id,noc,toc,tos,loc,riv,lak,pum,bor,tem,tps,hum,tof,wea,rai,dat,tas};
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
		display.setBounds(158, 318, 119, 33);
		contentPane.add(display);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());

			}
		});
		clear.setBounds(391, 318, 119, 33);
		contentPane.add(clear);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(22, 30, 1302, 254);
		contentPane.add(scrollPane_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_3.setViewportView(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
