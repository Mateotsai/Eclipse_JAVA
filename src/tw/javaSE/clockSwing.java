package tw.javaSE;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class clockSwing extends JPanel {
    private int size;
    
    public clockSwing() {
    	setPreferredSize(new Dimension(400,400));
    }
  

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 設置抗鋸齒analog

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //計算時鐘大小和位置
        size = Math.min(getWidth(),getHeight()) -40;
        int xCenter = getWidth() /2;
        int yCenter = getHeight() / 2;
        
        // 繪製時鐘面
        g2d.setColor(Color.WHITE);
        g2d.fillOval(xCenter - size/2, yCenter - size/2, size, size);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(xCenter - size/2, yCenter - size/2, size, size);

        // 繪製數字
        drawNumbers(g2d,xCenter,yCenter);
        
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
        drawHand(g2d, hourAngle, size * 0.3, 10, Color.BLACK, xCenter, yCenter);
        drawHand(g2d, minuteAngle, size * 0.38, 6,Color.BLUE, xCenter, yCenter);
        drawHand(g2d, secondAngle, size * 0.45, 3,Color.RED, xCenter, yCenter);

        //繪製中心點
        g2d.setColor(Color.BLACK);
        g2d.fillOval(xCenter -5, yCenter -5, 10, 10);
    }
    
    private void drawHand(Graphics2D g2d, double angle, double length, float thickness, Color color, int xCenter, int yCenter) {
        int endX = xCenter + (int) (length * Math.cos(angle));
        int endY = yCenter + (int) (length * Math.sin(angle));
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(xCenter, yCenter, endX, endY);
    }

    private void drawNumbers(Graphics2D g2d, int xCenter, int yCenter) {
        g2d.setFont(new Font("Arial", Font.BOLD, size / 15));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30 - 90);
            int x = (int) (xCenter + size * 0.4 * Math.cos(angle));
            int y = (int) (yCenter + size * 0.4 * Math.sin(angle));
            String number = Integer.toString(i);
            FontMetrics fm = g2d.getFontMetrics();
            int w = fm.stringWidth(number);
            int h = fm.getAscent();
            g2d.drawString(number, x - w/2, y + h/2);
        }
    }
    
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        clockSwing clock = new clockSwing();
        frame.add(clock);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 創建一個計時器來每16毫秒更新一次（約60 FPS）
        Timer timer = new Timer(16, e -> clock.repaint());
        timer.start();
    }
}