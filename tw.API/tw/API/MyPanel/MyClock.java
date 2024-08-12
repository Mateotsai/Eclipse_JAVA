package tw.API.MyPanel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	
	public MyClock() {
		timer =new Timer();
		timer.schedule(new MyTask(), 0, 100);
		
	}
	
	private class MyTask extends TimerTask{
		@Override
		public void run() {
			SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
			
			setText(adf.format(new Date()));
		}
	}
	

}
