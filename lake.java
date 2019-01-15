import java.io.*;
import java.util.*;
public class lake {
	public static int findin2D(ArrayList<int[]> a,int[] wanna) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals(wanna)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		// TODO a TODO a TODO
		BufferedReader f=new BufferedReader(new FileReader("lake.9.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("lake.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		//throw new Exception("Not finished");
		int x=Integer.parseInt(st.nextToken())+1;int y=Integer.parseInt(st.nextToken())+1;int z=Integer.parseInt(st.nextToken());
		ArrayList<int[]> al=new ArrayList<int[]>();
		int[] build= {0,0};
		for(int i=0;i<z;i++) {
			st=new StringTokenizer(f.readLine());
			build[0]=Integer.parseInt(st.nextToken());
			build[1]=Integer.parseInt(st.nextToken());
			al.add(build.clone());
			
		}
		int[][] map=new int[x][y];
		for(int i=0;i<z;i++) {
			build=al.get(i);
			map[build[0]][build[1]]=1;
		}
		int[][] logic={{1,0},{-1,0},{0,1},{0,-1}};
		Stack<Integer> X=new Stack<Integer>();Stack<Integer> Y=new Stack<Integer>();
		int answer=-1;
		int RAM=0;
		while(!(al.isEmpty())) {
			//System.out.println("DEBUG:"+x+" "+y+" "+z);
			RAM=0;
			X.clear();
			Y.clear();
			build=al.remove(0);
			X.add(build[0]);
			Y.add(build[1]);
		while(!(X.isEmpty())) {
			//System.out.println("DEBUG2:"+x+" "+y+" "+z);
			x=X.pop();
			y=Y.pop();
			try {
				if(map[x][y]==1) {
					
				map[x][y]=-2;
			for(int j=0;j<logic.length;j++) {
				build=logic[j];
				X.push(x+build[0]);
				Y.push(y+build[1]);
			}
			RAM++;
				}
			}catch(Exception e) {
				//e.printStackTrace();
				//System.out.println("INFO:OUT OF BOUNDS");
			}
			/*
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			//Thread.sleep(2000);
			 * 
			 */
			
			
		}
		if(RAM>answer) {
			answer=RAM;
		}
		}
		System.out.println(answer);
	}

}
