import java.io.*;
import java.util.*;
public class sboost {
	
	public static int M,F;
	public static double getspeed(int f,int m) {
		int tempf=f+F;
		int tempm=m+M;
		double f2,m2;
		f2=1.0*tempf;
		m2=1.0*tempm;
		return f2/m2;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("boost.1.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("sboost.out")));
		int N;
		StringTokenizer st=new StringTokenizer(f.readLine());
		F=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());;
		int[] fn=new int[N];
		int[] mn=new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			fn[i]=Integer.parseInt(st.nextToken());
			mn[i]=Integer.parseInt(st.nextToken());
		}
		String binary;
		int m1;
		int f1;
		int pos;
		int M1;
		int F1;
		double max=0;
		double prev=0;
		for(int j=1;j<(N*N)+1;j++) {
			
			binary=Integer.toBinaryString(j);
			F1=0;
			M1=0;
			for(int k=0;k<binary.length();k++) {
				if(Character.toString(binary.charAt(k)).equals("1")) {
					pos=N-k-1;
					M1=M1+mn[pos];
					F1=F1+fn[pos];
				}
			}
			max=getspeed(F1,M1);
			if(prev<max) {
				prev=max;
			}
		}
		System.out.println(prev);
		f.close();
		pw.println(prev);
		pw.close();
	}

}
