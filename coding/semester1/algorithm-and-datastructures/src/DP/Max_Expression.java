package DP;

public class Max_Expression {
	public static void main(String[] args) {
		// sample input
		int[] operand = { 4, -2, 6, 1, 5 };
		char[] operator = { '+', '*', '*', '+' };
		int max = maximizing_an_expression(5, operand, operator);

		System.out.println("expected: 72\noutput: " + max);
	}

	private static int maximizing_an_expression(int n, int[] Operand, char[] Operator) {
		int[][] MinTB = new int[n][n];
		int[][] MaxTB = new int[n][n];

		// base case
		for (int i = 0; i < n; i++) {
			MinTB[i][i] = Operand[i];
			MaxTB[i][i] = Operand[i];
		}

		// calculate upper right corner of matrix
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				int k = j - i;

				// calculate min and max of entry (k,j)
				for (int g = k; g < j; g++) {
					int j2 = g; // new j
					int k2 = g + 1; // new k

					// operator = j2 => changes per iteration of inner loop
					// calculate every combination of min and max entries
					int minMin = eval(MinTB[k][j2], MinTB[k2][j], Operator[j2]);
					int minMax = eval(MinTB[k][j2], MaxTB[k2][j], Operator[j2]);
					int maxMax = eval(MaxTB[k][j2], MaxTB[k2][j], Operator[j2]);
					int maxMin = eval(MaxTB[k][j2], MinTB[k2][j], Operator[j2]);
					int localMin = Math.min(Math.min(minMin, minMax), Math.min(maxMax, maxMin));
					int localMax = Math.max(Math.max(minMin, minMax), Math.max(maxMax, maxMin));

					MinTB[k][j] = (g == k) ? localMin : Math.min(localMin, MinTB[k][j]);
					MaxTB[k][j] = (g == k) ? localMax : Math.max(localMax, MaxTB[k][j]);
				}
			}
		}
		return MaxTB[0][n - 1];
	}

	public static int eval(int x, int y, char op) {
		return (op == '+') ? x + y : x * y;
	}

}
