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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entity.Ilac;
import repository.AdminRepository;
import repository.IlacRepository;
import repository.KullaniciRepository;

public class IlacEkleme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textIlacAdiAlani;
	private JTextField texttIlacAciklamasiAlani;
	private JTextField texttIlacFiyatAlani;
	static int ilacFiyat;
	static Ilac ilac = new Ilac();
	private JTable table;
	private DefaultTableModel model;

	// MAIN METHOD
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// INITIALIZE JFRAME FORM
				IlacEkleme form = new IlacEkleme();
				form.setVisible(true);
				;
			}
		});

	}

	// CONSTRUCTOR
	public IlacEkleme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 800, 465);
		setTitle("Eczane Otomasyonu");
		getContentPane().setLayout(null);

		goster();

		// OBTAIN SELECTED ROW
		JButton btnIlacEkleme = new JButton("\u0130la\u00E7 Ekle");
		btnIlacEkleme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIlacEkleme.setBounds(349, 154, 130, 30);
		btnIlacEkleme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean durum;
				AdminRepository adminRepository = new AdminRepository();
			    if (adminRepository.list().size() == 0) {
				if (adminRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Kayýt Olunuz.Kayýt Olmadan Herhangi Bir Ýþlem Yapamazsýnýz." + "\n");
				}
				try {
					ilacFiyat = Integer.parseInt(texttIlacFiyatAlani.getText());
					durum = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lütfen Karakter Ýçeren Fiyat Girmeyiniz." + "\n");
					setVisible(true);
					durum = false;
				}
				AdminKayit adminKayit = new AdminKayit();
				adminKayit.setVisible(true);
				close();
				} else if (adminRepository.list().size() >= 1) {
					IlacRepository ilacRepository = new IlacRepository();
					ilac.setIlacAd(textIlacAdiAlani.getText());
					ilac.setIlacAciklama(texttIlacAciklamasiAlani.getText());
					ilac.setIlacFiyat(Integer.parseInt(texttIlacFiyatAlani.getText()));
					ilacRepository.persist(ilac);
					JOptionPane.showMessageDialog(null, "Ýlacýnýz Baþarýyla Eklenmiþtir.");
					setVisible(true);
					ilacRepository.close();

				}

				// GET SELECTED ROW
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					String col = table.getValueAt(i, 0).toString();

					// DISPLAY
					/*
					 * if (checked) { JOptionPane.showMessageDialog(null, col);
					 * }
					 */
				}
				goster();
			}
		});
		getContentPane().add(btnIlacEkleme);

		JLabel lblyazilabel = new JLabel("\u0130la\u00E7 Eklemek \u0130\u00E7in;");
		lblyazilabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblyazilabel.setBounds(351, 0, 114, 19);
		getContentPane().add(lblyazilabel);

		JLabel lblIlacAdi = new JLabel("\u0130lac\u0131n Ad\u0131n\u0131 Giriniz:");
		lblIlacAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacAdi.setBounds(274, 34, 114, 19);
		getContentPane().add(lblIlacAdi);

		JLabel lblIlacAciklama = new JLabel("\u0130lac\u0131n A\u00E7\u0131klamas\u0131n\u0131 Giriniz:");
		lblIlacAciklama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacAciklama.setBounds(274, 64, 159, 19);
		getContentPane().add(lblIlacAciklama);

		JLabel lblIlacSerino = new JLabel("\u0130lac\u0131n Fiyat\u0131n\u0131 Giriniz:");
		lblIlacSerino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacSerino.setBounds(274, 94, 154, 19);
		getContentPane().add(lblIlacSerino);

		textIlacAdiAlani = new JTextField();
		textIlacAdiAlani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIlacAdiAlani.setBounds(443, 33, 130, 20);
		getContentPane().add(textIlacAdiAlani);
		textIlacAdiAlani.setColumns(10);

		texttIlacAciklamasiAlani = new JTextField();
		texttIlacAciklamasiAlani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texttIlacAciklamasiAlani.setBounds(443, 63, 130, 20);
		getContentPane().add(texttIlacAciklamasiAlani);
		texttIlacAciklamasiAlani.setColumns(10);

		texttIlacFiyatAlani = new JTextField();
		texttIlacFiyatAlani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texttIlacFiyatAlani.setBounds(443, 93, 130, 20);
		getContentPane().add(texttIlacFiyatAlani);
		texttIlacFiyatAlani.setColumns(10);

		int EkranX, EkranY;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Container c;
		c = this.getContentPane();
		EkranX = (int) kit.getScreenSize().width;
		EkranY = (int) kit.getScreenSize().height;
		this.setSize(800, 465);
		this.setLocation((EkranX - 800) / 2, (EkranY - 465) / 2);
		c.add(new JLabel("TurkishCode.com", SwingConstants.CENTER));
		setVisible(true);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void goster() {
		// ADD SCROLLPANE
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(117, 215, 600, 200);
		getContentPane().add(scroll);

		// THE TABLE
		table = new JTable();
		scroll.setViewportView(table);

		// THE MODEL OF OUR TABLE
		model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;

				default:
					return String.class;
				}
			}
		};
		IlacRepository ilacRepository = new IlacRepository();

		// ASSIGN THE MODEL TO TABLE
		table.setModel(model);

		model.addColumn("Seçim");
		model.addColumn("ID");
		model.addColumn("Ýlaç Adý");
		model.addColumn("Ýlaç Açýklamasý");
		model.addColumn("Ýlaç Fiyatý");

		// THE ROW
		for (int i = 0; i < ilacRepository.list().size(); i++) {
			Ilac ilac = ilacRepository.list().get(i);
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(ilac.getIlacId(), i, 1);
			model.setValueAt(ilac.getIlacAd(), i, 2);
			model.setValueAt(ilac.getIlacAciklama(), i, 3);
			model.setValueAt(ilac.getIlacFiyat(), i, 4);
		}
	}
}
