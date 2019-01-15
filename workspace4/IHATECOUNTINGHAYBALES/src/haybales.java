import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class haybales {
	 public static int search(int[] data,int key) {
		int low=0;
		int high=data.length-1;
		int val=0;
		while(high>low) {
	             int middle = (low + high) / 2;
	             if(data[middle] == key) {
	                 val++;
	                 System.out.println(high);
	                 if(high<4) {
	                	 
	                	 break;
	                 }
	                 
	             }
	             if(data[middle] < key) {
	                 low = middle + 1;
	             }
	             if(data[middle] > key) {
	                 high = middle - 1;
	             
	             }
	        }
		return val;
	 }    
	   
	public static void main(String[] idontneedthis) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("1.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		int N,Q;
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		int[] haybales=new int[N];
		st=new StringTokenizer(f.readLine());
		for(int bale=0;bale<N;bale++) {
			haybales[bale]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(haybales);
		int min,max,pos;
		for(int i=0;i<Q;i++) {
			st=new StringTokenizer(f.readLine());
			min=Integer.parseInt(st.nextToken());
			max=Integer.parseInt(st.nextToken());
			
			pos=0;
			for(int j=min;j<=max;j++) {
				
				if(search(haybales, j)>0) {
					pos++;
				}
				
			
			}
			pw.println(pos);
		}
		
		
		
		f.close();
		pw.close();
		System.out.println("Done");
	}
}
