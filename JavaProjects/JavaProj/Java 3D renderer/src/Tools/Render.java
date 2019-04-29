package Tools;

import java.awt.Graphics;

/*
 * 2D quick renderer
 * 
 */
public class Render{
	Graphics screen;
	public int offsetx = 0;
	public int offsety = 0;
	public Render(Graphics graphics) {
		this.screen = graphics;
	}
	public void rect(int x1,int y1,int x2, int y2) {	
		this.screen.drawRect(Math.min(x1, x2) + offsetx, Math.min(x1, x2) + offsety, Math.abs(x2-x1) + offsetx, Math.abs(y2-y1) + offsety);
	}
	public void rect(Point p1, Point p2) {
		this.rect(p1.x, p1.y,p2.x, p2.y);
	}
	public void line(int x1,int y1,int x2, int y2) {
		this.screen.drawLine(Math.min(x1, x2) + offsetx, Math.min(x1, x2) + offsety, Math.abs(x2-x1) + offsetx, Math.abs(y2-y1) + offsety);
	}
	public void rline(int x1,int y1,int x2, int y2) {
		this.screen.drawLine(x1, y1, x2, y2);
	}
	public void line(Point p1, Point p2) {
		this.rline(p1.x, p1.y,p2.x, p2.y);
	}
	public void Destroy() {
		this.screen = null;
		System.gc();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

}
