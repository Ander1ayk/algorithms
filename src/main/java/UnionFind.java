/**
 * Класс UnionFind реализует структуру данных "Система непересекающихся множеств" (Disjoint Set Union, DSU),
 * также известную как Union-Find. Используется для эффективного объединения и поиска компонент связности в графе.
 *
 * Особенности реализации:
 * - Сжатие пути (Path Compression): ускоряет операции find/root.
 * - Объединение по размеру (Union by Size): делает дерево более сбалансированным.
 *
 * Применение: нахождение количества компонент связности в неориентированном графе.
 */
public class UnionFind {
    private int[] parent; // Родитель каждого элемента (индекс вершины)
    private int[] size;   // Размер компоненты, к которой принадлежит элемент
    private int count;    // Текущее количество компонент (непересекающихся множеств)

    /**
     * Конструктор структуры Union-Find.
     *
     * @param n количество вершин в графе
     */
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;   // Изначально каждый элемент — корень самого себя
            size[i] = 1;     // Каждая компонента изначально имеет размер 1
        }
    }

    /**
     * Метод находит корень элемента с применением итеративного сжатия пути.
     *
     * @param i вершина
     * @return корень компоненты
     */
    private int root(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // Сжатие пути: укорачиваем путь к корню
            i = parent[i];
        }
        return i;
    }

    /**
     * Альтернативный рекурсивный метод поиска с сжатием пути.
     *
     * @param x вершина
     * @return корень компоненты
     */
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Рекурсивное сжатие пути
        }
        return parent[x];
    }

    /**
     * Проверяет, находятся ли вершины p и q в одной компоненте.
     *
     * @param p первая вершина
     * @param q вторая вершина
     * @return true, если в одной компоненте, иначе false
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Объединяет компоненты, содержащие вершины p и q.
     * Использует объединение по размеру и уменьшает счётчик компонент.
     *
     * @param p первая вершина
     * @param q вторая вершина
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return; // Уже в одной компоненте

        // Присоединяем меньшую компоненту к большей
        if (size[i] < size[j]) {
            parent[i] = j;
            size[j] += size[i];
        } else {
            parent[j] = i;
            size[i] += size[j];
        }

        count--; // После объединения — на одну компоненту меньше
    }

    /**
     * Возвращает текущее количество компонент в графе.
     *
     * @return количество компонент
     */
    public int getCount() {
        return count;
    }

    /**
     * Тестирование алгоритма на примере: 5 вершин, 3 ребра.
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        System.out.println("Количество компонент: " + uf.getCount()); // Ожидаемый результат: 2
    }
}
