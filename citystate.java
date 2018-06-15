import java.io.*;
import java.util.*;
public class citystate {
	public static double decify(int num) {
		return 0.01*num;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		double c1,c2;
		int N=Integer.parseInt(f.readLine());
		String[] state=new String[N];//INIT storage for state
		String[] city=new String[N];//INIT storage for city
		ArrayList<String> hitstates=new ArrayList<String>();
		ArrayList<String> hitcities=new ArrayList<String>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			state[i]=st.nextToken();
			city[i]=st.nextToken();
			//System.out.println("READ");
			
		}
		int a,b,c,d,e;
		e=0;
		for(int i=0;i<N;i++) {
			a=((int) city[i].charAt(0)) -(int) ' ';
			b=((int) city[i].charAt(1))-(int) ' ';
			c1=(((double)a)+(decify(b)));
			for(int j=i+1;j<N;j++) {
				if(j==i) {
					continue;
				}
				c=((int) state[j].charAt(0))-(int) ' ';
				d=((int) state[j].charAt(1))-(int) ' ';
				c2=(((double)c)+decify(d));
				
				//System.out.println("Debug "+c1+" , "+c2+" "+state[j].charAt(0)+state[j].charAt(1)+" "+city[i].charAt(0)+city[i].charAt(1));
				if(c2==c1) {
					
					//System.out.println("HIT");
					//System.out.println(city[i]+"  "+state[j]+" "+city[j]+" "+state[i]);
					if(city[j].equals(state[i].substring(0, 2))){
						e++;
					}
				}
			}
		}
		//String a1,a2;
		
		
		pw.println(e);
		pw.close();
		f.close();
	}
	

}
