package com.foriba.forms;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class AnaEkran {

	private JFrame frmEczaneOtomasyonu;
	private static JFrame frm;
	public static void main(String[] args) {
		 frm = new JFrame("ResizedLabel test");
		    int EkranX, EkranY;
		    Toolkit kit = Toolkit.getDefaultToolkit();
		    Container c;
	        c = frm.getContentPane();
	        EkranX = (int) kit.getScreenSize().width;
	        EkranY = (int) kit.getScreenSize().height;
	        frm.setSize(950, 550);
	        frm.setLocation((EkranX - 950) / 2, (EkranY - 600) / 2); 
	        c.add(new JLabel("",SwingConstants.CENTER));
		    
		 frm.setTitle("Eczane Otomasyonu");
	        final ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\bac7c3640384e024ffa15f55d9245c78.jpg");
	        JLabel lblGirissayfa = new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\bac7c3640384e024ffa15f55d9245c78.jpg"));
	        lblGirissayfa.setText("");
	        lblGirissayfa.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                JLabel label = (JLabel) e.getComponent();
	                Dimension size = label.getSize();
	                Image resized = icon.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
	                label.setIcon(new ImageIcon(resized));
	            }
	        });
	        frm.getContentPane().add(lblGirissayfa, BorderLayout.CENTER);
	        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frm.setResizable(false);
	        frm.pack();
	        
	        JMenuBar menuBar = new JMenuBar();
	        frm.setJMenuBar(menuBar);
	        
	        JMenu mnKayit = new JMenu("Kay\u0131t");
	        menuBar.add(mnKayit);
	        
	        JMenuItem mn�tmAdminKayit = new JMenuItem("Admin Kay\u0131t");
	        mn�tmAdminKayit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		AdminKayit adminKayit = new AdminKayit();
					adminKayit.setVisible(true);
					setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnKayit.add(mn�tmAdminKayit);
	        
	        JMenuItem mn�tmKullaniciKayit = new JMenuItem("Kullan\u0131c\u0131 Kay\u0131t");
	        mn�tmKullaniciKayit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		KullaniciKayit kullaniciKayit = new KullaniciKayit();
					kullaniciKayit.setVisible(true);
			        setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnKayit.add(mn�tmKullaniciKayit);
	        
	        JMenuItem mn�tmMusteriKayit = new JMenuItem("M\u00FC\u015Fteri Kay\u0131t");
	        mn�tmMusteriKayit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		MusteriKayit musteriKayit = new MusteriKayit();
					musteriKayit.setVisible(true);
			        setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnKayit.add(mn�tmMusteriKayit);
	        
	        JMenu mnGiris = new JMenu("Giri\u015F");
	        menuBar.add(mnGiris);
	        
	        JMenuItem mn�tmAdminGiris = new JMenuItem("Admin Giri\u015F");
	        mn�tmAdminGiris.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		AdminGiris adminGiris = new AdminGiris();
					adminGiris.setVisible(true);
			        setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnGiris.add(mn�tmAdminGiris);
	        
	        JMenuItem mn�tmKullaniciGiris = new JMenuItem("Kullan\u0131c\u0131 Giri\u015F");
	        mn�tmKullaniciGiris.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		KullaniciGiris kullaniciGiris = new KullaniciGiris();
					kullaniciGiris.setVisible(true);
			        setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnGiris.add(mn�tmKullaniciGiris);
	        
	        JMenuItem mn�tmMusteriGiris = new JMenuItem("M\u00FC\u015Fteri Giri\u015F");
	        mn�tmMusteriGiris.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		MusteriGiris musteriGiris = new MusteriGiris();
					musteriGiris.setVisible(true);
			        setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnGiris.add(mn�tmMusteriGiris);
	        
	        JMenu mnIslemler = new JMenu("\u0130\u015Flemler");
	        menuBar.add(mnIslemler);
	        
	        JMenuItem mn�tmIlacEkle = new JMenuItem("\u0130la\u00E7 Ekle");
	        mn�tmIlacEkle.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		IlacEkleme ilacEkleme = new IlacEkleme();
					ilacEkleme.setVisible(true);
					setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnIslemler.add(mn�tmIlacEkle);
	        
	        JMenuItem mn�tmIlacCikar = new JMenuItem("\u0130la\u00E7 \u00C7\u0131kar");
	        mn�tmIlacCikar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		IlacCikarmaa ilacCikarmaa = new IlacCikarmaa();
					ilacCikarmaa.setVisible(true);
					setVisible(false);
					
	        	}

				private void setVisible(boolean b) {					
				}
	        });
	        mnIslemler.add(mn�tmIlacCikar);
	        
	        JMenuItem mn�tmIlacGuncelle = new JMenuItem("\u0130la\u00E7 G\u00FCncelle");
	        mn�tmIlacGuncelle.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		IlacGuncelleme ilacGuncelleme = new IlacGuncelleme();
					ilacGuncelleme.setVisible(true);
					setVisible(false);
					
	        	}
	        	
	        	private void setVisible(boolean b) {
				}
	        });
	        mnIslemler.add(mn�tmIlacGuncelle);
	        
	        JMenuItem mn�tmIlacListele = new JMenuItem("\u0130la\u00E7 Listele");
	        mn�tmIlacListele.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		IlacListeleme ilacListeleme = new IlacListeleme();
					ilacListeleme.setVisible(true);
					setVisible(false);
	        	}

				private void setVisible(boolean b) {
				}
	        });
	        mnIslemler.add(mn�tmIlacListele);
	        frm.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	    private void initialize() {
		frmEczaneOtomasyonu = new JFrame();
		frmEczaneOtomasyonu.setTitle("ECZANE OTOMASYONU");
		frmEczaneOtomasyonu.setBounds(100, 100, 461, 379);
		frmEczaneOtomasyonu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar_1 = new JMenuBar();
		frmEczaneOtomasyonu.setJMenuBar(menuBar_1);
		
		JMenu mnIslemler = new JMenu("\u0130\u015Flemler");
		menuBar_1.add(mnIslemler);
		
		JMenu mnGiris = new JMenu("Giri\u015F");
		mnIslemler.add(mnGiris);
		
		JMenuItem mn�tmAdmin = new JMenuItem("Admin");
		mn�tmAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		mnGiris.add(mn�tmAdmin);
		
		JMenuItem mn�tmKullanici = new JMenuItem("Kullan\u0131c\u0131");
		mn�tmKullanici.setHorizontalAlignment(SwingConstants.CENTER);
		mnGiris.add(mn�tmKullanici);
		
		JMenuItem mn�tmMusteri = new JMenuItem("M\u00FC\u015Fteri");
		mn�tmMusteri.setHorizontalAlignment(SwingConstants.CENTER);
		mnGiris.add(mn�tmMusteri);
		
		JPanel resimpanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmEczaneOtomasyonu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(resimpanel, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(2, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(resimpanel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(4, Short.MAX_VALUE))
		);
		
		JLabel lblresimlabel = new JLabel("");
		//lblresimlabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\depositphotos_4114611-stock-illustration-nurse-emoticon.jpg"));
		GroupLayout gl_resimpanel = new GroupLayout(resimpanel);
		gl_resimpanel.setHorizontalGroup(
			gl_resimpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_resimpanel.createSequentialGroup()
					.addComponent(lblresimlabel, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_resimpanel.setVerticalGroup(
			gl_resimpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_resimpanel.createSequentialGroup()
					.addComponent(lblresimlabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		resimpanel.setLayout(gl_resimpanel);
		frmEczaneOtomasyonu.getContentPane().setLayout(groupLayout);
	}
	   
}
