package com.mygitgor.algorithm;

import java.io.*;

/**
 * V__2
 */
public class TheMostEffectiveWay {

    /**
     * Условие задачи
     * У нас есть прямоугольная таблица (матрица) размером N × M, где в каждой клетке записано число — в
     * Игрок начинает в левой верхней клетке (это клетка [0][0] в нумерации с нуля или [1][1] в нумерации с единицы — как удобно)
     * За один ход можно двигаться только вправо или только вниз
     * При проходе через клетку игрок отдаёт еду, равную числу в этой клетке (включая старт и финиш)
     * Нужно найти минимальный вес еды, который придётся отдать, чтобы добраться из левого верхнего угла в правый нижний
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] firstLine = reader.readLine().split(" ");
            if (firstLine.length != 2) {
                throw new IllegalArgumentException("Invalid input format");
            }

            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);

            if (N <= 0 || M <= 0) {
                throw new IllegalArgumentException("Matrix dimensions must be positive");
            }

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] row = reader.readLine().split(" ");
                if (row.length != M) {
                    throw new IllegalArgumentException("Invalid row length");
                }
                for (int j = 0; j < M; j++) {
                    grid[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[] dp = new int[M];
            dp[0] = grid[0][0];

            for (int j = 1; j < M; j++) {
                dp[j] = dp[j - 1] + grid[0][j];
            }

            for (int i = 1; i < N; i++) {
                dp[0] += grid[i][0];
                for (int j = 1; j < M; j++) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }

            writer.write(String.valueOf(dp[M - 1]));
            writer.newLine();
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

}
