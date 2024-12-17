import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Verify_Code extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
    private String mobile;

    // then create setters and getter
    public void setMobile(String user)
    {
    	this.mobile = mobile;
	}
    public String getMobile()
    {
    	return this.mobile;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verify_Code frame = new Verify_Code();
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
	public Verify_Code() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			Forgot_Password f = new Forgot_Password();
			f.setVisible(true);
			dispose();
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("");
		message.setBounds(321, 151, 46, 14);
		contentPane.add(message);
		
		JButton Submit_Button = new JButton("Submit");
		Submit_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String npass = textField.getText();
				String cpass = textField_1.getText();
				if(npass.equals("")|| cpass.equals(""))
				{
					JOptionPane.showMessageDialog(message, "Enter the password");
				}
				else if(npass.equals(cpass))
				{

					System.out.println("Closing");
					
					User_Login u1 = new User_Login();
					u1.setVisible(true);
					dispose();
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(message, "Check Your Password It Is Not Same");
				}
			}
		});
		Submit_Button.setBackground(new Color(127, 255, 0));
		Submit_Button.setFont(new Font("Tahoma", Font.BOLD, 18));
		Submit_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			

				
			}
		});
		Submit_Button.setBounds(302, 277, 103, 31);
		contentPane.add(Submit_Button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\xander.jpg"));
		lblNewLabel.setBounds(40, 77, 294, 162);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reset Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(274, 22, 168, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(371, 96, 103, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(371, 194, 116, 25);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(532, 96, 116, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(532, 194, 116, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}

}
