import java.io.*;
import java.util.*;

/*
 * Angry Cows: Silver Edition
 */
public class angry {
	static List<Integer> field = new ArrayList<Integer>();
	public static int N;
	
	public static int launchSim(int power){
		//System.out.println("Power: "+power);
		int cowsUsed  = 0;
		int curCow = 0;
		int power2 = power*2;
		int l,range;
//		/int lastCow = field.get(field.size() - 1);
		while(curCow < N) {
			cowsUsed++;
			int pos = field.get(curCow);
			l = curCow + 1;
			
			range =0;
			//System.out.println("Checking "+curCow + " In range "+curCow + " " + (curCow + 2 * power));
			for(int i = l; i < N; i ++) {
				
				if(field.get(i) <= pos + power2) {
					//System.out.println(field.get(i)+" In range "+i);
					range++;
				}
			}
			//curCow++;
			curCow = curCow + range + 1;
			//			curCow ++;
			
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
		int r = 1000000000;
		while (r - l > 1) {
			int m = (l + r) / 2;
			int t = launchSim(m);
			if (t < K) {
				r = m;
			}else if(K == t) {
				//				System.out.println("Got it");
				r = m;
				//break;
			}else {
			            l = m;
			        }    
			    }    
			    
		//System.out.println(field);
		//System.out.println(costs);
		System.out.println(r +" "+l+" "+answer);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		pw.println(r);
		pw.close();
		
		//System.out.println("");
	}

}
