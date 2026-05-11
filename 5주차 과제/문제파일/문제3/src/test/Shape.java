package test;

public class Shape {
	
	protected int x;
	protected int y;
	protected String color;
	
	public Shape(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public double getArea() {
		System.out.println("아직 면적을 계산할 수 없습니다.");
		return 0;
	}
}
