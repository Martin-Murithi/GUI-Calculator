import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class textField implements ActionListener{
	JTextField field;
	JFrame frame;
	JLabel label;
	JButton button;
	public textField() {
		frame = new JFrame();
		field = new JTextField(30);
		label = new JLabel();
		button = new JButton();
		
		button.setBackground(Color.green);
		button.setForeground(Color.black);
		button.setBounds(50,14,80,40);
		button.setText("Submit");
		button.setFocusable(false);
		button.addActionListener(this);
		
		label.setBounds(90,70,200,50);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.GREEN);
		label.setOpaque(true);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		field.setBounds(150, 20, 180, 30);
		field.setBackground(Color.black);
		field.setCaretColor(Color.GREEN);
		field.setForeground(Color.GREEN);
		field.setFont(new Font("Verdana", Font.PLAIN, 15));
		field.setText("Enter Name :");
		
		frame.setBounds(120,100,350,180);
		frame.setVisible(true);
		frame.setTitle("TEXTFIELD");
		frame.setLayout(null);
		frame.add(field);
		frame.add(label);
		frame.add(button);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			label.setText(field.getText());
			field.setText("");
		}
		
	}
}
