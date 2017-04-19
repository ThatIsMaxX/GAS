package org.timomax.gas;
	import java.awt.Toolkit;

import javax.swing.*;

public class Start {
	public void start(){
		JFrame jf = new JFrame();
		jf.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); 
		jf.setVisible(true);
		jf.setResizable(false);
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jf.add(jp);
		
		JButton jb = new JButton("Login");
		jb.setSize(jf.getWidth()/4, jf.getHeight()/4);
		jb.setBounds(jf.getWidth()/4+jb.getWidth()/2, jf.getHeight()/4-jb.getHeight()/2, jf.getWidth()/4, jf.getHeight()/4);
		jp.add(jb);
		
		JButton jb1 = new JButton("Regist");
		jb1.setSize(jf.getWidth()/4, jf.getHeight()/4);
		jb1.setBounds(jf.getWidth()/2-jb.getWidth()/2, jf.getHeight()/2-jb.getHeight()/2, jf.getWidth()/4, jf.getHeight()/4);
		jp.add(jb1);
	}
}
