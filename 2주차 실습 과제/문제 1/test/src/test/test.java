package test;

import java.util.*;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> toDoList = new ArrayList<>();
		int num, i, delNum;
		String addList;
		while(true) {
			System.out.println("ToDo 리스트");
			System.out.println("1. 할 일 추가");
			System.out.println("2. 완료된 항목 체크");
			System.out.println("3. 목록 보기");
			System.out.println("4. 종료");
			System.out.printf("메뉴를 선택하세요: ");
			num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1:
				System.out.printf("할 일을 입력하세요: ");
				addList = sc.nextLine();
				toDoList.add(addList);
				System.out.println("할 일이 추가되었습니다.");
				break;
			case 2:
				i = 1;
				for(String s : toDoList) {
					System.out.printf("%d. %s\n", i, s);
					i++;
				}
				System.out.printf("완료한 항목 번호를 입력해주세요: ");
				delNum = sc.nextInt();
				toDoList.remove(delNum - 1);
				System.out.println("삭제되었습니다.");
				break;
			case 3:
				System.out.println("ToDo 리스트:");
				i = 1;
				for(String s : toDoList) {
					System.out.printf("%d. %s\n", i, s);
					i++;
				}
				break;
			case 4:
				System.out.println("프로그램이 종료되었습니다.");
				return;
			}
		}
	}
}