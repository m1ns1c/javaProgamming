package test;

public class Circle extends Shape{

	private int radius;
	
	public Circle(int x, int y, String color, int radius) {
		super(x, y, color);
		this.radius = radius;
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
}
