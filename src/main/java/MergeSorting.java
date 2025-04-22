/**
 * Класс MergeSorting реализует алгоритм сортировки слиянием (merge sort)
 * с использованием двух массивов для хранения промежуточных результатов.
 */
public class MergeSorting {

    /**
     * Главный метод, точка входа в программу.
     * Создает массив, выводит его на экран, сортирует его и снова выводит.
     */
    public static void main(String[] args) {
        // Исходный массив
        int[] array = new int[]{15, 78, 89, 9, 12, 12546, 8, 879, 16, 54, 1};

        // Печать исходного массива
        System.out.println(arrayToString(array));

        // Сортировка массива с помощью merge sort
        array = mergeSort(array);

        // Печать отсортированного массива
        System.out.println(arrayToString(array));
    }

    /**
     * Метод сортировки слиянием.
     * Выполняет итеративную (не рекурсивную) сортировку массива.
     *
     * @param array массив, который нужно отсортировать
     * @return отсортированный массив
     */
    private static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;               // Массив-источник
        int[] currentDest = new int[array.length]; // Массив-приемник

        int size = 1; // Размер подмассива для слияния
        while (size < array.length) {
            // Слияние всех подмассивов текущего размера
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            // Поменять местами массив-источник и массив-приемник
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            // Увеличение размера подмассивов для следующей итерации
            size = size * 2;

            // Печать промежуточного результата после каждой итерации
            System.out.println(arrayToString(currentSrc));
        }
        return currentSrc;
    }

    /**
     * Слияние двух подмассивов фиксированного размера.
     *
     * @param src1      первый исходный массив
     * @param src1Start начальный индекс первого подмассива
     * @param src2      второй исходный массив (может быть тем же самым, что и src1)
     * @param src2Start начальный индекс второго подмассива
     * @param dest      массив, куда записывается результат слияния
     * @param destStart индекс в массиве назначения, с которого начинается запись
     * @param size      размер каждого из сливаемых подмассивов
     */
    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start; // Текущий индекс в первом подмассиве
        int index2 = src2Start; // Текущий индекс во втором подмассиве

        // Конец первого и второго подмассива
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        // Общее количество элементов для слияния
        int iterationCount = src1End - src1Start + src2End - src2Start;

        // Основной цикл слияния
        for (int i = destStart; i < destStart + iterationCount; i++) {
            // Выбираем наименьший элемент из двух подмассивов
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    /**
     * Преобразует массив в строку в формате [a, b, c, ...].
     *
     * @param array массив для преобразования
     * @return строковое представление массива
     */
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
