package tw.IDPanel;

import java.awt.Color;
import java.util.LinkedList;

public class Line {

	//屬性
	private Color color;
	private float width;
	private LinkedList<Point> line;
	//建構式初始化
	public Line(Color color, float width) {
		this.color = color;
		this.width = width;
		line = new LinkedList<>();
	}
	//方法
	public Color getColor() {
		return color;
	}
	public float getWidth() {
		return width;
	}
	
	public void addPoint(Point point) {
		line.add(point);
	}
	
	public Point getPoint(int index) {
		return line.get(index);
	}
	public int size() {
		return line.size();
	}
}
