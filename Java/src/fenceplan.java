import java.io.*;
import java.util.*;
public class fenceplan {
	// Func Ref
    // Output values 
    // 0 = p, q, r colinear 
    // 1 = Clockwise 
    // 2 = Counterclockwise 
	static int[][] matrix;
	static Point[] graph;
    public static int orientation(Point p, Point q, Point r) 
    { 
        int val = (q.y - p.y) * (r.x - q.x) - 
                  (q.x - p.x) * (r.y - q.y); 
       
        if (val == 0) return 0;  // collinear 
        return (val > 0)? 1: 2; // clock or counterclock wise 
    }
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		prev = new int[N];
		matrix = new int[N][N];
		graph = new Point[N];
		for(int i = 0; i < N;i ++) {
			st = new StringTokenizer(f.readLine());
			int x,y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[i] = new Point(x,y);
		}
		Arrays.fill(prev, -1);
	}
	static int[] prev;
	public void crawl(int k) {
		
	}
}
class Point{
	int x = 0; int y = 0;
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}