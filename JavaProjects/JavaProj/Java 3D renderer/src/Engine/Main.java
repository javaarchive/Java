/*
 * Extremely cool 3D graphics engine
 * Version 1.0.2
 */
package Engine;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Tools.JDrawable;
import Tools.Point;
import Tools.Render;
import Tools.RenderGui;
import Tools.Core;
public class Main implements JDrawable, KeyListener, ActionListener{
	RenderGui rg;
	public int k = 90;
	public JFrame frame;
	public Main() {
		System.out.println("Graphics engine starting up.....");
		frame = new JFrame("3D graphics");
		frame.setSize(800, 800);
		rg = new RenderGui(this);
		frame.add(rg);
		frame.setVisible(true);
		frame.addKeyListener(this);
		Timer t = new Timer(10,this);
		t.start();
	}
	public static void main(String[] args) {
		Main main = new Main();
		
	}
	@Override
	public void render(Graphics g) {
		k = k + 1;
		Render r = new Render(g);
		r.offsetx = 250;
		r.offsety = 250;
		Point a = new Point(150,150);
		Point b = new Point(450,150);
		Point c = new Point(550,150);
		Point d = new Point(550,350);
		//r.line(a ,Core.calc2D( Core.radian(k), b, a));
		//r.line(a ,Core.calc2D( Core.radian(k), c, a));
		//r.line(a ,Core.calc2D( Core.radian(k), c, d));
		//r.line(a ,Core.calc2D( Core.radian(k), a, d));
		r.line(a ,Core.calc2D( Core.radian(k), d, a));
		r.line(b ,Core.calc2D( Core.radian(k), d, a));
		//r.rect(20, 10, 75, 90);
		r.Destroy();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			rg.render();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		rg.render();
		
	}
}
