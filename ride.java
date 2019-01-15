/*
ID: johnath6
LANG: JAVA
TASK: ride
PROG: ride
*/
import java.io.*;
public class ride {
	public static void main(String[] args) throws IOException {
		String dictor="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		BufferedReader f=new BufferedReader(new FileReader("ride.in"));
		String comet=f.readLine();
		String group=f.readLine();
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		int num=1;
		
		for(int i=0;i<comet.length();i++) {
			num=num*(dictor.indexOf(Character.toString(comet.charAt(i)))+1);
		}
		int int1=num%47;
		//Reset
		num=1;
		for(int i=0;i<group.length();i++) {
			num=num*(dictor.indexOf(Character.toString(group.charAt(i)))+1);
		}
		int int2=num%47;
		if(int1==int2) {
			out.println("GO");
		}else {
			out.println("STAY");
		}
		f.close();
		out.close();
		
	}
}
