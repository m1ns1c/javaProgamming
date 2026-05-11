package test;

public class test {
    public static void main(String[] args) {

        Dog d1 = new Dog("Molly", 10, "brown");
        Dog d2 = new Dog("Daisy", 6, "black");
        Dog d3 = new Dog("Bella", 7, "white");

        System.out.printf("강아지 #1 = \"%s\", %d, \"%s\"\n", d1.getName(), d1.getAge(), d1.getColor());
        System.out.printf("강아지 #2 = \"%s\", %d, \"%s\"\n", d2.getName(), d2.getAge(), d2.getColor());
        System.out.printf("강아지 #3 = \"%s\", %d, \"%s\"\n", d3.getName(), d3.getAge(), d3.getColor());
        System.out.printf("현재까지 생성된 강아지의 수 = %d\n\n", Dog.count);

        Witch.younger(d1);
        Witch.younger(d2);
        Witch.younger(d3);

        System.out.printf("강아지 #1 = \"%s\", %d, \"%s\"\n", d1.getName(), d1.getAge(), d1.getColor());
        System.out.printf("강아지 #2 = \"%s\", %d, \"%s\"\n", d2.getName(), d2.getAge(), d2.getColor());
        System.out.printf("강아지 #3 = \"%s\", %d, \"%s\"\n", d3.getName(), d3.getAge(), d3.getColor());
    }
}