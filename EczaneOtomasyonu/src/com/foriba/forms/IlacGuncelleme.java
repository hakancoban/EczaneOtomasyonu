package com.foriba.forms;

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
import javax.swing.table.DefaultTableModel;
import entity.Ilac;
import repository.AdminRepository;
import repository.IlacRepository;

public class IlacGuncelleme extends JFrame {

	private static final long serialVersionUID = 1L;
	static int ilacFiyat;
	static String ilacAciklama;
	static String ilacAdi;
	static long Id;
	private JTable table;
	private DefaultTableModel model;
	private IlacRepository ilacRepository = new IlacRepository();

	// MAIN METHOD
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// INITIALIZE JFRAME FORM
				IlacGuncelleme form = new IlacGuncelleme();
				form.setVisible(true);
				;
			}
		});

	}

	// CONSTRUCTOR
	public IlacGuncelleme() {
		// the form
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 800, 336);
		setTitle("Eczane Otomasyonu");
		getContentPane().setLayout(null);
		
		goster();

		// OBTAIN SELECTED ROW
		JButton btnÝlacGuncelle = new JButton("\u0130la\u00E7 G\u00FCncelle");
		btnÝlacGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnÝlacGuncelle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdminRepository adminRepository = new AdminRepository();
				if (adminRepository.list().size() == 0) {
				if (adminRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Kayýt Olunuz.Kayýt Olmadan Herhangi Bir Ýþlem Yapamazsýnýz." + "\n");
				}
				
				if (ilacRepository.list().size() == 0) {
					JOptionPane.showMessageDialog(null, "Depoda Ýlaç Bulunmamaktadýr.");
					setVisible(true);
				}
				AdminKayit adminKayit = new AdminKayit();
				adminKayit.setVisible(true);
				close();
				}else if (ilacRepository.list().size() >= 1) {
					
					for (int i = 0; i < table.getRowCount(); i++) {
						if (((Boolean) table.getValueAt(i, 0)).booleanValue()) {
//							ilacRepository.remove((long) table.getValueAt(i, 1));
							IlacGuncelleme2 guncelleme2=new IlacGuncelleme2(ilacRepository.list().get(i));
							guncelleme2.setVisible(true);
						}
					}
				}
				
				
				ilacRepository.close();
				close();

				// GET SELECTED ROW
				/*for (int i = 0; i < table.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					String col = table.getValueAt(i, 1).toString();

					// DISPLAY
					
					  if (checked) { JOptionPane.showMessageDialog(null, col);
					  }
					 
				}*/
				goster();
			}
		});

		// ADD BUTTON TO FORM
		btnÝlacGuncelle.setBounds(352, 272, 142, 30);
		getContentPane().add(btnÝlacGuncelle);

		JLabel lblyazi = new JLabel("\u0130la\u00E7 G\u00FCncellemek \u0130\u00E7in Bir CheckBox \u0130\u015Faretleyiniz.");
		lblyazi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblyazi.setBounds(274, 0, 313, 19);
		getContentPane().add(lblyazi);
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void goster() {

		// ADD SCROLLPANE
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(114, 48, 600, 200);
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
