package gui_System;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MoneyConverter extends JFrame {
    
    JLabel SystemTitle, AmountLabel, ConvFrom, ConvTo;
    JTextField AmountInput, ResultField;
    JButton Convertion;
    JComboBox<String> ConvertionFrom, ConvertionTo;

    
    final double USDtoPHP = 57.90; //USD to Peso
    final double PHPtoUSD = 1 / USDtoPHP;
    
    final double USDtoEuro = 0.95; //USD to Euro
    final double EurotoUSD = 1 / USDtoEuro;
    
    final double USDtoJapYen = 149.68; //USD to JapanYen
    final double JapYentoUSD = 1 / USDtoJapYen;
    
    final double USDtoGBP = 0.79; // USD to GBP UK  Dollars/
    final double GBPtoUSD = 1 / USDtoGBP;
    
    final double USDtoAUD = 1.57; //USD to Australian Dollars
    final double AUDtoUSD = 1 / USDtoAUD; 
    
    final double USDtoCAND = 1.42; //to Canada Dollars
    final double CANDtoUSD = 1 / USDtoCAND; 

    String[] Currencies = {"Select Currency", "USD", "PHP", "EUR", "JPY", "GBP", "AUD", "CAD"};    

    public MoneyConverter() {
        this.setTitle("MoneyConverter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);  
  
        SystemTitle = new JLabel("Currency Converter");
        SystemTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        SystemTitle.setBounds(80, 10, 300, 50);
        this.add(SystemTitle);
   
        AmountLabel = new JLabel("Amount:");
        AmountLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        AmountLabel.setBounds(30, 75, 100, 50);
        this.add(AmountLabel);

        AmountInput = new JTextField();
        AmountInput.setBounds(120, 88, 150, 25);
        this.add(AmountInput);
 
        ConvFrom = new JLabel("From:");
        ConvFrom.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ConvFrom.setBounds(30, 125, 100, 50);
        this.add(ConvFrom);
 
        ConvertionFrom = new JComboBox<>(Currencies);
        ConvertionFrom.setBounds(120, 137, 150, 25);
        this.add(ConvertionFrom);

        ConvTo = new JLabel("To:");
        ConvTo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ConvTo.setBounds(30, 175, 100, 50);
        this.add(ConvTo);

        ConvertionTo = new JComboBox<>(Currencies);
        ConvertionTo.setBounds(120, 188, 150, 25);
        this.add(ConvertionTo);
 
        Convertion = new JButton("Convert");
        Convertion.setBounds(120, 290, 100, 30);
        this.add(Convertion);
      
        ResultField = new JTextField();
        ResultField.setBounds(120, 245, 150, 25);
        ResultField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ResultField.setEditable(false); 
        this.add(ResultField);

        Convertion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        this.setVisible(true);
    }
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(AmountInput.getText());
            String fromCurrency = (String) ConvertionFrom.getSelectedItem();
            String toCurrency = (String) ConvertionTo.getSelectedItem();
            double convertedAmount = 0;

            if (fromCurrency.equals(toCurrency)) {
                JOptionPane.showMessageDialog(this, "Please select different currencies.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double usdAmount = amount; 
            
            switch (fromCurrency) {
                case "PHP": usdAmount = amount * PHPtoUSD; break;
                case "EUR": usdAmount = amount * EurotoUSD; break;
                case "JPY": usdAmount = amount * JapYentoUSD; break;
                case "GBP": usdAmount = amount * GBPtoUSD; break;
                case "AUD": usdAmount = amount * AUDtoUSD; break;
                case "CAD": usdAmount = amount * CANDtoUSD; break;
            }
            switch (toCurrency) {
                case "PHP": convertedAmount = usdAmount * USDtoPHP; break;
                case "EUR": convertedAmount = usdAmount * USDtoEuro; break;
                case "JPY": convertedAmount = usdAmount * USDtoJapYen; break;
                case "GBP": convertedAmount = usdAmount * USDtoGBP; break;
                case "AUD": convertedAmount = usdAmount * USDtoAUD; break;
                case "CAD": convertedAmount = usdAmount * USDtoCAND; break;
                case "USD": convertedAmount = usdAmount; break;
            }
            ResultField.setText(String.format("%.2f %s", convertedAmount, toCurrency));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
