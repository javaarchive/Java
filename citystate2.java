import java.io.*;
import java.util.*;
public class citystate2 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("custom.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		
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
		int e;
		e=0;
		for(int i=0;i<N;i++) {
			
			
			for(int j=0;j<N;j++) {
				if(j==i) {
					continue;
				}
				
				
				//System.out.println("Debug "+c1+" , "+c2+" "+state[j].charAt(0)+state[j].charAt(1)+" "+city[i].charAt(0)+city[i].charAt(1));
				if(city[i].equals(state[j].substring(0, 2))) {
					e++;
					//System.out.println("HIT");
					hitcities.add(city[j]);
					hitstates.add(state[i]);
				}
			}
		}
		int cancel=0;
		
		for(int i=0;i<hitstates.size();i++) {
			
			
				
				
				//System.out.println(" "+hitstates.get(i).charAt(0)+hitstates.get(i).charAt(1)+" "+hitcities.get(i).charAt(0)+hitcities.get(i).charAt(1));
				
				if(hitcities.get(i).equals(hitstates.get(i).substring(0, 2))) {
					cancel++;
					//System.out.println("HIT");
					
				}else {
					e--;
				}
			
		}
		e=e-cancel/2;
		pw.println(e);
		pw.close();
		f.close();
	}
	

}
