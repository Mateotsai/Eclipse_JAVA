package tw.mateo0812;

import java.util.Timer;
import java.util.TimerTask;

public class lesson06_timer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 0, 1*1000);
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("Main");
	}
}

class MyTask extends TimerTask{
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
		//不設定i++甚麼時候結束，之後透過timer取消
	}
}
class StopTask extends TimerTask{
	private Timer timer;
	public StopTask(Timer timer){
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.purge();
		timer.cancel();
		timer = null;
	}
}