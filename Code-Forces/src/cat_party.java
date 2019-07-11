import java.util.*;
public class cat_party {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] days = new int[N];
		for(int i = 0; i < N; i ++) {
			days[i] = sc.nextInt();
		}
		
		HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
		int out = N;
		for(int i = 0; i < N; i ++) {
			freq.putIfAbsent(days[i], 0);
			freq.put(days[i],freq.get(days[i])+1);
			//System.out.println(freq);
			Set<Integer> values = new HashSet<Integer>(freq.values());
			//System.out.println("Map "+values.size()+" i = "+i+" "+values);
			if(values.size() == 2) {
				//System.out.println("Day "+i);
				out = i + 1;
			}
		}
		Set<Integer> values = new HashSet<Integer>(freq.values());
		//System.out.println("Map "+values.size()+" i = "+N+" "+values);
		
		//System.out.println(freq);
		System.out.println(out);
		sc.close();
	}

}
