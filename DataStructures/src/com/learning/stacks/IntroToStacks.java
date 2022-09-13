package com.learning.stacks;

public class IntroToStacks {

    final int MAX_SIZE = 5;
    int top = -1;
    int stack[] = new int[MAX_SIZE];

    public static void main(String[] args) {
        IntroToStacks newStack = new IntroToStacks();
        newStack.push(4);
        newStack.push(2);
        newStack.push(6);
        newStack.push(1);
        newStack.push(9);
        newStack.printStackElements();
        int poppedElement = newStack.pop();
        System.out.println(poppedElement + " popped from the stack!");
        newStack.printStackElements();
    }

    public boolean push(int newValue) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow occurred!");
            return false;
        }
        ++top;
        stack[top] = newValue;
        System.out.println(newValue + " pushed into the stack!");
        return true;
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack underflow occurred!");
            return 0;
        }
        int removedValue = stack[top];
        --top;
        return removedValue;
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack underflow occurred!");
            return 0;
        }
        int topValue = stack[top];
        return topValue;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void printStackElements() {
        System.out.println("Elements in the stack from the top are ... :- ");
        for (int i = top; i > -1; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
