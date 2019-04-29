package RSA;
import java.math.BigInteger;
import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean customprime=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("P:");
		BigInteger p=sc.nextBigInteger();
		System.out.println("Q:");
		BigInteger q=sc.nextBigInteger();
		System.out.println("Calculating public key/encryption key");
		BigInteger n=p.multiply(q);
		BigInteger e=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)).subtract(BigInteger.ONE);
		if(customprime) {
			System.out.println("Custom primes is enabled. Please manually enter a relativley prime number to "+(e.add(BigInteger.ONE)));
			e=sc.nextBigInteger();
		}
		System.out.println("Your public key is "+n+ ","+e);
		System.out.println("Calculating private key/decryption key");
		BigInteger i=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		boolean found=false;
		for(BigInteger d=BigInteger.ONE;!(found);d=d.add(BigInteger.ONE)) {
			if(e.multiply(d).mod(i).equals(BigInteger.ONE)) {
				System.out.println("It is:"+d);
				found=true;
			}else {
				//System.out.println(d+","+i+","+e);
				//System.out.println(e.multiply(d).mod(i));
			}
		//if(d.toString().equals("100")) {break;}
		}
		System.out.println("You also need the public key for decrypting");
		
	}

}
/*
 * Sample numbers
 * 20,988,936,657,440,586,486,151,264,256,610,222,593,863,921 
* 170,141,183,460,469,231,731,687,303,715,884,105,727 
* 12027524255478748885956220793734512128733387803682075433653899983955179850988797899869146900809131611153346817050832096022160146366346391812470987105415233
* 12131072439211271897323671531612440428472427633701410925634549312301964373042085619324197365322416866541017057361365214171711713797974299334871062829803541
 */
