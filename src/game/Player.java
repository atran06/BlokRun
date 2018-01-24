package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Player extends GameObject {

	Handler handler;
	
	private Image image;
	private boolean canDamage = true;
	public Timer timer;
	public static int speed;
	
	public static enum PLYRCOLOR {
		red,
		green,
		blue,
		indigo,
		violet,
		black,
		white
	};
	
	public static PLYRCOLOR color = PLYRCOLOR.white;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		loadImage();
		speed = 2;
	}
	public void paintComponent(Graphics g) {
		if(color == PLYRCOLOR.white) {
			g.setColor(Color.white);
		} else if(color == PLYRCOLOR.blue) {
			g.setColor(Color.blue);
		} else if(color == PLYRCOLOR.red) {
			g.setColor(Color.red);
		} else if(color == PLYRCOLOR.green) {
			g.setColor(Color.green);
		} else if(color == PLYRCOLOR.indigo) {
			g.setColor(Color.cyan);
		} else if(color == PLYRCOLOR.black) {
			g.setColor(Color.black);
		} else if(color == PLYRCOLOR.violet) {
			g.setColor(new Color(255, 0, 255));
		}
		g.drawImage(image, x, y, null);
	}
	public void loadImage() {
		image = new ImageIcon(getClass().getResource("/resources/Blok_Slime64.png")).getImage();
	}
	public void tick() {		
		x += velX;
		y += velY;
		
		collision();
				
		if(handler.isUp()) {
			velY = -speed;
		} else if(!handler.isDown()) {
			velY = 0;
		}
		if(handler.isDown()) {
			velY = speed;
		} else if(!handler.isUp()) {
			velY = 0;
		}
		if(handler.isLeft()) {
			velX = -speed;
		} else if(!handler.isRight()) {
			velX = 0;
		}
		if(handler.isRight()) {
			velX = speed;
		} else if(!handler.isLeft()) {
			velX = 0;
		}
	}
	private void collision() {
		
		timer = new Timer();
		
		for(int i = 0; i < handler.list.size(); i++) {
			GameObject tempObject = handler.list.get(i);
			
			if(tempObject.getID() == ID.block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
					if(canDamage) {
						Game.HP -= 10;
						canDamage = false;
						timer.schedule(new TimerTask() { 
							   public void run() {
							       canDamage = true;
							   }
							},  3000);
						if(Game.HP < 0) {
							Game.HP = 0;
						}
					}
				}
			}
			if(tempObject.getID() == ID.door) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.switchlvl();
					Game.HP = 100;
				}
			}
			if(tempObject.getID() == ID.hp) {
				if(getBounds().intersects(tempObject.getBounds())) {
					Game.HP += 10;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}
}
