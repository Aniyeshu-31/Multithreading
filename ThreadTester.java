import java.lang.Thread;
public class ThreadTester{
    public static void main(String[] args) {
        
        // Thread th1 = new Thread1("Thread1");
        // // th1.start();
        
        // Method1 
        // Runnable thread22 = new Thread2();
        // Thread thread = new Thread(thread22 , "thread2");
        // thread.start();
        Thread thread = new Thread(new Thread2(), "thread2");
        thread.start();
        // Method2
        // Thread thread = new Thread(()->{
        //      for(int i = 0;i < 5;i++ ){
        //     System.out.println(Thread.currentThread()+", "+i);
        //  }
        // } , "Thread2");
        // thread.start();
        // System.out.println("Main Is Exiting");
        // System.out.println("Main is Starting");
        // Stack st = new Stack(5);
        // new Thread(()->{
        //     int count = 0;
        //     while(count++ < 10) {
        //         System.out.println("Pushed"+" "+st.push(100));
        //     }
        // },"Pusher").start();
        // new Thread(()->{
        //      int count = 0;
        //      while(count-- < 10) {
        //         System.out.println("Popped"+" "+st.pop());
        //      }
        // },"Popper").start();

        // System.out.println("Main is Exiting");


        // for creating the deadlock situation reverse the order of lock passed into synchronized block
        String lock1 = "Aniyeshu";
        String lock2 = "Verma";
        Thread thread1 = new Thread(()-> {
             synchronized(lock1) {
                  try {
                     Thread.sleep(1);
                  } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                synchronized(lock2) {
                    System.out.println("lock acquired from 1");
                }
            }
        });
        Thread thread2 = new Thread(()-> {
            synchronized(lock1) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    // TODO: handle exception
                e.printStackTrace();
                }
                synchronized(lock2) {
                    System.out.println("lock acquired from 2");
                }
            } 
        });
        thread1.start();
        thread2.start();
    }
}