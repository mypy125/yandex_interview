package com.mygitgor.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * V__1
 */
public class PathSpeleologist {
    /**
     *Пещера представлена кубом, разбитым на N частей по каждому измерению (то есть на N 3 N3 кубических клеток).
     * Каждая клетка может быть или пустой, или полностью заполненной камнем.
     * Исходя из положения спелеолога в пещере, требуется найти,
     * какое минимальное количество перемещений по клеткам ему требуется,чтобы выбраться на поверхность.
     * Переходить из клетки в клетку можно, только если они обе свободны и имеют общую грань.
     * Формат ввода
     * В первой строке содержится число N ( 1 ≤ N ≤ 30 1≤N≤30). Далее следует N блоков.
     * Блок состоит из пустой строки и N строк по N символов: # - обозначает клетку, заполненную камнями,
     * точка - свободную клетку. Начальное положение спелеолога обозначено заглавной буквой S.
     * Первый блок представляет верхний уровень пещеры, достижение любой свободной его клетки означает выход на поверхность.
     * Выход на поверхность всегда возможен.
     * Формат вывода
     * Вывести одно число - длину пути до поверхности.
     * Примечание
     * Нужно спуститься на уровень вниз, сделать два движения на запад, подняться на уровень вверх, сделать движение на юг, подняться на уровень вверх.
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(reader.readLine());

            char[][][] cave = new char[N][N][N];
            int startZ = -1, startY = -1, startX = -1;

            for (int z = 0; z < N; z++) {
                reader.readLine();
                for (int y = 0; y < N; y++) {
                    String line = reader.readLine();
                    for (int x = 0; x < N; x++) {
                        cave[z][y][x] = line.charAt(x);
                        if (cave[z][y][x] == 'S') {
                            startZ = z;
                            startY = y;
                            startX = x;
                        }
                    }
                }
            }

            int[] dz = {0, 0, 0, 0, 1, -1};
            int[] dy = {0, 0, 1, -1, 0, 0};
            int[] dx = {1, -1, 0, 0, 0, 0};

            Queue<int[]> queue = new LinkedList<>();
            boolean[][][] visited = new boolean[N][N][N];

            queue.offer(new int[]{startZ, startY, startX, 0});
            visited[startZ][startY][startX] = true;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int z = curr[0], y = curr[1], x = curr[2], dist = curr[3];

                if (z == 0) {
                    writer.write(String.valueOf(dist));
                    return;
                }

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (nz >= 0 && nz < N && ny >= 0 && ny < N && nx >= 0 && nx < N
                            && !visited[nz][ny][nx] && cave[nz][ny][nx] != '#') {
                        visited[nz][ny][nx] = true;
                        queue.offer(new int[]{nz, ny, nx, dist + 1});
                    }
                }
            }
        }
    }
}
