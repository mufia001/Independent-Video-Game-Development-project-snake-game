import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener{
	private Snake snake;
	private Food food;
	private Timer timer;
	private int delay;
	private int height;
	private int width;
	private Random random;
	private Thread thread;
	private long speed = 100;
	private JLabel label;
	
	private int score;
	
	public Game() {
		snake = new Snake(new int[100],new int[100]);
		food = new Food();
		addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(true);
		delay = 100;
		height = 500;
		width = 500;
		random=new Random();
		timer = new Timer(delay,this);
		timer.start();
		score = 0;
		label = new JLabel("Score " + score);
		
		
		
		
	}
	public void paint(Graphics g) {
		g.drawRect(0, 0, height, width);
		g.setColor(Color.black);
		g.fillRect(0, 0, height, width);
		snake.paint(g);
		food.paint(g);
		
		snake.death();
		
		repaint();
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			if(snake.down()==false) {
				snake.direction(0,-1);
				
			}
			else {
				snake.notup();
				snake.down();
				snake.left();
				snake.right();
			}
			
			
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(snake.up()==false) {
				snake.direction(0,1);
				
			}
			else {
				snake.notdown();
				snake.up();
				snake.left();
				snake.right();
			}
		
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(snake.right()==false) {
				snake.direction(-1,0 );
				
			}
			else {
				snake.notleft();
				snake.right();
				snake.up();
				snake.down();
			}
			
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(snake.left()==false) {
				snake.direction(1,0);
				
			}
			else {
				snake.notright();
				snake.left();
				snake.up();
				snake.down();
			}
			
			
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
		
		
		snake.shiftingsnakebodypostiontotheright();
		
		snake.shiftingsnakebodypositiontotheleft();
		snake.shiftingsnakebodypositionup();
		snake.shiftingsnakepositiondown();
		repaint();	
		
		
		
		
		
		
		
		
		for(int i =0; i<snake.snakexlength();i++) {
			int r = snake.getX(0);
			if(r - food.getfoodX() >= -10 &&  r - food.getfoodX() <= 10) {
			for(int j = 0; j<snake.snakeylength();j++) {
				int g = snake.getY(0);
				if(g- food.getfoody() >= -10 && g - food.getfoody() <= 10) {
					int x = random.nextInt(300);
					int y = random.nextInt(350);
					food.setfoodx(x);
					food.setfoody(y);
					snake.lengthofsnake();
					delay--;
					score++;
					label.setText("Score " + score);
					
				}
			}
		}
		}
		
		
		
		
	}
	
	public JLabel label() {
		return label;
	}
	
	
	}
		
	
	
	



