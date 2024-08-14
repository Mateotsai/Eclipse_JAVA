package tw.javaSE;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class clockSwing extends JPanel {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 480;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 設置抗鋸齒
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 繪製時鐘面
        g2d.setColor(Color.WHITE);
        g2d.fillOval(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(0, 0, WIDTH, HEIGHT);

        // 獲取當前時間
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int millisecond = now.getNano() / 1_000_000;

        // 計算指針角度
        double secondAngle = Math.toRadians((second + millisecond / 1000.0) * 6 - 90);
        double minuteAngle = Math.toRadians((minute + (second + millisecond / 1000.0) / 60.0) * 6 - 90);
        double hourAngle = Math.toRadians((hour % 12 + (minute + (second + millisecond / 1000.0) / 60.0) / 60.0) * 30 - 90);

        // 繪製指針
        drawHand(g2d, hourAngle, 130, Color.BLACK);
        drawHand(g2d, minuteAngle, 170, Color.BLUE);
        drawHand(g2d, secondAngle, 220, Color.RED);
    }

    private void drawHand(Graphics2D g2d, double angle, int length, Color color) {
        int centerX = WIDTH  / 2;
        int centerY = HEIGHT / 2;
        int endX = centerX + (int) (length * Math.cos(angle));
        int endY = centerY + (int) (length * Math.sin(angle));
        g2d.setColor(color);
        g2d.drawLine(centerX, centerY, endX, endY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        clockSwing clock = new clockSwing();
        frame.add(clock);
        frame.setSize(WIDTH*7/6, HEIGHT*7/6);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 創建一個計時器來每16毫秒更新一次（約60 FPS）
        Timer timer = new Timer(16, e -> clock.repaint());
        timer.start();
    }
}