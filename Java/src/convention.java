import java.io.*;
import java.util.*;
public class convention {
	static int[] time = new int[100000];static int N,M,C;
	public static boolean pos(int waittime) {
		int w = 1;
		int fa = time[0];
		int firstpos = 0;// Default
		
		for(int i = 1; i < N;i++) {
			if(time[i] - fa > waittime || (i + 1 - firstpos > C)){
				w += 1;
				fa = time[i];
				firstpos = i;
			}
		}
		return (w <= M);
	}
	static int bs(int low,int high)
	{
		if(low == high) return low;
		if(low + 1 == high)
		{
			if(pos(low)) return low;
			return high;
		}
		int mid = (low+high)/2;
		if(pos(mid)) return bs(low,mid);
		else return bs(mid+1,high);
	}
	//    Power counter 123456789
	static int MAX_POSSIBLE = 1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		f.close();
		PrintWriter pw = new PrintWriter(new FileWriter("convention.out"));
		pw.print(bs(0,MAX_POSSIBLE));
		pw.close();
	}

}
