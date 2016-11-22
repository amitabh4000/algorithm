package Concurrency.optimisticSynch;

import java.util.concurrent.locks.*;
public class deadlockDoubleLock {

    class Cell
    {
        final int ID;  //set in constructor
        private long value;
        Lock lock = new ReentrantLock();
        Cell(long value){
            ID = 32;
            this.value = value;
        }
        synchronized long getValue(){return value;}
        /////////////////
        synchronized void setValue(long v){value = v;}
        ////////////////
        synchronized void swapValue(Cell other){
            if (this==other) return; //alias check
            long t = getValue();
            long v = other.getValue();
            setValue(v);
            other.setValue(t);
        }

        /////// Deadlock free code ////
        synchronized void swapValueDeadlockFree(Cell other){
            if (this==other) return; //alias check
            lock.lock();
            try {
                if(other.lock.tryLock()) {
                    try {
                        long t = getValue();
                        long v = other.getValue();
                        setValue(v);
                        other.setValue(t);
                    }
                    finally {
                        other.lock.unlock();
                    }
                }
            }
            finally{
               lock.unlock();
            }
        }
    }


}
