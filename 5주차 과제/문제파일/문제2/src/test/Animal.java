package test;

public class Animal {
	
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public void speak() {
        System.out.println("소리를 내지 않습니다.");
    }
}