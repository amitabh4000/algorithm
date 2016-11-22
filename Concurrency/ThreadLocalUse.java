package Concurrency;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by SAmitabh on 02-10-2016.
 */
public class ThreadLocalUse implements Runnable{

        private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected SimpleDateFormat initialValue(){
                return new SimpleDateFormat("yyyyMMdd HHmm");
            }
        };
        @Override
        public void run(){
              System.out.println("Thread Name = "+Thread.currentThread().getName()+"default" +
                      "Formatter="+formatter.get().toPattern());
            try{
                  Thread.sleep(new Random().nextInt(1000));
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            formatter.set(new SimpleDateFormat());
            System.out.println("Thread Name = " + Thread.currentThread().getName() + "default" +
                    "Formatter=" + formatter.get().toPattern());
        }
        public static void main(String[] args) throws InterruptedException{
            ThreadLocalUse obj = new ThreadLocalUse();
            for(int i = 0 ; i < 10 ; i++){
                Thread t = new Thread(obj,""+i);
                Thread.sleep(new Random().nextInt(1000));
                t.start();
            }
        }

}
