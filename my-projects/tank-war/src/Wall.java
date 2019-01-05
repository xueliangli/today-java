import java.awt.*;

class Wall {
    private int x,y,w,h;
    private TankClient tc;

    Wall(int x, int y, int w, int h, TankClient tc) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.tc = tc;
    }

    void draw(Graphics g){
        g.fillRect(x,y,w,h);
    }

    //与其他东西做碰撞检测
    Rectangle getRect(){
        return new Rectangle(x,y,w,h);
    }
}
