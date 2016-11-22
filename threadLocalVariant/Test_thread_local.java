package threadLocalVariant;

import Concurrency.ThreadLocalUse;

import java.util.Random;

/**
 * Created by SAmitabh on 03-10-2016.
 */
public class Test_thread_local  {


    public static threadLocalDup<String> threadSlogans = new threadLocalDup<>();
    public static threadLocalDup<Integer> threadNum = new threadLocalDup<>();

    public static void main(String[] args){
        Runnable task1 = ()->{
            System.out.println("Thread id is: " + Thread.currentThread().getId());

            for(int i = 0 ; i < 100 ;i++) {
                String Slogan ="";
                String tName = Thread.currentThread().getName();
                for(int j = 0 ; j < new Random().nextInt(5)+1;j++) Slogan = Slogan+tName;
                threadSlogans.set("I am thread " + Slogan + " ya ya ya");
                threadNum.set((int)Thread.currentThread().getId()*10);
                try {
//                    System.out.println("My thread id is: " + Thread.currentThread().getId()
//                            + " Slogan is: '" + threadSlogans.get()
//                             +"' and Id is: "+threadNum.get());
                    String s = threadSlogans.get();
                    long k = threadNum.get();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
//                try{
//                    Thread.sleep(100);
//                }
//                catch(InterruptedException e){
//                    e.printStackTrace();
//                }
            }
        };
        Thread[] threadArr = new Thread[1000];
        String map ="abcdefghij";
        long startTime = 0,timeTaken;
        for(int i= 0; i<1000; i++){
            startTime = System.currentTimeMillis();
            threadArr[i] = new Thread(task1);
            threadArr[i].start();
        }

        try {
            for (Thread thread : threadArr) {
                thread.join();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        timeTaken = System.currentTimeMillis()-startTime;
        System.out.println("**********  Time Taken is   "+timeTaken+"ms *******************");
    }

}
