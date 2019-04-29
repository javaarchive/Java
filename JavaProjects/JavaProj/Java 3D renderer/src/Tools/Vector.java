package Tools;

public class Vector {
	public Vector() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	int[] coord;
	int x,y,z;
	public Vector(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
		coord = new int[3];
		coord[0] = x;
		coord[1] = y;
		coord[2] = z;
	}
	public Vector subtract(Vector p) {
		return new Vector(this.x - p.x, this.y - p.y, this.z - p.z);
	}
	public Vector add(Vector p) {
		return new Vector(this.x + p.x, this.y + p.y, this.z + p.z);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
