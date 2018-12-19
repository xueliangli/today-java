package javase.concurrent;
/*************************************************************************
 *
 * 通过继承 thread 类实现多线程
 *
 * start() 后不是马上执行多线程的代码，而是进入 runnable 状态，随时等待操作系统的调用
 *
 * 两种方式都是通过Thread的对象的API来控制线程的
 * main方法其实也是一个线程。在java中所以的线程都是同时启动的，至于什么时候，哪个先执行，完全看谁先得到CPU的资源。
 *
 * 在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用java命令执行一个类的时候，
 * 实际上都会启动一个ＪＶＭ，每一个ｊＶＭ实际就是在操作系统中启动了一个进程。
 *
 *************************************************************************/
public class TestThread extends Thread {
    private String name;
    private TestThread(String name){
        this.name=name;
    }
    /**
     * 重写 run 方法
     * 存放多线程代码的地方
     * */
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(name+" 运行 "+i);
            try {
                sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //通过调用 thread 类中的API
        Thread th1 = new TestThread("A");
        Thread th2 = new TestThread("B");
        th1.start();
        th2.start();
    }
}
