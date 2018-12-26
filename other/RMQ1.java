
public class RMQ1 {
	public static int[][] generate(int[] arr, int n) {
	int[][] lookup = new int[arr.length + 1][arr.length  + 1];
	for (int i = 0; i < n; i++) 
        lookup[i][i] = i; 
    for (int i=0; i<n; i++) { 
        for (int j = i+1; j<n; j++) {
  

           if (arr[lookup[i][j - 1]] < arr[j]) {
              lookup[i][j] = lookup[i][j - 1]; 
           }else {
              lookup[i][j] = j; 
           }
        }
    } 
    return lookup;
	}
	public static void RMQ(int arr[], int n, Query q[], int m) { 
	    int[][] lookup = generate(arr, n); 
	    for (int i=0; i<m; i++){ 
	        int L = q[i].L, R = q[i].R; 
	        System.out.println("Minimum of [" + L + ", " + R + "] is "  + arr[lookup[L][R]]); 
	    } 
	} 
	public static void main(String[] args) {
		

	}

}
class Query{
	int L;
	int R;
}