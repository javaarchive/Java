import java.io.*;
import java.util.*;
public class barn1 {
	public static int boarddist(int x,int y) {
		return Math.max(y-x, x-y);// Difference
		//TODO add offset if needed
	}
	public static int count(int[] arr) {
		boolean b=false;int c=0;int temp;
		for(int i=0;i<arr.length;i++) {
			temp=arr[i];
			if(temp==0 && b) {
				b=false;
				c++;
			}
			if(temp==1 && b==false) {
				b=true;
			}
		}
		return c;
	}
	public static void main(String[] args) throws IOException{
		/*
		 *Variable names and what they means 
		 * bs prefix means blocked stall
		 * x,y,z are really just M S C in the problem
		 * bstalls is a array of blocked stalls
		 * stalls is a Bit representation of all stalls
		 * WARNING "blockedstalls" is a multi use temporary variable that is reused many times for memory efficency.
		 */
		BufferedReader f=new BufferedReader(new FileReader("barn1.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int x=Integer.parseInt(st.nextToken());//Read x
		int y=Integer.parseInt(st.nextToken());//Read y
		int z=Integer.parseInt(st.nextToken());//Read z
		int[] stalls=new int[y+1];// Offset a bit
		int blockedstall=-1;
		int[] bstalls=new int[z+1];//Offset a bit
		for(int i=0;i<z;i++) {
			blockedstall=Integer.parseInt(f.readLine());
			stalls[blockedstall]=1;
			bstalls[i]=blockedstall;
		}
		f.close();
		f=null;
		for(int i:stalls) {System.out.print(i+" ");}
		int combination=0;
		int[][][] mergecosts=new int[y+1][(2*z*(z-1))+1][2];//int[Offset][Which combination][x,y]
		for(int i=0;i<mergecosts.length;i++) {
			for(int j=0;j<mergecosts[i].length;j++) {
				mergecosts[i][j][0]=-1; // Doubles check speed if first is -1 then skip
			}
		}
		
		for(int bs1:bstalls) {
			for(int bs2:bstalls) {
				if(bs1==bs2 || bs1>bs2 || bs1==0 || bs2==0) {
					//System.out.println("Debug point 2: Info, blockedstall: "+blockedstall+", combination: "+combination+", More info: bs1: "+bs1+", bs2: "+bs2);
					System.out.println("Both are same, bs1: "+bs1+", bs2: "+bs2);
					continue;
				}else {
				combination++;//increment
				blockedstall=boarddist(bs1,bs2);
				//System.out.println("Debug point 1: Info, blockedstall: "+blockedstall+", combination: "+combination+", More info: bs1: "+bs1+", bs2: "+bs2);
				System.out.println("bs1: "+bs1+", bs2: "+bs2);
				mergecosts[blockedstall][combination][0]=bs1;
				mergecosts[blockedstall][combination][1]=bs2;
				
				}
			}
		}
		System.out.println(combination);
		combination=0;
		//for(int i=0;i<)	
	}
}