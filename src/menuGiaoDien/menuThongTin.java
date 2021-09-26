package menuGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.account;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class menuThongTin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public menuThongTin(String username) {
		setResizable(false);
		setTitle("INFORMATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		account acc = new account();
		try {
			Connection connection = Database.getConnection();
			String sql = "select * from information where numberbank="+username;
			Statement sta = connection.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				acc.setNumberbank(username);
				acc.setFirstname(rs.getString("firstname"));
				acc.setLastname(rs.getString("lastname"));
				acc.setMoney(rs.getInt("money"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		JLabel lblNewLabel = new JLabel("Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(119, 11, 200, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 85, 130, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NumberBank:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 145, 130, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Money:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 205, 130, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbName = new JLabel(acc.getLastname()+" "+acc.getFirstname());
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setBounds(165, 85, 259, 28);
		contentPane.add(lbName);
		
		JLabel lbNumberBank = new JLabel(acc.getNumberbank());
		lbNumberBank.setHorizontalAlignment(SwingConstants.CENTER);
		lbNumberBank.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbNumberBank.setBounds(165, 145, 259, 34);
		contentPane.add(lbNumberBank);
		
		JLabel lbMoney = new JLabel(String.valueOf(acc.getMoney()));
		lbMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lbMoney.setBounds(165, 205, 259, 34);
		contentPane.add(lbMoney);
		
		JButton btnClose = new JButton("CLose");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(0, 253, 90, 23);
		contentPane.add(btnClose);
	}
	

}
