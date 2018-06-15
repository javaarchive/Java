import java.io.*;
import java.util.*;
public class citystate3 {
	public static double decify(int num) {
		return 0.01*num;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		
		
		int N=Integer.parseInt(f.readLine());
		
		String tmpStr;
		int [][] freq =new int[26*26][26*26];
		int [] idx1 = new int[N];
		int state, city;
		int Nidx=0;
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			tmpStr=st.nextToken();
			state=26*(tmpStr.charAt(0)-'A')+tmpStr.charAt(1)-'A';
			tmpStr=st.nextToken();
			city=26*(tmpStr.charAt(0)-'A')+tmpStr.charAt(1)-'A';
			
			if(city!=state)
			{
				if(freq[city][state]==0)
					idx1[Nidx++]=(city<<10)+state;
				freq[city][state]++;
			}
			
			//System.out.println("READ");	
		}
		int count=0;
		/*
		for(int i=0;i<26*26;i++)
		{
			for(int j=i+1;j<26*26;j++)
			{
				
				count+=freq[i][j]*freq[j][i];
			}
		}*/
		
		for(int i=0;i<Nidx;i++)
		{
			city=idx1[i]>>10;
			state=idx1[i]&1023;
			
			//System.out.println("city:"+city+" state:"+state +" " +idx1[i]);		
			count+=freq[city][state]*freq[state][city];
			
		}
		
		pw.println(count/2);
		pw.close();
		f.close();
	}
	

}
