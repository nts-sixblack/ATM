package menuGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class menuRutTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumberBank;
	private JTextField txtMoney;
	private JTextField txtRutTien;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public menuRutTien(String username) {
		setTitle("RutTien");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		account acc = new account();
		try {
			Connection connection = Database.getConnection();
			String sql = "select * from information where numberbank = "+username;
			Statement sta = connection.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			
			while(rs.next()) {
				acc.setNumberbank(rs.getString("numberbank"));
				acc.setMoney(rs.getInt("money"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("NumberBank:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 130, 140, 25);
		contentPane.add(lblNewLabel);
		
		txtNumberBank = new JTextField(acc.getNumberbank());
		txtNumberBank.setEditable(false);
		txtNumberBank.setBounds(174, 130, 260, 25);
		contentPane.add(txtNumberBank);
		txtNumberBank.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Money:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(24, 180, 140, 25);
		contentPane.add(lblNewLabel_1);
		
		txtMoney = new JTextField(String.valueOf(acc.getMoney()));
		txtMoney.setEditable(false);
		txtMoney.setBounds(174, 180, 260, 25);
		contentPane.add(txtMoney);
		txtMoney.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SoTienCanRut");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 227, 140, 25);
		contentPane.add(lblNewLabel_2);
		
		txtRutTien = new JTextField();
		txtRutTien.setBounds(174, 227, 260, 26);
		contentPane.add(txtRutTien);
		txtRutTien.setColumns(10);
		
		JButton btnNewButton = new JButton("RutTien");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon rut tien khong ?");
				if(i == JOptionPane.YES_OPTION) {
					int money = Integer.parseInt(txtRutTien.getText());
					if(acc.getMoney()>=money) {
						try {
							Connection con = Database.getConnection();
							String sql = "update information set money="+(acc.getMoney()-money);
							PreparedStatement pre = con.prepareStatement(sql);
							pre.executeUpdate();
							JOptionPane.showMessageDialog(null, "Ban da rut tien thanh cong");
							
							String query = "select * from information where numberbank="+username;
							Statement sta = con.createStatement();
							ResultSet rs = sta.executeQuery(query);
							while(rs.next()) {
								txtMoney.setText(String.valueOf(rs.getInt("money")));
							}
							txtRutTien.setText("");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Tai khoang ban khong co du tien de rut");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(225, 279, 119, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 341, 102, 39);
		contentPane.add(btnNewButton_1);
	}

}
