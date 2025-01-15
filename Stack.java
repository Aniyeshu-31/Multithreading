import java.lang.Integer;
public class Stack {
    int[] arr ;
    int top;
    Integer lock;
   public Stack(int capacity){
     arr = new int[capacity];
     top = -1; 
     lock = 1;
   }
//    public Stack() {
//      lock = new Object();
//    }
    boolean isFull(){
        return top >= arr.length - 1;
    }

     boolean push(int x) {
        // synchronized(lock){
            System.out.println(lock);
            if(isFull()) return false; 
            
            ++top;
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
               
            }
            
            arr[top] = x;
            return true; 
        }
        
    // }
    // synchronized boolean push(int x) {
        //  synchronized(this){   this happens when we make the method Synchronized!.
    //         if(isFull()) return false; 
            
    //         ++top;
    //         try{
    //           Thread.sleep(1000);
    //         }
    //         catch(Exception e){
               
    //         }
            
    //         arr[top] = x;
    //         return true; 
    //       }
    // }
   //  In case of making the static method sychronized we use ClassName.class here in the case Stack.class
     int pop() {
        // synchronized(lock){
            if(isEmpty()) return Integer.MIN_VALUE; 
            int x = arr[top]; 
            arr[top] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            top--;
            return x;
        // }
    }


    int peek() { 
        if (isEmpty()) return Integer.MIN_VALUE; 
        return arr[top];
    }

    int size() {
        return top + 1; 
    }

    boolean isEmpty() {
        return (top < 0); 
    }
}
