import java.io.*;
import java.util.*;
public class dining {
	public static final int NO_PARENT = -1; // Constant for no parent 
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dining.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N,M,K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		final int numOfCows =  N - 1;
		List<List<Integer>> graph = new ArrayList<>(N);
		for(int i = 0; i < N; i ++) {
			graph.add(new ArrayList<>());
		}
		Map<Pair,Integer> cost = new HashMap<>(); 
		for(int i =0 ; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int edgeCost = Integer.parseInt(st.nextToken());
			graph.get(start-1).add(end-1);
			graph.get(end-1).add(start-1);
			cost.put(new Pair(start-1,end-1), edgeCost);
		}
		Map<Pair,Integer> costWithHaybales = new HashMap<>(cost); 
		System.out.println("Cost without haybales: "+cost);
		System.out.println("Graph as an edgelist:  "+graph);
		//int[] taste = new int[N];
		Pair key;
		//cost.get(new Pair(0,1));
		for(int i = 0; i < K; i ++) {
			st = new StringTokenizer(f.readLine());
			int index = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			//costWithHaybales.get(new Pair(0,1));
			for(int node: graph.get(index)) {
				key = new Pair(index,node);//assert key.equals(new Pair(node,index));
				//System.out.println("Map: "+costWithHaybales);
				//System.out.println(key+ " "+costWithHaybales.get(key));
				costWithHaybales.put(key, 
						costWithHaybales.get(key) - value);
			}
			//taste[index] = value;
		}
		System.out.println("Cost with haybales:    "+costWithHaybales);
		f.close();
		int[] empty = new int[M];
		Arrays.fill(empty, Integer.MAX_VALUE);
		int[] distTo = new int[M];
		for(int i = 0; i < numOfCows; i ++) {
			distTo = Arrays.copyOf(empty, M);
		}
	}

}

// Order does not matter pair
class Pair{
	int x,y;
	public Pair(int x,int y) {
		this.x =x;
		this.y =y;
	}
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pair) {
			Pair p = (Pair) obj;
			if((p.x == this.x && p.y == this.y) || (p.x == this.y && this.x == p.y)) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	@Override
	public int hashCode(){
		return (Integer.hashCode(this.x) + 3) * (Integer.hashCode(this.y) + 3);
	}
}
class Edge{
	int x;
	int y;
	int weight;
	public Edge(int x,int y,int weight) {
		this.x = x;
		this.y =y;
		this.weight = weight;
	}
	public String toString() {
		return "("+this.x+"--"+this.y+" = "+this.weight+")";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge) {
			Edge other = (Edge) obj;
			if((this.x == other.x && this.y == other.y) || (this.x == other.y && this.y == other.x)) {
				if(this.weight == other.weight) {
					return true;
				}else {
					return false;
				}
			}
			return false;
		}else {
			return false;
		}
	}
}