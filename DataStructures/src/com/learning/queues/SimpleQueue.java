package com.learning.queues;

public class SimpleQueue {

    static private int front, rear, capacity;
    static private int queue[];


    SimpleQueue(int capacity) {
        front = 0;
        rear = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    //function to insert an element -> REAR
    static void enqueue(int data) {
        if (capacity == rear) {
            System.out.println("\nQueue is full!\n");
            return;
        } else {
            queue[rear] = data;
            rear++;
        }
        return;
    }

    //function to delete an element -> FRONT
    static int dequeue() {
        if (front == rear) {
            System.out.println("\nQueue is empty!\n");
            return -1;
        }

        int removedElement = queue[front];

        //shift all the elements
        for (int i = front; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        if (rear < capacity) {
            queue[rear] = 0;
        }
        rear--;
        return removedElement;
    }

    static void display() {

        int i;
        if (front == rear) {
            System.out.println("\nQueue is empty!\n");
            return;
        }

        for (int j = front; j < rear; j++) {
            System.out.print(queue[j] + " ");
        }
        return;

    }

}
