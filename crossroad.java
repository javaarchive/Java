import java.util.*;
import java.io.*;
public class crossroad {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try{
			System.out.println("Starting");
			BufferedReader f=new BufferedReader(new FileReader("crossroad.in"));
			int N=Integer.parseInt(f.readLine());
			int cows=10;
			int[] Cows=new int[cows];
			for(int i=0;i<cows;i++) {Cows[i]=0;}
			int[] prev=new int[cows];
			int id;
			int pos;
			for(int i=0;i<cows;i++) {prev[i]=-1;}
			StringTokenizer st;
			int total=0;
			//int previd;
			//previd=-1;
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(f.readLine());
				id=Integer.parseInt(st.nextToken())-1;
				pos=Integer.parseInt(st.nextToken());
				if(prev[id]!=pos) {
					if(prev[id]==-1) {
					prev[id]=pos;
					}else {
					Cows[id]++;
					prev[id]=pos;
					}
				}
				
			}
			f.close();
			for(int i=0;i<cows;i++) {
				
				total=total+Cows[i];
			}
			try{
				System.out.println("TRYING TO WRITE");
				PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
				pw.println(total);
				
				pw.close();
			}catch(IOException e) {
				System.out.println("File MISSING");
			}
		}catch(Exception e) {
			System.out.println("ERROR:"+e.getMessage());
			System.exit(1);
		}
		
		
		
	}

}
