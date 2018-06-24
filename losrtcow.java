import java.io.*;
import java.util.*;
public class losrtcow {
	public static String repeat(int count, String with) {
	    return new String(new char[count]).replace("\0", with);
	}
	public static String changen(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("lostcow.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int pos=x;
		int steps=1;
		int k=0;
		int offset=925;
		while(true) {
			k=k+(Math.abs((pos-x)));//Put breakpoint here
			pos=x+steps;
			System.out.println(pos);
			if(pos>(-offset)) {
				//System.out.println(repeat(1000+offset+1,"*"));
				//System.out.println(changen(pos+2,'X',repeat(1000+offset+1," ")));
			}
			if(pos>y&&x<y) {
				break;
			}
			
			steps=steps*2;
			
			pos=x-steps;
			
			k=k+(Math.abs((pos-x)));
			System.out.println(pos);
			if(pos>(-offset)) {
				//System.out.println(repeat(1000+offset+1,"*"));
				//System.out.println(changen(pos+2,'X',repeat(1000+offset+1," ")));
			}
			if(pos<y&&y<x) {
				break;
			}
			
			
			steps=steps*2;
			
			
			
			
		}
		
		System.out.println(k);
		PrintWriter pw=new PrintWriter(new FileWriter("lostcow.out"));
		pw.println(k);
		pw.close();
		f.close();
	}

}
