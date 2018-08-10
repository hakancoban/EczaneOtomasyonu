package com.foriba.forms;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import repository.IlacRepository;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IlacBulmaSonuc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static long Id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlacBulmaSonuc frame = new IlacBulmaSonuc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IlacBulmaSonuc() {
		setTitle("Eczane Otomasyonu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 306, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel IlacBulmapanel = new JPanel();
		IlacBulmapanel.setBounds(0, 0, 294, 180);
		contentPane.add(IlacBulmapanel);
		IlacBulmapanel.setLayout(null);
		
		JLabel lblIlacAdi = new JLabel("\u0130lac\u0131n Ad\u0131:");
		lblIlacAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacAdi.setBounds(35, 50, 68, 19);
		IlacBulmapanel.add(lblIlacAdi);
		
		JLabel lblIlacAciklamasi = new JLabel("\u0130lac\u0131n A\u00E7\u0131klamas\u0131:");
		lblIlacAciklamasi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacAciklamasi.setBounds(35, 80, 113, 19);
		IlacBulmapanel.add(lblIlacAciklamasi);
		
		JLabel lblIlaAdi1 = new JLabel("");
		lblIlaAdi1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlaAdi1.setBounds(158, 50, 126, 19);
		IlacBulmapanel.add(lblIlaAdi1);
		
		JLabel lblIlacAciklama1 = new JLabel("");
		lblIlacAciklama1.setBounds(158, 81, 126, 18);
		IlacBulmapanel.add(lblIlacAciklama1);
		
		JLabel lblBulunanIlac = new JLabel("Bulunan \u0130la\u00E7;");
		lblBulunanIlac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBulunanIlac.setBounds(109, 11, 87, 19);
		IlacBulmapanel.add(lblBulunanIlac);
	
		JButton btnilacGoster = new JButton("\u0130la\u00E7 G\u00F6ster");
		btnilacGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IlacRepository ilacRepository = new IlacRepository();
			    
			    if (ilacRepository.find(Id) != null) {
					ilacRepository.find(Id).getIlacAd();
					lblIlaAdi1.setText(ilacRepository.find(Id).getIlacAd());
					ilacRepository.find(Id).getIlacAciklama();
					lblIlacAciklama1.setText(ilacRepository.find(Id).getIlacAciklama());
				}
			}
		});
		btnilacGoster.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnilacGoster.setBounds(94, 117, 126, 23);
		IlacBulmapanel.add(btnilacGoster);
		
		int EkranX, EkranY;
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Container c;
	        c = this.getContentPane();
	        EkranX = (int) kit.getScreenSize().width;
	        EkranY = (int) kit.getScreenSize().height;
	        this.setSize(300, 182);
	        this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
	        c.add(new JLabel("TurkishCode.com",SwingConstants.CENTER));
	        setVisible(true);
	}
}
