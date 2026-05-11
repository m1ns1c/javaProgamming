package test;

public class test {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int aiRand;
		boolean b;

		for(int i = 0; i < 6; i++) {
			aiRand = (int)(Math.random() * 45) + 1;
			b = false;
			
			for(int j = 0; j < i; j++) {   
				if(lotto[j] == aiRand) {
					b = true;
					break;
				}
			}
			
			if(b) {
				i--;   
				continue;
			}
			lotto[i] = aiRand;
		}
		
		System.out.println("로또 번호 생성기");
		System.out.print("선택된 번호: ");
		for(int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}
	}
}