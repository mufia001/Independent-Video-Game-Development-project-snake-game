import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake   {

	public Snake(int[] x, int[] y) {
		
		this.x = x;
		this.y = y;
		height = 15;
		width = 15;
		xspeed = 0;
		yspeed =0;
		lengthofsnake=2;
		tailofthesnake = new int[0];	
		up = false;
		down = false;
		left = false;
		right = false;
		movethesnake=0;
		
				
	}
	public void paint(Graphics g) {
		
		
		for(int i = 0; i<lengthofsnake;i++) {
			if(i==0) {
			g.drawOval(x[i],y[i],width,height);
			g.setColor(Color.GREEN);
			g.fillOval(x[i],y[i],width, height);
			}
			if(i!=0) {
				g.drawOval(x[i],y[i],width,height);
				g.setColor(Color.GREEN);
				g.fillOval(x[i],y[i],width, height);
			}
		}
			
		
		
	}
	public void death() {
		for(int i=4;i<lengthofsnake;i++) {
			if(x[i] == x[0] && y[i] == y[0]) {
				lengthofsnake = 1;
			}
		}
	}
	public void direction(int x, int y) {
		this.xspeed= x;
		this.yspeed=y;
	}
	
	
	
	public int getX(int i) {
		return x[i];
		
		
		
	}
	public void setX(int xs) {
		for(int i = 0; i< x.length;i++) {
			x[i] = xs;
		}
		
	}
	public void setY(int ys) {
		for(int i=0; i<y.length;i++) {
			y[i] = ys;
		}
		
	}
	public int getY(int i) {
		return y[i];
		}
	public boolean notright() {
		return (xspeed == 1 && yspeed == 0)==false;
	}
	

	public boolean right() {
		return (xspeed == 1 && yspeed == 0) == true;
		
	}
	
	
	public boolean left() {
		return (xspeed == -1 && yspeed == 0) == true;
	}
	public boolean notleft() {
		return (xspeed == -1 && yspeed == 0) == false;
	}	
	
	public boolean up() {
		return (xspeed == 0 && yspeed == -1) == true;
			
	}
	public boolean notup() {
		return (xspeed == 0 && yspeed == -1) == false;
			
	}
	
	public boolean down() {
		return (xspeed == 0 && yspeed == 1) == true;
		
	}
	public boolean notdown() {
		return (xspeed == 0 && yspeed == 1) == false;
		
	}
	
	
	public void lengthofsnake() {
		lengthofsnake++;
	}
	public int[] tailofsnake() {
		return tailofthesnake;
	}
	
	public int snakexlength() {
		return x.length;
	}
	public int snakeylength() {
		return y.length;
	}
	public int snakelength() {
		return lengthofsnake;
	}
	public void shiftingsnakebodypostiontotheright() {
		if(this.right() == true) {
			
		for(int i=lengthofsnake-1; i>=0;i--) {
			
			y[i+1] = y[i];
			System.out.println("y[i+1] " + y[i+1]);
			System.out.println("y[i] " + y[i]);
			
		}
		for(int i= lengthofsnake;i>=0;i--) {
			
			if(i==0) {
				x[i] = x[i] + 12;
				
			}
			else {
				x[i] = x[i-1];
				
			}
			if(x[i] > 500) {
				x[i] = 0;
			}
		}
		
	}
		
	}
	public void shiftingsnakebodypositiontotheleft() {
		
		if(this.left() == true) {
			for(int i = lengthofsnake-1;i>=0;i--) {
				y[i+1] = y[i];
				
			}
			for(int i=lengthofsnake;i>=0;i--) {
				
				if(i==0) {
					x[i] = x[i]-12;
					
				}
				else {
					x[i] = x[i-1];
					
				}
				if(x[i] < 0) {
					x[i] = 500;
				}
			}
			
		}
		
		
	}
	public void shiftingsnakebodypositionup() {
		if(this.up() == true) {
			for(int i=lengthofsnake-1; i>=0;i--) {
				x[i+1] = x[i];
				
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					y[i] = y[i]-12;
				}
				else {
					y[i] = y[i-1];
				}
				if(y[i] < 0) {
					y[i] = 500;
				}
			}
		}
	}
	public void shiftingsnakepositiondown() {
		if(this.down() == true) {
			
			for(int i=lengthofsnake-1; i>=0;i--) {
				x[i+1] = x[i];
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					y[i] = y[i]+12;
				}
				else {
					y[i] = y[i-1];
				}
				if(y[i] > 500) {
					y[i] = 0;
				}
			}
		}
	}
	private int[] x;
	private int[] y;
	private int height;
	private int width;
	private int xspeed;
	private int yspeed;
	private int lengthofsnake;
	private int[] tailofthesnake;
	private int delay;
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private int movethesnake;
	
}
