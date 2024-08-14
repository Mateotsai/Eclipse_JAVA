package tw.javaSE;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class clock {

	public static void main(String[] args) {

		while (true) {
			LocalTime now = LocalTime.now();
			int hour = now.getHour();
			int minute = now.getMinute();
			int second = now.getSecond();
			
			// 計算指針角度
			double secondAngle = second * 6; // 每秒6度
			double minuteAngle = (minute + second / 60.0) * 6; // 每分鐘6度
			double hourAngle = (hour % 12 + minute / 60.0) * 30; // 每小時30度

			// 顯示時鐘
			System.out.printf("時間: %02d:%02d:%02d\n", hour, minute, second);
			System.out.printf("時針: %.1f度\n", hourAngle);
			System.out.printf("分針: %.1f度\n", minuteAngle);
			System.out.printf("秒針: %.1f度\n", secondAngle);
			System.out.println("--------------------");

			try {
				TimeUnit.SECONDS.sleep(1); // 每秒更新一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 清除控制台（注意：這在某些環境中可能不起作用）
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	}

}
