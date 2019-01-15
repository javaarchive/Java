import java.io.*;
import java.util.*;

public class square {

	public static int GetInt(StringTokenizer st) throws IOException{
		return Integer.parseInt(st.nextToken());
		
	}
	private static BufferedReader f;
	public static int[] sort(int x,int y) {
		int[] output= {y,x};
		if(x>y) {
			output[0]=x;
			output[1]=y;
		}
		for(int i:output) {
			System.out.print(i+"  ");
		}
		System.out.println();
		return output;
	}
	public static int solve(int x1,int y1,int x2,int y2,int X1,int Y1,int X2,int Y2) {
		int[] a,b,c,d,e,f,g,h;
		int MINX,MINY,MAXX,MAXY;
		a=sort(x1,x2);
		b=sort(X1,X2);
		c=sort(y1,y2);
		d=sort(Y1,Y2);
		e=sort(a[0],b[0]);
		f=sort(c[0],d[0]);
		g=sort(a[1],b[1]);
		h=sort(c[1],d[1]);
		MAXX=e[0];
		MAXY=f[0];
		MINY=h[1];
		MINX=g[1];
		int x,y;
		x=MAXX-MINX;
		y=MAXY-MINY;
		if(x>y) {
			return x*x;
		}else {
			return y*y;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		f = new BufferedReader(new FileReader("square.in"));
		StringTokenizer st1;
		StringTokenizer st2;
		st1=new StringTokenizer(f.readLine());
		st2=new StringTokenizer(f.readLine());
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		pw.print(solve(GetInt(st1),GetInt(st1),GetInt(st1),GetInt(st1),GetInt(st2),GetInt(st2),GetInt(st2),GetInt(st2)));
		pw.close();
		f.close();
		
		
	}

}
