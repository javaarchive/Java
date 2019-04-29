package Tools;

public class Degree {
	double value;
	public void mirror() {
		this.value = 360 - this.value;
	}
	public Degree(int value) {
		this.value = value;
	}
	public Degree(Radian rad) {
		this.value = Core.degree(rad.value);
	}
	public Radian toRadian() {
		return new Radian(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
