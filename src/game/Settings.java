package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Settings {

	private Image image;
	
	public Settings() {
		loadImage();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	public void loadImage() {
		image = new ImageIcon(getClass().getResource("/resources/Blok_Settings.png")).getImage();
	}
}
