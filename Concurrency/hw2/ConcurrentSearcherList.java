package Concurrency.hw2;

import java.util.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.Condition;
public class ConcurrentSearcherList<T> {

	/*
	 * Three kinds of threads share access to a singly-linked list:
	 * searchers, inserters and deleters. Searchers merely examine the list;
	 * hence they can execute concurrently with each other. Inserters add
	 * new items to the front of the list; insertions must be mutually exclusive
	 * to preclude two inserters from inserting new items at about
	 * the same time. However, one insert can proceed in parallel with
	 * any number of searches. Finally, deleters remove items from anywhere
	 * in the list. At most one deleter process can access the list at
	 * a time, and deletion must also be mutually exclusive with searches
	 * and insertions.
	 *
	 * Make sure that there are no data races between concurrent inserters and searchers!
	 */

    private final Lock lock;

    // Values //

    static final int NUM_SEARCHER = 10;
    static final int NUM_DELETER = 10;
    static final int NUM_INSERTER = 10;
    static final int SEARCH_PER_THREAD = 100;
    static final int INSERT_PER_THREAD = 100;
    static final int DELETE_PER_THREAD = 100;

    //**** Conditions for searching ******//
    private final Condition canSearch;
    private final Condition canInsert;
    private final Condition canRemove;
    private  int countSearcher;
    private  int countInserter;
    private  int countRemover;
    private static class Node<T>{
        final T item;
        Node<T> next;

        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }


    private volatile  Node<T> first;



    public ConcurrentSearcherList() {
        lock = new ReentrantLock();
        canSearch = lock.newCondition();
        canInsert = lock.newCondition();
        canRemove = lock.newCondition();
        first = null;
    }

    /**
     * Inserts the given item into the list.
     *
     * Precondition:  item != null
     *
     * @param item
     * @throws InterruptedException
     */
    public void insert(T item) throws InterruptedException{
        assert item != null: "Error in ConcurrentSearcherList insert:  Attempt to insert null";
        start_insert();
        try{
            first = new Node<T>(item, first);
            System.out.println("In insert thread,Thread id is: "+Thread.currentThread().getName()+"Inserting val "+item);
        }
        finally{
            end_insert();
        }
    }

    /**
     * Determines whether or not the given item is in the list
     *
     * Precondition:  item != null
     *
     * @param item
     * @return  true if item is in the list, false otherwise.
     * @throws InterruptedException
     */
    public boolean search(T item) throws InterruptedException{
        assert item != null: "Error in ConcurrentSearcherList search:  Attempt to search for null";
        start_search();
        try{
            for(Node<T> curr = first;  curr != null ; curr = curr.next){
                if (item.equals(curr.item)) {
                    System.out.println("In search thread,Thread id is: "+Thread.currentThread().getName()+"Searched item "+item);
                    return true;
                }
            }
            return false;
        }
        finally{
            end_search();
        }
    }

    /**
     * Removes the given item from the list if it exists.  Otherwise the list is not modified.
     * The return value indicates whether or not the item was removed.
     *
     * Precondition:  item != null.
     *
     * @param item
     * @return  whether or not item was removed from the list.
     * @throws InterruptedException
     */
    public boolean remove(T item) throws InterruptedException{
        assert item != null: "Error in ConcurrentSearcherList remove:  Attempt to remove null";
        start_remove();
        try{
            if(first == null) return false;
            if (item.equals(first.item)){
                System.out.println("In remove thread,Thread id is: "+Thread.currentThread().getName()+"removed item "+item);
                first = first.next; return true;
            }
            for(Node<T> curr = first;  curr.next != null ; curr = curr.next){
                if (item.equals(curr.next.item)) {
                    System.out.println("In remove thread,Thread id is: "+Thread.currentThread().getName()+"removed item "+item);
                    curr.next = curr.next.next;
                    return true;
                }
            }
            return false;
        }
        finally{
            end_remove();
        }
    }

    private void start_insert() throws InterruptedException{
        try{
            Thread.sleep(4);
        }
        catch(InterruptedException e){

        }

        lock.lock();
        try {
            while (countRemover != 0 || countInserter != 0) {
                canInsert.await();
            }
            countInserter++;
        }
        finally{
            lock.unlock();
        }
    }

    private void end_insert(){
           lock.lock();
           try {
               countInserter--;
               canRemove.signalAll();
               canInsert.signalAll();
           }
           finally {
               lock.unlock();
           }
    }

    private void start_search() throws InterruptedException{
        try{
            Thread.sleep(4);
        }
        catch(InterruptedException e){

        }
        lock.lock();
        try {
            while (countRemover != 0) {
                canSearch.await();
            }
            countSearcher++;
        }
        finally {
            lock.unlock();
        }
    }

    private void end_search(){
        lock.lock();
        try {
            countSearcher--;
            canRemove.signalAll();
        }
        finally{
            lock.unlock();
        }
    }

    private void start_remove() throws InterruptedException{
        try{
            Thread.sleep(4);
        }
        catch(InterruptedException e){

        }
        lock.lock();
        try {
            while (countRemover != 0 || countSearcher != 0 || countInserter != 0) {
                canRemove.await();
            }
            countRemover++;
        }
        finally {
            lock.unlock();
        }
    }

    private void end_remove() {
        lock.lock();
        try {
            countRemover--;
            canSearch.signalAll();
            canRemove.signalAll();
            canInsert.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        Thread[] searcherArr = new Thread[NUM_SEARCHER];
        Thread[] inserterArr = new Thread[NUM_INSERTER];
        Thread[] deleterArr  =  new Thread[NUM_DELETER];
        ConcurrentSearcherList <Integer> concurrentList = new ConcurrentSearcherList<>();
        Random random = new Random();


        //****** Invoke searcher thread using lambda expression *****//
            for (Thread thread : inserterArr) {

                    new Thread(() -> {
                        for (int i = 0; i < INSERT_PER_THREAD; i++) {
                            try {
                                concurrentList.insert(random.nextInt(10));
                            }
                            catch (InterruptedException e) {

                            }
                        }

                    }).start();

            }

        //****** Invoke inserter thread using lambda expression *****//
            for (Thread thread : searcherArr) {

                new Thread(() -> {
                    for (int i = 0; i < SEARCH_PER_THREAD; i++) {
                        try {
                            concurrentList.search(random.nextInt(10));
                        }
                        catch (InterruptedException e) {

                        }
                    }
                }).start();

            }


        //****** Invoke deleter thread using lambda expression *****//
        for (Thread thread : deleterArr) {

            new Thread(() -> {
                for (int i = 0; i < DELETE_PER_THREAD; i++) {
                    try {
                        concurrentList.remove(random.nextInt(8));
                    }
                    catch (InterruptedException e) {

                    }
                }
            }).start();

        }

    }
}

