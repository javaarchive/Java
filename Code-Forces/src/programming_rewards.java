import java.util.*;
public class programming_rewards {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		if(x > y || x > z) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}

}
