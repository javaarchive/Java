// POSSIBLE FLOODFILL METHOD
import java.io.*;
import java.util.*;
public class perimeter {
	public static int N;
	public static boolean[][] grid;
	public static boolean within(int x,int y,boolean[][] grid) {
		return true;
		/*
		if(-1 < x && x < grid.length) {
			if(-1 < y && y < grid[x].length) {
				return true;
			}
		}
		return false;
		*/
	}
	public static Structure flood(int x,int y, int i) {
		Structure st = new Structure(i);
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(x,y));
		while(!q.isEmpty()) {
			Position p = q.poll();
			int x1 = p.x;
			int y1 = p.y;
			try {
			
				//System.out.println("FILL ("+x1+","+y1+")");
				if(grid[x1][y1]) {
					if(x1 < N && grid[x1 + 1][y1]) {
						q.add(new Position(x1 + 1,y1));
					}
					if(1 < x1 && grid[x1 - 1][y1]) {
						q.add(new Position(x1 - 1,y1));
					}
					if(y1 < N && grid[x1][y1 + 1]) {
						q.add(new Position(x1,y1 + 1));
					}
					if(1 < y1 && grid[x1][y1 - 1]) {
						q.add(new Position(x1,y1 - 1));
					}
				}else {
					continue;
				}
			}catch(Exception ex) {
				continue;
			}
			st.addStruct(p);
			grid[p.x][p.y] = false; // TODO remove to prevent intefering with addStruct
			
		}
		return st;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		N = Integer.parseInt(f.readLine());
		
		int size = N+2;
		int iter_size = N+1;
		grid = new boolean[size][size];
		for(int i = 1; i < iter_size; i ++) {
			String str = f.readLine();
			for(int j = 1; j < iter_size; j ++) {
				grid[i][j] = (str.charAt(j - 1) == '#');
			}
		}
		//flood(0,0,grid);
		//flood(1,1,grid);
		//System.out.println(Arrays.deepToString(grid).replace('[', '\n'));
		List<Structure> structs = new ArrayList<Structure>();
		int numStructs = 0; 
		for(int i = 1; i < iter_size; i ++) {
			for(int j = 1; j < iter_size; j ++) {
				if(grid[i][j] == true) {
					numStructs ++;
					Structure st = flood(i, j, numStructs);
					//st.toggleAll();
					//st.perimeterList.removeAll(st.posList);
					
					//st.perimeterList.removeAll(st.posList);
					structs.add(st);
				}
			}
		}
		int largestArea = -1;
		int perimOfLarge = -1;
		for(Structure struct:structs) {
			//struct.toggleAll();
			//struct.perimeterList.removeAll(struct.posList);
			int area = struct.posList.size();
			System.out.println("1:"+struct.posList);
			System.out.println("2:"+struct.perimeterList);
			if(area > largestArea) {
				largestArea = area;
				perimOfLarge = struct.perimeterList.size();
			}else if(area == largestArea) {
				perimOfLarge = Integer.min(struct.perimeterList.size(),perimOfLarge);
			}
		}
		f.close();
		System.out.println(largestArea + " " + perimOfLarge);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		pw.println(largestArea + " " + perimOfLarge);
		//pw.println();
		pw.close();
		
		/*
		for(Structure struct:structs) {
			struct.toggleAll();
			for(Position p:struct.perimeterList) {
				grid[p.x][p.y] = true;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				boolean stat = grid[i][j];
				System.out.print(String.format("%2d", stat ? 1:0) );
			}
			System.out.println();
			System.out.println();
		}
		*/
	}
}
class Structure{
	List<Position> posList = new ArrayList<Position>();
	List<Position> perimeterList = new ArrayList<Position>();
	public int id = -1;
	public Structure(int id) {
		this.id = id;
	}
	public void addStruct(Position p) {
		posList.add(p);
		boolean[][] grid = perimeter.grid;
			if(grid[p.x + 1][p.y] == false) {
				perimeterList.add(new Position(p.x + 1,p.y));
				//return;
			}
		
		
			if(grid[p.x - 1][p.y] == false) {
				perimeterList.add(new Position(p.x - 1,p.y));
				//return;
			}
		
		
			if(grid[p.x][p.y + 1] == false) {
				perimeterList.add(new Position(p.x,p.y + 1));
				//return;
			}
		
		
			if(grid[p.x][p.y - 1] == false) {
				perimeterList.add(new Position(p.x,p.y - 1));
				//return;
			}
		
		/*
		if(perimeter.within(p.x - 1, p.y - 1)) {
			if(grid[p.x - 1][p.y - 1] == false) {
				perimeterList.add(p);
				return;
			}
		}
		if(perimeter.within(p.x + 1, p.y + 1)) {
			if(grid[p.x + 1][p.y + 1] == false) {
				perimeterList.add(p);
				return;
			}
		}
		if(perimeter.within(p.x + 1, p.y - 1)) {
			if(grid[p.x + 1][p.y - 1] == false) {
				perimeterList.add(p);
				return;
			}
		}
		if(perimeter.within(p.x - 1, p.y + 1)) {
			if(grid[p.x - 1][p.y + 1] == false) {
				perimeterList.add(p);
				return;
			}
		}
		*/
	}
	public void toggleAll() {
		for(Position p:this.posList) {
			perimeter.grid[p.x][p.y] = !perimeter.grid[p.x][p.y];
		}
		//return grid;
	}
}
class Position{
	int x,y;
	boolean perimeter = false;
	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object s) {
		if(s instanceof Position) {
			Position p = (Position) s;
			return ((p.y == this.y) && (p.x == this.x));
		}
		return false;
	}
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}