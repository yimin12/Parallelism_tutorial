package Question_6;
import Homework_9.Question_6.BoundedBuffer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31 22:28
 *   @Description :
 *
 */
public class BoundedBufferTest {

    @Test
    public void testIsEmptywhenConstructed(){
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++)
            bb.put(i);
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    class Big {
        double[] data = new double[100000];
    }

    @Test
    public void testLeak() throws Exception {
        BoundedBuffer<Big> bb = new BoundedBuffer<Big>(1000);
        long heapSize1 = Runtime.getRuntime().freeMemory();
        for(int i = 0; i < 1000; i ++){
            bb.put(new Big());
        }
        for(int i = 0; i < 1000; i ++){
            bb.take();
        }
        long heapSize2 =  Runtime.getRuntime().freeMemory();
        assertTrue(Math.abs(heapSize1 - heapSize2) < 1000000000L);
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        Thread taker = new Thread() {
            public void run() {
                try {
                    int unused = bb.take();
                } catch (InterruptedException success) { }
            }};
        try {
            taker.start();
            Thread.sleep(1000);
            taker.interrupt();
            taker.join(1000);
            assertFalse(taker.isAlive());
        } catch (Exception unexpected) {

        }
    }
}
