package Homework_11.Question_6.Example_1;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/14 12:19
 *   @Description :
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Identical to JDK {@link java.util.concurrent.CountDownLatch}, but adds {@link #countDown(int) }.
 * We do not inherit from the built-in JDK class because its private synchronization mechanism does
 * not efficiently support counting down an arbitrary value - only one value at a time
 * @see java.util.concurrent.CountDownLatch
 */
@SuppressWarnings({"JavaDoc", "UnusedDeclaration"})
public class CountDownLatch {

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count){
            setState(count);
        }

        int getCount(){
            return getState();
        }

        public int tryAcquireShared(int acquires){
            return getState() == 0 ? 1 : -1;
        }

        // Compare and set for the state
        public boolean tryReleaseShared(int releases){
            for(;;){
                int c = getState();
                if(c == 0) return false;
                int nextCount = c - releases;
                if(compareAndSetState(c, nextCount)){
                    return nextCount == 0;
                }
            }
        }
    }

    private final Sync sync;

    public CountDownLatch(int count){
        if(count < 0) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public boolean await(long timeout, TimeUnit unit) throws InterruptedException{
        return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    public void countDown(){
        sync.releaseShared(1);
    }

    public void countDown(int count){
        sync.releaseShared(count);
    }

    public long getCount(){
        return sync.getCount();
    }

    public String toString(){
        return super.toString() + "[Count = " + sync.getCount() + "]";
    }

}
