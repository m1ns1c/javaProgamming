package test;

import java.util.*;

public class Dice {
    private int result; 
    private Random rand = new Random();

    public Dice() {
        result = 0;
    }

    public void roll() {
        result = rand.nextInt(6) + 1; 
    }

    public int getValue() {
        return result;
    }

    public void setValue(int value) {
        result = value;
    }
}