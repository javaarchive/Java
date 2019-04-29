import java.io.*;
import java.util.*;
public class mixmilk {

	public static void main(String[] args) throws IOException{
		int c1,c2,c3;
		int m1,m2,m3;
		StringTokenizer st;
		BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
		st = new StringTokenizer(f.readLine());
		c1 = Integer.parseInt(st.nextToken());
		m1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		c2 = Integer.parseInt(st.nextToken());
		m2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		c3 = Integer.parseInt(st.nextToken());
		m3 = Integer.parseInt(st.nextToken());
		f.close();
		//int pourFrom = 0;
		int pour;
		for(int i=0;i<100;i++) {
			pour = i % 3;
			if(pour == 0) {
			//   Empty part< Filled part of m1
				if(c2 - m2 < m1) { // Can you fill it to the max
					m1 = m1 - (c2 - m2); // Remove fillable portion
					m2 = c2; // Fill it to the brim
				}else {
					m2 = m2 + m1; // Empty all
					m1 = 0;
				}
				
			}else if(pour == 1) {
			//   Empty part< Filled part of m2
							if(c3 - m3 < m2) { // Can you fill it to the max
								m2 = m2 - (c3 - m3); // Remove fillable portion
								m3 = c3; // Fill it to the brim
							}else {
								m3 = m3 + m2; // Empty all
								m2 = 0;
							}
			}else if(pour == 2) {
			//   Empty part< Filled part of m1
							if(c1 - m1 < m3) { // Can you fill it to the max
								m3 = m3 - (c1 - m1); // Remove fillable portion
								m1 = c1; // Fill it to the brim
							}else {
								m1 = m1 + m3; // Empty all
								m3 = 0;
							}
							
			}
			//System.out.println("m1 "+m1+" m2 "+m2+" m3 "+m3);
			//i++; // Keep this at the end
		}
		//System.out.println("m1 "+m1+" m2 "+m2+" m3 "+m3);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		pw.println(m1);
		pw.println(m2);
		pw.println(m3);
		pw.close();
	}

}
