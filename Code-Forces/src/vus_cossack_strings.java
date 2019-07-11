import java.util.*;

public class vus_cossack_strings {
	public static int diff(String m, String p) {
		int answer = 0;
		assert (m.length() == p.length());
		int N = m.length();
		for(int i = 0; i < N; i ++) {
			if(m.charAt(i) != p.charAt(i)) {
				answer ++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		sc.close();
		int lenA = a.length();
		int len = b.length();
		List<String> substrings = new ArrayList<String>();
		/*
		for(int i = 0 ; i < lenA; i ++) {
			if(a.charAt(i) == 1) {
				
			}else {
				// assert (a.charAt(i) == 0);
			}
		}
		*/
		for(int i = 0; i < lenA; i++) {
			if(i + len > lenA) {
				break;
			}
			substrings.add(a.substring(i, i + len));
		}
		int count = 0;
		//System.out.println(substrings);
		for(String s:substrings) {
			if(diff(s,b) % 2 == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
