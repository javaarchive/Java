import java.io.*;
import java.util.*;
public class lostcow {
	private static int y;
	private static int x;
	public static void printanswer(long a) throws IOException{
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		pw.println(a);
		pw.close();
	}
	public static int findeven() {
		setting=true;
		for(int i=0;true;i=i+2) {
		//	if(y<=(x+pow(2, i))) {
			if(y<=(x+(1<<i))) {
				return i;
			}
		}
	}
	public static boolean setting=false;
	public static int findodd() {
		
		for(int i=1;true;i=i+2) {
		//	if((x-pow(2, i))<=y) {
			if((x-(1<<i))<=y) {
				return i;
			}
		}
		
	}
	public static long f(int a) {
		System.out.println(a);
		long p=1;
		for(int i=0;i<a;i++) {
			p+=(long) (Math.pow(2, i)+Math.pow(2, i+1));
		}
		//if(setting)p+=(long) Math.pow(2, a);
		return p;
	}
	public static long pow(long base,int expo) {
		long n=1, n1;
		for(int i=0;i<expo;i++) {
			n=n*base;
		}
		n1=1<<expo;
		return n;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("lostcow.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		f.close();
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		if(x==y) {
			printanswer(0);
			System.exit(0);
		}
		int temp,r;
		if(x<y) {
			temp=findeven();
			r=Math.abs(y-(x+( int)Math.pow(2, temp) ));
			System.out.println(r);
			printanswer(f(temp)-r);
		}else if(x>y) {
			temp=findodd();
			r=Math.abs(y-(x-(int)Math.pow(2, temp) ));
			printanswer(f(temp)-r);
		}else {
			throw new IOException("Invalid input");
		}
		
	}
	

}
