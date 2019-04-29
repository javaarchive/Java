import java.io.*;
import java.util.*;

public class blist {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("blist.in"));
		int N =Integer.parseInt(f.readLine());
		int[] time = new int[1001]; // Bronze level so it's ok
		StringTokenizer st;
		int x,y,z;
		int max = -1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(f.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			for(int j=x;j<=y;j++) {
				time[j] = time[j] + z;
				if(time[j]>max) {
					max = time[j];
				}
			}
		}
		f.close();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		pw.println(max);
		pw.close();
		
	}

}
