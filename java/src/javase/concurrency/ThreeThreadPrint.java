package javase.concurrency;

/*************************************************************************
 *
 * 三线程打印ABC问题
 *
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，
 * 要求线程同时运行，交替打印10次ABC。
 *
 * 这个问题用Object的wait()，notify()就可以很方便的解决。
 *
 * 程序运行:
 * A线程最先运行，持有C,A对象锁，后释放A,C锁，唤醒B。
 * 线程B等待A锁，再申请B锁，后打印B，再释放B，A锁，唤醒C，线程C等待B锁，再申请C锁，后打印C，再释放C,B锁，唤醒A。
 *
 * Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，
 * 主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。
 *
 *************************************************************************/
public class ThreeThreadPrint implements Runnable {
    private String name;
    private final Object prev;
    private final Object self;

    private ThreeThreadPrint(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name + " ");
                    count--;
                    //释放当前锁
                    self.notify();
                }
                try {
                    //等待前一个锁，等待的过程会释放手里的锁。相当于把两个锁都释放了
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreeThreadPrint tha = new ThreeThreadPrint("A", c, a);
        ThreeThreadPrint thb = new ThreeThreadPrint("B", a, b);
        ThreeThreadPrint thc = new ThreeThreadPrint("C", b, c);
        new Thread(tha).start();
        //确保按顺序A、B、C执行
        Thread.sleep(100);
        new Thread(thb).start();
        Thread.sleep(100);
        new Thread(thc).start();
        Thread.sleep(100);
    }
}
