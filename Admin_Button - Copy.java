import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Admin_Button extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Button frame = new Admin_Button();
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
	public Admin_Button() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Admin_Login  f = new Admin_Login();
				f.setVisible(true);
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton User_Reg_Button = new JButton("User Registration");
		User_Reg_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Details ud = new User_Details();
				ud.setVisible(true);
				dispose();
			}
		});
		User_Reg_Button.setBounds(101, 125, 150, 34);
		contentPane.add(User_Reg_Button);
		
		JButton Crop_Reg_Button = new JButton("Crop Registration");
		Crop_Reg_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crop_Details cd = new Crop_Details();
				cd.setVisible(true);
				dispose();
			}
		});
		Crop_Reg_Button.setBounds(317, 125, 150, 34);
		contentPane.add(Crop_Reg_Button);
		
		JButton Land_Reg_Button = new JButton("Land Registration");
		Land_Reg_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Land_Details ld = new Land_Details();
				ld.setVisible(true);
				dispose();
			}
		});
		Land_Reg_Button.setBounds(214, 221, 150, 34);
		contentPane.add(Land_Reg_Button);
	}

}
