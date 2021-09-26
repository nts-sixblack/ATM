package menuGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.menuLogin;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public menuMain(String username) {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 160, 38);
		contentPane.add(lblNewLabel);
		//Thong tin nguoi dung
		JButton btnThongTin = new JButton("ThongTin");
		btnThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuThongTin frame = new menuThongTin(username);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnThongTin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnThongTin.setBounds(10, 100, 150, 54);
		contentPane.add(btnThongTin);
		//Sua ma pin
		JButton btnMaPin = new JButton("MaPin");
		btnMaPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPIN frame = new menuPIN(username);
				frame.setVisible(true);	
				frame.setLocationRelativeTo(null);
			}
		});
		btnMaPin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMaPin.setBounds(10, 180, 150, 54);
		contentPane.add(btnMaPin);
		//RutTien
		JButton btnRutTien = new JButton("RutTien");
		btnRutTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuRutTien frame = new menuRutTien(username);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnRutTien.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRutTien.setBounds(260, 100, 150, 54);
		contentPane.add(btnRutTien);
		//ChuyenTien
		JButton btnChuyenTien = new JButton("ChuyenTien");
		btnChuyenTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuChuyenTien frame = new menuChuyenTien(username);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnChuyenTien.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChuyenTien.setBounds(260, 180, 150, 54);
		contentPane.add(btnChuyenTien);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 350, 96, 30);
		contentPane.add(btnNewButton);
	}

}
