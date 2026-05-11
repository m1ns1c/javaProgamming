package test;

import java.util.*;
	
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        Account acc = new Account("주민식", 0);

        while (true) {
            System.out.println("==== 은행 계좌 시스템 ====");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 잔액 조회");
            System.out.println("4. 종료");
            System.out.print("기능을 선택하세요: ");

            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("입금 금액: ");
                double money = sc.nextDouble();
                acc.deposit(money);

            } else if (menu == 2) {
                System.out.print("출금 금액: ");
                double money = sc.nextDouble();
                acc.withdraw(money);

            } else if (menu == 3) {
                System.out.println("현재 잔액: " + acc.getBalance());

            } else if (menu == 4) {
                System.out.println("종료합니다.");
                break;
            }
        }
        sc.close();
	}
}