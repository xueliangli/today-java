package javase.concurrent.test;
/*************************************************************************
 *
 * 探究join方法的作用:
 * 等待该线程终止,主线程等待子线程的终止
 *
 * 未使用join方法：
 * main 主线程开始~
 * main 主线程结束~
 * 线程1 线程开始~
 * 线程2 线程开始~
 * 子线程 A 运行 0
 * 子线程 B 运行 0
 * 子线程 A 运行 1
 * 子线程 B 运行 1
 * 子线程 B 运行 2
 * 子线程 A 运行 2
 * 子线程 A 运行 3
 * 子线程 B 运行 3
 * 子线程 B 运行 4
 * 子线程 A 运行 4
 * 线程2 线程结束~
 * 线程1 线程结束~
 *
 * 使用join方法：
 * main 主线程开始~
 * 线程1 线程开始~
 * 线程2 线程开始~
 * 子线程 B 运行 0
 * 子线程 A 运行 0
 * 子线程 A 运行 1
 * 子线程 A 运行 2
 * 子线程 B 运行 1
 * 子线程 A 运行 3
 * 子线程 A 运行 4
 * 子线程 B 运行 2
 * 线程1 线程结束~
 * 子线程 B 运行 3
 * 子线程 B 运行 4
 * 线程2 线程结束~
 * main 主线程结束~
 *************************************************************************/
public class JoinTest extends Thread{
    private String name;
    private JoinTest(String name){
        this.name=name;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" 线程开始~");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程 "+name+" 运行 "+i);
            try {
                sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" 线程结束~");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" 主线程开始~");
        Thread th1 = new JoinTest("A");
        Thread th2 = new JoinTest("B");
        th1.setName("线程1");
        th2.setName("线程2");
        th1.start();
        th2.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 主线程结束~");
    }
}
