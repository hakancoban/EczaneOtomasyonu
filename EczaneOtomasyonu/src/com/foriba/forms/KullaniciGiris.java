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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.Kullanici;
import repository.KullaniciRepository;

public class KullaniciGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblKullaniciAdi;
	private JLabel lblKullaniciSoyadi;
	private JLabel lblKullaniciSifre;
	private JTextField textKullaniciSoyadi1;
	private JTextField textKullaniciAdi1;
	private JPasswordField passwordKullaniciSifre1;
	static boolean okey;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciGiris frame = new KullaniciGiris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public KullaniciGiris() {
		setTitle("Kullan\u0131c\u0131 Giri\u015F Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 303, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(-1, 0, 299, 135);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);

		lblKullaniciAdi = new JLabel("Ad\u0131n\u0131z:");
		lblKullaniciAdi.setBounds(56, 10, 60, 14);
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKullaniciAdi.setEnabled(true);
		loginpanel.add(lblKullaniciAdi);

		lblKullaniciSoyadi = new JLabel("Soyad\u0131n\u0131z:");
		lblKullaniciSoyadi.setBounds(52, 37, 75, 17);
		lblKullaniciSoyadi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(lblKullaniciSoyadi);

		lblKullaniciSifre = new JLabel("\u015Eifreniz:");
		lblKullaniciSifre.setBounds(56, 66, 68, 14);
		lblKullaniciSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(lblKullaniciSifre);

		textKullaniciSoyadi1 = new JTextField();
		textKullaniciSoyadi1.setBounds(137, 34, 101, 20);
		textKullaniciSoyadi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textKullaniciSoyadi1);
		textKullaniciSoyadi1.setColumns(10);

		textKullaniciAdi1 = new JTextField();
		textKullaniciAdi1.setBounds(137, 4, 101, 20);
		textKullaniciAdi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textKullaniciAdi1);
		textKullaniciAdi1.setColumns(10);

		JButton btnGirisAdmin = new JButton("Giri\u015F");
		btnGirisAdmin.setBounds(107, 103, 89, 23);
		btnGirisAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciRepository kullaniciRepository = new KullaniciRepository();
				if (kullaniciRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Kayýt Olunuz Böyle Bir Kayýt Bulunamadý." + "\n");
				}

				for (Kullanici kullanici : kullaniciRepository.list()) {
					if (textKullaniciAdi1.getText().equals(kullanici.getKullaniciAd())
							&& textKullaniciSoyadi1.getText().equals(kullanici.getKullaniciSoyad())
							&& new String(passwordKullaniciSifre1.getPassword())
									.equals(kullanici.getKullaniciSifre())) {
						setVisible(false);
						okey = true;
						JOptionPane.showMessageDialog(null, "Giriþ Baþarýlý." + "\n");
						close();
					}
					if (!okey) {
						JOptionPane.showMessageDialog(null, "Hatalý Giriþ Yaptýnýz." + "\n");
					}
				}
				kullaniciRepository.close();
			}
		});
		btnGirisAdmin.setForeground(Color.BLACK);
		btnGirisAdmin.setBackground(Color.ORANGE);
		btnGirisAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginpanel.add(btnGirisAdmin);

		passwordKullaniciSifre1 = new JPasswordField();
		passwordKullaniciSifre1.setBounds(137, 64, 101, 20);
		loginpanel.add(passwordKullaniciSifre1);

		int EkranX, EkranY;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Container c;
		c = this.getContentPane();
		EkranX = (int) kit.getScreenSize().width;
		EkranY = (int) kit.getScreenSize().height;
		this.setSize(303, 162);
		this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
		c.add(new JLabel("TurkishCode.com", SwingConstants.CENTER));
		setVisible(true);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
