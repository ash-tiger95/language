package algorithm.boj.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main_Silver2_4358_생태학 {

	static int cnt;
	static HashMap<String, Integer> hm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		cnt = 0;
		hm = new HashMap<String, Integer>();

		while (true) {
			String str = br.readLine();
			if (str == null || str.equals(""))
				break;

			hm.put(str, hm.getOrDefault(str, 0) + 1);
			cnt++;
		}

//		Object[] keys = hm.keySet().toArray();
		String[] keys = hm.keySet().toArray(new String[hm.size()]);
		Arrays.sort(keys);

		for (String key : keys) {
			sb.append(key)
				.append(" ")
				.append(String.format("%.4f", (double) (hm.get(key) * 100.0 / cnt))) // 백분율, 소수점 4째자리까지
				.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}
}