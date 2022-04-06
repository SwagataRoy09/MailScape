package mailsystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class loginMail{
	 public static java.sql.Statement management() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailscaping", "root", "root");
	        java.sql.Statement st = con.createStatement();
	        return st;
	    }


	private JFrame frame;
	private static JTextField EMAIL;
	private static JPasswordField passwordField;
    static loginMail window;
	static String m1;
	static String p1;
	/**
	 * Launch the application.
	 * @return 
	 */
	public static ArrayList<String> mail() {
		ArrayList<String> list = new ArrayList<>();
			list.add(EMAIL.getText());
			list.add(passwordField.getText());
			return list;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 window = new loginMail();
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
	public loginMail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setBackground(Color.ORANGE);
		txtpnPassword.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		txtpnPassword.setText("PASSWORD");
		txtpnPassword.setBounds(42, 218, 87, 34);
		frame.getContentPane().add(txtpnPassword);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBackground(Color.ORANGE);
		txtpnEmail.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		txtpnEmail.setText("EMAIL");
		txtpnEmail.setBounds(55, 129, 51, 25);
		frame.getContentPane().add(txtpnEmail);
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setForeground(Color.DARK_GRAY);
		txtpnLogin.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		txtpnLogin.setBackground(Color.ORANGE);
		txtpnLogin.setText("LOGIN");
		txtpnLogin.setBounds(262, 33, 74, 44);
		frame.getContentPane().add(txtpnLogin);
		
		JButton LOGOUT = new JButton("LOGOUT");
		LOGOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		LOGOUT.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		LOGOUT.setBackground(Color.ORANGE);
		LOGOUT.setBounds(234, 368, 133, 44);
		frame.getContentPane().add(LOGOUT);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					window.frame.setVisible(false);
					new signupMail().main(null);
				} 
				catch (Exception e1) {
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(355, 301, 153, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 204, 102));
		passwordField.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		passwordField.setToolTipText("PASSWORD");
		passwordField.setBounds(134, 207, 435, 59);
		frame.getContentPane().add(passwordField);
		
		EMAIL = new JTextField();
		EMAIL.setBackground(new Color(255, 204, 102));
		EMAIL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		EMAIL.setToolTipText("EMAIL ID\r\n");
		EMAIL.setBounds(108, 108, 461, 59);
		frame.getContentPane().add(EMAIL);
		EMAIL.setColumns(10);
		
		JButton LOGIN = new JButton("LOGIN");
		LOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = 	EMAIL.getText().toLowerCase();
				m1=mail;
				String password = passwordField.getText();
				p1=password;
				try {
					 String query = "select * from signup order by email";
					 ResultSet rs = management().executeQuery(query);

		    while (rs.next()) {
				String[] arr = new String[2];
				arr[0]=mail;
				arr[1]=password;
			      if (rs.getString(2).contains(mail) && rs.getString(3).contains(password)){
					  window.frame.setVisible(false);
				      new sendMail().main(arr);
				      return;
			  }
		}
        JOptionPane.showMessageDialog(null, "INVALID USER NAME OR PASSWORD");
					new signupMail().main(null);
				}
				catch(Exception ex) {
					
				}
			}
		});
		LOGIN.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		LOGIN.setBackground(Color.ORANGE);
		LOGIN.setBounds(102, 301, 153, 44);
		frame.getContentPane().add(LOGIN);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\MAIL SCAPING\\yellow.jpeg"));
		lblNewLabel.setBounds(0, 0, 609, 435);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 130, 45, 13);
		frame.getContentPane().add(label);
	}
}
