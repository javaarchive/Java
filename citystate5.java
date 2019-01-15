import java.io.*;
import java.util.*;
public class citystate5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		int n = Integer.parseInt(br.readLine());
		Map<String, Long> count = new HashMap<String, Long>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String city = st.nextToken();
			String state = st.nextToken();
			if(!city.substring(0, 2).equals(state)) {
				String key = city.substring(0, 2) + state;
				if(!count.containsKey(key)) {
					count.put(key, 0L);
				}
				count.put(key, count.get(key) + 1);
			}
		}
		long ret = 0;
		for(String key: count.keySet()) {
			String otherKey = key.substring(2) + key.substring(0, 2);
			if(count.containsKey(otherKey)) {
				ret += count.get(key) * count.get(otherKey);
			}
		}
		// note that we have double-counted each pair
		pw.println(ret / 2);
		pw.close();
	}
}