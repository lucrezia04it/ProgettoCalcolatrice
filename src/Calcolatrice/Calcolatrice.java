package Calcolatrice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calcolatrice extends JFrame implements ActionListener { //JFrame crea la finestra

    private JTextField num1Field; // Campo di testo 
    private JTextField num2Field; // Campo di testo 
    private JTextField resultField; // Campo di testo risultato
    private JButton addButton, subtractButton, multiplyButton, divideButton; 

    public Calcolatrice() {
    setTitle("Calcolatrice con Due Campi"); // titolo

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // termina

    setLayout(new GridLayout(4, 2, 5, 5)); // griglia
    
    add(new JLabel("Primo Numero:"));
    num1Field = new JTextField(); // crea il campo
    add(num1Field); //lo rende visibile

    add(new JLabel("Secondo Numero:")); 
    num2Field = new JTextField(); 
    add(num2Field); 

    add(new JLabel("Risultato:"));
    resultField = new JTextField(); 
    resultField.setEditable(false);//non editabile 
    add(resultField); 
    
    addButton = new JButton("+"); 
    subtractButton = new JButton("-"); 
    multiplyButton = new JButton("*");
    divideButton = new JButton("/"); 
    
    addButton.addActionListener(this); //avvisa la classe
    subtractButton.addActionListener(this); 
    multiplyButton.addActionListener(this); 
    divideButton.addActionListener(this); 
    
    add(addButton); //rendiamo visibile i bottoni
    add(subtractButton);
    add(multiplyButton); 
    add(divideButton);
    
    setSize(300, 200); 
    setVisible(true);//finestra visibile
    }
    
    public void actionPerformed(ActionEvent e) {//Actionevent è un paramentro,"e" contiene informazioni sull'azione
    
    try {
        double num1 = Double.parseDouble(num1Field.getText()); 
        double num2 = Double.parseDouble(num2Field.getText());
        double result = 0; 
        
        if(e.getSource() == addButton) {
        	result = num1 + num2;
        }
        else if(e.getSource() == subtractButton) {
        	result = num1 - num2;
        }
        else if(e.getSource() == multiplyButton) {
        	result = num1 * num2;
        }
        else if(e.getSource() == divideButton) {
        	 if (num2 != 0) {
                 result = num1 / num2;
             } else {
                 resultField.setText("Errore: divisione per zero");
                 return;
             }
    }
        resultField.setText(String.valueOf(result)); 
        
 } catch (NumberFormatException ex) {
    resultField.setText("Errore: input non valido");
    }
    }
}