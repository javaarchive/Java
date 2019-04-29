import java.util.Scanner;

public class Main2_TV_Buying {
	public static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		long x=sc.nextLong();
		long y=sc.nextLong();
		long g=gcd(x,y);
		System.out.println(Long.min((long) a/(x/g), (long) b/(y/g)));
	}

}
