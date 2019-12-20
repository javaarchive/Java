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
		for(int i =0 ; i < N; i ++) {
			connections.put(i+1, new ArrayList<>());
		}
		for(int i = 0; i < N-1; i ++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			connections.get(x).add(y);
			connections.get(y).add(x);
		}
		String answer = "";
		for(int i =0 ; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			char pref = st.nextToken().charAt(0);
			Set<Integer> visited = new HashSet<>();
			Queue<Traversal> options = new LinkedList<>();
			List<Integer> base = new ArrayList<>();
			base.add(a);
			options.add(new Traversal(base, lookup[a-1] == pref));
			while(!options.isEmpty()) {
				Traversal t =options.poll();
				int lastNode = t.nodes.get(t.nodes.size()-1);
				if(lastNode == b) {
					if(lookup[b-1] == pref || t.good) {
						answer += "1";
					}else {
						answer += "0";
					}
					break; // FINALLY
				}
				for(int node: connections.get(lastNode)) {
					if(visited.contains(node)) {
						continue;
					}
					List<Integer> al = new ArrayList<>(t.nodes);
					al.add(node);
					options.add(new Traversal(al, lookup[node-1] == pref || t.good));
				}
				visited.add(lastNode);
			}
		}
		pw.println(answer);
		f.close();
		pw.close();
	}

}
class Traversal {
	List<Integer> nodes;
	boolean good;
	public Traversal(List<Integer> nodes, boolean gotMilk) {
		this.good =gotMilk;
		this.nodes = nodes;
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