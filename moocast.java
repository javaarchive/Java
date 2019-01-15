import java.io.*;
import java.util.*;
public class moocast {
	
	private static int[][] data;
	private static int[][] map;
	private static int cowstargeted;
	private static int[][] modifmap;
	private static int cownum;
	public static void d(String a) {
		System.out.println(a);
	}
	public static void Cast(int cow) {
		d("Loading data varibles");
		
		int range=data[cow][2];
		int x=data[cow][0];
		int y=data[cow][1];
		int a,b;
		d("Done");
		//int count=0;
		double calc=0;
		 for(int x1=x-range;x1<x+range;x1++) {
			 //count++;
			 if(cownum==0) {break;}
			 for(int y1=y-range;y1<y+range;y1++) {
				 if(cownum==0) {break;}
				 a=Math.max(x1-x, x-x1);
				 b=Math.max(y1-y, y-y1);
				 calc=Math.sqrt(a*a+b*b);
				 
				 if(-1<x1&&-1<y1&&y1<25000&&x1<25000&&modifmap[x1][y1]!=0&&-1<calc&&calc<range+1) {
					 	 
						 //count++;
						 ////////////System.out.println("X Y = "+x1+" - "+y1+"   "+count);
						 if(modifmap[x1][y1]>0) {
							 cownum--;
							 System.out.println("Cow found");
							 ////////////System.out.println("RAnge:"+range);
							 ////////////System.out.println(calc);
							 ////////////System.out.println("We've hit a cow");
							 cowstargeted++;
							 modifmap[x1][y1]=0;//Eliminate the cow
							 //Above disables a cow
							 Cast(map[x1][y1]);
						 }
					 
				 
				
			 }
			 }
			 if(cownum==0) {break;}
		 }
	}
	public static void main(String[] args) throws IOException {
		
		d("Reading");
		BufferedReader f = new BufferedReader(new FileReader("3.in"));
		int N=Integer.parseInt(f.readLine());//Read N
		d("Parsed N");
		data = new int[N][3];
		StringTokenizer st;
		map = new int[25000][25000];
		d("Data init done");
		cownum = N;
		for(int i=0;i<N;i++) {
			cownum=N;
			/*Data Format
			 * 0 x
			 * 1 y
			 * 2 Power
			 */
			st=new StringTokenizer(f.readLine());
			for(int j=0;j<3;j++) {
				data[i][j]=Integer.parseInt(st.nextToken());
			}
			map[data[i][0]][data[i][1]]=i+1;
			
		} 
		modifmap = map.clone();
		f.close();
		int high=1;
		for(int i=0;i<N;i++) {
			modifmap=map.clone();
			cowstargeted=1;
			////////////System.out.println("--Cow--");
			Cast(i);
			if(cowstargeted>high) {
				System.out.println("New high");
				high=cowstargeted;
			}
		}
		////////////System.err.println(high);
		f.close();
		d("Closed f now writting output");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

	
		pw.println(high);
		pw.flush();
		
		pw.close();
		
		
		
	}

}
