package gui_System;

import java.awt.Font;

import javax.swing.*;
import javax.swing.JTextField;

public class MoneyConverter extends JFrame{
	
	JLabel SystemTitle, AmountLabel, ConvFrom, ConvTo;
	JTextField AmountInput;
	JButton Convertion;
	JComboBox ConvertionFrom, ConvertionTo;
	
	//Currency Values
	double PHP = 57.91;
	
	String Currencies [] = {"Select Currency" , "USD" , "PHP"};	
	public MoneyConverter() {
		this.setTitle("MoneyConverter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
		
		//============SystemTitle Inside Window===================
		SystemTitle = new JLabel("Currency Converter");
		SystemTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 27)); //SystemTitle FONT
		SystemTitle.setBounds(65,5,300,50);
		this.add(SystemTitle);
		
		//============AmountLabel Inside Window===================
		AmountLabel = new JLabel("Amount");
		AmountLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		AmountLabel.setBounds(25,75,100,50);
		this.add(AmountLabel);
		
		//============ConvFrom===================
		ConvFrom = new JLabel("From");
		ConvFrom.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		ConvFrom.setBounds(25,125,100,50);
		this.add(ConvFrom);
		
		
		
		//============ConvTo===================
		ConvTo = new JLabel("To");
		ConvTo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		ConvTo.setBounds(25,175,100,50);
		this.add(ConvTo);

		
		//===========Amount TextField=====================
		AmountInput = new JTextField();
		AmountInput.setBounds(95,88,150,25);
		this.add(AmountInput);
		
		
		ConvertionFrom = new JComboBox(Currencies);
		ConvertionFrom.setBounds(95,137,150,25);
		this.add(ConvertionFrom);
		
		ConvertionTo = new JComboBox(Currencies);
		ConvertionTo.setBounds(95,188,150,25);
		this.add(ConvertionTo);
		
		//==========ConvertBUtton==========
		Convertion = new JButton("Convert");
		Convertion.setBounds(95,245,100,25);
		this.add(Convertion);

		//JTextField Error automatically the error pop if the String is input
		AmountInput.addKeyListener(new KeyAdapter(){
			public void keyTyped(keyEvent e){
				if(!Character.isDigit(e.getKeyChar())){
					JOptionPane.showMessageDialog(null, "Error: Integers Only.", "String not allowed.", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
	}
}
