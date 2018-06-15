/*
TASK:beads 
ID:johnath6
LANG:JAVA
PROG:beads
 */


import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("beads.in"));
		PrintWriter pw=new PrintWriter(new FileWriter("beads.debug"));
		final int N=Integer.parseInt(f.readLine());
		String beads=f.readLine();
		String current="USA";
		int bit=23;//23 for beta
		String a=Character.toString(beads.charAt(0));
		int max=0;
		int prev=0;
		boolean s=true;
		boolean second=true;
		String thew="";
		for(int j=bit;j<N;j++) {
			current=Character.toString(beads.charAt(j));
			
			pw.print("DEBUG:  ");
			pw.println(current.equals("w"));
			if((a.equals("w"))) {
				
				if(current.equals(thew)||thew.equals("")) {
					a=current;
					max++;
				}
				
			}
			else if(a.equals(current)){
				max++;//same
			} else if(current.equals("w")) {
				
				thew=a;//assign
				a="w";
				max++;
				
			}
			else {
				if(!(second)) {
					second=true;
					thew="";
					System.out.print("|");
					if(max>prev) {
						prev=max;
						max=0;
					}
					
					
				}else {
					second=false;
				}
				if(s&&j==N-1) {
					pw.println("DEBUG signal 1");
					s=!(s);
					j=0;
					thew="";
				}else if(!(s)) {
					break;
				}
				a=current;
			}
			System.out.print(current);
			
			
			
		}
		System.out.println(prev);
		pw.close();
		f.close();
	}
}