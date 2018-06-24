import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class folding {
	public static boolean isOdd(double num) {
		System.err.println(num+"  ");
		
		if(num==1.0||num==1||num==-1||num==-1.0) {
			return true;
		}
		num++;
		return ((Math.abs(num)%2)==1)||num==1.0;
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("10.in"));
		PrintWriter pw=new PrintWriter(new FileWriter("folding.out"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		final int N=Integer.parseInt(st.nextToken());
		final int L=Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new PriorityQueue<Integer>(N, null);
		for(int i=0;i<N;i++) {
			queue.add(Integer.parseInt(f.readLine()));
		}
		int max;
		int prev=-1;
		double test;
		
		for(int i=0;i<N;i++) {
			max=0;
			test=queue.poll();
			for(double test1:queue) {
				if(test==1) {
					test=-2;
				}
				if(test1==0) {
					test1=1;
				}
				if(isOdd((test-test1))) {
					max++;
					System.out.println("OMG "+System.nanoTime());
				}
				
				System.out.println(test+" "+test1+" "+(test1-test));
				
			}
			if(max>prev) {
				prev=max;
			}
			
		}
		pw.println(prev);
		f.close();
		pw.close();
		
	}

}
