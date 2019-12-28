import java.io.*;
import java.util.*;
public class milkvisits {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[] lookup = f.readLine().toCharArray();
		Map<Integer, List<Integer>> connections = new HashMap<>();
		for(int i =1 ; i < (N+1); i ++) {
			connections.put(i, new ArrayList<>());
		}
		for(int i = 0; i < N-1; i ++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			connections.get(x).add(y);
			connections.get(y).add(x);
		}
		int[] seg = new int[N];
		int segNum = 1;
		Stack<Traversal> ts = new Stack<>();
		
		
		//int test = 0;
		//char target = lookup[test];
		
		for(int i = 1; i < (N+1); i ++) {
			segNum++;
			if(seg[i-1] != 0) {
				continue;
			}
			char target = lookup[i-1];
			ts.push(new Traversal(i));
			while(!ts.empty()) {
				Traversal t = ts.pop();
				seg[t.lastNode-1] = segNum;
				for(int node: connections.get(t.lastNode)) {
					if(lookup[node-1] == target && seg[node-1]==0) {
						ts.push(new Traversal(node));
					}
				}
			}
		}
		//System.out.println("Node numbers      : {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,...}");
		//System.out.println("Generated Seg Data: "+Arrays.toString(seg));
		//System.out.println("Lookup database   : "+Arrays.toString(lookup));
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			char T = st.nextToken().charAt(0);
			if(seg[a-1] != seg[b-1]) {
				pw.print("1");
			}else {
				if(lookup[a-1] == T && lookup[b-1] == T) {
					pw.print("1");
				}else {
					pw.print("0");
				}
			}
		}
		pw.println();
		f.close();
		pw.close();
	}

}
class Traversal {
	int lastNode;
	
	public Traversal(int lastNode) {
		this.lastNode = lastNode;
	}
}
class Path{
	public int x,y,w;
	public Path(int x,int y) {
		this.x = x;
		this.y = y;
		//this.w = length;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Path) {
			Path p = (Path) o;
			return (this.x == p.x)&&(this.y == p.y);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return Integer.hashCode(this.x) * Integer.hashCode(this.y+1);
	}
}