package Tools;

public class Core {
	public static double radian(double in) {
		return Math.toRadians(in);
	}
	public static double degree(double in) {
		return Math.toDegrees(in);
	}
	public static double tan(double in) {
		return Math.tan(in);
	}
	public static double cos(double in){
		return Math.cos(in);
	}
	public static double sin(double in){
		return Math.sin(in);
	}
	public static double Tan(double in) {
		return sin(in)/cos(in);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(radian(90));
	}
	public static Point calc2D(double x, Point e, Point center) {
		int x1 = (int) Math.round((center.x + (e.x-center.x)*Math.cos(x) - (e.y-center.y)*Math.sin(x)));
		int y1 = (int) Math.round((center.y + (e.x-center.x)*Math.sin(x) + (e.y-center.y)*Math.cos(x)));
		return new Point(x1,y1,e.z);
	}
	public static Point calc2D(Radian x, Point e, Point center) {
		int x1 = (int) Math.round((center.x + (e.x-center.x)*Math.cos(x.value) - (e.y-center.y)*Math.sin(x.value)));
		int y1 = (int) Math.round((center.y + (e.x-center.x)*Math.sin(x.value) + (e.y-center.y)*Math.cos(x.value)));
		return new Point(x1,y1,e.z);
	}
	public static Point calc2D(Degree x, Point e, Point center) {
		int x1 = (int) Math.round((center.x + (e.x-center.x)*Math.cos(x.toRadian().value) - (e.y-center.y)*Math.sin(x.toRadian().value)));
		int y1 = (int) Math.round((center.y + (e.x-center.x)*Math.sin(x.toRadian().value) + (e.y-center.y)*Math.cos(x.toRadian().value)));
		return new Point(x1,y1,e.z);
	}
	
}
