package com.foriba.forms;

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
import entity.Ilac;
import repository.IlacRepository;

public class IlacGuncelleme2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIlacAdiYazma;
	private JTextField textIlacAciklamaYazma;
	private JTextField textIlacFiyatYazma;
	private Ilac ilac;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlacGuncelleme2 frame = new IlacGuncelleme2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IlacGuncelleme2() {

	}

	public IlacGuncelleme2(Ilac ilac) {
		this.ilac = ilac;
		setTitle("Eczane Otomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int EkranX, EkranY;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Container c;
		c = this.getContentPane();
		EkranX = (int) kit.getScreenSize().width;
		EkranY = (int) kit.getScreenSize().height;
		this.setSize(435, 200);
		this.setLocation((EkranX - 330) / 2, (EkranY - 265) / 2);
		c.add(new JLabel("", SwingConstants.CENTER));

		JButton btnGuncelle = new JButton("\u0130la\u00E7 G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				IlacRepository ilacRepository = new IlacRepository();
				ilac.setIlacAd(textIlacAdiYazma.getText());
				ilac.setIlacAciklama(textIlacAciklamaYazma.getText());
				ilac.setIlacFiyat(Integer.parseInt(textIlacFiyatYazma.getText()));
				ilacRepository.merge(ilac);
				JOptionPane.showMessageDialog(null, "Ýlacýnýz Baþarýyla Güncellenmiþtir.");
				setVisible(true);
				IlacGuncelleme guncelleme = new IlacGuncelleme();
				guncelleme.setVisible(true);
				ilacRepository.close();

			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuncelle.setBounds(158, 122, 120, 23);
		contentPane.add(btnGuncelle);

		JLabel lblIlacAdiYazi = new JLabel("\u0130lac\u0131n Ad\u0131n\u0131 Giriniz:");
		lblIlacAdiYazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacAdiYazi.setBounds(52, 21, 113, 19);
		contentPane.add(lblIlacAdiYazi);

		JLabel lblÝlacAciklamaYazi = new JLabel("\u0130lac\u0131n A\u00E7\u0131klamas\u0131n\u0131 Giriniz:");
		lblÝlacAciklamaYazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblÝlacAciklamaYazi.setBounds(52, 51, 159, 19);
		contentPane.add(lblÝlacAciklamaYazi);

		JLabel lblIlacFiyatYazi = new JLabel("\u0130lac\u0131n Fiyat\u0131n\u0131 Giriniz:");
		lblIlacFiyatYazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacFiyatYazi.setBounds(52, 81, 127, 19);
		contentPane.add(lblIlacFiyatYazi);

		textIlacAdiYazma = new JTextField();
		textIlacAdiYazma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIlacAdiYazma.setBounds(221, 20, 147, 20);
		textIlacAdiYazma.setText(ilac.getIlacAd());
		contentPane.add(textIlacAdiYazma);
		textIlacAdiYazma.setColumns(10);

		textIlacAciklamaYazma = new JTextField();
		textIlacAciklamaYazma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIlacAciklamaYazma.setBounds(221, 50, 147, 20);
		textIlacAciklamaYazma.setText(ilac.getIlacAciklama());
		contentPane.add(textIlacAciklamaYazma);
		textIlacAciklamaYazma.setColumns(10);

		textIlacFiyatYazma = new JTextField();
		textIlacFiyatYazma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIlacFiyatYazma.setBounds(221, 80, 147, 20);
		textIlacFiyatYazma.setText(String.valueOf(ilac.getIlacFiyat()));
		contentPane.add(textIlacFiyatYazma);
		textIlacFiyatYazma.setColumns(10);

	}
}
