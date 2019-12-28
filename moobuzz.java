// Extremely Simple MooBuzz solution
// Generates precalc lookup table
// Utilizes/"exploits" fact that the moobuzz sequence will repeat!
import java.io.*;
import java.util.*;
public class moobuzz {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		int N = Integer.parseInt(f.readLine()) -1;
		int[] baseNumberTable = new int[9];
		int x = 0;
		for(int i = 0; i < 9; i ++) {
			while(true) {
				x++;
				if(x % 3 == 0 || x % 5 == 0) {
					continue;
				}else {
					baseNumberTable[i] = x;
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(baseNumberTable));
		int num = N % 8;
		int base = baseNumberTable[num];
		int offset = 15 * Math.floorDiv(N, 8);
		pw.println(base + offset);
		f.close();
		pw.close();
	}

}
