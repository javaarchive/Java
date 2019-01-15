/*
 TASK:milk
 ID:JOHNATH6
 LANG:JAVA
 PROB:milk
 */
import java.io.*;
import java.util.*;
public class milk {	
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("milk.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int full=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[] arr=new int[1001];
		int totalprice=0;
		int cur=0;
		int n;
		int k,r;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			k=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());;
			if(arr[k]==0) {arr[k]=r;}else {arr[k]=arr[k]+r;}
		}
		f.close();
		System.out.println("GRAPH-----------------------------");
		System.out.println("----------------------------------");
		System.out.println("Amount               Price   ");
		for(int i=0;i<1001;i++) {
			//System.out.println("Buying price "+i);
			if(cur==full) {
				//System.out.println("Full capactiy");
				break;
			}
			if(arr[i]==0) {
				//System.out.println("?");
				continue;
			}
			if((full-cur)>=arr[i]) {totalprice+=(arr[i]*i);cur+=(arr[i]);System.out.println(""+arr[i]+"                  "+i+"  "+totalprice+"  "+cur);}else {
				n=full-cur;
				
				totalprice+=(n*i);cur+=(n);
				System.out.println(""+n+"                  "+i+"  "+totalprice+"  "+cur);
			}
			
		}
		PrintWriter pw=new PrintWriter(new FileWriter("milk.out"));
		System.out.println(totalprice);
		pw.println(totalprice);
		pw.close();
	}
}