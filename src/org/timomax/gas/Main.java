package org.timomax.gas;

public class Main {

	static RegistOv reg = new RegistOv();
	static LoginOv log = new LoginOv();
	static Start st = new Start();
	public static void main(String[] args){
		st.start();
		log.loginOv();
		reg.registOv();
	}
	
	public void Main(){
		st.start();
	}

}
