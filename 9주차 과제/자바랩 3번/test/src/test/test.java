package test;

import java.util.*;

interface Queue {
    int dequeue();
    void enqueue(int item);
    boolean isEmpty();
}

class MyQueue implements Queue {
    private int[] arr;
    private int front;
    private int back;
    private int size;

    MyQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        back = 0;
        size = 0;
    }
    
    public void enqueue(int item) {
        if (size == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[(front + i) % arr.length];
            }
            arr = newArr;
            front = 0;
            back = size;
        }
        arr[back] = item;
        back = (back + 1) % arr.length;
        size++;
    }

    public int dequeue() {
        int item = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return item;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

public class test {
    public static void main(String[] args) {
        Queue queue = new MyQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue()); 
        System.out.println(queue.isEmpty()); 
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); 
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty()); 
    }
}