package mailsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class signupMail extends loginMail {

	private JFrame frame;
	private JTextField nameField;
	private JTextField mailField_1;
	private JPasswordField passwordField;
	static signupMail window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new signupMail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signupMail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 static void insert(String name,String email, String password) throws Exception {
	        String query = "insert into signup values('" + name + "','" + email + "','"+password+"')";
	        Statement statement= management();
	        statement.executeUpdate(query);
	    }
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setText("          name :");
		txtpnName.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		txtpnName.setBounds(44, 46, 131, 32);
		frame.getContentPane().add(txtpnName);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("      Email :");
		txtpnEmail.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		txtpnEmail.setBounds(44, 108, 131, 32);
		frame.getContentPane().add(txtpnEmail);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		txtpnPassword.setText("PASSWORD :");
		txtpnPassword.setBounds(44, 172, 131, 32);
		frame.getContentPane().add(txtpnPassword);
		
		JButton btnNewButton_1 = new JButton("signup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=nameField.getText();
					String mail = mailField_1.getText();
					String password = passwordField.getText();
					JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");
					insert(name,mail,password);
					}
					catch(Exception exd) {
						
					}
			}
		});
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		btnNewButton_1.setBackground(new Color(255, 204, 102));
		btnNewButton_1.setBounds(376, 271, 120, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					window.frame.setVisible(false);
					new loginMail().main(null);
				} 
				catch (Exception e1) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setBounds(148, 271, 114, 45);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 172, 417, 32);
		frame.getContentPane().add(passwordField);
		
		mailField_1 = new JTextField();
		mailField_1.setBounds(173, 108, 417, 32);
		frame.getContentPane().add(mailField_1);
		mailField_1.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(173, 46, 417, 32);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\MAIL SCAPING\\yellow.jpeg"));
		lblNewLabel.setBounds(0, 0, 633, 374);
		frame.getContentPane().add(lblNewLabel);
	}

}
