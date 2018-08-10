package com.foriba.forms;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entity.Ilac;
import repository.IlacRepository;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class IlacListeleme extends JFrame{

	private static final long serialVersionUID = 1L;

//MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
               IlacListeleme form=new IlacListeleme();
               form.setVisible(true);;
           }
       });

  }

  //CONSTRUCTOR
  public IlacListeleme()
  {
    //the form
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setResizable(false);
    setBounds(200,200,800,330);
    setTitle("Eczane Otomasyonu");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(100,47,600,200);
    getContentPane().add(scroll);

    //THE TABLE
    final JTable table=new JTable();
    scroll.setViewportView(table);

    //THE MODEL OF OUR TABLE
    DefaultTableModel model=new DefaultTableModel()
    {
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
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

    IlacRepository ilacRepository=new IlacRepository();
    
//  //ASSIGN THE MODEL TO TABLE
  table.setModel(model);
  
  model.addColumn("Seç");
  model.addColumn("ID");
  model.addColumn("Ýlaç Ad");
  model.addColumn("Ýlaç Açýklama");
  model.addColumn("Ýlaç Fiyat");

//  //THE ROW
  for(int i=0;i<ilacRepository.list().size();i++){
    Ilac ilac=ilacRepository.list().get(i);
    model.addRow(new Object[0]);
    model.setValueAt(false,i,0);
    model.setValueAt(ilac.getIlacId(), i, 1);
    model.setValueAt(ilac.getIlacAd(), i, 2);
    model.setValueAt(ilac.getIlacAciklama(), i, 3);
    model.setValueAt(ilac.getIlacFiyat(), i, 4);
  }
    
    int EkranX, EkranY;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Container c;
        c = this.getContentPane();
        EkranX = (int) kit.getScreenSize().width;
        EkranY = (int) kit.getScreenSize().height;
        this.setSize(800, 295);
        this.setLocation((EkranX - 800) / 2, (EkranY - 400) / 2);
        c.add(new JLabel("TurkishCode.com",SwingConstants.CENTER));
        
        JLabel lblYazi = new JLabel("\u0130la\u00E7 Listesi");
        lblYazi.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblYazi.setBounds(348, 11, 102, 25);
        getContentPane().add(lblYazi);
        setVisible(true);
  }
  public void close(){
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}