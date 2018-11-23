import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {
    public static class Stack {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public Stack(int s) {
            maxSize = s;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int j) {
            top++;
            stackArray[top] = j;
        }

        public int pop() {
            return stackArray[top--];
        }

        public int peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public boolean isFull() {
            return (top == maxSize - 1);

        }

        public void makeEmpty() {
            top = -1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int num = sc.nextInt();
        //int num= Integer.parseInt(n);
        String x= sc.nextLine();
        int num=Integer.parseInt(x);
        Stack theStack = new Stack(10);
        String[] commands= new String[num+1];
        for(int i=0;i<commands.length-1;i++)
        {
            commands[i]=sc.nextLine();
        }
        for(int i=0;i<commands.length-1;i++)
        {
            if(commands[i].substring(0,3).equals("POP"))
            {
                if(!theStack.isEmpty())
                {
                    theStack.pop();
                }

            }
            else if(commands[i].substring(0,4).equals("PUSH"))
            {
                theStack.push(Integer.parseInt(commands[i].substring(5)));
            }
            /*else if(commands[i].substring(0,2).equals("POP"))
            {
                theStack.pop();
            }
            */
        }
        int max=0;
        for(int i=0;i<commands.length-1;i++)
        {
            if(theStack.stackArray[i]>max)
            {
                max=theStack.stackArray[i];
            }
        }
        if(theStack.isEmpty())
        {
            System.out.println("empty");
        }
        else{
            System.out.println(max);
        }
    }
}
