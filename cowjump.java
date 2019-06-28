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
		int output = pointYCompare(m.a, l.a) * pointYCompare(m.b, l.b);;
		System.out.println("Intersection of line "+m+" and "+l + " is "+output + " == -1");
		return output;
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
			if(input[i][0] == null && input[i][1] == null) {
				System.out.println("End of segments");
				break;
			}
			System.out.println("Checking "+s.a.x+" - "+input[i][0].x + " - "+s.b.x);
			boolean firstWithinLine = (s.a.x <= input[i][0].x && s.b.x >= input[i][0].x);
			System.out.println("(s.a.x <= input[i][0].x && s.b.x >= input[i][0].x)");
			System.out.println((s.a.x <= input[i][0].x)+" && " + (s.b.x >= input[i][0].x));
			System.out.println("firstWithinLine = "+firstWithinLine);
			//|| (s.a.y <= input[i][0].y && s.b.y >= input[i][0].y);
			if(firstWithinLine) {
				// TODO check line cross logic
				LineSegement full = new LineSegement(input[i][0], input[i][1]);
				if(linesCompare(s,new LineSegement(full.atX_(s.a.x),full.atX_(s.a.y))) == -1) {
					System.out.println("Intersect!");
					return true;
				}else {
					System.out.println("No Intersection!");
				}
				//continue; // Both statements may be true
			}
			boolean secondWithinLine = (s.a.x <= input[i][1].x && s.b.x >= input[i][1].x);
			//|| (s.a.y <= input[i][0].y && s.b.y >= input[i][0].y);
			if(secondWithinLine && !firstWithinLine) {
				// TODO check line cross logic
				LineSegement full = new LineSegement(input[i][0], input[i][1]);
				if(linesCompare(s,new LineSegement(full.atX_(s.a.x), full.atX_(s.b.x))) == -1) {
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
		//testIntersections();
		//testIntersections();
		BufferedReader f = new BufferedReader(new FileReader("cowjump2.in"));
		int N = Integer.parseInt(f.readLine());
		Point[][] input = new Point[N][2];
		//System.out.println(input[0][0]);
		int output = -1;
		for(int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			boolean status;
			if(a.x > b.x) {
				status = sweepCheck(
						new LineSegement(b,a),
						input);
			}else {
			status = sweepCheck(
					new LineSegement(a,b),
					input);
			}
			System.out.println("That was line "+i);
			output = i;
			if(status) {
				break;
			}

 			input[i][0] = a;
			input[i][1] = b;
			/*for(int j = 0; j < i; j ++) {
				if(Point.intersection(input[j][0], input[j][1], input[i][0], input[i][1])) {
					PrintWriter pw = new PrintWriter("cowjump.out");
					pw.println(i+1);
					pw.close();
					System.exit(0);
=======
=======
>>>>>>> parent of c6da410... Long Proofing
=======
>>>>>>> parent of c6da410... Long Proofing
			a = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			b = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
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
			System.out.println(points.get(i));
		}
		for(int i =0 ; i < N; i ++) {
			System.out.println(Arrays.toString(lookup[i]));
			System.out.println(segements.get(i));
		}
		
		int currentY = -1;
		int index;
		// boolean newY = true;
		 List<Integer> pz = new ArrayList<Integer>();
		int[] tbl = new int[N];
		int max = -1;
		int maxi = -1;
		for(int i = 0 ; i < N; i ++) {
			Point p = points.get(i);
			//index = p.index;
			/*if(p.y != currentY) {
				currentY = (int) p.y;
				continue;
			}else {
				*/
			int state = num(p.index,p,lookup);
			System.out.println("Endpoint "+ state + " "+p);
				if(state == 0) {
					pz.add(p.index);
					int sz = pz.size() - 1;
					LineSegement newline = segements.get(p.index);
					for(int j =0 ;j < sz; j ++ ) {
							if(Point.intersection(newline,segements.get(pz.get(j)))) {
								System.out.println("Intersectsion at "+segements.get(p.index)+" -|||- "+segements.get(j));
								tbl[i] ++;
								tbl[j] ++;
								if(tbl[i] > max) {
									max = tbl[i];
									maxi = i;
								}
								if(tbl[j] > max) {
									max = tbl[j];
									maxi = j;
								}
							
						}
					}
				}else if(state == 1) {
					pz.remove(pz.indexOf(p.index));
					
				}else {
					continue;
>>>>>>> parent of c6da410... Long Proofing
				}
			}*/
		}
		f.close();
		PrintWriter pw = new PrintWriter("cowjump.out");
		pw.println(output+1);
		pw.close();
		System.exit(0);

<<<<<<< HEAD
 	}

 }
class Point{
	double x,y;
=======
}
class Point implements Comparable<Point>{
	double x,y;
	int index = -1; 
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of c6da410... Long Proofing
=======
>>>>>>> parent of c6da410... Long Proofing
=======
>>>>>>> parent of c6da410... Long Proofing
	public Point(double x,double y) {
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
	static boolean intersection(Point a, Point b,Point c, Point d) {
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
<<<<<<< HEAD
	public String toString() {
		return "("+this.x + ","+ this.y + ")";
=======
	// Given three colinear points p, q, r, the function checks if 
	// point q lies on line segment 'pr' 
	static boolean onSegment(Point p, Point q, Point r) 
	{ 
	    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && 
	        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) 
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
		if(notwice.contains(new Pair<LineSegement,LineSegement>(a,b))) {
			return false;
		}else {
			notwice.add(new Pair<LineSegement,LineSegement>(a,b));
		}
		return intersection(a.a, a.b, b.a, b.b);
	}
	public String toString() {
		return "("+this.x + ","+ this.y + ","+this.index+")";
	}
	boolean eq(Point q) {
		if(q.x == this.x && q.y == this.y) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Point arg0) {
		if(arg0.x == this.x) {
			return Double.compare(this.y, this.y);
		}else if(this.x > arg0.x) {
			return -1;
		}else {
			return 1;
		}
		//return Double.compare(this.x, arg0.x);
		//return 0;
>>>>>>> parent of c6da410... Long Proofing
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
	public double atX(double x) {
		if(this.a.y == this.b.y) { // Straight
			return this.a.y;
		}else {
			return this.a.y * (x/this.a.x);
		}
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public Point atX_(double x) {
		return new Point(x,this.atX(x));
	}
=======
=======
>>>>>>> parent of c6da410... Long Proofing
=======
>>>>>>> parent of c6da410... Long Proofing
	
	public Point atX_(double x) {
		return new Point(x,this.atX(x));
	}
	/*
>>>>>>> parent of c6da410... Long Proofing
	public String toString() {
		return this.a.toString() + " -- "+this.b.toString();
	}
} 