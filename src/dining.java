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
    private static int[] dijkstra(int[][] graph1, int startVertex) {
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
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < dists[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    dists[vertexIndex] = shortestDistance +
                        edgeDistance;
                }
            }
        }
        root = parents;
        return dists;
        

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
