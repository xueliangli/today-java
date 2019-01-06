import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*************************************************************************
 * 坦克类 ：客户端的窗口显示
 * author : 李学亮
 * date : 2018/12/25
 *************************************************************************/
public class TankClient extends Frame {
    /**
     * 主方法：
     * 在客户端上显示一个窗口
     */
    public static void main(String[] args) {
        TankClient tc = new TankClient();
        tc.launchFrame();
    }

    /**
     * （一）
     * 产生一个窗口，不考虑关闭窗口功能
     * （二）
     * 1、可以关闭窗口
     * 2、不改变窗口大小
     */
    private final int TANK_NUM = 10;
    private final int X_TANKS = 50;
    private final int Y_TANKS = 50;

    private void launchFrame() {
        //画窗口之前就可以把坦克放进去了
        for (int i = 0; i < TANK_NUM; i++) {
            tanks.add(new Tank(X_TANKS, Y_TANKS + 50 * i, false, Tank.Direction.R, this));
        }
        //相对于屏幕的位置
        this.setLocation(400, 300);
        //窗口的长宽属性
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle("tank war");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.setBackground(Color.green);
        setVisible(true);
        //加监听器
        this.addKeyListener(new KeyMonitor());
        new Thread(new PaintThread()).start();
    }

    /**
     * （三）
     * 画出代表坦克的实心圆
     * 注意：不要改变原来的前景色，x 轴，y 轴的方向
     */
//    private int x = 50;
//    private int y = 50;
    private Tank myTank = new Tank(40, 40, true, Tank.Direction.STOP, this);
    //    private Tank enemyTank=new Tank(90,90,false,this);
    List<Tank> tanks = new ArrayList<>();
    Missile m = null;

    @Override
    public void paint(Graphics g) {
        //坦克顶部显示炮弹数目
        g.drawString("missiles count: " + missiles.size(), 10, 50);
        g.drawString("explodes count: " + explodes.size(), 10, 70);
        g.drawString("tanks count: " + tanks.size(), 10, 90);
//        enemyTank.draw(g);
//        exp.draw(g);
        for (Explode e : explodes) {
            e.draw(g);
        }
        /*
         * （十）按键打出炮弹
         */
        for (Missile m : missiles) {
            m.hitTanks(tanks);
            //不让子弹撞墙
            m.hitWall(w1);
            m.hitWall(w2);
            //自己可以被打
            m.hitTank(myTank);
            m.draw(g);
//            if (!m.isLive()) missiles.remove(m);
//            else m.draw(g);
        }
        for (Tank t : tanks) {
            t.collidesWithWall(w1);
            t.collidesWithWall(w2);
            t.draw(g);
        }
        myTank.draw(g);
        w1.draw(g);
        w2.draw(g);
    }

    /**
     * （四）让坦克动起来
     * 将坐标改成变量(paint 方法中的变量)，创建一个线程(属于创建窗口的线程)，使用内部类
     * 定时不断的刷新
     * repaint()方法直接调用父类中的 paint 方法
     */
    private class PaintThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                //先调用update方法，在通过此调用paint方法
                repaint();
                try {
                    //相当于一个定时器，定时刷新窗口
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * （五）消除闪烁的现象，使用双缓冲
     * 解决：从逐条显示，先画到虚拟屏幕中
     * 重写update方法
     */
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        //创建画笔
        Graphics offScreenImageGraphics = offScreenImage.getGraphics();
        //背景颜色改变成和原来一样
        Color color = offScreenImageGraphics.getColor();
        offScreenImageGraphics.setColor(Color.green);
        //画图
        offScreenImageGraphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        offScreenImageGraphics.setColor(color);
        //将图片刷新上去
        paint(offScreenImageGraphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * （六）代码重构：以后经常改动的量定义成常量
     */
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;

    /**
     * （七）键盘控制坦克行动
     */
    private class KeyMonitor extends KeyAdapter {
        //验证接口是否加上了

        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
        }

        /**
         * （九）键盘抬起来的健
         */
        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }

    /**
     * （十）能打出多发炮弹
     * 在 paint 方法处修改
     */
    //因为循环画出这些炮弹，所以用ARRAY比较快，需要进行测试
    List<Missile> missiles = new ArrayList<>();
    /*
     * （十一）解决炮弹不消失问题
     * 设置一个变量表示炮弹是否有效
     * 在子弹类中设置
     */
    /*
     * （十三）在坦克类中加入判断好坏坦克的变量
     */
    /**
     * 添加爆炸
     */
//    private Explode exp=new Explode(70,70,this);
    List<Explode> explodes = new ArrayList<>();
    /**
     * (1.9)随机数产生器
     * 只需要一个,math random 产生的是小数
     * */
    static Random r=new Random();
    /**
     *(2.0)墙
     * */
    private Wall w1=new Wall(100,200,20,150,this);
    private Wall w2=new Wall(300,100,300,20,this);
}
