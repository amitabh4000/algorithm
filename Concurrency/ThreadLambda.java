package Concurrency;

/**
 * Created by SAmitabh on 09-09-2016.
 */
public class ThreadLambda {

    static final int THREAD_NUM = 8;
    public static void examplelambda() {

        Thread[] threads = new Thread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            final int id = i;
            threads[i] = new Thread(() -> System.out.println("new Thread with id:" + id));
            threads[i].start();
        }
    }
        public static void main(String[] args){

                 examplelambda();
        }
}
