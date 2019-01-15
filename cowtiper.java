import java.io.*;
//import java.util.*;
import modules.PrettyPrinter;
public class cowtiper {
	private static int[][] field;
	private static int N;
	private static boolean patch;
	public static int c(char bit) {
		switch(bit) {
		case '1':
			patch=false;
			return 1;
		case '0':
			return 0;
		default:
			return -1;
		}
	}
	public static int sum(int[][] a) {
		/*
		 * Finds total amount of cows not tipped over 
		 */
		int out=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i][j]==0) {
					out++;
				}
			}
		}
		return out;
	}
	public static int[][] invert(int[][] a){
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
					if(a[i][j]==1) {
						a[i][j]=0;
					}else if(a[i][j]==0) {
						a[i][j]=1;
					}
				
			}
		}
		return a;
	}
	public static int[][] invert(int[][] a,int x,int y){
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.println("Invert X:"+i+" Y:"+j+"");
				
					if(a[i][j]==1) {
						a[i][j]=0;
					}else if(a[i][j]==0) {
						a[i][j]=1;
					}
				
			}
		}
		return a;
	}
	public static int[][] best(int[][] a){
		int temp=sum(a);
		if(temp<((N*N)-temp)) {
			a=invert(a);
		}
		return a;
	}
	public static int[][] best_NS(int[][] a){
		int temp=sum(a);
		if(temp<((N*N)-temp)) {
			a=invert(a);
		}
		return a;
	}
	public static int[][] best(int[][] a,int x,int y){
		int temp=sum(a);
		if(temp<((N*N)-temp)) {
			a=invert(a,x,y);
		}
		return a;
	}
	public static int[][] best_NS(int[][] a,int x,int y){
		int temp=sum(a);
		if(temp<((N*N)-temp)) {
			a=invert(a,x,y);
		}
		return a;
	}
	public static void showfield() {
		String[][] ppa=new String[N][N];
		//field=best(field);
		PrettyPrinter pp=new PrettyPrinter(System.out);
		for(int i = 0; i < N; i++)
	    {
	        for(int j = 0; j < N; j++)
	            ppa[i][j] = Integer.toString(field[i][j]);
	    }
		pp.print(ppa);
	}
	
	public static int hx(int[][] a) {
		int l=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i][j]==1) {
					if(i>l) {
						l=i;
					}
				}
			}
		}
		return l;
	}
	public static int hy(int[][] a) {
		int l=-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i][j]==1) {
					if(j>l) {
						l=j;
					}
				}
			}
		}
		return l;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("5(1).in"));
		N = Integer.parseInt(f.readLine());
		field = new int[N][N];
		
		String temp;
		patch = true;
		for(int i=0;i<N;i++) {
			temp=f.readLine();
			for(int j=0;j<N;j++) {
				field[i][j]=c(temp.charAt(j));
						//Integer.parseInt(Character.toString(temp.charAt(j)));
			}
		}
		f.close();
		//Begin debug zone
		showfield();
		String[][] ppa=new String[N][N];
		
		field=best(field); // DO NOT REMOVE
		
		PrettyPrinter pp=new PrettyPrinter(System.out);
		for(int i = 0; i < N; i++)
	    {
	        for(int j = 0; j < N; j++)
	            ppa[i][j] = Integer.toString(field[i][j]);
	    }
		pp.print(ppa);
		
		//End debug zone
		int test=0;
		//if(sum(field)==(N*N)) {
			test=0;
		//}else {
			test=1;
		
		while(sum(field)!=(N*N)) {
			//if()
			showfield();
			System.out.println(hx(field));
			System.out.println(hy(field));
			field=invert(field,hx(field)+1,hy(field)+1);
			showfield();//Debug
			//Thread.sleep(500);
			test++;
			if(test>10000) {
				throw new Exception("Auto terminate");
			}
		}
		//}
		
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		if(patch) {test=0;}
		pw.println(test);
		pw.flush();
		pw.close();
		
	}

}
