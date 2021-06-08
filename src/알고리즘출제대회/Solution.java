package 알고리즘출제대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int T;
	static String s;

	static void init() throws Exception {
		s = br.readLine();
	}

	static void solve() {
		StringBuilder temp = new StringBuilder(s);
		String comp = temp.reverse().toString();

		int length = s.length();
		int[][] dp = new int[length + 1][length + 1];

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {

				if (s.charAt(i - 1) == comp.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		sb.append(dp[length][length] + "\n");

	}

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
