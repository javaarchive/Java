package Tools;

public class Point {
	public Point() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	int x,y,z;
	int[] coord;
	public Point(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
		coord = new int[3];
		coord[0] = x;
		coord[1] = y;
		coord[2] = z;
	}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
		this.z=0;
		coord = new int[3];
		coord[0] = x;
		coord[1] = y;
		coord[2] = 0;
	}
	public Point subtractVector(Vector p) {
		return new Point(this.x - p.x, this.y - p.y, this.z - p.z);
	}

	public Point subtract(Point p) {
		return new Point(this.x - p.x, this.y - p.y, this.z - p.z);
	}
	public static Point Subtract(Point a,Point b) {
		return a.subtract(b);
	}
	public Point add(Point p) {
		return new Point(this.x + p.x, this.y + p.y, this.z + p.z);
	}
	public Point addVector(Vector p) {
		return new Point(this.x + p.x, this.y + p.y, this.z + p.z);
	}
	public static Point add(Point a,Point b) {
		assert(a.add(b) == b.add(a));
		return a.add(b);
	}
	public double distanceFrom(Point p) {
		int dx = this.x-p.x;
		int dy = this.y-p.y;
		int dz = this.z-p.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
	public static double DistanceFrom(Point a,Point b) {
		return a.distanceFrom(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
