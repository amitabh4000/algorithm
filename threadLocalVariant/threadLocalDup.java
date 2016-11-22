package threadLocalVariant;

import java.util.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class threadLocalDup <V> {

    Map<String ,V> map;
    private final Lock mutex_ = new ReentrantLock();
    public threadLocalDup(){
         map = new HashMap<>();
    }


    public V get()throws Exception{
        Thread t = Thread.currentThread();
        try {
            mutex_.lock();
            if (map != null) {
                if (map.containsKey(t.getName())) {
                    return map.get(t.getName());
                } else {
                    throw new Exception("Accessing get befores set for thread " + Thread.currentThread().getName());
                }
            } else {
                throw new Exception("Map not created yet");
            }
        }
        finally {
            mutex_.unlock();
        }

    }
    public void set(V value){
        Thread t = Thread.currentThread();
        try {
            mutex_.lock();
            map.put(t.getName(), value);
        }
        finally {
            mutex_.unlock();
        }
    }
    public void remove(){
        Thread t = Thread.currentThread();
        if(map.containsKey(t.getName())){
            map.remove(t.getName());
        }
    }

}
