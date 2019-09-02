import java.io.*;
import java.util.*;
public class dining {
	public static int[] distTo;
	public static int[] distOrig;
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
		//System.out.println("Cost without haybales: "+cost);
		//System.out.println("Graph as an edgelist:  "+graph);
		int[] taste = new int[N];
		//Pair key;
		List<Integer> bales = new ArrayList<>();
		//Map<Integer, Integer> haybales = new HashMap<>();
		//cost.get(new Pair(0,1));
		for(int i = 0; i < K; i ++) {
			st = new StringTokenizer(f.readLine());
			int index = Integer.parseInt(st.nextToken()) - 1;
			bales.add(index);
			int value = Integer.parseInt(st.nextToken());
			/*
			//costWithHaybales.get(new Pair(0,1));
			for(int node: graph.get(index)) {
				Pair key = new Pair(index,node);//assert key.equals(new Pair(node,index));
				//System.out.println("Map: "+costWithHaybales);
				//System.out.println(key+ " "+costWithHaybales.get(key));
				//costWithHaybales.put(key, 
				//		costWithHaybales.get(key) - value);
			}
			*/
			taste[index] = value;
		}
		//System.out.println("Cost with haybales:    "+costWithHaybales);
		f.close();
		int[] empty = new int[N];
		Arrays.fill(empty, Integer.MAX_VALUE);
		empty[N-1] = 0;
		//distTo = new int[M];
		//distTo= Arrays.copyOf(empty, N);
		distOrig= Arrays.copyOf(empty, N);
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<Integer> nextNodes = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(dining.distTo[arg0], dining.distTo[arg1]);
				//return 0;
			}
		});		
		/*
		nextNodes.add(N-1);
		// begin dijkstra from barn with haybales
		while(visited.size() < N) {
			System.out.println(visited.size());
			int u = nextNodes.remove(); // Get next node
			System.out.println(u);
			visited.add(u);
			List<Integer> adj = graph.get(u);
			for(int node:adj) {
				if(!visited.contains(node)) {
					int edgeDist = costWithHaybales.get(new Pair(u,node));
					int totalDist = distTo[u] + edgeDist;
					if (totalDist < distTo[node]) 
	                    distTo[node] = totalDist; 
					nextNodes.add(node);
				}
			}
		}
		*/
		PriorityQueue<Integer> nextNodesOrig = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(dining.distOrig[arg0], dining.distOrig[arg1]);
				//return 0;
			}
		});	
		//visited.clear();
		
		nextNodesOrig.add(N-1);
		// begin dijkstra from barn without haybales
				while(visited.size() < N) {
					int u = nextNodesOrig.remove(); // Get next node
					visited.add(u);
					List<Integer> adj = graph.get(u);
					for(int node:adj) {
						if(!visited.contains(node)) {
							int edgeDist = cost.get(new Pair(u,node));
							int totalDist = distOrig[u] + edgeDist;
							if (totalDist < distOrig[node]) 
			                    distOrig[node] = totalDist; 
							nextNodesOrig.add(node);
						}
					}
				}
		//System.out.println("Output          :" + Arrays.toString(distOrig));
		
		//for(int bale: graph.get(N-1)) {
		//	graph.get(bale).remove((Object) (N-1));
		//}
		
		//graph.get(N-1).clear();
		
		for(int i = 0 ; i < K;  i++) {
			int target = bales.get(i);
			//for(int bale:graph.get(target)) {
			//	graph.get(bale).remove(target);
			//}
			//graph.get(target).clear();
			graph.get(target).add(N-1);
			graph.get(N-1).add(target);
			costWithHaybales.put(new Pair(target,N-1), distOrig[target] - taste[i]);
		}
		visited.clear();
		distTo= Arrays.copyOf(empty, N);
		nextNodes.add(N-1);
		// begin dijkstra from barn with haybales
		while(visited.size() < N) {
			//System.out.println(visited.size());
			int u = nextNodes.remove(); // Get next node
			//System.out.println(u);
			visited.add(u);
			List<Integer> adj = graph.get(u);
			for(int node:adj) {
				if(!visited.contains(node)) {
					int edgeDist = costWithHaybales.get(new Pair(u,node));
					int totalDist = distTo[u] + edgeDist;
					if (totalDist < distTo[node]) 
	                    distTo[node] = totalDist; 
					nextNodes.add(node);
				}
			}
		}
		//System.out.println("Output(haybales):" + Arrays.toString(distTo));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		for(int i  =0 ; i < numOfCows; i ++) {
			if(distTo[i] >= distOrig[i]) {
				pw.println(1);
			}else {
				pw.println(0);
			}
		}
		pw.close();
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