package com.mygitgor.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * V__1
 */
public class Fleas {

    /**
     *  На клеточном поле, размером NxM (2 ≤ ≤ N, M ≤ ≤ 250) сидит Q (0 ≤ ≤ Q ≤ ≤ 10000) блох в различных клетках.
     *  «Прием пищи» блохами возможен только в кормушке - одна из клеток поля, заранее известная.
     *  Блохи перемещаются по полю странным образом, а именно, прыжками, совпадающими с ходом обыкновенного шахматного коня.
     *  Длина пути каждой блохи до кормушки определяется как количество прыжков.
     *  Определить минимальное значение суммы длин путей блох до кормушки или, если собраться блохам у кормушки невозможно,
     *  то сообщить об этом. Сбор невозможен, если хотя бы одна из блох не может попасть к кормушке.
     * Формат ввода
     * В первой строке входного файла находится 5 чисел, разделенных пробелом: N, M, S, T, Q. N, M - размеры доски
     * (отсчет начинается с 1); S, T - координаты клетки - кормушки (номер строки и столбца соответственно),
     * Q - количество блох на доске. И далее Q строк по два числа - координаты каждой блохи.
     * Формат вывода
     * Содержит одно число - минимальное значение суммы длин путей или -1, если сбор невозможен.
     */
    private static final int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    private static final int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[][] distance = new int[N + 1][M + 1];
            for(int[] row : distance){
                Arrays.fill(row, -1);
            }

            Queue<int[]>queue = new LinkedList<>();
            queue.offer(new int[]{S,T});
            distance[S][T]=0;

            while (!queue.isEmpty()){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && distance[nx][ny] == -1){
                        distance[nx][ny]=distance[x][y] + 1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }

            int totalDistance = 0;
            boolean possible = true;

            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(distance[x][y] == -1){
                    possible = false;
                    break;
                }
                totalDistance += distance[x][y];
            }

            writer.write(possible ? String.valueOf(totalDistance) : "-1");
            writer.newLine();
        }
    }

    /*
     * Декомпозиция задачи
     * Представление поля и блох:
     *   Поле можно представить как граф, где каждая клетка — вершина, а рёбра — возможные ходы коня.
     *   Координаты блох и кормушки заданы в 1-индексации (от 1 до N и от 1 до M).
     *
     * Поиск кратчайших путей:
     *   Для каждой блохи нужно найти кратчайший путь до кормушки.
     *   Так как все блохи движутся к одной точке (S, T), эффективнее один раз запустить BFS из кормушки и вычислить расстояния до всех клеток.
     *
     * Проверка достижимости:
     *   Если хотя бы для одной блохи расстояние до кормушки не вычислено (∞ или -1), сбор невозможен → ответ -1.
     *   Иначе суммируем все расстояния.
     *
     * Оптимизация:
     *   BFS из кормушки работает за O(N×M), что допустимо при N, M ≤ 250 (62 500 операций).
     *   Хранение расстояний в 2D-массиве.
     *
     * Решение по шагам
     * 1. Чтение входных данных
     *     Считываем N, M, S, T, Q.
     *     Считываем координаты Q блох.
     *
     * 2. BFS от кормушки (S, T)
     *     Инициализируем массив dist[N+1][M+1] (1-индексация), заполняем -1 (недостижимо).
     *     Запускаем BFS из (S, T), вычисляя расстояния до всех клеток.
     *
     * 3. Проверка и суммирование
     *     Для каждой блохи в координате (x, y):
     *         Если dist[x][y] == -1 → вывод -1.
     *         Иначе добавляем dist[x][y] к сумме.
     *     Выводим сумму.
     *
     */
}
