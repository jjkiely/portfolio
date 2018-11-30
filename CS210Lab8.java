import java.util.*;
import java.math.*;

public class CS210Lab8 {
    public static void main(String args[] ) throws Exception {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        Queue myQ= new Queue(200);
        String[] commands=new String[n];
        for(int i=0;i<n;i++)
        {
            commands[i]=sc.nextLine();
        }
        for(int i=0;i<n;i++)
        {
            if(commands[i].contains("INSERT"))
            {
                myQ.insert(commands[i].substring(7));
            }
            else if(commands[i].contains("REMOVE"))
            {
                if(!myQ.isEmpty())
                {
                    myQ.remove();
                }
            }
        }
        /*while(sc.hasNextLine())
        {
            if(sc.nextLine().contains("INSERT"))
            {
                myQ.insert(sc.nextLine().substring(6));
            }
            else if(sc.nextLine().contains("REMOVE"))
            {
                if(!myQ.isEmpty())
            {
                myQ.remove();
            }
            }
        }*/
        System.out.println(myQ.queArray[0]);
    }
}

class Queue{
    private int maxSize;
    public String[] queArray;
    public int front;
    private int rear;
    private int nItems;

    public Queue(int s) {          // constructor 
        maxSize = s;
        queArray = new String[maxSize];
        front = -1;
        nItems=0;
    }
    public boolean check(String s1, String s2)
    {
        boolean bool=false;
        if(s1.length()<s2.length())
        {
            bool= true;
        }
        else if(s1.length()==s2.length())
        {
            if(s2.compareTo(s1)>0)
            {
                bool= true;
            }
        }
        return bool;
        
    }

    public void shiftElements(int pos)
    {
        for(int i=0; i<queArray.length;i++)
        {
            if(i>=pos)
            {
                queArray[i]=queArray[i+1];
            }
        }
    }
    public void insert(String item) { // insert item

         if(nItems==0){ // if no items,
         queArray[0] = item; // insert at 0
         }
         else
         {
             int j=nItems;
             while(j>0&&check(item,queArray[j])==true)
             {
                 //nItems++;
                 shiftElements(j);
                 item=queArray[j];
                 j--;
             }
             if(check(item,queArray[j])==false)
             {
                //nItems++;
                item=queArray[nItems];
             }
         }
    }
    
    public String remove() { // take item from front of queue
         if(isEmpty()) return null; //don’t remove if empty
         String temp = queArray[front];// get value and incr front
         front++;
         if(front == maxSize) // deal with wraparound
         front = 0;
         nItems--; // one less item
         return temp;
        } 

    public String peekFront(){    // peek at front of queue     
        if(isEmpty()){
            return null;
        }
        return queArray[front];
    }      

    public boolean isEmpty() {    // true if queue is empty
        return front == -1;
    }      

    public boolean isFull() {    // true if queue is full
        return front == maxSize - 1;
    }      

}


