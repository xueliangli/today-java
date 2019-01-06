import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * （八）添加100辆坦克
 * 利用数组需要添加坦克类的引用，属性在类中包含着
 */
class Tank {
    private int x, y;
    //上一步的位置,记录移动前的位置
    private int oldX, oldY;

    private TankClient tc;
    //判断四个按键是否按下
    private boolean bL = false;
    private boolean bU = false;
    private boolean bR = false;
    private boolean bD = false;
    //坦克的长度高度
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    boolean isGood() {
        return good;
    }

    //判断坦克的所属势力
    private boolean good;
    //定义坦克当前移动到哪一步了
    private int step = TankClient.r.nextInt(12) + 3;

    //方向
    enum Direction {
        L, LU, U, RU, R, RD, D, LD, STOP
    }

    private Direction dir = Direction.STOP;
    //定义炮筒的方向
    private Direction ptDir = Direction.D;

    //构造方法
    private Tank(int x, int y, boolean good) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
        this.good = good;
    }

    Tank(int x, int y, boolean good, Direction dir, TankClient tc) {
        this(x, y, good);
        this.tc = tc;
        this.dir = dir;
    }

    //让坦克自己画自己，外部不需要在关心坦克内部了
    void draw(Graphics g) {
        //如果为 false 则不画了
        if (!live) {
            if (!good) {
                tc.tanks.remove(this);
            }
            return;
        }
        Color color = g.getColor();
        //区分敌我坦克
        if (good) g.setColor(Color.red);
        else g.setColor(Color.BLUE);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        //坐标怎么变化
//        y += 3;
//        x += 4;
        switch (ptDir) {
            case L:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT / 2);
                break;
            case LU:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);
                break;
            case LD:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT);
                break;
            case R:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
                break;
            case RU:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
                break;
            case RD:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT);
                break;
            case U:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y);
                break;
            case D:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + Tank.HEIGHT);
                break;
        }
        move();
    }

    /**
     * 撞墙就回到上一步的位置
     * */
    private void stay() {
        x=oldX;
        y=oldY;
    }

    private void move() {
        //撞墙前移动之前记录，上一步坦克所在的位置
        this.oldX = x;
        this.oldY = y;
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
        //坦克移动过后调整炮筒方法，让其随坦克移动而移动
        if (this.dir != Direction.STOP) {
            this.ptDir = this.dir;
        }
        /*
         * (十二) 坦克出街问题
         * */
        if (x < 0) x = 0;
        if (y < 30) y = 30;
        if (x + Tank.WIDTH > TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
        if (y + Tank.HEIGHT > TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT - Tank.HEIGHT;

        if (!good) {
            Direction[] dirs = Direction.values();
            if (step == 0) {
                step = TankClient.r.nextInt(12) + 3;
                int rn = TankClient.r.nextInt(dirs.length);
                dir = dirs[rn];
            }
            //每移动一次，步骤减一个
            step--;
            if (TankClient.r.nextInt(40) > 38)
                this.fire();
        }
    }

    void keyPressed(KeyEvent e) {
        //            测试:System.out.println("ok");
        int key = e.getExtendedKeyCode();
        switch (key) {
//            case KeyEvent.VK_CONTROL:
//                //坦克要打出子弹，方法开火，有返回值，子弹
//                //第二次修改：每打出一发炮弹往容器里添加一发炮弹
//                //也可以写在fire里面
//                tc.missiles.add(fire());
//                break;
            //为了防止炮弹密集，干脆键盘抬起时打出炮弹
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

    void keyReleased(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        switch (key) {
            case KeyEvent.VK_CONTROL:
                //坦克要打出子弹，方法开火，有返回值，子弹
                //第二次修改：每打出一发炮弹往容器里添加一发炮弹
                //也可以写在fire里面
                fire();
                break;
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

    private Missile fire() {
        //被击败就别发子弹了
        if (!live) return null;
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
        //new 炮弹的时候需要把坦克的 tc 传给它
        Missile m = new Missile(x, y, good, ptDir, this.tc);
        tc.missiles.add(m);
        return m;
    }

    Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    /*
     * 定义布尔类型的量代表坦克是否存活
     * */
    private boolean live = true;

    boolean isLive() {
        return live;
    }

    void setLive(boolean live) {
        this.live = live;
    }

    /**
     * 坦克不能穿过墙
     */
    boolean collidesWithWall(Wall w) {
        if (this.live && this.getRect().intersects(w.getRect())) {
//            this.dir = Direction.STOP;
            this.stay();
            return true;
        }
        return false;
    }
}
