package Concurrency;

/**
 * Created by SAmitabh on 08-10-2016.
 */
public class AccountFinegrainLocking {
    private int balance;
    public class person{
        private String name;
        private String address;
        synchronized void a(){
          // name address operations
        }
    }
    synchronized void b(){
        // balance operations
    }

}
