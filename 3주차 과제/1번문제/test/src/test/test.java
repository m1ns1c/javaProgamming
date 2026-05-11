package test;

import java.util.*;
	
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Counter c = new Counter(0);

	    System.out.println("객체 생성 후 Counter value: " + c.getCount());
	    c.up();
	    System.out.println("up() 호출 후 Counter value: " + c.getCount());
	    c.up();
	    System.out.println("up() 호출 후 Counter value: " + c.getCount());
	    c.down();
	    System.out.println("down() 호출 후 Counter value: " + c.getCount());
		
	}
}