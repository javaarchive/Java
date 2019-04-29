import java.util.Scanner;

public class Main3_Pythgorean_Triple_finder {
	public static int div(long n) {
		long t;
		for(int i=0;i<500;i++) {
			t=n/(long) (Math.pow((double) n,(double) i));
			if((t&1)==0) {
				return i;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		sc.close();
		int even=1;
		if((a & 1)==0) {
			int r;
			even=div(a);
			r=a/(long) (Math.pow((double) a,(double) even))
		}
		
		
	}

}
