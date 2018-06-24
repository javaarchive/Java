/*
TASK:milk2
ID:johnath6
LANG:JAVA
PROG:milk2
 */
import java.io.*;
import java.util.*;

/**
 * @author fath
 *
 */
public class milk2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int prevmilk=0;
		int prevwait=0;
		int maxw,maxm,end;
		
		int prevstop=-1;
		int start;
		int cachex=15;
		int cachey=-15;
		int prevs=0;
		StringTokenizer st;
		BufferedReader f=new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		final int N=Integer.parseInt(f.readLine());
		maxm=-25;
		int[] xx=new int[N];
		int[] yy=new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			xx[i]=Integer.parseInt(st.nextToken());
			
			yy[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xx);
		Arrays.sort(yy);
		if(N!=1) {
			for(int i=0;i<N;i++) {
				
				start=xx[i];
				
				end=yy[i];
				System.out.println(start+"    "+end);
				if(cachex>start&&end>cachey) {
					prevwait=0;
				}
				if(prevstop==-1) {
					prevstop=end;
					prevs=start;
					maxw=end-prevstop;
					
				}else {
					maxw=start-prevstop;
					
					if(prevs<start) {
						start=prevs;
					}
					
					
					maxm=end-start;
					System.out.println(" Total:"+maxm+"   "+maxw);
					
					
					
					
				}
				
				prevstop=end;
				
				if(maxm>prevmilk) {
					prevmilk=maxm;
					
				}
				if(maxw>prevwait) {
					prevwait=maxw;
				}
				maxw=0;
				maxm=0;
				
				//System.out.println(rangex+" "+rangey);
			}
		}else {
			prevwait=0;
			//st=new StringTokenizer(f.readLine());
			prevmilk=-xx[0]+yy[0];
		}
			
		out.println(prevmilk+" "+prevwait);
		f.close();
		out.close();
	}

}
