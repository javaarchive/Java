import java.util.ArrayList;

public class Test1 {
	public static boolean isrect(int[][] map,int x,int y) {
		int cachedsize=-1;
		int cachey=-1;
		for(int i=x;i<map.length;i++) {
			if(x>cachedsize) {
				return false;
			}
			for(int j=y;j<map.length;j++) {
				if(map[x][y]==0) {
					cachey=y;
					cachedsize=x;
				}
				if(y>cachey) {
					return false;
				}
			}
		}
		return true;
	}
	public static ArrayList<Integer> touching(int[][] map,int x,int y){
		ArrayList<Integer> out=new ArrayList<Integer>();
		try {
			out.add(map[x-1][y]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x+1][y]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x][y-1]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x][y+1]);
		}catch(Exception e) {
			
		}
		return out;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] modernarttest= {
				{1,2,3,4,3},
				{1,1,3,4,2},
				{1,1,3,4,1},
				{1,1,1,4,4},
				{0,0,0,0,0}
			
		};
		System.out.println(isrect(modernarttest,1,1));
		System.out.println(isrect(modernarttest,0,0));
		System.out.println(isrect(modernarttest,0,3));
		
	}

}
