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
		int mtime = -1,ctime;
		cow c2;
		boolean first =true;
		for(int i = 0; i < time.size(); i ++) {
			System.out.println("Completed "+i+" of "+time.size()+" <- Value may change but N is "+N);
			if(theline.isEmpty()) {
			tc = time.get(i);// Short for the cow
			}else {
				//System.out.println(tc.x +" " +  tc.y +" "+ theline.get(0).x+" "+theline.get(0).y);
				c2 = theline.get(0);
				boolean nodouble = c2.equals(tc);
				if(nodouble) {
					i --; // Make sure loop runs again
					time.remove(c2); // Remove cow
					tc = theline.remove(0); // Let the waiting cow eat
					continue;
				}
				
				ctime = tc.x - c2.x;
				//System.out.println("Achieved time of "+ctime);
				if(ctime > mtime) {
					if(!nodouble) {
					//System.out.println("New range");
					mtime = ctime;
					}
				}
				i --; // Make sure loop runs again
				time.remove(c2); // Remove cow
				//senority.remove(theline.get(0));
				tc = theline.remove(0); // Let the waiting cow eat
				tc.x = tc.x + ctime;
			}
			
			c1 = tc.x + tc.y;
			
			for(int j = i + 1; j < time.size(); j ++) {
				if (time.get(i).x > time.get(j).x) {
					//break;
					continue; // On second thought
				//throw new IOException("Something impossible just happeneded.");	
				}
				if(time.get(j).x > c1) {
					break;
				}
				
				theline.add(time.get(j));
				theline.sort(cowcompare);
			}
			if(i == 0 && first) {
				//System.out.println(theline.remove(0));
			}
			//System.out.println(theline);
			first = false;
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