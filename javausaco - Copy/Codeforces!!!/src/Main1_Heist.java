import java.util.*;
public class Main1_Heist {
	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			a.add(sc.nextInt());
		}
		a.sort(null);
		int s=0;
		for(int i=0;i<(n-1);i++) {
			s+=(a.get(i+1)-a.get(i)-1);
		}
		System.out.println(s);
	}
}