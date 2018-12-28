package javase.concurrency;

public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
    }
}

class WoTou {
    private int id;

    WoTou(int id) {
        this.id = id;
    }

    public String toString() {
        return "WoTou : " + id;
    }
}

class SyncStack {
    private int index = 0;
    private WoTou[] arrWT = new WoTou[6];

    synchronized void push(WoTou wt) {
        while (index == arrWT.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        arrWT[index] = wt;
        index++;
    }

    synchronized WoTou pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return arrWT[index];
    }
}

class Producer implements Runnable {
    private SyncStack ss;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了：" + wt);
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private SyncStack ss;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 60; i++) {
            WoTou wt = ss.pop();
            System.out.println("消费了: " + wt);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
