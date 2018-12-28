package javase.concurrency.test;
/*************************************************************************
 *
 * sleep()和yield()的区别
 *
 * sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
 * yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行
 *
 *************************************************************************/
public class YieldTest extends Thread{
    private YieldTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            //让出CPU之后谁抢到谁执行
            if (i==3)
                Thread.yield();
            if (i==4) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread th1 = new YieldTest("张三");
        Thread th2 = new YieldTest("李四");
        th1.start();
        th2.start();
    }
}
