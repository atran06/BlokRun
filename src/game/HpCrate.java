package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HpCrate extends GameObject {

	public HpCrate(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 64, 64);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}

}
