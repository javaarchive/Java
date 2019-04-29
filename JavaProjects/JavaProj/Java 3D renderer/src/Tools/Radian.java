package Tools;

public class Radian {
	double value;
	public Radian(int value) {
		this.value = value;
	}
	public Radian(Degree deg) {
		this.value = Core.radian(deg.value);
	}
	public Degree toDegree() {
		return new Degree(this);
	}
	public static void main(String[] args) {
		
	}

}
