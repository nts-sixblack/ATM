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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class menuChuyenTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMoney;
	private JTextField txtNumberBank;
	private JTextField txtTienCanChuyen;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public menuChuyenTien(String username) {
		setTitle("ChuyenTien");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		account acc = new account();
		try {
			Connection con = Database.getConnection();
			String sql = "select money from  information where numberbank="+username;
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				acc.setMoney(rs.getInt("money"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("Money:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 150, 132, 30);
		contentPane.add(lblNewLabel);
		
		txtMoney = new JTextField(String.valueOf(acc.getMoney()));
		txtMoney.setEditable(false);
		txtMoney.setBounds(177, 150, 257, 30);
		contentPane.add(txtMoney);
		txtMoney.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NumberBank:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 200, 135, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Money:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(35, 241, 135, 30);
		contentPane.add(lblNewLabel_2);
		
		txtNumberBank = new JTextField();
		txtNumberBank.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNumberBank.setBounds(177, 200, 257, 29);
		contentPane.add(txtNumberBank);
		txtNumberBank.setColumns(10);
		
		txtTienCanChuyen = new JTextField();
		txtTienCanChuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienCanChuyen.setBounds(177, 241, 257, 30);
		contentPane.add(txtTienCanChuyen);
		txtTienCanChuyen.setColumns(10);
		
		JButton btnChuyenTien = new JButton("ChuyenTien");
		btnChuyenTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNumberBank.getText().equals("") || txtTienCanChuyen.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ban chua dien day du thong tin");
				} else {
					int money = Integer.parseInt(txtTienCanChuyen.getText());
					String numberBank = txtNumberBank.getText();
					if(money<=acc.getMoney()) {
						try {
							Connection connection = Database.getConnection();
							String sql = "select numberbank from information";
							Statement sta = connection.createStatement();
							ResultSet rs = sta.executeQuery(sql);
							
							while(rs.next()) {
								if(numberBank.equals(rs.getString("numberbank"))) {
									int i = JOptionPane.showConfirmDialog(null, "Ban co chac muon chuyen tien khong ?");
									if(i == JOptionPane.YES_OPTION) {
										int money1 = 0;
										String query = "select money from information where numberbank="+numberBank;
										Statement statement = connection.createStatement();
										ResultSet result = statement.executeQuery(query);
										while(result.next()) {
											money1 = result.getInt("money");
										}
										money1 += money;
										String querry = "update information set money="+money1+" where numberbank="+numberBank;
										PreparedStatement pre = connection.prepareStatement(querry);
										pre.executeUpdate();
										
										Connection con = Database.getConnection();
										String x = String.valueOf(acc.getMoney()-money);
										String sqll = "update information set money="+x+" where numberbank="+username;
										PreparedStatement prepared = con.prepareStatement(sqll);
										prepared.execute();
										JOptionPane.showMessageDialog(null, "Chuyen tien thanh cong ");
										
										String ssql = "select money from information where numberbank="+username;
										Statement state = connection.createStatement();
										ResultSet resultMoney = state.executeQuery(ssql);
										while(resultMoney.next()) {
											txtMoney.setText(String.valueOf(resultMoney.getInt("money")));
										}
										txtNumberBank.setText("");
										txtTienCanChuyen.setText("");
									}
								}
							}
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Ban khong du tien de chuyen");
					}
				}
			}
		});
		btnChuyenTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChuyenTien.setForeground(new Color(0, 0, 0));
		btnChuyenTien.setBounds(232, 297, 161, 30);
		contentPane.add(btnChuyenTien);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(10, 357, 89, 23);
		contentPane.add(btnClose);
	}

}
