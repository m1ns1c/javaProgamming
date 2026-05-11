package test;

public class Counter {
    private int counter;

    public Counter(int value) {
        counter = value;
    }

    void up() {
        counter++;
    }
    
    void down() {
        counter--;
    }

    void reset() {
        counter = 0;
    }
    
    int getCount() {
        return counter;
    }
}