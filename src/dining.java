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
    static int[] dijkstra(int graph[][], int src) { 
    	V = graph.length;
        int dist[] = new int[V]; 
        root = new int[V];
        boolean set1[] = new boolean[V]; 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            set1[i] = false; 
        } 
        dist[src] = 0;
        for (int count = 0; count < V-1; count++) { 
            int u = minDist(dist, set1);          
            set1[u] = true;            
            for (int v = 0; v < V; v++)    
                if (!set1[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v]; 
                    root[v] = u;
             }
        }   
        return dist;
    } 
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("dining.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N][N];
		for(int i = 0; i < N; i++){
		//Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken()),y = Integer.parseInt(st.nextToken()),z = Integer.parseInt(st.nextToken());
			matrix[x + OFFSET][y + OFFSET] = z;
			matrix[y + OFFSET][x + OFFSET] = z;
		}
		int[] out = dijkstra(matrix, N - 1);
		System.out.println(Arrays.toString(root));
		System.out.println(Arrays.toString(out));
	}
}