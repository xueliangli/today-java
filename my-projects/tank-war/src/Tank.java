import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * （八）添加100辆坦克
 * 利用数组需要添加坦克类的引用，属性在类中包含着
 */
class Tank {
    private int x, y;

    private TankClient tc;
    //判断四个按键是否按下
    private boolean bL = false;
    private boolean bU = false;
    private boolean bR = false;
    private boolean bD = false;
    //坦克的长度高度
    private static final int WIDTH=30;
    private static final int HEIGHT=30;

    //方向
    enum Direction {
        L, LU, U, RU, R, RD, D, LD, STOP
    }

    private Direction dir = Direction.STOP;

    //构造方法
    Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Tank(int x, int y, TankClient tc) {
        this.x = x;
        this.y = y;
        this.tc = tc;
    }

    //让坦克自己画自己，外部不需要在关心坦克内部了
    void draw(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        //坐标怎么变化
//        y += 3;
//        x += 4;
        move();
    }

    private void move() {
        //步进值
        int X = 5;
        int Y = 5;
        switch (dir) {
            case L:
                x -= X;
                break;
            case LU:
                x -= X;
                y -= Y;
                break;
            case LD:
                x -= X;
                y += Y;
                break;
            case R:
                x += X;
                break;
            case RU:
                x += X;
                y -= Y;
                break;
            case RD:
                x += X;
                y += Y;
                break;
            case U:
                y -= Y;
                break;
            case D:
                y += Y;
                break;
            case STOP:
                break;
        }
    }

    void keyPressed(KeyEvent e) {
        //            测试:System.out.println("ok");
        int key = e.getExtendedKeyCode();
        switch (key) {
            case KeyEvent.VK_CONTROL:
                //坦克要打出子弹，方法开火，有返回值，子弹
                tc.m=fire();
                break;
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }
        //重新定位方向
        locateDirection();
    }

    void keyReleased(KeyEvent e){
        int key = e.getExtendedKeyCode();
        switch (key) {

            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        //重新定位方向
        locateDirection();
    }
    private void locateDirection() {
        if (bL && !bU && !bR && !bD) dir = Direction.L;
        if (!bL && !bU && bR && !bD) dir = Direction.R;
        if (!bL && bU && !bR && !bD) dir = Direction.U;
        if (!bL && !bU && !bR && bD) dir = Direction.D;
        if (bL && bU && !bR && !bD) dir = Direction.LU;
        if (bL && !bU && !bR && bD) dir = Direction.LD;
        if (!bL && bU && bR && !bD) dir = Direction.RU;
        if (!bL && !bU && bR && bD) dir = Direction.RD;
        if (!bL && !bU && !bR && !bD) dir = Direction.STOP;
    }
    private Missile fire(){
        int x=this.x+Tank.WIDTH/2-Missile.WIDTH/2;
        int y=this.y+Tank.HEIGHT/2-Missile.HEIGHT/2;
        Missile m=new Missile(x,y,dir);
        return m;
    }
}
