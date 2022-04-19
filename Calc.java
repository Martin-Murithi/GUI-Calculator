import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc implements ActionListener {
	private JFrame myFrame;
	private JPanel myPanel;
	private JTextField myField;
	private JLabel myLabel;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[10];
	private JButton add,minus,multiply,divide,equals,Clr,Del,decimal,leftBracket,rightBracket;
	
	private double num1 = 0;
	private double num2 = 0;
	private double results = 0;
	private char operator;
	private  int i;
	private int j;
	public Calc() {
		myFrame = new JFrame();
		myPanel = new JPanel();
		myField = new JTextField(30);
		
		
		myField.setBackground(Color.black);
		myField.setForeground(Color.green);
		myField.setFont(new Font("Verdana", Font.PLAIN,21));
		myField.setBounds(0,0,315,43);
		myField.setCaretColor(Color.green);
		myField.setBorder(null);
		myField.setHorizontalAlignment(JTextField.RIGHT);
	
		numberButtons[0] = new JButton("0"); 
		numberButtons[1] = new JButton("1"); 
		numberButtons[2] = new JButton("2"); 
		numberButtons[3] = new JButton("3"); 
		numberButtons[4] = new JButton("4"); 
		numberButtons[5] = new JButton("5"); 
		numberButtons[6] = new JButton("6"); 
		numberButtons[7] = new JButton("7"); 
		numberButtons[8] = new JButton("8"); 
		numberButtons[9] = new JButton("9"); 
		for(i = 0;i < 10; i++) {
			numberButtons[i].setBackground(Color.BLACK);
			numberButtons[i].setFont(new Font("Verdana", Font.PLAIN, 16));
			numberButtons[i].setForeground(Color.GREEN);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBorder(null);
			numberButtons[i].addActionListener(this);
		}
		add = new JButton("+");
		minus = new JButton("-");
		divide = new JButton("/");
		multiply = new JButton("*");
		equals = new JButton("=");
		Clr = new JButton("clr");
		Del = new JButton("del");
		leftBracket = new JButton("(");
		rightBracket = new JButton(")");
		decimal = new JButton(".");
		
		functionButtons[0] = add;
		functionButtons[1] = minus;
		functionButtons[2] = divide;
		functionButtons[3] = multiply;
		functionButtons[4] = equals;
		functionButtons[5] = Clr;
		functionButtons[6] = Del;
		functionButtons[7] = leftBracket;
		functionButtons[8] = rightBracket;
		functionButtons[9] = decimal;

		for(j = 0; j < 10; j++) {
			functionButtons[j].setBackground(Color.BLACK);
			functionButtons[j].setFont(new Font("Verdana", Font.PLAIN, 21));
			functionButtons[j].setForeground(Color.GREEN);
			functionButtons[j].setFocusable(false);
			functionButtons[j].setBorder(null);
			functionButtons[j].addActionListener(this);
		}
		
		
		
		myLabel = new JLabel();
		myLabel.setBackground(Color.BLACK);
		myLabel.setForeground(Color.GREEN);
		myLabel.setBounds(0,42,315,38);
		myLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		myLabel.setHorizontalAlignment(JLabel.RIGHT);
		myLabel.setOpaque(true);
		
		myPanel.setBackground(Color.BLACK);
		myPanel.setSize(315,350);
		myPanel.setLocation(0, 80);
		myPanel.setLayout(new GridLayout(5,4));
		
		myPanel.add(numberButtons[0]);
		myPanel.add(numberButtons[1]);
		myPanel.add(numberButtons[2]);
		myPanel.add(numberButtons[3]);
		myPanel.add(numberButtons[4]);
		myPanel.add(numberButtons[5]);
		myPanel.add(numberButtons[6]);
		myPanel.add(numberButtons[7]);
		myPanel.add(numberButtons[8]);
		myPanel.add(numberButtons[9]);
		
		myPanel.add(functionButtons[0]);
		myPanel.add(functionButtons[1]);
		myPanel.add(functionButtons[2]);
		myPanel.add(functionButtons[3]);
		myPanel.add(functionButtons[4]);
		myPanel.add(functionButtons[5]);
		myPanel.add(functionButtons[6]);
		myPanel.add(functionButtons[7]);
		myPanel.add(functionButtons[8]);
		myPanel.add(functionButtons[9]);
		
		
		myFrame.setVisible(true);	
		myFrame.setLayout(null);
		myFrame.setSize(330, 460);
		myFrame.setTitle("CALCULATOR");
		myFrame.add(myField);
		myFrame.add(myLabel);
		myFrame.add(myPanel);
		myFrame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int k;
			for( k = 0; k < 10; k++) {
				if(e.getSource() == numberButtons[k]) {
					myField.setText(myField.getText().concat(String.valueOf(k)));
				}	
			}
			
			if(e.getSource() == decimal) {
				myField.setText(myField.getText().concat("."));
			}
			if(e.getSource() == leftBracket) {
				myField.setText(myField.getText().concat("("));
			}
			if(e.getSource() == rightBracket) {
				myField.setText(myField.getText().concat(")"));
			}
			if(e.getSource() == add) {
				num1 = Double.parseDouble(myField.getText());
				operator = '+';
				myField.setText("");
			}
			if(e.getSource() == minus) {
				num1 = Double.parseDouble(myField.getText());
				operator = '-';
				myField.setText("");
			}
			if(e.getSource() == divide) {
				num1 = Double.parseDouble(myField.getText());
				operator = '/';
				myField.setText("");
			}
			if(e.getSource() == multiply) {
				num1 = Double.parseDouble(myField.getText());
				operator = '*';
				myField.setText("");
			}
			if(e.getSource() == equals) {
				num2 = Double.parseDouble(myField.getText());
				switch(operator) {
				case '+':
					results = num1 + num2;
					myField.setText(num1+ "+"+ num2);
					break;
				case '-':
					results = num1 - num2;
					myField.setText(num1+ "-"+ num2);
					break;
				case '/':
					results = num1 / num2;
					myField.setText(num1+ "/"+ num2);
					break;
				case '*':
					results = num1 * num2;
					myField.setText(num1+ "*"+ num2);
					break;
				}
				myLabel.setText(String.valueOf(results));
			}
			if(e.getSource() == Del) {
				
				int length = myField.getText().length();
				int nLength = myField.getText().length() - 1;
				String newLength;
				if(length > 0) {
				StringBuilder sb = new StringBuilder(myField.getText());
				sb.deleteCharAt(nLength);
				newLength = sb.toString();
				myField.setText(newLength);
				
				}
			}
			if(e.getSource() == Clr) {
				myField.setText("");
				myLabel.setText("");
			}	
	}
}
		

