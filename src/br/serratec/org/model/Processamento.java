package br.serratec.org.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Processamento {
	
	public void processarFolha() {
	ImageIcon icon = new ImageIcon("img/dp.png");
	JOptionPane pane = new JOptionPane ("   Processando folha de pagamento, aguarde...  ");
    JDialog dialog = pane.createDialog(null, "TI GÓDX - Departamento Pessoal");


              Timer timer = new Timer(3000, 
                       new ActionListener() {
                              public void actionPerformed(ActionEvent evt) {
                                        dialog.dispose();
                              }
                       });

              timer.setRepeats(false);
              timer.start();
              dialog.show();
              timer.stop();
    }
}

