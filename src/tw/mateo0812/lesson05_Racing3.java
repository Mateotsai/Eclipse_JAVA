package tw.mateo0812;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class lesson05_Racing3 extends JFrame{
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private Random random = new Random();
	public lesson05_Racing3() {
		super("Racing");
		
		setLayout(new GridLayout(9,1));
		go = new JButton("GO!");	
		add(go);
		lanes = new JLabel[8];
		for(int i=0; i<lanes.length;i++) {
			lanes[i] = new JLabel(String.format("%d.",(i+1)));
			add(lanes[i]);
		}
		
		setSize(1024,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initGame();
	}

	private void initGame() {
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}
	
	private void go() {
		cars = new Car[8];
		for(int i =0; i<cars.length;i++) {
			cars[i] = new Car(i);
		}
		for(int i =0; i<cars.length;i++) {
			cars[i].start();
		}
	}
	
	private class Car extends Thread{
		private int lane;
		private StringBuffer path;
		private int speed;
		
		Car(int lane){
			this.lane = lane;
			path = new StringBuffer(String.format("%d.",(lane+1)));
			this.speed = random.nextInt(601)+100;
		}
		
			@Override
			public void run() {
			for(int i=0; i<100; i++) {
				path.append("ε=ε=┌(；´ﾟｪﾟ)┘");
				lanes[lane].setText(path.toString());
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
				}
			}
		}	
	}

	public static void main(String[] args) {
		new lesson05_Racing3();
	}

}