import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class BlockingQueue{
    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int capacity) {
       this.capacity  = capacity;
       q = new LinkedList<>();
    }
    public boolean add(int item) {
         synchronized(q) {
            while(q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
            q.add(item);  
            q.notifyAll(); // to notify all the threads who are waiting for the queue to be full here it means to notify the remove() Thread.
        return true;
        }
    }
    public int remove() {
         synchronized(q) {
             while(q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             }

             int element = q.poll();
             q.notifyAll();
             return element;
         }
    }
}