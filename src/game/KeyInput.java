package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		for(int i = 0; i < handler.list.size(); i++) {
			
			GameObject tempObject = handler.list.get(i);
			
			if(tempObject.getID() == ID.player) {
				if(code == KeyEvent.VK_W) handler.setUp(true);
				if(code == KeyEvent.VK_S) handler.setDown(true);
				if(code == KeyEvent.VK_A) handler.setLeft(true);
				if(code == KeyEvent.VK_D) handler.setRight(true);
				if(code == KeyEvent.VK_SHIFT) Player.speed = 3;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		for(int i = 0; i < handler.list.size(); i++) {
			
			GameObject tempObject = handler.list.get(i);
			
			if(tempObject.getID() == ID.player) {
				if(code == KeyEvent.VK_W) handler.setUp(false);
				if(code == KeyEvent.VK_S) handler.setDown(false);
				if(code == KeyEvent.VK_A) handler.setLeft(false);
				if(code == KeyEvent.VK_D) handler.setRight(false);
				if(code == KeyEvent.VK_SHIFT) Player.speed = 2;
			}
		}
	}

}
