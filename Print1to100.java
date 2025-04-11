public class Print1to100 {
    private static int count = 1;
    private static int MAX = 100;
    private static Object lock = new Object();

    public static void main(String[] args) {

        Runnable task = () -> {
            while (true) {
                synchronized (lock) {
                    if (count > MAX)
                        break;
                    System.out.println(Thread.currentThread().getName() + " => " + count++);
                    lock.notifyAll();
                    try {
                        if (count < MAX) {
                            lock.wait();
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        Thread.currentThread().interrupt();
                    }
                }

            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        t1.start();
        t2.start();
        t3.start();
    }

}
