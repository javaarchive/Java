import java.io.*;
import java.util.*;
public class dining {
	static final int V=9; 
    static int minDistance(int dist[], boolean[] set1)  { 
        int min = Integer.MAX_VALUE, min_index=-1; // Computers are too stupid to understand infinite
        for (int v = 0; v < V; v++) 
            if (set1[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        return min_index; 
    } 
    final int OFFSET  = -1; // Offset by 1 for adjancey matirix because index begins at 0
    static int dijkstra(int graph[][], int src) { 
        int dist[] = new int[V]; 
        boolean set1[] = new boolean[V]; 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            set1[i] = false; 
        } 
        dist[src] = 0;
        for (int count = 0; count < V-1; count++) { 
            int u = minDistance(dist, set1);          
            set1[u] = true;            
            for (int v = 0; v < V; v++)    
                if (!set1[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v]; 
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
		
	}
}
