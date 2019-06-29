// This is cowjump version 2 aka Cow Steeplechase USACO US Open Silver problem 2

import java.io.*;
import java.util.*;
public class cowjump {
	static ArrayList<Point> points;
	static ArrayList<LineSegement> segements;
	static int N;
	
	public static Point op(int i,Point k, Point[][] input) {
		Point a = input[i][0];
		Point b = input[i][0];
		if(a.eq(k)) {
			return b;
		}else {
			return a;
		}
	}
	public static int num(int i,Point k, Point[][] input) {
		Point a = input[i][0];
		Point b = input[i][1];
		//System.out.println(a +" -- "+b);
		if(a.eq(k)) {
			//System.out.println("!");
			return 0;
		}else {
			return 1;
		}
	}
	public static boolean edge(int i, Point k, Point[][] input) {
		if(input[i][1].x == k.x && input[i][0].x < k.x) {
			return true;
		}
		else if(input[i][0].x == k.x && input[i][1].x < k.x) {
			return true;
		}
		return false;
	}
	public static void testIntersections() {
		assert Point.intersection(new Point(0,0), new Point(2,9), new Point(0,1), new Point(6,1))== true; 
		//assert Point.intersection(new Point(0,0), new Point(1,1), new Point(3,3), new Point(3,12))== false; 
		//assert Point.linesCompare(new LineSegement(new Point(0,0), new Point(2,3)),new LineSegement(new Point(0,3),new Point(9,1))) == -1;
		System.out.println("All Tests OK!");
	}
	public static void main(String[] args) throws IOException{
		//testIntersections();
		// File Openning
		BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
		points = new ArrayList<Point>();
		segements = new ArrayList<LineSegement>();
		N = Integer.parseInt(f.readLine());
		Point[][] lookup = new Point[N][2];
		for(int i =0 ; i < N; i ++) {
			Point a,b;
			StringTokenizer st = new StringTokenizer(f.readLine());
			a = new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
			b = new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
			a = a.setIndex(i);
			b = b.setIndex(i);
			if(a.compareTo(b) == 1) {
				lookup[i][0] = b;
				lookup[i][1] = a;
			}else {
				lookup[i][0] = a;
				lookup[i][1] = b;
			}
			points.add(a);
			points.add(b);
			segements.add(new LineSegement(a, b));
		}
		f.close();
		points.sort(null);
		// Algorthim
		int size = points.size();
		
		for(int i = 0; i < size; i ++) {
			//System.out.println(points.get(i));
		}
		for(int i =0 ; i < N; i ++) {
			//System.out.println(Arrays.toString(lookup[i]));
			//System.out.println(segements.get(i));
		}
		//int currentY = -1;
		//int index;
		// boolean newY = true;
		 List<Integer> pz = new ArrayList<Integer>();
		long[] tbl = new long[2*N];
		//long max = -1;
		//long maxi = -1;
		int minindex = Integer.MAX_VALUE;
		//System.out.println("===="+N +" "+points.size());
		int line_a = -1,line_b = -1;
		boolean found_solution = false;
		for(int i = 0 ; i < points.size() && !found_solution; i ++) {
			Point p = points.get(i);
			//index = p.index;
			/*if(p.y != currentY) {
				currentY = (int) p.y;
				continue;
			}else {
				*/
			int state = num(p.index,p,lookup);
			//System.out.println("Endpoint "+ state + " "+p);
				if(state == 0) {
					pz.add(p.index);					
				}else if(state == 1) {
					pz.remove(pz.indexOf(p.index));
					long sz = pz.size();
					for(int j =0 ;j < sz ; j ++ ) {
						
							//if(j == k){
							//	continue;
							//}
							if(Point.intersection(segements.get(pz.get(j)),segements.get(p.index))) {
								found_solution = true;
								line_a = pz.get(j);
								line_b = p.index;
								break;
							}
					}
					
					
				}else {
					continue;
				}
				int sz = pz.size();
				
			//}
		}
		//LineSegement l_a = segements.get(line_a);
		//LineSegement l_b = segements.get(line_b);
		LineSegement intersection_line;
		/*
		if(line_a > line_b) {
			intersection_line = segements.get(line_a);
		}else {
			intersection_line = segements.get(line_b);
		}
		*/
		intersection_line = segements.get(line_a);
		for(int i = 0; i < N; i ++) {
			if(i == line_a || i == line_b) {
				continue; // Skip the already found lines
			}
			if(Point.intersection(intersection_line, segements.get(i))) {
				System.out.println("Other connect");
				minindex = intersection_line.a.index;
				break;
			}
		}
		
		intersection_line = segements.get(line_b);
		for(int i = 0; i < N; i ++) {
			if(i == line_a || i == line_b) {
				continue; // Skip the already found lines
			}
			if(Point.intersection(intersection_line, segements.get(i))) {
				System.out.println("Other connect");
				minindex = intersection_line.a.index;
				break;
			}
		}
		if(minindex == Integer.MAX_VALUE) {
			minindex = Math.min(line_a, line_b);
		}
		// File Writting
		//System.out.println(max + " " + maxi + " " + Arrays.toString(tbl));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		pw.println(minindex + 1);
		pw.close();
	}

}
class Point implements Comparable<Point>{
	long x,y;
	int index = -1; 
	public Point(long x,long y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	public Point setIndex(int i) {
		this.index = i;
		return this;
	}
	
	static boolean intersection2(Point a, Point b,Point c, Point d) {
		// OLD CALCULATION CODE
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
	// Given three colinear points p, q, r, the function checks if 
	// point q lies on line segment 'pr' 
	static boolean onSegment(Point p, Point q, Point r) 
	{ 
		
	    if (q.x <= Long.max(p.x, r.x) && q.x >= Long.min(p.x, r.x) && 
	        q.y <= Long.max(p.y, r.y) && q.y >= Long.min(p.y, r.y)) 
	    return true; 
	  
	    return false; 
	} 
	  
	// To find orientation of ordered triplet (p, q, r). 
	// The function returns following values 
	// 0 --> p, q and r are colinear 
	// 1 --> Clockwise 
	// 2 --> Counterclockwise 
	static int orientation(Point p, Point q, Point r) 
	{ 
	    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
	    // for details of below formula. 
	    double val = (q.y - p.y) * (r.x - q.x) - 
	            (q.x - p.x) * (r.y - q.y); 
	  
	    if (val == 0) return 0; // colinear 
	  
	    return (val > 0)? 1: 2; // clock or counterclock wise 
	} 
	  
	// The main function that returns true if line segment 'p1q1' 
	// and 'p2q2' intersect. 
	static boolean intersection(Point p1, Point q1, Point p2, Point q2) 
	{ 
	    // Find the four orientations needed for general and 
	    // special cases 
	    int o1 = orientation(p1, q1, p2); 
	    int o2 = orientation(p1, q1, q2); 
	    int o3 = orientation(p2, q2, p1); 
	    int o4 = orientation(p2, q2, q1); 
	  
	    // General case 
	    if (o1 != o2 && o3 != o4) 
	        return true; 
	  
	    // Special Cases 
	    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
	    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
	  
	    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
	    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
	  
	    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
	    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
	  
	    // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
	    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
	  
	    return false; // Doesn't fall in any of the above cases 
	} 
	
	static Set<Pair<LineSegement,LineSegement>> notwice = new HashSet<Pair<LineSegement,LineSegement>>();
	static boolean intersection(LineSegement a,LineSegement b) {
		//if(notwice.contains(new Pair<LineSegement,LineSegement>(a,b))) {
			//return false;
		//}else {
			//notwice.add(new Pair<LineSegement,LineSegement>(a,b));
		//}
		return intersection(a.a, a.b, b.a, b.b);
	}
	boolean eq(Point q) {
		if(q.x == this.x && q.y == this.y) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "("+this.x + ","+ this.y + ","+this.index+")";
	}
	@Override
	public int compareTo(Point arg0) {
		if(arg0.x == this.x) {
			return Long.compare(this.y, arg0.y);
		}else {
			return Long.compare(this.x, arg0.x);
		}
		//
		//return 0;
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
	public String toString() {
		return "{"+this.a+", "+this.b+"}";
	}
	public double atX(double x) {
		if(this.a.y == this.b.y) { // Straight
			return this.a.y;
		}else {
			return this.a.y * (x/this.a.x);
		}
	}
	/*
	public Point atX_(double x) {
		return new Point(x,this.atX(x));
	}
	*/
	/*
	public String toString() {
		return this.a.toString() + " -- "+this.b.toString();
	}
	*/
}
class Pair<F, S> {
    private F first; //first member of pair
    private S second; //second member of pair

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public F getFirst() {
        return first;
    }
    @Override 
    public boolean equals(Object obj){
    	if(obj instanceof Pair) {
    		//Pair<LineSegement, LineSegement> p = (Pair<LineSegement, LineSegement>) obj;
    		//Pair<LineSegement, LineSegement> m = (Pair<LineSegement, LineSegement>) this;
    		//return (p.first.a.x == m.first.a.x) && (p.first.a.x == m.first.a.y) && (p.first.b.x == m.first.b.x) && (p.first.b.x == m.first.b.y) && (p.second.a.x == m.second.a.x) && (p.second.a.x == m.second.a.y) && (p.second.b.x == m.second.b.x) && (p.second.b.x == m.second.b.y);
    		Pair q = (Pair) obj;
    		return q.first.equals(this.first) && q.second.equals(this.second);
    	}else {
    		return false;
    	}
    }
    @Override
    public int hashCode() {
    	return first.hashCode() * second.hashCode();
    }
    public S getSecond() {
        return second;
    }
    
}