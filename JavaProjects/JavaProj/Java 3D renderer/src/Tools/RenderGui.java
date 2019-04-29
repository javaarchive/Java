package Tools;

import java.awt.*;

import javax.swing.*;

public class RenderGui extends JPanel {
	private JDrawable aclass;
	public RenderGui(JDrawable c) {
		this.aclass=c;
	}

	public RenderGui(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public RenderGui(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public RenderGui(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	public void render(Graphics g) {
		System.out.println("It's rendering");
		this.aclass.render(g);
		//System.err.println("Render not implemented");
	}
	public void render() {
		this.repaint();
	}
	public void forcerender() {
		this.paint(this.getGraphics());
	}
	public void fr() {
		this.forcerender();
	}
	public void paintComponent(Graphics g) {
		Image img = createImage(this.getWidth(), this.getHeight());
		Graphics g1 = img.getGraphics();
		g1.setColor(getBackground());
	    g1.fillRect(0, 0, this.getWidth(), this.getHeight());
	    g1.setColor(getForeground());
		this.render(g1);
		g.drawImage(img, 0, 0, this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
