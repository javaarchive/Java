import java.io.*;
import java.util.*;

/*
 * Angry Cows: Silver Edition
 */
public class angry {
	static List<Integer> field = new ArrayList<Integer>();
	public static int N;
	
	public static int launchSim(int power){
		int cowsUsed  = 0;
		int curCow = 0;
//		/int lastCow = field.get(field.size() - 1);
		while(curCow < N) {
			int pos = field.get(curCow);
			curCow++;
			for(int i = pos; i < N; i ++) {
				if(field.get(i) < pos + 2 * power) {
					curCow++;
				}
			}
			cowsUsed++;
		}
		return cowsUsed;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // Number of cows
		//List<Integer> costs = new ArrayList<Integer>(N - 1);
		for(int i = 0; i < N; i ++) {
			field.add(Integer.parseInt(f.readLine()));
		}
		f.close();
		field.sort(null);
		int answer = -1;
		int l = 0;
		int r = N;
		while (r - l > 1) {
			int m = (l + r) / 2;
			if (launchSim(m) > K) {
				r = m;
			} else {
			            l = m;
			        }    
			    }    
			    
		System.out.println(field);
		//System.out.println(costs);
		System.out.println(l +" "+r);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		pw.println(answer);
		pw.close();
		for(int i = 0 ; i < N; i ++) {
			System.out.println(i+": "+launchSim(N));
		}
		//System.out.println("");
	}

}
