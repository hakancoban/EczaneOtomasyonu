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

import com.foriba.forms.IlacBulmaSonuc;

import repository.IlacRepository;

public class IlacArama extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdGiris;
	static long Id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlacArama frame = new IlacArama();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IlacArama() {
		setTitle("Eczane Otomasyonu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 300, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Aramapaneli = new JPanel();
		Aramapaneli.setBounds(0, 0, 274, 101);
		contentPane.add(Aramapaneli);
		Aramapaneli.setLayout(null);
		
		JLabel lblSerino = new JLabel("\u0130lac\u0131n Id'sini Girin:");
		lblSerino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSerino.setBounds(34, 30, 111, 19);
		Aramapaneli.add(lblSerino);
		
		textIdGiris = new JTextField();
		textIdGiris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textIdGiris.setBounds(155, 29, 97, 20);
		Aramapaneli.add(textIdGiris);
		textIdGiris.setColumns(10);
		
		JButton btnArama = new JButton("Ara");
		btnArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			     IlacRepository ilacRepository = new IlacRepository();
				 if (ilacRepository.list().size() == 0) {
						JOptionPane.showMessageDialog(null, "Depoda Ýlaç Bulunmamaktadýr.");
						setVisible(true);
					}
				 if (ilacRepository.list().size() >= 1) {
					 try {
							Id = Integer.parseInt(textIdGiris.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lütfen Karakter Ýçeren Id Girmeyiniz." + "\n");
							setVisible(true);
						}
					 ilacRepository.find(Id);
				}
				 close();
				IlacBulmaSonuc ilacBulmaSonuc = new IlacBulmaSonuc();
				ilacBulmaSonuc.setVisible(true);
			}

		});
		btnArama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArama.setBounds(78, 67, 111, 23);
		Aramapaneli.add(btnArama);
		
		JLabel lblIlacArama = new JLabel("\u0130la\u00E7 Aramak \u0130\u00E7in;");
		lblIlacArama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIlacArama.setBounds(78, 0, 111, 19);
		Aramapaneli.add(lblIlacArama);
		
		int EkranX, EkranY;
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Container c;
	        c = this.getContentPane();
	        EkranX = (int) kit.getScreenSize().width;
	        EkranY = (int) kit.getScreenSize().height;
	        this.setSize(280, 130);
	        this.setLocation((EkranX - 220) / 2, (EkranY - 265) / 2);
	        c.add(new JLabel("",SwingConstants.CENTER));
	        setVisible(true);
	}
	public void close(){
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}
