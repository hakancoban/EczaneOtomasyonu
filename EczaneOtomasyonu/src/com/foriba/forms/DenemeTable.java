package com.foriba.forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Ilac;
import repository.IlacRepository;

import java.awt.Font;

public class DenemeTable extends JFrame{

  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
               DenemeTable form=new DenemeTable();
               form.setVisible(true);;
           }
       });

  }

  //CONSTRUCTOR
  public DenemeTable()
  {
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200,200,800,337);
    setTitle("ProgrammingWizards Channel");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(70,80,600,200);
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

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    model.addColumn("SEÇ");
    model.addColumn("ÝLAÇ ID");
    model.addColumn("ÝLAÇ AD");
    model.addColumn("ÝLAÇ AÇIKLAMA");
    model.addColumn("ÝLAÇ FÝYAT");

    //THE ROW
    IlacRepository ilacRepository = new IlacRepository();
    for (int i = 0; i < ilacRepository.list().size(); i++) {
		Ilac ilac = ilacRepository.list().get(i);
		model.addRow(new Object[0]);
		model.setValueAt(false, i, 0);
		model.setValueAt(ilac.getIlacId(), i, 1);
		model.setValueAt(ilac.getIlacAd(), i, 2);
		model.setValueAt(ilac.getIlacAciklama(), i, 3);
		model.setValueAt(ilac.getIlacFiyat(), i, 4);
	}

    //OBTAIN SELECTED ROW
    JButton btnIlacCikar=new JButton("\u0130la\u00E7 \u00C7\u0131kar");
    btnIlacCikar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnIlacCikar.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  
    		 if ( ((Boolean) table.getValueAt(i, 0)).booleanValue()){
//            Boolean checked=Boolean.valueOf(table.getValueAt(i, 0).toString());
//            String col=table.getValueAt(i, 1).toString();
            ilacRepository.remove( (long) table.getValueAt(i, 1));
    		 
            //DISPLAY
//            if(checked)
//            {
//              JOptionPane.showMessageDialog(null, col);
//            }
    		 }
          }
          JOptionPane.showMessageDialog(null, "Ýlaç Çýkarýldý.");

    	  
        //GET SELECTED ROW
         
      }
    });

    //ADD BUTTON TO FORM
    btnIlacCikar.setBounds(20,30,130,30);
    getContentPane().add(btnIlacCikar);
  }

}