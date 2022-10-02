package algorithm.boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bronze2_13410_�Ųٷα����� {
	static int N, K, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ���� ��
		K = Integer.parseInt(st.nextToken()); // ���� ��

		answer = 0;

		// Ǯ��1) ���� ������ (���ڿ� �̿�), 128ms
		for (int i = 1; i <= K; i++) {
			String tmp = (N * i + "");
			String reversed = "";
			for (int j = tmp.length() - 1; j >= 0; j--) {
				reversed += tmp.charAt(j);
			}

			int v = Integer.parseInt(reversed);
			answer = answer > v ? answer : v;
		}

		System.out.println(answer);

		System.out.println(solve2());
		System.out.println("TEST");
	}

	// Ǯ��2) ���� ������ (���), 124ms
	private static int solve2() {
		int maxNum = 0;

		for (int i = 1; i <= K; i++) {
			int tmp = N * i;
			int num = 0;
			while (tmp > 0) {
				num = num * 10 + tmp % 10;
				tmp /= 10;
			}

			maxNum = Math.max(maxNum, num);
		}
		return maxNum;
	}
}
