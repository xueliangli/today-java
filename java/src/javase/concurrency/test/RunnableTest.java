package javase.concurrency.test;

import static java.lang.Thread.sleep;

public class RunnableTest implements Runnable {
    private String name;

    private RunnableTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " 运行 " + i);
            try {
                sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //通过调用 thread 类中的API
        new Thread(new RunnableTest("C")).start();
        new Thread(new RunnableTest("D")).start();
    }
}
