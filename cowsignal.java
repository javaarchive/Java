import java.io.*;
import java.util.*;
public class cowsignal {
	private static int K;
	public static ArrayList<ArrayList<Character>> build(ArrayList<ArrayList<Character>> map,int y,char l){
		for(int i=y*K;i<((y+1)*K);i++) {
			for(int j=0;j<K;j++) {
				map.get(i)
				.add(l);
				};
		}
		return map;
	}
	//private static final char s_OFF = 'B';
	//private static final char s_ON = '.';
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		String temp;
		ArrayList<ArrayList<Character>> omap=new ArrayList<ArrayList<Character>>();
		for(int i=0;i<(M*K);i++){
			
			omap.add(new ArrayList<Character>());
		}
		System.out.println("M*K "+M*K);
		//Character[][] map=new Character[M][N];
		for(int i=0;i<M;i++) {
			temp=f.readLine();
			for(int j=0;j<N;j++) {
				//map[i][j]=temp.charAt(j);
				omap=build(omap,i,temp.charAt(j));
			}
		}
		f.close();
		PrintWriter out=new PrintWriter(new FileWriter("cowsignal.out"));
		for(int i=0;i<(M*K);i++) {
			for(int j=0;j<(N*K);j++) {
				out.print(omap.get(i).get(j));
			}
			out.println();
		}
		out.flush();
		out.close();
		
		
		
	}

}
