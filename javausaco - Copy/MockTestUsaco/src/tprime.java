
import java.util.*;
public class tprime {
	
    public static long digitsumcheck(long m) {
    	long sum=0;
    
    	while(m > 0)
        {
            sum = sum + m % 10;
            m = m / 10;
        }
    	return sum;
    }
	public static boolean isprime(long testnum) {
		/*long pretest=digitsumcheck(testnum);
		if(pretest%3==0 || pretest%2==0) {
			return false;
		}
		*/
		long remainder;
		boolean isPrime=true;
		for(int i=2;i<=testnum/2;i++)
		  {
		   //testnumber is dived by itself
		            remainder=testnum % i;
		            //System.out.println(testnum+" Divided by "+ i + " gives a remainder "+remainder);
		            
		       //if remainder is 0 than testnumber is not prime and break loop. Eles continue loop
		     if(remainder==0)
		     {
		        isPrime=false;
		        break;
		     }
		  }
		return isPrime;
	}
	public static void checkprime(String l) {
		//StringBuilder a;
		//System.out.println("testing "+l);
		for(int i=1;i<(l.length());i++) {
			//System.out.println("Run "+i);
			
			if(isprime(Long.parseLong(l.substring(0, i)))&&isprime(Long.parseLong(l.substring(i)))) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BigInteger a,b;
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		for(int i=0;i<N;i++) {
			checkprime(sc.nextLine());
		}
	}

}
