package javase.concurrent;

public class DeadLock implements Runnable {
    private int flag;
    //不加 static 修饰的情况下不会发生死锁，保证只产生一次 o1，o2 对象？？？？？？？？？不确定的地方
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    /**
     * 不加 sleep 方法的情况下也不会发生死锁，原因是：sleep是抱着锁睡觉，所以线程二获取不了对象 o1 的锁
     * */
    @Override
    public void run() {
        System.out.println("flag : " + flag);
        //模拟出来的线程一
        if (flag == 0) {
            synchronized (o1) {
                try {
                    //人家抱着锁睡觉呢
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(flag);
                }
            }
        }

        //模拟出来的线程二
        if (flag != 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(flag);
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag=0;
        deadLock2.flag=1;
        //相当于创建了两个线程
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }
}
