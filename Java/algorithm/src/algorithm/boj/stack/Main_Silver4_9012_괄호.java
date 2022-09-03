package algorithm.boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Silver4_9012_괄호 {

	static int N;

	/* 방법1) Stack 이용하기 (128ms) */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean isTrue = true;

			for (char c : str.toCharArray()) {
				if (stack.size() == 0) {
					if (c == ')') {
						isTrue = false;
						break;
					}
					stack.push(c);
					continue;
				}

				if (c == '(') {
					stack.push('(');
				} else {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						isTrue = false;
						break;
					}
				}
			}

			if (stack.isEmpty() && isTrue) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}

	/* 방법2) 개수로 판별하기 (120ms) */
	private static String otherSolve(String str) {
		int count = 0;

		for (char c : str.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (count == 0) {
				return "NO";
			} else {
				count--;
			}
		}

		if (count == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
