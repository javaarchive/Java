import java.io.*;
import java.util.*;

public class revegetate {
	public static final int OFFSET = -1;
	public static final char NULL = '\u0000';
	public static void main(String[] args) throws IOException, InvalidInputException{
		// TODO Auto-generated method stub
		char[][] graph;
		int N,M;
		BufferedReader f = new BufferedReader(new FileReader("11.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][N]; // Adjancey Matrix
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(f.readLine());
			char state = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken()) + OFFSET;
			int y = Integer.parseInt(st.nextToken()) + OFFSET;
			// Validate Input
			//if(!(graph[x][y] == NULL || graph[x][y] == state)) {
				//throw new InvalidInputException("Improper input, conflicting nodes!");
			//}
			// End input validation
			graph[x][y] = state;
			graph[y][x] = state;
		}
		f.close();
		// begin algorthim
		int[] prevValues = new int[N];
		for(int i = 0; i < N; i ++) {
			if(prevValues[i] == 0) {
				prevValues = sim(0,graph,prevValues);
				
				AnswerBuilder.append('0');
				
			}
		}
		
		
		System.out.println(Arrays.toString(prevValues));
		
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				System.out.print((int) graph[i][j] + (j<N-1 ? ", ":""));
			}
			System.out.println();
		}
		
		PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
		pw.println(AnswerBuilder.toString());
		pw.close();
	}
	public static StringBuilder AnswerBuilder = new StringBuilder("1"); 
	//public static boolean atLeastOneConnected = false;
	public static int[] sim(int curNode,char[][] graph,int[] prevValues) { // int[][] grid
		int N = graph.length;
		//int[][] grid = new int[N][N];
		int[] prevNodes = new int[N];
		//int[] prevValues= new int[N];
		prevValues[curNode] = 0;
		Queue<Integer> pastures = new LinkedList<Integer>();
		pastures.add(curNode);
		
		//Queue<Character> states = new LinkedList<Character>();
		//atLeastOneConnected = false;
		while(!(pastures.isEmpty())) {
			int currentSim = pastures.poll();
			for(int i = 0; i < graph.length; i ++) {
				if(i == currentSim) {
					continue;
				}
				//char temp;
				if(prevValues[i] == 0 && graph[currentSim][i] != 0) {
					//atLeastOneConnected = true;
					prevValues[i] = currentSim; // Mark as visited
					
					pastures.add(i);
				}
				
			}
		}
		return prevValues;
	}
}
class InvalidInputException extends Exception { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1472101612368218565L;

	public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
