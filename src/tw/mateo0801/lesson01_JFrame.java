package tw.mateo0801;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class lesson01_JFrame extends JFrame{
	private JButton b1,b2,b3;
	
	
	//建構式
	public lesson01_JFrame() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
						
		setLayout(new FlowLayout());
		add(b1);add(b2);add(b3);
		
		
		//創造畫面視窗放在最後，元件先處理
		this.setSize(640,480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new lesson01_JFrame();
		

	}

}
