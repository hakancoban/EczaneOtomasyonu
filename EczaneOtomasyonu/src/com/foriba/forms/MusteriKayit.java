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

import entity.Musteri;
import repository.MusteriRepository;

public class MusteriKayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMusteriAdAlan;
	private JTextField textMusteriSoyadAlan;
	private static Musteri musteri = new Musteri();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriKayit frame = new MusteriKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MusteriKayit() {
		setTitle("M\u00FC\u015Fteri Kay\u0131t Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 318, 197);
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

		textMusteriAdAlan = new JTextField();
		textMusteriAdAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMusteriAdAlan.setBounds(132, 42, 117, 20);
		contentPane.add(textMusteriAdAlan);
		textMusteriAdAlan.setColumns(10);

		textMusteriSoyadAlan = new JTextField();
		textMusteriSoyadAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMusteriSoyadAlan.setBounds(132, 74, 117, 20);
		contentPane.add(textMusteriSoyadAlan);
		textMusteriSoyadAlan.setColumns(10);

		JButton btnKullaniciKayitButonu = new JButton("Kay\u0131t Ol");
		btnKullaniciKayitButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriRepository musteriRepository = new MusteriRepository();
				if (musteriRepository.list().size() >= 0) {
					musteri.setMusteriAd(textMusteriAdAlan.getText());
					musteri.setMusteriSoyad(textMusteriSoyadAlan.getText());
					musteriRepository.persist(musteri);
					JOptionPane.showMessageDialog(null, "Kaydýnýz Oluþturulmuþtur.");
				}
				musteriRepository.close();
				close();
				MusteriGiris musteriGiris = new MusteriGiris();
				musteriGiris.setVisible(true);
			}
		});
		btnKullaniciKayitButonu.setBackground(Color.ORANGE);
		btnKullaniciKayitButonu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKullaniciKayitButonu.setBounds(97, 115, 111, 23);
		contentPane.add(btnKullaniciKayitButonu);

		int EkranX, EkranY;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Container c;
		c = this.getContentPane();
		EkranX = (int) kit.getScreenSize().width;
		EkranY = (int) kit.getScreenSize().height;
		this.setSize(318, 197);
		this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
		c.add(new JLabel("TurkishCode.com", SwingConstants.CENTER));
		setVisible(true);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
