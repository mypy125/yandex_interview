package com.mygitgor.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        /*
         * 10 N
         * 0 1 0 0 0 0 0 0 0 0
         * 1 0 0 1 1 0 1 0 0 0
         * 0 0 0 0 1 0 0 0 1 0
         * 0 1 0 0 0 0 1 0 0 0
         * 0 1 1 0 0 0 0 0 0 1
         * 0 0 0 0 0 0 1 0 0 1
         * 0 1 0 1 0 1 0 0 0 0
         * 0 0 0 0 0 0 0 0 1 0
         * 0 0 1 0 0 0 0 1 0 0
         * 0 0 0 0 1 1 0 0 0 0
         * 5 4 numbers of two vertices - the start and end.
         */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int N = Integer.parseInt(reader.readLine());

            List<List<Integer>> graph = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (row[j].equals("1")) {
                        graph.get(i).add(j);
                    }
                }
            }

            String[] lastLine = reader.readLine().split(" ");
            int start = Integer.parseInt(lastLine[0]) - 1;
            int end = Integer.parseInt(lastLine[1]) - 1;

            int shortestPathLength = bfs(graph, start, end);

            writer.write(shortestPathLength + "\n");
        }
    }

    private static int bfs(List<List<Integer>> graph, int start, int end){
        if (start == end) return 0;

        Queue<Integer>queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        int[] distance = new int[graph.size()];

        queue.add(start);
        visited[start]=true;
        distance[start]= 0;

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int neighbor : graph.get(current)){
                if(!visited[neighbor]){
                    if(neighbor == end){
                        return distance[current] + 1;
                    }
                    visited[neighbor]=true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}
