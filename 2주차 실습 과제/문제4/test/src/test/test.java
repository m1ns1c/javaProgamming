package test;

import java.util.*;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		while(true) {

			char board[][] = new char[5][5];
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					board[i][j] = '-';
				}
			}

			System.out.println("그림 그리기 프로그램");
			System.out.println("1. 직선 그리기");
			System.out.println("2. 직사각형 그리기");
			System.out.print("원하는 그림을 선택하세요 (1-2, 종료: 0): ");
			n = sc.nextInt();

			int x1, y1, x2, y2;

			System.out.print("첫 번째 점의 좌표: ");
			x1 = sc.nextInt();
			y1 = sc.nextInt();

			System.out.print("두 번째 점의 좌표: ");
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			if(n == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if(n == 1) {
				int bx = (x2 > x1) ? 1 : -1;
				int by = (y2 > y1) ? 1 : -1;

				int x = x1;
				int y = y1;

				while(true) {
					board[x][y] = '*';
					if(x == x2 && y == y2) break;
					x += bx;
					y += by;
				}
			}
			else if(n == 2) {

				for(int i = x1; i <= x2; i++) {
					for(int j = y1; j <= y2; j++) {
						if(i == x1 || i == x2 || j == y1 || j == y2) {
							board[i][j] = '*';
						}
					}
				}
			}
			else {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}