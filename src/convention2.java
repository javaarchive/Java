import java.io.*;
import java.util.*;
public class convention2 {

	public static void main(String[] args) throws IOException{
		BufferedReader f= new BufferedReader(new FileReader("convention2.in"));
		StringTokenizer st;
		int N = Integer.parseInt(f.readLine());
		Map<cow,Integer> senority = new HashMap<cow,Integer>();
		ArrayList<cow> time = new ArrayList<cow>();
		for(int i = 0; i < N ; i ++) {
			st = new StringTokenizer(f.readLine());
			cow thecow = new cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			senority.put(thecow,i);
			time.add(thecow);
			thecow = null;
		}
		
		Collections.sort(time); // Looks a bit more stylish
		//time.sort(null);
		Comparator<cow> cowcompare = new Comparator<cow>() {
			@Override
			public int compare(cow arg0, cow arg1) {
				// TODO Auto-generated method stub
				return senority.get(arg0) - senority.get(arg1);
			}
		};
		List<cow> theline = new ArrayList<cow>();
		int c1; // Cache calculations
		cow tc = new cow(-2,-2);
		int mtime = -1,ctime,waittime;
		ctime  = 0;
		cow c2;
		int cows_eaten = 0;
		int maxsenority;
		//System.out.println(time);
		while(cows_eaten < N || theline.size() > 0) {
			if(theline.isEmpty()) {
				tc = time.get(cows_eaten);
				ctime = tc.x;
			}else {
			
				tc = theline.remove(0);
				waittime = ctime - tc.x;
				if(waittime > mtime) {
					mtime = waittime;
				}
			}
			ctime = ctime + tc.y;
			maxsenority = -1;
			//cow nextcow = new cow(-1,-1); // Not guaranteed to have a conflicting time 
			int count = 0;
			while(true) {			
				cows_eaten++;
				if(cows_eaten>=N ||time.get(cows_eaten).x >= ctime) { // If after the current cow is finished then all cows after it we don't have to worry about
					break;
				}else {
					count ++;
					theline.add(time.get(cows_eaten));
				}
			}
			if(count>0) {theline.sort(cowcompare);}
			
			
		}


		//System.out.println(mtime);
		PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));
		pw.print(mtime);
		pw.close();
	}
	

}
class cow implements Comparable<cow>{
	int x,y;
	public cow(int i,int j) {
		this.x = i;
		this.y = j;
	}
	@Override
	public int compareTo(cow arg0) {
		// TODO Auto-generated method stub
		return this.x - arg0.x;
	}
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	@Override
	public boolean equals(Object k) {
		if(!(k instanceof cow)) {
			return false;
		}
		cow c = (cow) k;
		return (c.x == this.x) && (c.y == this.y);
	}
}