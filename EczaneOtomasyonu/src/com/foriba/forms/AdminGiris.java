package com.foriba.forms;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import repository.AdminRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPasswordField;

public class AdminGiris extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAdminAdi;
	private JLabel lblAdminSoyadi;
	private JLabel lblAdminSifre;
	private JTextField textSoyadAlan;
	private JTextField textAdAlan;
	private JPasswordField passwordSifreAlan;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGiris frame = new AdminGiris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminGiris() {
	
		        
		setTitle("Admin Giri\u015F Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 303, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(0, 0, 297, 129);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);
		
		lblAdminAdi = new JLabel("Ad\u0131n\u0131z:");
		lblAdminAdi.setBounds(67, 11, 60, 14);
		lblAdminAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdminAdi.setEnabled(true);
		loginpanel.add(lblAdminAdi);
		
		lblAdminSoyadi = new JLabel("Soyad\u0131n\u0131z:");
		lblAdminSoyadi.setBounds(52, 33, 75, 17);
		lblAdminSoyadi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(lblAdminSoyadi);
		
		lblAdminSifre = new JLabel("\u015Eifreniz:");
		lblAdminSifre.setBounds(59, 61, 68, 14);
		lblAdminSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(lblAdminSifre);
		
		textSoyadAlan = new JTextField();
		textSoyadAlan.setBounds(137, 34, 120, 20);
		textSoyadAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textSoyadAlan);
		textSoyadAlan.setColumns(10);
		
		textAdAlan = new JTextField();
		textAdAlan.setBounds(137, 8, 120, 20);
		textAdAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textAdAlan);
		textAdAlan.setColumns(10);
		
		JButton btnGirisAdmin = new JButton("Giri\u015F");
		btnGirisAdmin.setBounds(107, 97, 89, 23);
		btnGirisAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminRepository adminRepository = new AdminRepository();
				if (adminRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Kayýt Olunuz Böyle Bir Kayýt Bulunamadý." + "\n");
					AdminKayit adminKayit = new AdminKayit();
					adminKayit.setVisible(true);
					close();
				}
				if (textAdAlan.getText().equals(adminRepository.list().get(0).getAdminAd())
						&& textSoyadAlan.getText().equals(adminRepository.list().get(0).getAdminSoyad())
						&& new String(passwordSifreAlan.getPassword()).equals(adminRepository.list().get(0).getAdminSifre())) {
					setVisible(false);
					try {
						JOptionPane.showMessageDialog(null, "Giriþ Baþarýlý" + "\n");
					} catch (Exception e2) {
					}
					JOptionPane.showMessageDialog(null, "Ýþlemler Menüsünden Bir Ýþlem Seçebilirsiniz.");
				}
				else {
					try {
						JOptionPane.showMessageDialog(null, "Hatalý Giriþ Yaptýnýz Lütfen Tekrar Deneyiniz.");
					} catch (Exception e2) {
					}
				}
				adminRepository.close();
				
				/*String mesaj;
				String satir="";
				String[] parts = satir.split(" ");
				if(textAdAlan.getText().equals(parts[0]) && textSoyadAlan.equals(parts[1]) && passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Giriþ Yapýldý.");
				}
				else if(!textAdAlan.getText().equals(parts[0]) && textSoyadAlan.equals(parts[1]) && passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
				    mesaj = JOptionPane.showInputDialog("Ad Hatalý Girildi.");
				}
				else if(textAdAlan.getText().equals(parts[0]) && !textSoyadAlan.equals(parts[1]) && passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Soyad Hatalý Girildi.");
				}
				else if(textAdAlan.getText().equals(parts[0]) && textSoyadAlan.equals(parts[1]) && !passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Þifre Hatalý Girildi.");
				}
				else if(!textAdAlan.getText().equals(parts[0]) && !textSoyadAlan.equals(parts[1]) && !passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Ad Ve Soyad Hatalý Girildi.");
				}
				else if(!textAdAlan.getText().equals(parts[0]) && textSoyadAlan.equals(parts[1]) && !passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Ad Ve Þifre Hatalý Girildi.");
				}
				else if(textAdAlan.getText().equals(parts[0]) && textSoyadAlan.equals(parts[1]) && !passwordSifreAlan.getPassword().toString().equals(parts[2]))
				{
					mesaj = JOptionPane.showInputDialog("Þifre Hatalý Girildi.");
				}
				else
				{
					mesaj = JOptionPane.showInputDialog("Hatalý Giriþ Yapýldý.");
				}*/
						
		        
			}
			
		});
		btnGirisAdmin.setForeground(Color.BLACK);
		btnGirisAdmin.setBackground(Color.ORANGE);
		btnGirisAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginpanel.add(btnGirisAdmin);
		
		passwordSifreAlan = new JPasswordField();
		passwordSifreAlan.setBounds(137, 58, 120, 20);
		passwordSifreAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(passwordSifreAlan);
		
		 int EkranX, EkranY;
		    Toolkit kit = Toolkit.getDefaultToolkit();
		    Container c;
		        c = this.getContentPane();
		        EkranX = (int) kit.getScreenSize().width;
		        EkranY = (int) kit.getScreenSize().height;
		        this.setSize(300, 155);
		        this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
		        c.add(new JLabel("",SwingConstants.CENTER));
		        setVisible(true);
	}
	public void close(){
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
