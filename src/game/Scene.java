package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Scene extends GameObject {

	public Scene(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.gray.darker());
		g.fillRect(x, y, 64, 64);
		
		g.setColor(Color.white);
		g.drawRect(x, y, 64, 64);
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}

}
