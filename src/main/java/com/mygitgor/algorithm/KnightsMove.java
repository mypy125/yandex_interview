package com.mygitgor.algorithm;

import java.io.*;

/**
 * V__2
 */
public class KnightsMove {

    /**
     * В левом верхнем углу находится шахматный конь, которого необходимо переместить в правый нижний угол доски.
     * В данной задаче конь может перемещаться на две клетки вниз и одну клетку вправо или на одну клетку вниз и две клетки вправо.
     * Необходимо определить, сколько существует различных маршрутов, ведущих из левого верхнего в правый нижний угол.
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            long[] prevPrevRow = new long[M + 1];
            long[] prevRow = new long[M + 1];
            prevRow[1] = 1;

            for (int i = 2; i <= N; i++) {
                long[] currRow = new long[M + 1];
                for (int j = 2; j <= M; j++) {
                    if (i - 2 >= 1 && j - 1 >= 1) {
                        currRow[j] += prevPrevRow[j - 1];
                    }
                    if (i - 1 >= 1 && j - 2 >= 1) {
                        currRow[j] += prevRow[j - 2];
                    }
                }
                prevPrevRow = prevRow;
                prevRow = currRow;
            }

            writer.write(prevRow[M] + "\n");
        }

    }
}
