package com.foriba.forms;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.Admin;
import repository.AdminRepository;

import javax.swing.JPasswordField;

public class AdminKayit extends JFrame {
	static File file = new File("C:/Users/HP/Desktop/Admin_Kayit_Tutma/Admin_Kayit.txt");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAdAlan;
	private JTextField textSoyadAlan;
	private JPasswordField passwordSifreAlan;
	private static Admin admin = new Admin();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminKayit frame = new AdminKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminKayit() {
		setTitle("Admin Kay\u0131t Ekran\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 270, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKayitYazisi = new JLabel("Kay\u0131t Olmak \u0130\u00E7in;");
		lblKayitYazisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKayitYazisi.setBounds(69, 11, 111, 19);
		contentPane.add(lblKayitYazisi);
		
		JLabel lblAd = new JLabel("Ad\u0131n\u0131z:");
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAd.setBounds(38, 45, 46, 14);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoyad.setBounds(38, 75, 64, 19);
		contentPane.add(lblSoyad);
		
		JLabel lblSifre = new JLabel("\u015Eifreniz:");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSifre.setBounds(38, 105, 50, 19);
		contentPane.add(lblSifre);
		
		textAdAlan = new JTextField();
		textAdAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAdAlan.setBounds(108, 42, 117, 20);
		contentPane.add(textAdAlan);
		textAdAlan.setColumns(10);
		
		textSoyadAlan = new JTextField();
		textSoyadAlan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSoyadAlan.setBounds(108, 73, 117, 20);
		contentPane.add(textSoyadAlan);
		textSoyadAlan.setColumns(10);
		
		JButton btnKayitButonu = new JButton("Kay\u0131t Ol");
		btnKayitButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminRepository adminRepository = new AdminRepository();
				if (adminRepository.list().size() == 0) {
					admin.setAdminAd(textAdAlan.getText());
					admin.setAdminSoyad(textSoyadAlan.getText());
					admin.setAdminSifre(new String(passwordSifreAlan.getPassword()));
					adminRepository.persist(admin);
					 JOptionPane.showMessageDialog(null, "Kaydýnýz Oluþturulmuþtur.");
				} else {
					JOptionPane.showMessageDialog(null, "Birden Fazla Kayýt Yapamazsýnýz.");
				}
				adminRepository.close();
				try {
					@SuppressWarnings("resource")
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

					writer.append(textAdAlan.getText()+" "+textSoyadAlan.getText()+" "+passwordSifreAlan.getPassword().toString());
					writer.newLine();

					writer.flush();

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					@SuppressWarnings("resource")
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					
					String s = reader.readLine();
					System.out.println("S nesnesindeki string: " + s);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				close();
				AdminGiris adminGiris = new AdminGiris();
				adminGiris.setVisible(true);
			}
		});
		btnKayitButonu.setBackground(Color.ORANGE);
		btnKayitButonu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKayitButonu.setBounds(69, 149, 111, 23);
		contentPane.add(btnKayitButonu);
		
		passwordSifreAlan = new JPasswordField();
		passwordSifreAlan.setBounds(108, 103, 117, 20);
		contentPane.add(passwordSifreAlan);
		
		int EkranX, EkranY;
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Container c;
	        c = this.getContentPane();
	        EkranX = (int) kit.getScreenSize().width;
	        EkranY = (int) kit.getScreenSize().height;
	        this.setSize(270, 210);
	        this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
	        c.add(new JLabel("",SwingConstants.CENTER));
	        setVisible(true);
	}
	public void close(){
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
