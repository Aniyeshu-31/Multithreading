import java.lang.Thread;
public class Thread1 extends Thread{
     
    public Thread1(String ThreadName) {
        super(ThreadName);
    }
    @Override
    public void run() {
       for(int i = 0;i < 5;i++) {
        System.out.println("inside "+Thread.currentThread().getName()+" "+ i);
       }
    }
}
