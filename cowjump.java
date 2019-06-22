import java.io.*;
import java.util.*;
public class cowjump {
	public static int pointYCompare(Point p1, Point p2) {
		// Compare points
		// Check if p2 is above, below, or next to p1
		System.out.println("pointycompare(("+p1.x+","+p1.y+"),("+p2.x+","+p2.y+")");
		if(p1.y == p2.y) {
			System.out.println("output: 0"); // Same Y
			return 0;
		}
		if(p2.y < p1.y) {
			System.out.println("output: -1"); // below
			return -1;
		}
		if(p2.y > p1.y) {
			System.out.println("output: 1"); // above
			return 1;
		}
		System.out.println("NONE OF THE ABOVE"); // This code should never run, but just keeping this to prevent syntax errors
		return -9999999;
	}
	public static int linesCompare(LineSegement m, LineSegement l) {
		System.out.println("Checking if line ("+m.a.x+","+m.a.y+")--"+"("+m.b.x+","+m.b.y+")" + " intersects with " + "("+l.a.x+","+l.a.y+")--"+"("+l.b.x+","+l.b.y+")");
		return pointYCompare(m.a, l.a) * pointYCompare(m.b, l.b);
	}
	public static void testIntersections() {
		assert Point.intersection(new Point(0,0), new Point(2,9), new Point(0,1), new Point(6,1))== true; 
		//assert Point.intersection(new Point(0,0), new Point(1,1), new Point(3,3), new Point(3,12))== false; 
		assert linesCompare(new LineSegement(new Point(0,0), new Point(2,3)),new LineSegement(new Point(0,3),new Point(9,1))) == -1;
		System.out.println("All Tests OK!");
	}
	public static boolean sweepCheck(LineSegement s,Point[][] input) {
		for(int i = 0; i < input.length; i ++) {
			System.out.println("Checking line "+i);
			if(input[i][0] == null || input[i][1] == null) {
				System.out.println("End of segments");
				break;
			}
			System.out.println("Checking "+s.a.x+" - "+input[i][0].x + " - "+s.b.x);
			boolean firstWithinLine = (s.a.x <= input[i][0].x && s.b.x >= input[i][0].x);
			System.out.println("firstWithinLine = "+firstWithinLine);
			//|| (s.a.y <= input[i][0].y && s.b.y >= input[i][0].y);
			if(firstWithinLine) {
				// TODO check line cross logic
				if(linesCompare(s,new LineSegement(input[i][0], input[i][1])) == -1) {
					System.out.println("Intersect!");
					return true;
				}else {
					System.out.println("No Intersection!");
				}
				continue; // Both statements may be true
			}
			boolean secondWithinLine = (s.a.x <= input[i][1].x && s.b.x >= input[i][1].x);
			//|| (s.a.y <= input[i][0].y && s.b.y >= input[i][0].y);
			if(secondWithinLine) {
				// TODO check line cross logic
				if(linesCompare(s,new LineSegement(input[i][0], input[i][1])) == -1) {
					System.out.println("Intersect!");
					return true;
				}else {
					System.out.println("No Intersection!");
				}
			}
			
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		testIntersections();
		// TODO Auto-generated method stub
		//testIntersections();
		BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
		int N = Integer.parseInt(f.readLine());
		Point[][] input = new Point[N][2];
		//System.out.println(input[0][0]);
		for(int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if(a.x > b.x) {
				System.out.println(sweepCheck(
						new LineSegement(b,a),
						input));
			}else {
			System.out.println(sweepCheck(
					new LineSegement(a,b),
					input));
			}
			input[i][0] = a;
			input[i][1] = b;
			/*for(int j = 0; j < i; j ++) {
				if(Point.intersection(input[j][0], input[j][1], input[i][0], input[i][1])) {
					PrintWriter pw = new PrintWriter("cowjump.out");
					pw.println(i+1);
					pw.close();
					System.exit(0);
				}
			}*/
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

class LineSegement {
	Point a,b;
	public LineSegement(Point a,Point b) {
		if(a.x > b.x) {
			this.a = b;
			this.b = a;
		}else {
		this.a = a;
		this.b = b;
		}
	}
	public double atX(int x) {
		if(this.a.y == this.b.y) { // Straight
			return this.a.y;
		}else {
			return this.a.y * (x/this.a.x);
		}
	}
}