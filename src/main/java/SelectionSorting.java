import java.util.Arrays;

/**
 * Класс SelectionSorting реализует алгоритм сортировки выбором (Selection Sort)
 * для массива целых чисел.
 */
public class SelectionSorting {

    /**
     * Главный метод программы.
     * Сначала выводит исходный массив, затем сортирует его методом выбора
     * и выводит отсортированный массив.
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Исходный массив чисел
        int[] array = {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};

        // Вывод массива до сортировки
        System.out.println(Arrays.toString(Arrays.stream(array).toArray()));

        // Сортировка выбором
        for (int step = 0; step < array.length; step++) {
            // Находим индекс минимального элемента в оставшейся части массива
            int index = minIndex(array, step);

            // Обмен текущего элемента с найденным минимальным
            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }

        // Вывод массива после сортировки
        System.out.println(Arrays.toString(Arrays.stream(array).toArray()));
    }

    /**
     * Метод поиска индекса минимального элемента в массиве, начиная с позиции start.
     *
     * @param array Массив, в котором ищем
     * @param start Начальная позиция поиска
     * @return Индекс минимального элемента в диапазоне [start, array.length)
     */
    private static int minIndex(int[] array, int start) {
        int minIndex = start;             // Предполагаем, что минимальный элемент — первый в диапазоне
        int minValue = array[start];      // Запоминаем значение

        // Перебираем оставшиеся элементы массива
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];      // Обновляем минимальное значение
                minIndex = i;             // И его индекс
            }
        }
        return minIndex; // Возвращаем индекс минимального элемента
    }
}
