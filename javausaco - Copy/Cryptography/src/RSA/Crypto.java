package RSA;
import java.util.*;
import java.math.*;
public class Crypto {
	public static char dc(int i) {
		return (char) i;
		
	}
	public static int ec(char i) {
		return (int) i;
	}
	public static BigInteger[] encrypt(String s, BigInteger n, BigInteger e) {
		char[] sa=s.toCharArray();
		BigInteger[] out=new BigInteger[sa.length];
		int temp;
		for(int i=0;i<sa.length;i++) {
			temp=ec(sa[i]);
			out[i]=BigInteger.valueOf(temp).modPow(e, n);
		}
		
		return out;
	}
public static void go(BigInteger[] k) {
	for(BigInteger a:k) {
		System.out.print(a+",");
		
	}
}
	public static void main(String[] args) {
		System.out.println("Encrypt or decrypt use d or e");
		final BigInteger ONE=BigInteger.ONE;
		Scanner sc=new Scanner(System.in);
		String choice=sc.nextLine();
		BigInteger n,e;
		if(choice.equals("d")) {
			System.out.println("Enter d");
			BigInteger d=sc.nextBigInteger();
			System.out.println("Enter n and e");
			n=sc.nextBigInteger();
			e=sc.nextBigInteger();
		}else if(choice.equals("e")) {
			System.out.println("Enter n and e and then your plaintext");
			n=sc.nextBigInteger();
			e=sc.nextBigInteger();
			System.out.println("Please enter your plaintext");
			go(encrypt(sc.nextLine(),n,e));
		}else {
			System.out.println("Invalid choice, terminating");
			System.exit(1);
			
		}//91,5,29
	}

}
