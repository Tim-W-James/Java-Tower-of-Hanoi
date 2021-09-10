/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.NoSuchElementException;

/**
 * An implementation of the stack interface using singly-linked nodes.
 */
public class LinkedStack implements Stack {

    //create node to store stack data
    private class Node {

        public Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node top = null;

    //push a new value
    public void push(Object item) {
        top = new Node(item, top);
    }
    
    //push a new disc, ensuring it is not larger that previous disc
    public void pushDisc(Object item) {
        if (top == null) {
            top = new Node(item, top);
        } else if ((Integer) item < (Integer) peek()){
            top = new Node(item, top);
        } else {
            System.out.println("Disc "+item+" is too large");
        }
    }
    
    //fill stack with discs of ascending values of size
    public void fillWithDiscs(int size) {
        for (int temp = size; temp > 0; temp--) {
            pushDisc(temp);
        }
    }

    //pop top value
    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }

    //checks if empty
    public boolean isEmpty() {
        return top == null;
    }

    //returns top value
    public Object peek() {
        if (top == null) {
            return 0;
        } else {
            return top.data; 
        }
    }

    //returns length
    public int length() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    //copies stack to another stack
    public LinkedStack copy() {
        LinkedStack copyStack = new LinkedStack();
        LinkedStack copyStack2 = new LinkedStack();

        for (Node node = top; node != null; node = node.next) {
            copyStack.push(node.data);
        }

        for (Node node2 = copyStack.top; node2 != null; node2 = node2.next) {
            copyStack2.push(node2.data);
        }

        return copyStack2;
    }

    //clear stack
    public void clear() {
        top = null;
    }

    //returns a string of top disc
    public String getSingleDiscString() {

        String discString = "";
        int blankSpaces = 10 - (Integer) peek();
        int filledSpaces = (Integer) peek() + ((Integer) peek() - 1);

        for (int temp = blankSpaces; temp > 0; temp--) {
            discString = discString + "☐";
        }

        for (int temp = filledSpaces; temp > 0; temp--) {
            discString = discString + "⬛";
        }

        for (int temp = blankSpaces; temp > 0; temp--) {
            discString = discString + "☐";
        }

        return discString;
    }

    //returns string of all discs
    public String getTotalDiscString() {
        String discString = "<html>";
        LinkedStack copyStack = this.copy();
        int temp = 10 - this.length();
        boolean newLine = false;
        
        for (; temp > 0; temp--) {
            if (newLine == true){
                discString = discString + "<Br>";
            } else {
                newLine = true;
            }
            
            discString = discString + "☐☐☐☐☐☐☐☐☐☐☐☐☐☐☐☐☐☐☐";
        }
        
        for (temp = this.length(); temp > 0; temp--) {
            if (newLine == true){
                discString = discString + "<Br>";
            } else {
                newLine = true;
            }
            discString = discString + copyStack.getSingleDiscString();
            copyStack.pop();
        }
        
        return discString;
    }

    /* A full stack should appear as:
    ☐☐☐☐☐☐☐☐☐⬛☐☐☐☐☐☐☐☐☐
    ☐☐☐☐☐☐☐☐⬛⬛⬛☐☐☐☐☐☐☐☐
    ☐☐☐☐☐☐☐⬛⬛⬛⬛⬛☐☐☐☐☐☐☐
    ☐☐☐☐☐☐⬛⬛⬛⬛⬛⬛⬛☐☐☐☐☐☐
    ☐☐☐☐☐⬛⬛⬛⬛⬛⬛⬛⬛⬛☐☐☐☐☐
    ☐☐☐☐⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛☐☐☐☐
    ☐☐☐⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛☐☐☐
    ☐☐⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛☐☐
    ☐⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛☐
    ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛
    */
}
