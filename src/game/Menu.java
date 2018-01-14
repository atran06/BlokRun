package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Menu {

	private Image image;
	
	public Menu() {
		loadPic();
	}
	public void paintComponent(Graphics g) {

		g.drawImage(image, 0, 0, null);
	}
	public void loadPic() {
		image = new ImageIcon(getClass().getResource("/resources/Blok_Menu.png")).getImage();
	}
}
