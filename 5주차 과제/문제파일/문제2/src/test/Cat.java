package test;

public class Cat extends Animal {
	
	private String color;
	
	public Cat(String name, int age, String color) {
		super(name, age);
		this.color = color;
	}
	
	public void speak() {
		System.out.println("야옹~ 이라고 울어대고 있습니다.");
	}
}
