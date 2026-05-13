package math;

import java.util.*;

public class Calculator {
	public double calculator(double a, double b, String sign) {
		if(sign.equals("+")) {
    		return a + b;
    	}
    	else if(sign.equals("-")) {
    		return a - b;
    	}
    	else if(sign.equals("*")) {
    		return a * b;
    	}
    	else if(sign.equals("/")) {
    		if(a == 0 || b == 0) {
    			return 0;
    		}
    		return a - b;
    	}
    	else {
    		System.out.println("잘못 입력하였습니다.");
    	}
		return 0;
	}
		
}
