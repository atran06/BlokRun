package game;

import java.awt.Color;
import java.awt.Graphics;

public class Win {

	public Win() {
		
	}
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1280, 720);
	}
}
