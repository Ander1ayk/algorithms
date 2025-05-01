import java.util.HashSet;
import java.util.Set;

/**
 * Класс QuickUnion реализует алгоритм "Быстрое объединение" (Quick Union) для задачи поиска количества островов.
 * Остров — это связная группа клеток со значением 1 в двумерной сетке.
 */
public class QuickUnion {
    private int[] parent;

    /**
     * Конструктор инициализирует массив parent, где каждый элемент изначально указывает на самого себя.
     * Это означает, что все элементы являются своими собственными корнями.
     *
     * @param n количество элементов
     */
    public QuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    /**
     * Метод возвращает корень элемента i.
     * Проход по цепочке родителей до тех пор, пока не дойдём до корня (где parent[i] == i).
     *
     * @param i индекс элемента
     * @return корень элемента
     */
    private int root(int i) {
        while (i != parent[i]) i = parent[i];
        return i;
    }

    /**
     * Метод проверяет, находятся ли два элемента в одной компоненте связности.
     *
     * @param p первый элемент
     * @param q второй элемент
     * @return true, если имеют одинаковый корень, иначе false
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Метод объединяет компоненты двух элементов, присоединяя корень одного к корню другого.
     *
     * @param p первый элемент
     * @param q второй элемент
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }

    /**
     * Основной метод программы. Подсчитывает количество островов в двумерной сетке (матрице).
     */
    public static void main(String[] args) {
        // Пример двумерного массива, где 1 — часть острова, 0 — вода
        byte[][] array = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 1}};

        int rows = array.length;
        int cols = array[0].length;

        // Инициализируем структуру QuickUnion с количеством элементов = строк * столбцов
        QuickUnion qu = new QuickUnion(rows * cols);

        // Объединяем соседние клетки с 1, если они связаны вертикально или горизонтально
        for (byte i = 0; i < array.length; i++) {
            for (byte j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    int index = i * cols + j;

                    // Сверху
                    if (i > 0 && array[i - 1][j] == 1) {
                        qu.union(index, (i - 1) * cols + j);
                    }

                    // Слева
                    if (j > 0 && array[i][j - 1] == 1) {
                        qu.union(index, i * cols + (j - 1));
                    }
                }
            }
        }

        // Используем Set, чтобы посчитать уникальные корни (острова)
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 1) {
                    int index = i * cols + j;
                    roots.add(qu.root(index));
                }
            }
        }

        // Выводим количество уникальных островов
        System.out.println("Количество островов = " + roots.size());
    }
}
