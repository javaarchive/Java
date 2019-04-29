import java.util.*;

public class unionsum {
	public static HashSet<Integer> genset(int a, int b, int c){
		//System.out.println("___________________________");
		HashSet<Integer> l=new HashSet<Integer>();
		for(int i=b;i<=c;i=i+a) {
			//System.out.println(" "+i);
			l.add(i);
		}
		//System.out.println("size: "+l.size());
		return l;
	}
	public static int ip(String a) {
		return Integer.parseInt(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st;
		Scanner sc=new Scanner(System.in);
		//st=new StringTokenizer(sc.nextLine());
		HashSet<Integer> a=genset(sc.nextInt(),sc.nextInt(),sc.nextInt());
		//st=new StringTokenizer(sc.nextLine());
		HashSet<Integer> b=genset(sc.nextInt(),sc.nextInt(),sc.nextInt());
		st=null; // Save memory
		a.addAll(b);
		int sum=0;
		for(int k:a) {
			//System.out.println(k);
			sum+=k;
		}
		System.out.println(sum);
		System.out.flush();
		sc.close();
	}

}
