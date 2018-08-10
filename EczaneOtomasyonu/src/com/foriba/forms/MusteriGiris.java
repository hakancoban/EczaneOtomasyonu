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

public class MusteriGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMusteriAdi;
	private JLabel lblMusteriSoyadi;
	private JTextField textMusteriSoyadi1;
	private JTextField textMusteriAdi1;
	static boolean okey;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriGiris frame = new MusteriGiris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MusteriGiris() {
		setTitle("M\u00FC\u015Fteri Giri\u015F Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 303, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel loginpanel = new JPanel();
		loginpanel.setBounds(0, 0, 299, 103);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);

		lblMusteriAdi = new JLabel("Ad\u0131n\u0131z:");
		lblMusteriAdi.setBounds(67, 11, 60, 14);
		lblMusteriAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMusteriAdi.setEnabled(true);
		loginpanel.add(lblMusteriAdi);

		lblMusteriSoyadi = new JLabel("Soyad\u0131n\u0131z:");
		lblMusteriSoyadi.setBounds(52, 33, 75, 17);
		lblMusteriSoyadi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(lblMusteriSoyadi);

		textMusteriSoyadi1 = new JTextField();
		textMusteriSoyadi1.setBounds(137, 34, 101, 20);
		textMusteriSoyadi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textMusteriSoyadi1);
		textMusteriSoyadi1.setColumns(10);

		textMusteriAdi1 = new JTextField();
		textMusteriAdi1.setBounds(137, 8, 101, 20);
		textMusteriAdi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginpanel.add(textMusteriAdi1);
		textMusteriAdi1.setColumns(10);

		JButton btnGirisAdmin = new JButton("Giri\u015F");
		btnGirisAdmin.setBounds(101, 74, 89, 23);
		btnGirisAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriRepository musteriRepository = new MusteriRepository();
				if (musteriRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Kayýt Olunuz Böyle Bir Kayýt Bulunamadý." + "\n");
				}
				for (Musteri musteri : musteriRepository.list()) {
					if (textMusteriAdi1.getText().equals(musteri.getMusteriAd())
							&& textMusteriSoyadi1.getText().equals(musteri.getMusteriSoyad())) {
						setVisible(false);
						okey = true;
						JOptionPane.showMessageDialog(null, "Giriþ Baþarýlý." + "\n");
						close();
					}
					if (!okey) {
						JOptionPane.showMessageDialog(null, "Hatalý Giriþ Yaptýnýz." + "\n");
					}
				}
				musteriRepository.close();
			}
		});
		btnGirisAdmin.setForeground(Color.BLACK);
		btnGirisAdmin.setBackground(Color.ORANGE);
		btnGirisAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginpanel.add(btnGirisAdmin);

		int EkranX, EkranY;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Container c;
		c = this.getContentPane();
		EkranX = (int) kit.getScreenSize().width;
		EkranY = (int) kit.getScreenSize().height;
		this.setSize(303, 132);
		this.setLocation((EkranX - 220) / 2, (EkranY - 205) / 2);
		c.add(new JLabel("TurkishCode.com", SwingConstants.CENTER));
		setVisible(true);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
