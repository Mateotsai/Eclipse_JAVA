package tw.mateo0805;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class lesson07_mouseListener  extends JFrame{

	public lesson07_mouseListener() {
		
		MyMouseListenerV2 mouseListener = new MyMouseListenerV2();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener); //都讓同一個lintener做就好
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
	new lesson07_mouseListener();
	}
}

//改用MouseAdapter，可以不用像第一版要把所有方法都全寫
class MyMouseListenerV2 extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed");
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(String.format("%d X %d", e.getX(), e.getY()));
	}
}

//class MyMouseListener implements MouseListener , MouseMotionListener{
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		System.out.println("Click");
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		System.out.println("Pressed");
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		System.out.println("Release");
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		System.out.println("Enter");
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		System.out.println("Exited");
//		
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		System.out.println("Dragged");
//		
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		System.out.println("Moved");
//		
//	}
//}