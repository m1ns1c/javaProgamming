package test;

public class Dog {
    private String name;
    private int age;
    private String color;

    static int count = 0; 

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        count++;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getColor() {
        return color;
    }
}