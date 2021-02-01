package DP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Max_LegoTurm {
	public static void main(String[] args) {
		// Uncomment the following two lines if you want to read from a file
		Scanner In;
		Scanner Out;
		try {
			In = new Scanner(new File(
					"cs_study/coding/semester1/algorithm-and-datastructures/src/DP/Test_Data/small-M_Lego.in"));
			Out = new Scanner(new File(
					"cs_study/coding/semester1/algorithm-and-datastructures/src/DP/Test_Data/small-M_Lego.out"));

			// Read the number of test cases
			int ntestcases = In.nextInt();
			for (int t = 0; t < ntestcases; t++) {
				int n = In.nextInt();

				int[] l = new int[n + 1];
				int[] b = new int[n + 1];
				int[] h = new int[n + 1];

				for (int i = 1; i <= n; i++)
					l[i] = In.nextInt();

				for (int i = 1; i <= n; i++)
					b[i] = In.nextInt();

				for (int i = 1; i <= n; i++)
					h[i] = In.nextInt();

				int expected = Out.nextInt();
				System.out.println("expected: " + expected);
				System.out.println("output: " + solve(n, l, b, h));
			}

			In.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// l[i] enthält die Länge
	// b[i] enthält die Breite
	// h[i] enthält die Höhe
	static int solve(int n, int[] l, int[] b, int[] h) {
		int maxH = 0;
		int maxAddH;
		for (int i = n; i > 0; i--) {
			maxAddH = 0;
			for (int j = i + 1; j <= n; j++) {
				if (((l[i] >= l[j]) && (b[i] >= b[j])) || ((l[i] >= b[j]) && (b[i] >= l[j]))) {
					// we can add block j onto block i
					maxAddH = (h[j] > maxAddH) ? h[j] : maxAddH;
					// update maxH if bigger
				}
			}
			// mod h[i] to current maxH
			h[i] += maxAddH;
			maxH = (h[i] > maxH) ? h[i] : maxH;
		}
		return maxH;
	}
}
