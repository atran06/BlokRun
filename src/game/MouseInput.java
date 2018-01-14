package game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import game.Game.STATE;

public class MouseInput implements MouseListener {

	private Handler handler;
	private Camera camera;
	
	public MouseInput(Handler handler, Camera camera) {
		this.handler = handler;
		this.camera = camera;
	}
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		System.out.println(mx + " " + my);
		if(Game.state == STATE.menu) {
			if(mx >= 330 && mx <= 960) {
				if(my >= 390 && my <= 550) {
					Game.state = Game.STATE.game;
				}
			}
			if(mx >= 785 && mx <= 1095) {
				if(my >= 600 && my <= 690) {
					System.exit(1);
				}
			}
			if(mx >= 195 && mx <= 500) {
				if(my >= 600 && my <= 690) {
					Game.state = Game.STATE.setting;
				}
			}
		}
		if(Game.state == STATE.setting) {
			if(mx >= 80 && mx <= 300) {
				if(my >= 590 && my <= 670) {
					Game.state = Game.STATE.menu;
				}
			}
			if(mx >= 320 && mx <= 380) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.red;
				}
			}
			if(mx >= 415 && mx <= 480) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.green;
				}
			}
			if(mx >= 515 && mx <= 575) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.blue;
				}
			}
			if(mx >= 610 && mx <= 675) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.black;
				}
			}
			if(mx >= 710 && mx <= 770) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.indigo;
				}
			}
			if(mx >= 810 && mx <= 870) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.white;
				}
			}
			if(mx >= 905 && mx <= 965) {
				if(my >= 450 && my <= 510) {
					Player.color = Player.PLYRCOLOR.violet;
				}
			}
		}
		if(Game.state == Game.STATE.game) {
			if(mx >= 80 && mx <= 300) {
				if(my >= 590 && my <= 670) {
					Game.state = Game.STATE.menu;
				}
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}

}
