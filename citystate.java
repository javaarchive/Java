import java.io.*;
import java.util.*;

public class citystate {
	public static void main(String[] args) throws IOException{
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		BufferedReader f=new BufferedReader(new FileReader("2.in"));
		int answer=0;
		int N=Integer.parseInt(f.readLine());
		List<String> k=new ArrayList<String>();
		List<String> checkstate=new ArrayList<String>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(f.readLine());
			checkstate.add(st.nextToken());
			k.add(st.nextToken());
			
		}
		String state,city;
		for(int i=0;i<N;i++) {
			state=checkstate.get(0);
			city=k.get(0);
			for(int j=0;j<k.size();j++) {
				
				if(i==j) {
					continue;
				}
				if(k.get(j).equals(state.substring(0,2))&&!(checkstate.get(j).equals(state))) {
					answer++; 
					System.out.println(k.get(j)+" is equal to "+state);
				}
			}
			k.remove(0);
			checkstate.remove(0);
			//System.out.println(city+"  "+state);
			
		}
		pw.println(answer);
		pw.close();
		f.close();
	}
}
