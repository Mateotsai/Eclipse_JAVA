package tw.mateo0806;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;

//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JTextArea;

import tw.IDPanel.MyPanel;


public class MySign extends JFrame{
	
//	private static final long serialVersionUID = 1L;
	private MyPanel myPanel;
//	private JButton b1,b2,b3,b4; 
//	private JTextArea log;	
		
	
	public MySign() {
		super("簽名");
		
		myPanel = new MyPanel();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);
		
		
		
		
		
//		b1 = new JButton("重寫");
//		b2 = new JButton("重做");
//		b3 = new JButton("Save as JPG.");
//		b4 = new JButton("Sava as Obj.");
//		log = new JTextArea();

		
		this.setSize(800,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new MySign();

	}

}
