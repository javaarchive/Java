import java.util.*;
import java.util.stream.Collectors;
public class StoTConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();sc.nextLine();
		for(int run = 0; run < N; run++) {
			
			String s = sc.nextLine(),t = sc.nextLine(),p = sc.nextLine();
			ArrayList<Character> needed = new ArrayList<Character>();
			System.out.println("s:"+s+"\n"+"t:"+t+"\n"+"p:"+p);
			try {
			int min = Integer.min(s.length(),t.length());
			for(int i = 0; i < min; i ++) {
				if(!(s.charAt(i) == t.charAt(i))) {
					throw new Exception("SOLUTION REQUIRES REORDER");
				}
			}
			for(int i =0 ; i < t.length(); i ++) {
				//System.out.println("add "+i);
				needed.add(t.charAt(i));
			}
			System.out.println("End Result: "+needed);
			for(int i =0 ; i < s.length(); i ++) {
				needed.remove(needed.indexOf(s.charAt(i)));
			}
			System.out.println("Letters needed: "+needed);
			
			List<Character> chars = p.chars()  			// IntStream
					.mapToObj(e -> (char)e) // Stream<Character>
					.collect(Collectors.toList());
			//System.out.println("Letters to find: "+needed);
			System.out.println("Letters to be used before: "+chars);
			for(char c: needed) {
				//chars.remove(Character.valueOf(c));
				chars.remove(chars.indexOf(c));
			}
			System.out.println("Letters to be used after: "+chars);
			System.out.println("YES");
			}catch(Exception e) {
				System.out.println("NO "+e.getLocalizedMessage());
			}
			
		}
	}
}
