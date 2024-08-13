package tw.mateo0812;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.API.MyGame.GamePanel;
import tw.API.MyGame.GamePanelV2;

public class lesson07_MyGameV2 extends JFrame{
	private GamePanelV2 panel;
	
	public lesson07_MyGameV2() {
		setLayout(new BorderLayout());
		panel = new GamePanelV2();
		add(panel,BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new lesson07_MyGameV2();

	}

}
