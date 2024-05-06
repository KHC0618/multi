package com.multi.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight {
	
	private static JFrame f;
	
	public static void main(String[] args) {
		
		f=new JFrame("Traffic Light");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,1000);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		f.getContentPane().setBackground(null);
		
		JButton b1=new JButton("red");
		JButton b2=new JButton("yellow");
		JButton b3=new JButton("blue");
		
		b1.setBackground(Color.red);
		b1.setFont(new Font("궁서",Font.BOLD, 50));
		b1.setSize(250,200);
		
		b2.setBackground(Color.yellow);
		
		b2.setFont(new Font("궁서",Font.BOLD, 50));
		b3.setBackground(Color.green);
	
		b3.setFont(new Font("궁서",Font.BOLD, 50));
		
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
	
		f.setVisible(true);
		
		
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String color=e.getActionCommand();
				btnEvent(color);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String color=e.getActionCommand();
				btnEvent(color);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String color=e.getActionCommand();
				btnEvent(color);
			}
		});
		
		
	}
	
	public static void btnEvent(String color) {
		JLabel j1=new JLabel("");
		ImageIcon icon1= new ImageIcon("src/com/multi/homework/img/"+color+".jpg");
		Image img1= icon1.getImage();
		Image chImg1= img1.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		ImageIcon chIcon1= new ImageIcon(chImg1);
		j1.setIcon(chIcon1);
		f.add(j1);
		f.setVisible(true);
		
	}



}
