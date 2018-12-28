package javase.concurrency.test;

/*************************************************************************
 *
 * 对于同步，要时刻清醒在哪个对象上同步，这是关键。
 *
 * A．无论synchronized关键字加在方法上还是对象上，它取得的锁都是对象，
 * 而不是把一段代码或函数当作锁――而且同步方法很可能还会被其他线程的对象访问。
 *
 * B．每个对象只有一个锁（lock）与之相关联。
 *
 * C．实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 *
 *************************************************************************/
public class SyncTest implements Runnable{
    private int b = 100;

    //方法锁
    private synchronized void m1() throws Exception{
        //Thread.sleep(2000);
        b = 1000;
        Thread.sleep(5000);
//        System.out.println("b = " + b);
    }

    private synchronized void m2() throws Exception {
        Thread.sleep(2500);
        b = 2000;
//        System.out.println("b = " + b);
    }

    public void run() {
        try {
            m1();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SyncTest st = new SyncTest();
        Thread t = new Thread(st);
        t.start();

        st.m2();
        System.out.println(st.b);
    }
}
