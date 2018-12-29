/*
 * Your cow has eaten your homework! 
 * What do you do?
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class homework{	
	public static final int LARGE_CONFIG=10001;
	public static int getsmall(List<Integer> l) {
		int min=LARGE_CONFIG;
		for(int i=0;i<l.size();i++) {
			if(l.get(i)<min) {
				min=l.get(i);
			}
		}
		return min;
	}
	public static double grade_assignment(List<Integer> homework) {
		int sum=0;
		//System.out.println("The homework is "+homework);
		for(int i=0;i<homework.size();i++) {
			sum+=homework.get(i);
		}
		sum-=getsmall(homework);
		return (double) sum/(homework.size()-1);
		
	}
	public static List<Integer >make_bessie_eat_homework(ArrayList<Integer> homework,int k) {
		//Simulate bessie eating the homework
		return homework.subList(k, homework.size());
	}
	public static void main(String[] args) throws Exception{
		//$1();
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("10.in"));
		int N=Integer.parseInt(f.readLine());
		ArrayList<Integer> grades=new ArrayList<Integer>();
		StringTokenizer st=new StringTokenizer(f.readLine());
		for(int i=0;i<N;i++) {
			grades.add(Integer.parseInt(st.nextToken()));
		}
		//System.out.println("homework "+grades);
		double bestscore=-1;
		double score;
		ArrayList<Integer> bestks=new ArrayList<Integer>();
		for(int i=1;i<(N-1);i++) {
		//for(int i=N-2;i>0;i--) {
			//System.out.println("K:"+i);
			score=grade_assignment(make_bessie_eat_homework(grades,i));
			//System.out.println("Score:"+score);
			if(score>bestscore) {
				//System.out.println("New Score:"+score);
				bestks.clear();
				bestks.add(i);
				bestscore=score;
			}else if(score==bestscore) {
				//System.out.println("Same score:"+score);
				bestks.add(i);
			}
			
			
		}
		f.close();
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		for(int a:bestks) {pw.println(a);}
		//pw.println(bestks.get(bestks.size()-1));
		pw.close();
		//$1();
		//System.out.println($r());
		
	}

}
