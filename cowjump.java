import java.io.*;
import java.util.*;
public class cowjump {
	public static void testIntersections() {
		assert Point.intersection(new Point(0,0), new Point(2,9), new Point(0,1), new Point(6,1))== true; 
		assert Point.intersection(new Point(0,0), new Point(1,1), new Point(3,3), new Point(3,12))== false; 
		System.out.println("All Tests OK!");
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//testIntersections();
		BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
		int N = Integer.parseInt(f.readLine());
		Point[][] input = new Point[N][2];
		//System.out.println(input[0][0]);
		for(int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			input[i][0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			input[i][1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int j = 0; j < i; j ++) {
				if(Point.intersection(input[j][0], input[j][1], input[i][0], input[i][1])) {
					PrintWriter pw = new PrintWriter("cowjump.out");
					pw.println(i+1);
					pw.close();
					System.exit(0);
				}
			}
		}
	}

}
class Point{
	int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	static boolean intersection(Point a, Point b,Point c, Point d) {
		Point E = new Point(b.x - a.x, b.y - a.y);
		Point F = new Point(d.x - c.x, d.y - c.y);
		Point P = new Point(-E.y, E.x);
		Point Q = new Point(a.x - c.x, a.y - c.y);
		double k = F.x * P.x + F.y * P.y;
		if(k == 0) {
			// Parallel
			return false;
		}
		
		double h = (Q.x * P.x + Q.y * P.y)/(k);
		if(0 <= h && h <= 1) {
			return true;
		}
		return false;
	}
}