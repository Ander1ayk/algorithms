/**
 * Реализация структуры данных Quick-Find (наивная реализация Union-Find / Disjoint Set Union).
 * Подходит для понимания базовой идеи объединения компонент и проверки связности.
 */
public class QuickFind {
    private int[] id; // массив, где индекс — элемент, а значение — идентификатор компоненты (группы)

    /**
     * Конструктор инициализирует массив id[] так, что каждый элемент находится в своей группе.
     *
     * @param n количество элементов
     */
    public QuickFind(int n) {
        id = new int[n];
        // Изначально каждый элемент принадлежит своей компоненте (сам себе)
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Проверяет, находятся ли два элемента в одной компоненте.
     *
     * @param p первый элемент
     * @param q второй элемент
     * @return true, если оба элемента принадлежат одной компоненте
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * Объединяет компоненты, к которым принадлежат элементы p и q.
     * Все элементы с id[p] получают id[q].
     *
     * @param p первый элемент
     * @param q второй элемент
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        // Заменяем все id, равные pid, на qid (объединение компонент)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /**
     * Тестирование работы алгоритма Quick-Find.
     */
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10); // создаём 10 элементов: 0–9

        // Объединяем пары
        qf.union(0, 1);
        qf.union(2, 3);
        qf.union(3, 4);
        qf.union(5, 6);

        // Проверяем связи между элементами
        System.out.println("first = " + qf.connected(0, 1));  // true
        System.out.println("second = " + qf.connected(2, 4)); // true (через 3)
        System.out.println("third = " + qf.connected(0, 4));  // false (разные компоненты)
    }
}
