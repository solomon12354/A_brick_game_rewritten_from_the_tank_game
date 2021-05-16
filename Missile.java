package HW6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Missile extends MoveableObject {

	Tank tank; 
	/**
	 * 
	 */
	public Missile() {
		super();
		this.deltaX = 10;
		this.deltaY = 10;
		this.width = 10;
		this.height = 10;
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
        public void restart(){
            this.setX(350);
            this.setY(580);
            this.deltaX = 1;
            this.deltaY = -1;
            this.tank = tank;
        }
	public Missile(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		this.deltaX = 1;
		this.deltaY = -1;
		this.tank = tank;
	}
        public void moveBall() {
            x+=deltaX;
            y+=deltaY;
            /*switch (this.direction) {
		case KeyEvent.VK_UP:
			y-=deltaY;
			break;
		case KeyEvent.VK_RIGHT:
			x+=deltaX;
			break;
		case KeyEvent.VK_DOWN:
			y+=deltaY;
			break;
		case KeyEvent.VK_LEFT:
			x-=deltaX;
			break;

		default:
			break;
            }*/
	}
	@Override
        
        
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!this.isLive()) {
			// tank.getMissiles().remove(this); // cause Exception 
			return;
		}
		this.moveBall();
		g.setColor(this.color);
		g.fillOval(x, y, width, height);
		if (y>750) {
			super.setLive(false);
		}
	}
	public boolean hitTank (Tank t) {
		boolean hitFlag = false;
		if (t.contain(this.getCenterX(), this.getCenterY())) {
			hitFlag = true;
			t.setLive(false);
			//this.setLive(false);
		}
		return hitFlag;
	}
        public boolean hitEdge (Tank t) {
		boolean hitFlag = false;
		if (t.contain(this.getCenterX(), this.getCenterY())) {
			hitFlag = true;
			t.setLive(false);
			this.setLive(false);
		}
		return hitFlag;
	}
}
