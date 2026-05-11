package test;

public class Triangle extends Shape{

	private int width;
	private int	height;
	
	public Triangle(int x, int y, String color, int width, int height) {
		super(x, y, color);
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return (width * height) / 2;
	}

}
