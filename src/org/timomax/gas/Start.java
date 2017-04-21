package org.timomax.gas;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Start implements ActionListener{
	
	public void start(){
		JFrame jf = new JFrame();
		jf.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); 
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jf.add(jp);
		
		JButton jb = new JButton("Login");
		jb.setSize(jf.getWidth()/4, jf.getHeight()/4);
		jb.setBounds(jf.getWidth()/4+jb.getWidth()/2, jf.getHeight()/4-jb.getHeight()/2, jf.getWidth()/4, jf.getHeight()/4);
		jp.add(jb);
		jb.addActionListener(this);
		jb.setActionCommand("login");
		
		JButton jb1 = new JButton("Regist");
		jb1.setSize(jf.getWidth()/4, jf.getHeight()/4);
		jb1.setBounds(jf.getWidth()/2-jb.getWidth()/2, jf.getHeight()/2-jb.getHeight()/2, jf.getWidth()/4, jf.getHeight()/4);
		jp.add(jb1);
		jb1.addActionListener(this);
		jb1.setActionCommand("register");
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			LoginOv log = new LoginOv();	
		}	
		if(e.getActionCommand().equals("register")){
			RegistOv reg = new RegistOv();
		}
	}
}


