package DP;

public class Max_Square {
    private static int Square(int M, int N, int[][] B) {
        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (B[i][j] == 1 && i != 0 && j != 0) {
                    if (B[i - 1][j - 1] != 0) {

                        if (B[i - 1][j - 1] == B[i - 1][j] && B[i - 1][j - 1] == B[i][j - 1]) {
                            B[i][j] = B[i - 1][j - 1] + 1;
                        } else if (B[i - 1][j] != 0 && B[i][j - 1] != 0) {
                            B[i][j] = Math.min(B[i - 1][j - 1], Math.min(B[i - 1][j], B[i][j - 1])) + 1;
                        }
                    }
                }
                max = Math.max(B[i][j], max);
            }
        }

        return max * max;
    }
}
