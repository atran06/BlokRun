package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> list = new LinkedList<>();
	protected boolean up = false, down = false, right = false, left = false;
	
	public void tick() {
		for(int i = 0; i < list.size(); i++) {
			GameObject tempObject = list.get(i);
			
			tempObject.tick();
		}
	}
	public void paintComponent(Graphics g) {
		for(int i = 0; i < list.size(); i++) {
			GameObject tempObject = list.get(i);
			
			tempObject.paintComponent(g);
		}
	}
	public void addObject(GameObject tempObject) {
		list.add(tempObject);
	}
	public void removeObject(GameObject tempObject) {
		list.remove(tempObject);
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
}
