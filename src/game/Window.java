package game;

import javax.swing.JFrame;

public class Window {

	public Window(int width, int height, String title, Game game) {
	
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setTitle(title);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(game);
		frame.addKeyListener(new KeyInput(Game.handler));
		frame.addMouseListener(new MouseInput(Game.handler, Game.camera));
	}
}
