package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import menuGiaoDien.menuMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class menuLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuLogin frame = new menuLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuLogin() {
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 24, 120, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 105, 159, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(10, 165, 156, 30);
		contentPane.add(lblNewLabel_2);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUserName.setBounds(179, 105, 255, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setBounds(179, 165, 255, 30);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				String password = txtPassword.getText();
				if(checkLogin(username, password)) {
					menuMain frame = new menuMain(username);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					txtUserName.setText("");
					txtPassword.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Dang nhap khong thanh cong");
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBounds(133, 206, 150, 40);
		contentPane.add(btnLogin);
	}
	private boolean checkLogin(String username, String password) {
		int check = 0;
		try {
			Connection connection = Database.getConnection();
			String sql = "select password from information where numberbank="+username;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String checkPass = rs.getString("password");
				if(password.equals(checkPass)) {
					check = 1;
				}
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		if(check == 1) {
			return true;
		} else {
			return false;
		}
	}
}
