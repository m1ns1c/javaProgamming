package test;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    public void speak() {
        System.out.println("멍멍! 라고 짖습니다.");
    }

}