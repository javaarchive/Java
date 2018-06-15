import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
public class highcard {

	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("highcard.in"));
		int[] bessie,enemy;
		int N=Integer.parseInt(f.readLine());
		bessie=new int[N];
		enemy=new int[N];
		for(int i=0;i<N;i++) {
			enemy[i]=Integer.parseInt(f.readLine());
		}
		Arrays.sort(enemy);
		Arrays.sort(bessie);
		int place=0;
		for(int j=1;j<(N*2)+1;j++) {
			if(Arrays.binarySearch(enemy, j)<0) {
				bessie[place]=j;
				place++;
			}
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			//System.out.println(bessie[i]+" , "+enemy[i]);//Debug
			if(bessie[i]>enemy[i]) {
				answer++;
			}else {
				for(int j=i+1;j<N;j++) {
					if(bessie[j]>enemy[i]) {
						answer++;
						bessie[j]=0;
						break;
						
					}
				
				}
				
				
			}
			
		}
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		out.println(answer);
		out.close();
		f.close();
		
		
	
	}
}
