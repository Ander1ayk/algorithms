/**
 * Класс bubbleSort реализует алгоритм сортировки пузырьком (Bubble Sort)
 * для массива целых чисел.
 */
public class bubbleSort {

    /**
     * Главный метод программы.
     * Сначала выводит исходный массив, затем сортирует его методом пузырька
     * и выводит отсортированный массив.
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Исходный массив чисел
        int[] array = {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};

        // Выводим массив до сортировки
        printArray(array);

        // Флаг, указывающий, отсортирован ли массив
        boolean isSorted = false;

        // Повторяем, пока массив не будет полностью отсортирован
        while (!isSorted) {
            isSorted = true;

            // Проходим по массиву и сравниваем соседние элементы
            for (int i = 1; i < array.length; i++) {
                // Если текущий элемент меньше предыдущего — меняем местами
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;

                    // Так как была замена — массив еще не отсортирован
                    isSorted = false;
                }
            }
        }

        // Печатаем массив после сортировки
        System.out.println();
        printArray(array);
    }

    /**
     * Метод для печати элементов массива через пробел в одну строку.
     *
     * @param arr Массив целых чисел для вывода
     */
    private static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
