import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class unionlength {
	public static int ag(HashSet<Integer> s) {
		ArrayList<Integer> k=new ArrayList<Integer>(s);
		int r=0;
		for(int i=0;i<k.size()-1;i++) {
			if(k.get(i+1)-k.get(i)!=1) {
				r++;
			}
		}
		return r;
		
	}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> k=new HashSet<Integer>();
		StringTokenizer st;
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(sc.nextLine());
			k.addAll(genset(1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			
		}
		sc.close();
		System.out.println(k.size()-ag(k)-1);
		
		
	}

}

