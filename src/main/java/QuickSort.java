import java.util.Arrays;

/**
 * Класс QuickSort реализует алгоритм быстрой сортировки (QuickSort)
 * для массива целых чисел.
 */
public class QuickSort {

    /**
     * Главный метод программы.
     * Выводит массив до сортировки, выполняет быструю сортировку и затем выводит отсортированный массив.
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Исходный массив
        int[] array = {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};

        // Вывод до сортировки
        System.out.println("Before sorting: " + Arrays.toString(array));

        // Выполняем быструю сортировку
        quickSort(array, 0, array.length - 1);

        // Вывод после сортировки
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    /**
     * Метод быстрой сортировки (QuickSort).
     * Рекурсивно сортирует массив от позиции from до to.
     *
     * @param arr  Массив для сортировки
     * @param from Начальный индекс диапазона
     * @param to   Конечный индекс диапазона
     */
    private static void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            // Разделяем массив и получаем индекс, с которого нужно продолжать
            int divideIndex = partition(arr, from, to);

            // Рекурсивно сортируем левую и правую части
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    /**
     * Метод разделения массива на две части:
     * элементы меньше опорного (pivot) — слева,
     * элементы больше — справа.
     *
     * @param arr  Массив
     * @param from Начальный индекс диапазона
     * @param to   Конечный индекс диапазона
     * @return Индекс, с которого начинается правая часть
     */
    private static int partition(int[] arr, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;

        // Выбираем опорный элемент как средний
        int pivot = arr[from + (to - from) / 2];

        // Пока указатели не пересеклись
        while (leftIndex <= rightIndex) {

            // Ищем элемент слева, который больше или равен опорному
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            // Ищем элемент справа, который меньше или равен опорному
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            // Если индексы не пересеклись — меняем элементы местами
            if (leftIndex <= rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        // Возвращаем индекс начала правой части
        return leftIndex;
    }

    /**
     * Метод обмена двух элементов массива местами.
     *
     * @param array  Массив
     * @param index1 Индекс первого элемента
     * @param index2 Индекс второго элемента
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
