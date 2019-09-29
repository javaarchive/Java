import java.io.*;
import java.util.*;
public class multimoo {
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	static Set<Position> visited = new HashSet<>();
	public static int[][] grid;
	public static int N;
	public static int floodFill(int tx,int ty, Segement s) {
		visited.clear();
		int covered = 0;
		//reset();
		int color = grid[tx][ty];
		qx.add(tx);
		qy.add(ty);
		while(!qx.isEmpty()) {
			covered++;
			int x = qx.poll();
			int y = qy.poll();
			s.pieces.add(new Position(x,y));
			//System.out.println(x+" "+y+" "+visited);
			visited.add(new Position(x,y));
			if(x-1 >= 0 && x-1 < N && y < N && y >= 0 && grid[x-1][y] == color&& !visited.contains(new Position(x-1,y))) {
				qx.add(x-1);
				qy.add(y);
			}
			if(x+1 >= 0 && x+1 < N && y < N && y >= 0 && grid[x+1][y] == color&& !visited.contains(new Position(x+1,y))) {
				qx.add(x+1);
				qy.add(y);
			}
			if(x >= 0 && x < N && y +1 < N && y+1 >= 0 && grid[x][y+1] == color&& !visited.contains(new Position(x,y+1))) {
				qx.add(x);
				qy.add(y+1);
			}
			if(x >= 0 && x < N && y-1 < N && y-1 >= 0 && grid[x][y-1] == color && !visited.contains(new Position(x,y-1))) {
				qx.add(x);
				qy.add(y-1);
			}
		}
		return covered;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		N = Integer.parseInt(f.readLine());
		grid = new int[N][N];
		for(int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int j = 0 ; j < N; j ++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		f.close();
		int maxID = 0;
		int maxCount = 0;
		List<Segement> pieceList = new ArrayList<>();
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				Segement s = new Segement(grid[i][j]);
				if(!visited.contains(new Position(i,j))) {
					int id = grid[i][j];
					int count = floodFill(i, j,s);
					if(count > maxCount) {
						maxCount = count;
						maxID = id;
					}
				}
				if(s.pieces.size() > 0) {
				pieceList.add(s);
				}
			}
		}
		int LSize = 0;
		for(Segement s:pieceList) {
			System.out.println(s.pieces);
		}
		for(int i = 0; i < N; i ++) {
			Segement p = pieceList.get(i);
			for(Position pos:p.pieces) {
				int x = pos.x;
				int y = pos.y;
				int color= grid[x][y];
				Set<Position> check = new HashSet<Position>();
				if(x-1 >= 0 && x-1 < N && y < N && y >= 0 && grid[x-1][y] != color&& !visited.contains(new Position(x-1,y))) {
					check.add(new Position(x-1,y));
				}
				if(x+1 >= 0 && x+1 < N && y < N && y >= 0 && grid[x+1][y] != color&& !visited.contains(new Position(x+1,y))) {
					check.add(new Position(x+1,y));
				}
				if(x >= 0 && x < N && y +1 < N && y+1 >= 0 && grid[x][y+1] != color&& !visited.contains(new Position(x,y+1))) {
					check.add(new Position(x,y+1));
				}
				if(x >= 0 && x < N && y-1 < N && y-1 >= 0 && grid[x][y-1] != color && !visited.contains(new Position(x,y-1))) {
					check.add(new Position(x,y-1));
				}
				for(int j = 0; j < pieceList.size(); j ++) {
					if(i==j) {
						continue;
					}
					Set<Position> checked = new HashSet<>(check);
					checked.retainAll(pieceList.get(j).pieces);
					if(checked.size() > 0) {
						int size = pieceList.get(j).pieces.size() + pieceList.get(i).pieces.size();
						System.out.println("1: "+i+" "+j+" "+size);
						System.out.println("2: "+pieceList.get(i).id+" "+pieceList.get(j).id+" "+size);
						if(size>LSize) {
							LSize = size;
						}
					}
					checked.clear();
					checked = null;
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		System.out.println("Max Count "+maxCount+" (obtained with id "+maxID+")");
		System.out.println("Max Count team up "+LSize);
		pw.println(maxCount);
		pw.println(LSize);
		pw.close();
	}

}
class Position{
	int x,y;
	//boolean perimeter = false;
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
	@Override
	public int hashCode() {
		return ((Integer.hashCode(this.x) -7)*(Integer.hashCode(this.y)-5));
	}
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}
class Segement{
	public Set<Position> pieces;
	public int id;
	public Segement(int id) {
		this.id = id;
		this.pieces = new HashSet<>();
	}
	
}