import java.io.*;
import java.util.*;
public class backforth {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
		//int[] barnA = new int[101];
		//int[] barnB = new int[101];
		StringTokenizer stA = new StringTokenizer(f.readLine());
		StringTokenizer stB = new StringTokenizer(f.readLine());
		int x,y;
		ArrayList<Integer> bA = new ArrayList<Integer>();
		ArrayList<Integer> bB = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			x = Integer.parseInt(stA.nextToken());
			y = Integer.parseInt(stB.nextToken());
			bA.add(x);
			bB.add(y);
			//barnA[x]++;
			//barnB[y]++;
		}
		HashSet<Integer> answers = new HashSet<Integer>();
		int a,b,c,d;
		//System.out.println(bA);
		//System.out.println(bB);
		for(int i=0;i<bA.size();i++) {
			a = bA.remove(i);
			bB.add(a);
			for(int j=0;j<bB.size();j++) {
				b = bB.remove(j);
				bA.add(b);
				for(int k=0;k<bA.size();k++) {
					c = bA.remove(k);
					bB.add(c);
					for(int l=0;l<bB.size();l++) {
						d = bB.remove(l);
						bA.add(d);
						//System.out.println(a+" "+b+" "+c+" "+d);
						answers.add(1000-a+b-c+d);
						bA.remove(bA.size()-1);
						bB.add(l, d);
					}
					bB.remove(bB.size()-1);
					bA.add(k, c);
					
				}
				bA.remove(bB.size() - 1);
				bB.add(j, b);
				
			}
			bB.remove(bB.size() - 1);
			bA.add(i, a);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		pw.println(answers.size());
		pw.close();
		
	}

}
