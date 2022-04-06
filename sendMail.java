package mailsystem;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;

public class sendMail extends loginMail {

	private JFrame frame;
	private JTextField tofield;
	private JTextField sub;
	static private JTextField mssg;
	private JTextPane txtpnTo;
	private JTextPane txtpnSubject;
	static private String from,password;

	/**
	 * Launch the application.
	 */
	private static boolean send(String message, String subject, String to, String from, String password) {
		Properties p = new Properties();
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "465");
		p.setProperty("mail.smtp.ssl.enable", "true");
		p.setProperty("mail.smtp.auth", "true");


		Session s = Session.getDefaultInstance(p, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from.trim(), password);
			}
		});
		s.setDebug(true);
		Message m = new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			Transport.send(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		from=args[0];
		password=args[1];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sendMail window = new sendMail();
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
	public sendMail() throws Exception{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 612, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtpnSubject = new JTextPane();
		txtpnSubject.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		txtpnSubject.setText("SUBJECT :");
		txtpnSubject.setBounds(46, 78, 85, 39);
		frame.getContentPane().add(txtpnSubject);
		
		txtpnTo = new JTextPane();
		txtpnTo.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		txtpnTo.setText("   TO :");
		txtpnTo.setBounds(46, 17, 85, 39);
		frame.getContentPane().add(txtpnTo);
		
		mssg = new JTextField();
		mssg.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		mssg.setText("");
		mssg.setBounds(20, 140, 556, 184);
		frame.getContentPane().add(mssg);
		mssg.setColumns(10);
		
		sub = new JTextField();
		sub.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		sub.setToolTipText("SUBJECT");
		sub.setBounds(141, 78, 424, 39);
		frame.getContentPane().add(sub);
		sub.setColumns(10);
		
		tofield = new JTextField();
		tofield.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		tofield.setToolTipText("TO");
		tofield.setBounds(141, 17, 424, 39);
		frame.getContentPane().add(tofield);
		tofield.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 204, 102));
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		btnNewButton_1.setBounds(345, 344, 134, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String from1=from;
			       String password1=password;
			       String to = tofield.getText();
			       String subject=sub.getText();
			       String message=mssg.getText();
			       if(send(message,subject,to,from1,password1)) {
			    	   JOptionPane.showMessageDialog(null, "SUCCESSFULLY SENT");
			       }
			       else {
			    	   JOptionPane.showMessageDialog(null, "INVALID");
			       }
			}
		});
		btnNewButton.setBounds(141, 344, 135, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\MAIL SCAPING\\yellow.jpeg"));
		lblNewLabel.setBounds(0, 0, 598, 408);
		frame.getContentPane().add(lblNewLabel);
	}

}
