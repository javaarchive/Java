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
	public static void main(String[] args) throws IOException{
		
		// File Openning
		BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
		points = new ArrayList<Point>();
		segements = new ArrayList<LineSegement>();
		N = Integer.parseInt(f.readLine());
		Point[][] lookup = new Point[N][2];
		for(int i =0 ; i < N; i ++) {
			Point a,b;
			StringTokenizer st = new StringTokenizer(f.readLine());
			a = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			b = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			a = a.setIndex(i);
			b = b.setIndex(i);
			if(a.x > b.x) {
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
			//System.out.println("Endpoint "+ state + " "+p);
				if(state == 0) {
					pz.add(p.index);
				}else if(state == 1) {
					pz.remove(pz.indexOf(p.index));
					
				}else {
					continue;
				}
				int sz = pz.size();
				for(int j =0 ;j < sz ; j ++ ) {
					for(int k = j + 1; k < sz; k ++) {
						//if(j == k){
						//	continue;
						//}
						if(Point.intersection(segements.get(j),segements.get(k))) {
							//System.out.println("Intersectsion at "+segements.get(j)+" -|||- "+segements.get(k));
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
				}
			//}
		}
		// File Writting
		//System.out.println(max + " " + maxi + " " + Arrays.toString(tbl));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		pw.println(max + 1);
		pw.close();
	}

}
class Point implements Comparable<Point>{
	double x,y;
	int index = -1; 
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
	public Point setIndex(int i) {
		this.index = i;
		return this;
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
		return "| ("+this.x + ","+ this.y + ") INDEX "+this.index + " |";
	}
	boolean eq(Point q) {
		if(q.x == this.x && q.y == this.y) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Point arg0) {
		return Double.compare(this.x, arg0.x);
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
		return "{"+this.a+","+this.b+"}";
	}
	public double atX(double x) {
		if(this.a.y == this.b.y) { // Straight
			return this.a.y;
		}else {
			return this.a.y * (x/this.a.x);
		}
	}
	
	public Point atX_(double x) {
		return new Point(x,this.atX(x));
	}
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