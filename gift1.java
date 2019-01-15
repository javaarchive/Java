/*
ID: johnath6
LANG: JAVA
TASK: gift1
PROG: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
	public static int cache;
	public static int geteach(int what,int divide) {
		
		try {
			cache=what%divide;
			return (what-cache)/divide;
		}catch(ArithmeticException e){
			cache=0;
			return 0;
			
		}
	}
	public static int lsearch(Object[] j,Object k) {
		for(int i=0;i<j.length;i++) {
			if(j[i].equals(k)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		BufferedReader f=new BufferedReader(new FileReader("gift1.in"));
		int NP=Integer.parseInt(f.readLine());
		String[] names;
		int[] money;
		names=new String[NP];
		money=new int[NP];
		for(int i=0;i<NP;i++) {
			names[i]=f.readLine();
			money[i]=0;
		}
		String person;
		StringTokenizer st;
		int share,people,deduct,each,p;
		for(int i=0;i<NP;i++) {
			person=f.readLine();
			st=new StringTokenizer(f.readLine());
			share=Integer.parseInt(st.nextToken());
			deduct=-share;
			
			
			
			
			people=Integer.parseInt(st.nextToken());
			each=geteach(share,people);
			deduct=deduct+cache;
			cache=0;
			for(int j=0;j<people;j++) {
				p=lsearch(names,f.readLine());
				money[p]=money[p]+each;
			}
			p=lsearch(names,person);
			money[p]=money[p]+deduct;
		}
		for(int i=0;i<NP;i++) {
			out.print(names[i]+" ");
			out.println(money[i]);
		}
		f.close();
		out.close();
	}
}
