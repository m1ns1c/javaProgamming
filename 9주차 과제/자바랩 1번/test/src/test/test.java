package test;

import java.util.*;

interface Animal {
	void makeSound();
}

class Dog implements Animal {
	public void makeSound() { System.out.println("멍멍!"); }
}

class Cat implements Animal {
	public void makeSound() { System.out.println("야옹~"); }
}

class Bird implements Animal {
	public void makeSound() { System.out.println("짹짹!"); }
}

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Animal dog = new Dog();
        dog.makeSound();
        
        Animal cat = new Cat();
        cat.makeSound();
        
        Animal bird = new Bird();
        bird.makeSound();
        
    }
}