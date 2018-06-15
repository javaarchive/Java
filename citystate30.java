import java.io.*;
import java.util.*;
public class citystate30 {
	public static double decify(int num) {
		return 0.01*num;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		
		
		int N=Integer.parseInt(f.readLine());
		
		String tmpStr;
		//int [][] freq =new int[26*26][26*26];
		//int [] idx1 = new int[N];
		int [] state=new int[N];
		int [] city=new int[N];
		//int Nidx=0;
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			tmpStr=st.nextToken();
			state[i]=26*(tmpStr.charAt(0)-'A')+tmpStr.charAt(1)-'A';
			tmpStr=st.nextToken();
			city[i]=26*(tmpStr.charAt(0)-'A')+tmpStr.charAt(1)-'A';
			
			//System.out.println("READ");	
		}
		int count=0;
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				if(state[i]==city[j]&&state[j]==city[i]&&state[i]!=city[i])
					count++;
				
			}
			
		}
		
		pw.println(count);
		pw.close();
		f.close();
	}
	

}
