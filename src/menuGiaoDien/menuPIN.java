package menuGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import database.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPIN extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtCheckNewPass;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public menuPIN(String username) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(156, 11, 108, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 82, 164, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Password:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(30, 138, 164, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Check Password: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(30, 194, 164, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Change ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = "";
				try {
					Connection connection = Database.getConnection();
					String sql = "select password from information where numberbank="+username;
					Statement sta = connection.createStatement();
					ResultSet rs = sta.executeQuery(sql);
					while(rs.next()) {
						pass = rs.getString("password");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(pass.equals(txtPass.getText())){
					String newPass;
					if(txtNewPass.getText().equals(txtCheckNewPass.getText())) {
						newPass = txtNewPass.getText();
						try {
							Connection connection = Database.getConnection();
							String sql = "update information set password ="+newPass+" where numberbank="+username;
							Statement sta = connection.createStatement();
							sta.executeUpdate(sql);
							txtPass.setText("");
							txtNewPass.setText("");
							txtCheckNewPass.setText("");
							JOptionPane.showMessageDialog(null, "Da thay doi mat khau thanh cong");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "xac nhan mat khau khong dung");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sai mat khau");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(239, 231, 141, 39);
		contentPane.add(btnNewButton);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(204, 82, 220, 30);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setBounds(204, 138, 220, 30);
		contentPane.add(txtNewPass);
		txtNewPass.setColumns(10);
		
		txtCheckNewPass = new JPasswordField();
		txtCheckNewPass.setBounds(204, 194, 220, 30);
		contentPane.add(txtCheckNewPass);
		txtCheckNewPass.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 258, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
