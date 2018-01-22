package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Timer timer = new Timer(5, this);

	public static Handler handler;
	public Player player;
	private Menu menu;
	private Settings setting;
	private Win win;
	public static Camera camera;
	private HP hp;
	
	public static BufferedImage level = null, level2 = null;
	private Image back;
	private Image hpBot;
	
	public static int HP = 100;
	public static int lvl = 1;
	
	public static enum STATE {
		game,
		menu,
		setting,
		win
	};
	public static STATE state = STATE.menu;
	
	public Game() {
		timer.start();
		
		camera = new Camera(0, 0);
		handler = new Handler(camera);
		menu = new Menu();
		setting = new Settings();
		win = new Win();
		hp = new HP();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.imageLoader("/resources/Blok_Scene_HP.png");
		level2 = loader.imageLoader("/resources/Blok_Scene_HP1.png");
		
		loadLevel(level);
		loadImage();
	}
	public void paintComponent(Graphics g) {
		if(state == STATE.menu) {
			menu.paintComponent(g);
		} else if(state == STATE.setting) {
			setting.paintComponent(g);
		} else if(state == STATE.game) {
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.gray);
			g.fillRect(0, 0, 1280, 720);
			
			g2d.translate(-camera.getX(), -camera.getY());
			
			handler.paintComponent(g);
			
			g2d.translate(camera.getX(), camera.getY());

			g.drawImage(back, 0, 0, null);
			g.drawImage(hpBot, 0, 0, null);
			
			hp.paintComponent(g);
		} else if(state == STATE.win) {
			win.paintComponent(g);
		}
	}
	private void loadImage() {
		back = new ImageIcon(getClass().getResource("/resources/Blok_Back.png")).getImage();
		hpBot = new ImageIcon(getClass().getResource("/resources/Blok_HP_Bottom.png")).getImage();
	}
	public static void loadLevel(BufferedImage image) {
			
		int w = image.getWidth();
		int h = image.getHeight();
			
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
					
				if(red == 255) {
					handler.addObject(new Scene(xx*64, yy*64, ID.block));
				}
				if(green == 255 && blue == 255) {
					handler.addObject(new HpCrate(xx*64, yy*64, ID.hp));
				}
				if(green == 255 && blue == 0) {
					handler.addObject(new Door(xx*64, yy*64, ID.door));
				}
				if(blue == 255 && green == 0) {
					handler.addObject(new Player(xx*64, yy*64, ID.player, handler));
				}
			}
		}	
	}
	public void actionPerformed(ActionEvent e) {
		if(state == STATE.menu) {
			validate();
			repaint();
		} 
		if(state == STATE.game) {
			validate();
			repaint();
			
			for(int i = 0; i < handler.list.size(); i++) {
				if(handler.list.get(i).getID() == ID.player) {
					camera.tick(handler.list.get(i));
				}
			}
			handler.tick();
		} else if(state == STATE.setting) {
			repaint();
		} else if(state == STATE.win) {
			validate();
			repaint();
		}
	}
}
