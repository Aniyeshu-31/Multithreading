public class Print1to100 {
    public static void print1to100(int start,int end){
        synchronized(Print1to100.class){
          for(int i = start;i <= end;i++) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
         new Thread(()->{
             print1to100(1,33);
         }).start();
         
         new Thread(()->{
             print1to100(34, 67);
         }).start();

         new Thread(()->{ 
            print1to100(68, 100);
         }).start();
     }
}
