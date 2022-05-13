package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.source.tree.Tree;

import Config.Config;

import Utils.UpdateThread;
import Utils.World;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class MainJFrame extends JFrame implements Config{

	public static PlayPanel playPanel;
	private JTextField textField;
	/**
	 * Launch the application.
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Exception{
				try {
					if(SIZE < 3) {
						throw new Exception("SIZE is too small");
					}
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, length+25+sideLength, Height+50);
		getContentPane().setLayout(null);
		playPanel = new PlayPanel();
		playPanel.setBounds(5, 5, length, Height);
		getContentPane().add(playPanel);
		
		UpdateThread updateThread = new UpdateThread(playPanel);
		
		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 25));
		btnNewButton_1.setBounds(879, 296, 179, 78);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//string to int
				World.newWorld(Integer.parseInt(textField.getText()));
				updateThread.setIsContinue(1);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 25));
		btnNewButton_2.setBounds(879, 537, 179, 78);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bstr = btnNewButton_2.getText();
				if(bstr.equals("Stop")) {
					updateThread.setIsContinue(0);
					btnNewButton_2.setText("Continue");
				}else {
					updateThread.setIsContinue(1);
					btnNewButton_2.setText("Stop");
				}
			}
		});
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("����", Font.PLAIN, 22));
		textField.setText("0");
		textField.setBounds(957, 51, 101, 66);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u53C2\u6570");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(879, 52, 68, 65);
		getContentPane().add(lblNewLabel);
		
		updateThread.start();
	}
}
