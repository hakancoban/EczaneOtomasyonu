package com.foriba.forms;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.Kullanici;
import repository.KullaniciRepository;

import javax.swing.JPasswordField;

public class KullaniciKayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textKullaniciAdAlan;
	private JTextField textKullaniciSoyadAlan;
	private JPasswordField passwordKullaniciSifreAlan;
	private static Kullanici kullanici = new Kullanici();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciKayit frame = new KullaniciKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public KullaniciKayit() {
		setTitle("Kullan\u0131c\u0131 Kay\u0131t Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 318, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKayitYazisi1 = new JLabel("Kay\u0131t Olmak \u0130\u00E7in;");
		lblKayitYazisi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKayitYazisi1.setBounds(97, 12, 111, 19);
		contentPane.add(lblKayitYazisi1);
		
		JLabel lblKullaniciAd = new JLabel("Ad\u0131n\u0131z:");
		lblKullaniciAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKullaniciAd.setBounds(56, 42, 46, 14);
		contentPane.add(lblKullaniciAd);
		
		JLabel lblKullaniciSoyad = new JLabel("Soyad\u0131n\u0131z:");
		lblKullaniciSoyad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKullaniciSoyad.setBounds(56, 75, 64, 19);
		contentPane.add(lblKullaniciSoyad);
		
		JLabel lblKullaniciSifre = new JLabel("\u015Eifreniz:");
		lblKullaniciSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKullaniciSifre.setBounds(56, 105, 50, 19);
		contentPane.add(lblKullaniciSifre);
		
		textKullaniciAdAlan = new JTextField();
		textKullaniciAdAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textKullaniciAdAlan.setBounds(132, 42, 117, 20);
		contentPane.add(textKullaniciAdAlan);
		textKullaniciAdAlan.setColumns(10);
		
		textKullaniciSoyadAlan = new JTextField();
		textKullaniciSoyadAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textKullaniciSoyadAlan.setBounds(132, 74, 117, 20);
		contentPane.add(textKullaniciSoyadAlan);
		textKullaniciSoyadAlan.setColumns(10);
		
		JButton btnKullaniciKayitButonu = new JButton("Kay\u0131t Ol");
		btnKullaniciKayitButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				KullaniciRepository kullaniciRepository = new KullaniciRepository();
				if (kullaniciRepository.list().size() >= 0) {
				kullanici.setKullaniciAd(textKullaniciAdAlan.getText());
				kullanici.setKullaniciSoyad(textKullaniciSoyadAlan.getText());
				kullanici.setKullaniciSifre(new String(passwordKullaniciSifreAlan.getPassword()));
				kullaniciRepository.persist(kullanici);
				JOptionPane.showMessageDialog(null, "Kaydýnýz Oluþturulmuþtur.");
				}
				kullaniciRepository.close();
				close();
				KullaniciGiris kullaniciGiris = new KullaniciGiris();
				kullaniciGiris.setVisible(true);
			}
		});
		btnKullaniciKayitButonu.setBackground(Color.ORANGE);
		btnKullaniciKayitButonu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKullaniciKayitButonu.setBounds(97, 149, 111, 23);
		contentPane.add(btnKullaniciKayitButonu);
		
		passwordKullaniciSifreAlan = new JPasswordField();
		passwordKullaniciSifreAlan.setBounds(132, 104, 117, 20);
		contentPane.add(passwordKullaniciSifreAlan);
		
		int EkranX, EkranY;
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Container c;
	        c = this.getContentPane();
	        EkranX = (int) kit.getScreenSize().width;
	        EkranY = (int) kit.getScreenSize().height;
	        this.setSize(318, 222);
	        this.setLocation((EkranX - 250) / 2, (EkranY - 285) / 2);
	        c.add(new JLabel("TurkishCode.com",SwingConstants.CENTER));
	        setVisible(true);
	}
	public void close(){
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
