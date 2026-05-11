package test;

import java.util.*;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		float n1, n2, result;

		System.out.printf("연산을 입력하세요: ");
		s  = sc.next();

		System.out.printf("피연산자 2개를 입력하세요: ");
		n1 = sc.nextFloat();
		n2 = sc.nextFloat();

		if(s.equals("+")) {
			result = n1 + n2;
			System.out.printf("%.1f + %.1f = %.1f", n1, n2, result);
		} 
		else if(s.equals("-")) {
			result = n1 - n2;
			System.out.printf("%.1f - %.1f = %.1f", n1, n2, result);
		} 
		else if(s.equals("*")) {
			result = n1 * n2;
			System.out.printf("%.1f * %.1f = %.1f", n1, n2, result);
		} 
		else if(s.equals("/")){
			if (n2 != 0.0f) {
				result = n1 / n2;
				System.out.printf("%.1f / %.1f = %.1f", n1, n2, result);
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		} 
		else {
			System.out.println("잘못 입력하였습니다.");
		}
	}
}