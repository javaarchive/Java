import java.io.*;
import java.util.*;
public class dining {
	static int V;
    static int minDist(int dist[], boolean[] set1)  { 
        int min = Integer.MAX_VALUE, min_index=-1; // Computers are too stupid to understand infinite
        for (int v = 0; v < V; v++) 
            if (set1[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        return min_index; 
    } 
    static final int OFFSET  = -1; // Offset by 1 for adjancey matirix because index begins at 0
    public static int[] root;
    public static int status = -1;
    public static int[] arr;
    public static int[] pasture;
    public static List<IPair> pastures = new ArrayList<IPair>();
    
    public static int[] dijkstra(int[][] graph1, int startVertex) {
    	status = 0;
        int N = graph1.length;
        int[] dists = new int[N];
        boolean[] added = new boolean[N];
        for (int vertexIndex = 0; vertexIndex < N; vertexIndex++) {
            dists[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        dists[startVertex] = 0;
        int[] parents = new int[N];
        parents[startVertex] = -1;
        for (int i = 1; i < N; i++) {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < N; vertexIndex++) {
                if (!added[vertexIndex] && dists[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = dists[vertexIndex];
                }
            }
            added[nearestVertex] = true;
            for (int vertexIndex = 0; vertexIndex < N; vertexIndex++) {
            	
                int edgeDistance = graph1[nearestVertex][vertexIndex];
                // Used to be    >
                if (edgeDistance != 0 && ((shortestDistance + edgeDistance) < dists[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    dists[vertexIndex] = shortestDistance +
                        edgeDistance;
                   
                }
                if(pastures.contains(new IPair(nearestVertex,vertexIndex))) {
                	System.out.println("Info: "+nearestVertex+" "+vertexIndex);
                	System.out.println("Set "+(nearestVertex - 1) + " and "+(vertexIndex - 1));
                	arr[nearestVertex] = 1;
                	arr[vertexIndex] = 1;
                	/*
                	if(pasture[nearestVertex] > 0) {
                	for(int j = 0; j < N; j++) {
        				
        					graph1[nearestVertex][j] = 0;
                        	graph1[j][nearestVertex] = 0;
        				
        			}
                	}
                	if(pasture[vertexIndex] > 0) {
                    	for(int j = 0; j < N; j++) {
            				
            					graph1[j][vertexIndex] = 0;
                            	graph1[vertexIndex][j] = 0;
            				
            			}
                    	}
                    */
                	graph1[nearestVertex][vertexIndex] = 0;
                	graph1[vertexIndex][nearestVertex] = 0;
                }
            }
        }
        root = parents;
        return dists;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("1.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N][N];
		arr = new int[N];
		pasture = new int[N];
		for(int i = 0; i < N; i++){
		//Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken()),y = Integer.parseInt(st.nextToken()),z = Integer.parseInt(st.nextToken());
			matrix[x + OFFSET][y + OFFSET] = z;
			matrix[y + OFFSET][x + OFFSET] = z;
		}
		//System.out.println(Arrays.deepToString(matrix).replaceAll("],*", "],\n"));
		// Dijkstra Modification begins here
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pasture[x-1] = y;
			x = x + OFFSET;
			for(int j = 0; j < N; j++) {
				if(matrix[j][x] != 0) {
					//System.out.println("Override 1   "+j+" "+x+" "+y);
				matrix[j][x] = matrix[j][x] - y;
				}
				if(matrix[x][j] != 0) {
					//System.out.println("Override 2   "+x+" "+j+" "+y);
				matrix[x][j] = matrix[x][j] - y;
				}
				
			}
			pastures.add(new IPair(x,y));
			
		}
		// End modification
		System.out.println("Modifacation Complete");
		System.out.println(Arrays.deepToString(matrix).replaceAll("],*", "],\n"));
		int[] out = dijkstra(matrix, N-1);
		
		System.out.println(Arrays.toString(root));
		System.out.println(Arrays.toString(out));
		PrintWriter pw = new PrintWriter(new FileWriter("dining.out"));
		for(int k:arr) {
			pw.println(k);
		}
		pw.close();
		
	}
}
class IPair implements Comparable<IPair>{
	int x,y;
	public IPair(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public IPair() {
		this.x = 0;
		this.y = 0;
	}
	@Override
	public int compareTo(IPair arg0) {
		
		return this.x - arg0.x;
	}
	
	
}
