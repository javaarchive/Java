//package guiests;
import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.math.BigInteger;
import java.util.ArrayList;
//import org.

import javax.swing.JFrame;
public class pascal implements KeyListener,MouseWheelListener {
	public void mouseWheelMoved(MouseWheelEvent e) {
		int a=e.getWheelRotation();
		if(a==0) {
			System.err.println("What?");
		}else if(a>0) {
			down();
		}else if(a<0) {
			up();
		}else {
			System.err.println("What?????????");
		}
	}
	private Canvas canvas;
	private BigInteger YSPACING;
	private BigInteger START;
	private BigInteger N=new BigInteger("50");
	public void down() {
		this.START=this.START.add(BigInteger.ONE);
    	this.N=this.N.add(BigInteger.ONE);
    	this.canvas.repaint();
	}
	public void up() {
		this.START=this.START.subtract(BigInteger.ONE);
    	this.N=this.N.subtract(BigInteger.ONE);
    	this.canvas.repaint();
	}
	public void keyTyped(KeyEvent e) {
		//System.err.println("Triggered");
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
        	down();
        }else if (e.getKeyCode()==KeyEvent.VK_UP) {
        	up();
        }
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        this.keyTyped(e);
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }
	public static void main(String[] args) {
		(new pascal()).makegui();
	}
	public void makegui() {
		YSPACING = new BigInteger("40");
	        START = BigInteger.ONE;
		 JFrame frame = new JFrame("Pascal's triangle: Viewing "+N+" rows");
		 frame.setUndecorated(true);
	     canvas = new Canvas() {
	    	 
	    	 public BigInteger factorial(BigInteger n) {
	    		    BigInteger f = BigInteger.ONE;
	    		    for(BigInteger i=BigInteger.ONE;i.compareTo(n)!=1;i=i.add(BigInteger.ONE)) {
	    		        f=f.multiply(i);
	    		    }
	    		    //System.out.println(n+"!="+f);
	    		    return f;
	    		}
	    	 @SuppressWarnings("unused")
			public long fact(long n,long k) {
	    		    long f = n;
	    		    for(long i=n;i>(n-k-1);i--) {
	    		        f *= i;
	    		    }
	    		    return f;
	    		}
	    	 
	    	 public BigInteger[][] dp1=new BigInteger[N.intValue()+1][N.intValue()+1];
			
	    	 public BigInteger c(BigInteger n,BigInteger k) {
	    		 BigInteger i;
	    		 try {
	    		 if(dp1[n.intValue()][k.intValue()]==BigInteger.ZERO || dp1[n.intValue()][k.intValue()]==null) {
	    			 dp1[n.intValue()][k.intValue()]=(factorial(n).divide(factorial(k).multiply(factorial(n.subtract(k)))));
	    		 }
	    		 i=dp1[n.intValue()][k.intValue()];
	    		 //System.out.println("C("+n+","+k+")"+"="+i);
	    		 } catch(Exception e) {
	    			 i=BigInteger.ONE;
	    			 //e.printStackTrace(System.out);
	    			 return (factorial(n).divide(factorial(k).multiply(factorial(n.subtract(k)))));
	    		 }
	    		 return i;
	    	 }
	    	 public ArrayList<BigInteger> genrow(BigInteger row){
	    		 ArrayList<BigInteger> o=new ArrayList<BigInteger>();
	    		 //System.out.println("Generating row "+row);
	    		 for(BigInteger i=BigInteger.ZERO;i.compareTo(row)==-1;i=i.add(BigInteger.ONE)) {
	    			 //System.out.println("Puting item "+i);
	    			 o.add(c(row.subtract(BigInteger.ONE),i));
	    		 }
	    		 return o;
	    	 }
	    	 public String repeat(int count, String with) {
	    		    return new String(new char[count]).replace("\0", with);
	    		}
	    	 public void drawints(ArrayList<BigInteger> x,Graphics2D g,BigInteger y) {
	    		 //g.clearRect(0, 1024, 0, 1024);
	    		 //double w=this.getSize().getWidth();
	    		 final int SPACING=13;
	    		 //double center=w/2;
	    		 g.setFont(new Font("arial", Font.PLAIN, 18));
	    		 String out="";
	    		 for(int i=0;i<x.size();i++) {
	    			 out=out+x.get(i)+repeat(SPACING," ");
	    		 }
	    		 out=out.substring(0, out.length()-SPACING);
	    		 FontMetrics fm = g.getFontMetrics();
	             long x2 = ((getWidth() - fm.stringWidth(out)) / 2);
	             //long y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
	    			g.drawString(out, x2,y.longValueExact());
	    		 
	    	 }
	    	 public void paint(Graphics g) {
	 	        //g.fillOval(100, 100, 200, 200);
	 	        Graphics2D g2;
	 	        g2 = (Graphics2D) g;
	 	        //System.out.println("Drawing");
	 	        //ArrayList<Long> k=new ArrayList<Long>();
	 	        
	 	        
	 	        BigInteger k=BigInteger.ZERO;
	 	        for(BigInteger i=START;i.compareTo(N)==-1;i=i.add(BigInteger.ONE)) {
	 	        	k=k.add(BigInteger.ONE);
	 	        drawints(genrow(i),g2,k.multiply(YSPACING));
	 	        }
	 	    }
	     };
	     
	     canvas.setSize(1024, 1024);
	     frame.add(canvas);
	     frame.pack();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setVisible(true);
	     canvas.addKeyListener(this);
	     canvas.addMouseWheelListener(this);
	     canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}
	

}