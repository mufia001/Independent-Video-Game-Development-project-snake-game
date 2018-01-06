import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {

	
	private int width;
	private int height;
	private int x;
	private int y;
	private Random rand;
	public Food() {
		
		width = 15;
		height = 15;
		x =100;
		y = 100;
		rand = new Random();
	}
	public void paint(Graphics g ) {
		g.drawOval(x,y , width, height);
		g.setColor(Color.orange);
		g.fillOval(x,y , width, height);
		//System.out.println("food x= "+ x + "food y= "+ y);
		
	}
	public int getfoodX() {
		return x;
	}
	public int getfoody() {
		return y;
	}
	public void setfoodx(int x) {
		this.x = x;
	}
	public void setfoody(int y) {
		this.y = y;
	}
	
}

