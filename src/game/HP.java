package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HP {
	
	private Image hp100;
	private Image hp90;
	private Image hp80;
	private Image hp70;
	private Image hp60;
	private Image hp50;
	private Image hp40;
	private Image hp30;
	private Image hp20;
	private Image hp10;

	public HP() {
		loadImage();
	}
	public void paintComponent(Graphics g) {
		if(Game.HP == 100) {
			g.drawImage(hp100, 0, 0, null);
		} else if(Game.HP == 90) {
			g.drawImage(hp90, 0, 0, null);
		} else if(Game.HP == 80) {
			g.drawImage(hp80, 0, 0, null);
		} else if(Game.HP == 70) {
			g.drawImage(hp70, 0, 0, null);
		} else if(Game.HP == 60) {
			g.drawImage(hp60, 0, 0, null);
		} else if(Game.HP == 50) {
			g.drawImage(hp50, 0, 0, null);
		} else if(Game.HP == 40) {
			g.drawImage(hp40, 0, 0, null);
		} else if(Game.HP == 30) {
			g.drawImage(hp30, 0, 0, null);
		} else if(Game.HP == 20) {
			g.drawImage(hp20, 0, 0, null);
		} else if(Game.HP == 10) {
			g.drawImage(hp10, 0, 0, null);
		}
	}
	public void loadImage() {
		hp100 = new ImageIcon(getClass().getResource("/resources/Blok_HP_100.png")).getImage();
		hp90 = new ImageIcon(getClass().getResource("/resources/Blok_HP_90.png")).getImage();
		hp80 = new ImageIcon(getClass().getResource("/resources/Blok_HP_80.png")).getImage();
		hp70 = new ImageIcon(getClass().getResource("/resources/Blok_HP_70.png")).getImage();
		hp60 = new ImageIcon(getClass().getResource("/resources/Blok_HP_60.png")).getImage();
		hp50 = new ImageIcon(getClass().getResource("/resources/Blok_HP_50.png")).getImage();
		hp40 = new ImageIcon(getClass().getResource("/resources/Blok_HP_40.png")).getImage();
		hp30 = new ImageIcon(getClass().getResource("/resources/Blok_HP_30.png")).getImage();
		hp20 = new ImageIcon(getClass().getResource("/resources/Blok_HP_20.png")).getImage();
		hp10 = new ImageIcon(getClass().getResource("/resources/Blok_HP_10.png")).getImage();
	}
}
