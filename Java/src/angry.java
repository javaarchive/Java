import java.io.*;
import java.util.*;

/*
 * Angry Cows: Silver Edition
 */
public class angry {
	static List<Integer> field = new ArrayList<Integer>();
	//public List<Integer> launchSim(int pos){
	//	
	//}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken()); // Number of haybales
		int K = Integer.parseInt(st.nextToken()); // Number of cows
		List<Integer> costs = new ArrayList<Integer>(N - 1);
		for(int i = 0; i < N; i ++) {
			field.add(Integer.parseInt(f.readLine()));
		}
		f.close();
		field.sort(null);
		for(int i = 0; i < (N-1); i ++) {
			costs.add(field.get(i+1) - field.get(i));
		}
		System.out.println(field);
		System.out.println(costs);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		pw.println(Collections.max(costs));
		pw.close();
		//System.out.println("");
		for(int i = 0 ; i < N; i ++) {
			
		}
	}

}
