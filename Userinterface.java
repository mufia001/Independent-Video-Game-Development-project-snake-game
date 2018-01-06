import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Userinterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		Game game = new Game();
		JFrame frame2 = new JFrame();
		
		frame.setBounds(0, 0, 500, 500);
		frame2.setBounds(500,500,100,100);
		
		
		
		frame.add(game);
		frame.setVisible(true);
		frame2.add(game.label());
		frame2.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
