/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import javax.swing.JOptionPane;

/**
 *
 * @author timja
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //creates three stacks
        LinkedStack StackA = new LinkedStack();
        LinkedStack StackB = new LinkedStack();
        LinkedStack StackC = new LinkedStack();

        String tempString;
        int tempInt;
        int size;

        //get size of stack from user
        tempString = JOptionPane.showInputDialog(null, "How many discs do you want (Max of 10)", "Tower of Hanoi", JOptionPane.INFORMATION_MESSAGE); //input dialogue with return value

        //error checking
        while (true) {
            try {
                tempInt = Integer.parseInt(tempString);

                if (1 < tempInt && tempInt <= 10) { //if value is valid, set size
                    size = tempInt;
                    break; //break loop
                }

                tempString = (JOptionPane.showInputDialog(null, "Error Found, Enter a Valid Integer Between 2 and 10: ", "Tower of Hanoi", JOptionPane.INFORMATION_MESSAGE));

            } catch (NumberFormatException nFE) {
                //display error to user
                tempString = (JOptionPane.showInputDialog(null, "Error Found, Enter a Valid Integer Between 2 and 10: ", "Tower of Hanoi", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        //fills stackA
        StackA.fillWithDiscs(size);

        //create display
        TowerGUI display = new TowerGUI(StackA, StackB, StackC, size);
        display.setVisible(true);
        display.updateStacks();

        //constantly updates the buttons to be enabled if actions are legal, otherwise disabled
        while (true) {

            //button 1
            if (StackA.length() == 0) { //if stack is empty, disable
                display.jButton1.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton1.setEnabled(false);
            } else if (StackB.length() != 0) {
                if ((Integer) StackA.peek() < (Integer) StackB.peek()) { //if stack contains values and is legal, enable
                    display.jButton1.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton1.setEnabled(true);
                } else { //else, is illegal, so disable
                    display.jButton1.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton1.setEnabled(false);
                }
            } else if (StackB.length() == 0) { //if other stack is empty, enable
                display.jButton1.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton1.setEnabled(true);
            }

            //button 2
            if (StackA.length() == 0) {
                display.jButton2.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton2.setEnabled(false);
            } else if (StackC.length() != 0) {
                if ((Integer) StackA.peek() < (Integer) StackC.peek()) {
                    display.jButton2.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton2.setEnabled(true);
                } else {
                    display.jButton2.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton2.setEnabled(false);
                }
            } else if (StackC.length() == 0) {
                display.jButton2.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton2.setEnabled(true);
            }

            //button 3
            if (StackB.length() == 0) {
                display.jButton3.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton3.setEnabled(false);
            } else if (StackA.length() != 0) {
                if ((Integer) StackB.peek() < (Integer) StackA.peek()) {
                    display.jButton3.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton3.setEnabled(true);
                } else {
                    display.jButton3.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton3.setEnabled(false);
                }
            } else if (StackA.length() == 0) {
                display.jButton3.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton3.setEnabled(true);
            }

            //button 4
            if (StackB.length() == 0) {
                display.jButton4.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton4.setEnabled(false);
            } else if (StackC.length() != 0) {
                if ((Integer) StackB.peek() < (Integer) StackC.peek()) {
                    display.jButton4.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton4.setEnabled(true);
                } else {
                    display.jButton4.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton4.setEnabled(false);
                }
            } else if (StackC.length() == 0) {
                display.jButton4.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton4.setEnabled(true);
            }

            //button 5
            if (StackC.length() == 0) {
                display.jButton5.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton5.setEnabled(false);
            } else if (StackB.length() != 0) {
                if ((Integer) StackC.peek() < (Integer) StackB.peek()) {
                    display.jButton5.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton5.setEnabled(true);
                } else {
                    display.jButton5.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton5.setEnabled(false);
                }
            } else if (StackB.length() == 0) {
                display.jButton5.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton5.setEnabled(true);
            }

            //button 6
            if (StackC.length() == 0) {
                display.jButton6.setForeground(new java.awt.Color(204, 204, 204));
                display.jButton6.setEnabled(false);
            } else if (StackA.length() != 0) {
                if ((Integer) StackC.peek() < (Integer) StackA.peek()) {
                    display.jButton6.setForeground(new java.awt.Color(0, 0, 0));
                    display.jButton6.setEnabled(true);
                } else {
                    display.jButton6.setForeground(new java.awt.Color(204, 204, 204));
                    display.jButton6.setEnabled(false);
                }
            } else if (StackA.length() == 0) {
                display.jButton6.setForeground(new java.awt.Color(0, 0, 0));
                display.jButton6.setEnabled(true);
            }

            //test for victory condition
            if (StackB.length() == size || StackC.length() == size) {
                JOptionPane.showMessageDialog(null, "You Win!! \nActions Taken: " + display.actions, "Victory", JOptionPane.INFORMATION_MESSAGE); //message dialogue
                System.exit(0);
            }
        }
    }
}
