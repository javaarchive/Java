/*
TASK:friday
ID:johnath6
LANG:JAVA
PROG:friday
 */

import java.io.*;


public class friday {
	public static int days(int monthnum,int year) {
		if(monthnum==9||monthnum==11||monthnum==4||monthnum==6) {
			return 30;
		}
		if(monthnum==2) {
			if(!(year%100==0)) {
				
				
				if(year%4==0) {
					return 29;
				}else {
					return 28;
				}
			}else {
				if(year%400==0) {
					return 29;
				}else {
					return 28;
				}
			}
		}else {
			return 31;
		}
	}
	public static int lsearch(int[] a,int b) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==b) {
				return i;
			}
		}
		
		return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("friday.in"));
		int N=Integer.parseInt(f.readLine());
		f.close();
		int year=1900;
		int scroll=1;
		int[] rec= {0,0,0,0,0,0,0};
		int[] date= {1,2,3,4,5,6,7};
		int s=0;
		int c=0;
		
		for(int i=0;i<N;i++) {
			
			for(int j=1;j<13;j++) {
				
				c=days(j,year);//Get days in the month
				
				s=lsearch(date,(((scroll+13)%7))+1);//find where to place record
				scroll=scroll+c;// Pass days
				
				rec[s]=rec[s]+1;
			}
			year++;
		}
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int record=0;
		for(int k:rec) {
			record++;
			out.print(k);
			if(record<7) {
				out.print(" ");
			}
			
		}
		out.println();
		out.close();
		
		
		

	}

}