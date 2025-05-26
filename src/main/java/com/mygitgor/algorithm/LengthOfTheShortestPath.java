package com.mygitgor.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * V__1
 */
public class LengthOfTheShortestPath {
    /**
     *Дан неориентированный граф. Найдите длину минимального пути между двумя вершинами.
     * Формат ввода
     *
     * В первой строке записано целое число N N ( 1 ≤ N ≤ 100 1≤N≤100) – количество вершин в графе.
     *
     * Далее записывается матрица смежности — N N строк, в каждой из которых содержится N N чисел 0 или 1, разделённых пробелом. Число 0 означает отсутствие ребра, а 1 — наличие ребра.
     *
     * В последней строке задаются номера двух вершин — начальной и конечной.
     *
     * Вершины нумеруются с единицы.
     * Формат вывода
     *
     * Выведите длину кратчайшего пути — минимальное количество ребер, которые нужно пройти.
     *
     * Если пути нет, нужно вывести -1.
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            List<List<Integer>> graph = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                String[] edge = reader.readLine().split(" ");
                int u = Integer.parseInt(edge[0]) - 1;
                int v = Integer.parseInt(edge[1]) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            String[] lastLine = reader.readLine().split(" ");
            int start = Integer.parseInt(lastLine[0]) - 1;
            int end = Integer.parseInt(lastLine[1]) - 1;

            int shortestPathLength = bfs(graph, start, end);

            writer.write(shortestPathLength + "\n");
        }
    }

    private static int bfs(List<List<Integer>> graph, int start, int end){
        if (start == end) {
            return 0;
        }
        return -1;
    }
}
