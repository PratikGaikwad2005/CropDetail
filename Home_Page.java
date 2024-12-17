import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Home_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page frame = new Home_Page();
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
	public Home_Page() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				//Home_Page h1 = new Home_Page();
				//h1.setVisible(true);
				//dispose();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User_Login u4 = new User_Login();
				u4.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnNewButton.setBounds(21, 166, 104, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Admin_Login ad=new Admin_Login();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(472, 166, 104, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel.setBounds(170, 71, 272, 229);
		contentPane.add(lblNewLabel);
	}
}
