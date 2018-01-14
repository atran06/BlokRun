package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Door extends GameObject{

	private Image image;
	
	public Door(int x, int y, ID id) {
		super(x, y, id);
		loadImage();
	}
	public void tick() {
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	public void loadImage() {
		image = new ImageIcon(getClass().getResource("/resources/Blok_Door.png")).getImage();
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
