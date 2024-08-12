package tw.mateo0812;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.API.MyGame.GamePanel;

public class lesson07_MyGame extends JFrame{
	private GamePanel panel;
	
	public lesson07_MyGame() {
		setLayout(new BorderLayout());
		panel = new GamePanel();
		add(panel,BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new lesson07_MyGame();

	}

}
