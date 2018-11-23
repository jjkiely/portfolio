import java.util.Scanner;
public class CS210Lab7
{
    public static class Stack{
        private int maxSize;
        private int[] stackArray;
        private int top;


        public Stack(int s){
            maxSize=s;
            stackArray = new int[maxSize];
            top=-1;
        }

        public void push(int j)
        {
            top++;
            stackArray[top]=j;
        }

        public int pop()
        {
            return stackArray[top--];
        }
        public int peek()
        {
            return stackArray[top];
        }

        public boolean isEmpty()
        {
            return(top==-1);
        }

        public boolean isFull()
        {
            return(top==maxSize-1);

        }
        public void makeEmpty()
        {
            top=-1;
        }

    }

    public static void main(String[]args)
    {
        Scanner sc= new Scanner(System.in);
        Stack theStack=new Stack(100);
    }
}
