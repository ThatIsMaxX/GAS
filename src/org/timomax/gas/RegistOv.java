package org.timomax.gas;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistOv {
	public void registOv(){
		JFrame jf = new JFrame();
		jf.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); 
		jf.setVisible(true);
		jf.setResizable(false);
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jf.add(jp);
		
		JButton jb = new JButton("Registrieren");
		jb.setSize(jf.getWidth()/4, jf.getHeight()/4);
		jb.setBounds(jf.getWidth()/4+jb.getWidth()/2, jf.getHeight()/4-jb.getHeight()/2, jf.getWidth()/4, jf.getHeight()/4);
		jp.add(jb);
		
		JTextField name = new JTextField("Username:");
		name.setSize(jf.getWidth()/4, jf.getHeight()/16);
		name.setBounds(jf.getWidth()/2-name.getWidth()/2, jf.getHeight()/2-name.getHeight()/2, jf.getWidth()/4, jf.getHeight()/16);
		jp.add(name);
		
		JTextField email = new JTextField("Password:");
		email.setSize(jf.getWidth()/4, jf.getHeight()/16);
		email.setBounds(jf.getWidth()/2-email.getWidth()/2, jf.getHeight()/2+(((jf.getHeight()/2)/2)/2)/2-email.getHeight()/2, jf.getWidth()/4, jf.getHeight()/16);
		jp.add(email);
		
		JTextField pw = new JTextField("Password:");
		pw.setSize(jf.getWidth()/4, jf.getHeight()/16);
		pw.setBounds(jf.getWidth()/2-pw.getWidth()/2, jf.getHeight()/2+((jf.getHeight()/2)/2)/2-pw.getHeight()/2, jf.getWidth()/4, jf.getHeight()/16);
		jp.add(pw);
	}
}
