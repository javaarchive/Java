import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
public class japanese_majhong {
	static List<Integer> m,p,s;
	public static int maxConsect;
	public static int maxSame;
	public static int consect_count;
	public static int same_count;
	public static void process(List<Integer> l){
		maxConsect = 0;
		maxSame = 0;
		consect_count = 0;
		same_count = 0;
		boolean isConsecutive = false;
		boolean isSame = false;
		int prev = -1;
		for(int num:l) {
		if(isConsecutive == false && isSame == false) {
				isConsecutive = true;
				isSame = true;
				consect_count ++;
				same_count ++;
			}else {
				if(prev == (num - 1)) {
					isConsecutive = true;
				}else if(prev == num) {
					isSame = true;
				}
				if(isConsecutive) {
					if(prev == (num - 1)) {
						isConsecutive = true;
						consect_count++;
					}else {
						isConsecutive = false;
					}
				}
				if(isSame) {
					if(prev == num) {
						isSame = true;
						same_count++;
					}
				}else{
					isSame = false;
				}
				
			}
		if(same_count > maxSame){
			maxSame = same_count;
		}
		if(consect_count > maxConsect) {
			maxConsect = consect_count;
		}
			prev = num; // Keep at end
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = new ArrayList<Integer>();
		p = new ArrayList<Integer>();
		s = new ArrayList<Integer>();
		//System.out.println(s);
		for(int i = 0; i < 3; i ++) {
			String str = sc.next();
			String suit = str.substring(1);
			//System.out.println(suit);
			int num = Integer.parseInt(str.substring(0, 1));
			if(suit.equals("m")) {
				m.add(num);
			}else if(suit.equals("p")) {
				p.add(num);
			}else if(suit.equals("s")) {
				s.add(num);
			}
		}
		m.sort(null);
		p.sort(null);
		s.sort(null);
		int ans;
		int maxMaxSame = -1;
		int maxMaxConsect = -1;
		//System.out.println("m");
		process(m);
		maxMaxSame = maxSame;
		maxMaxConsect = maxConsect;
		//System.out.println(maxConsect+" "+maxSame);
		//System.out.println("p");
		process(p);
		maxMaxSame = Integer.max(maxSame, maxMaxSame);
		maxMaxConsect = Integer.max(maxConsect, maxMaxConsect);
		//System.out.println(maxConsect+" "+maxSame);
		//System.out.println("s");
		process(s);
		maxMaxSame = Integer.max(maxSame, maxMaxSame);
		maxMaxConsect = Integer.max(maxConsect, maxMaxConsect);
		//System.out.println(maxConsect+" "+maxSame);
		System.out.println(Integer.min(3 - maxMaxSame, 3 - maxMaxConsect));
	}

}
