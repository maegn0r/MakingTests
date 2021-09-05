import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        int[] arrWithFours = {1, 3, 65, 2, 4, 2, 56, 7, 4, 2, 78, 2};
        int[] onesAndFoursArr = {4, 1, 1, 1, 1, 4, 1, 4, 1, 4, 4, 4, 1, 4};
        cutOnLastFour(arrWithFours);
        checkArray(onesAndFoursArr);

    }

    public static int[] cutOnLastFour(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Массив не должен быть пустым!");
        }
        int lastFourIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex == -1) {
            throw new RuntimeException("В массиве нет цифры 4!");
        }
        return Arrays.copyOfRange(arr, lastFourIndex + 1, arr.length);
    }

    public static boolean checkArray(int[] arr) {
        int countFours = 0;
        int countOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                countOnes++;
            }
            if (arr[i] == 4) {
                countFours++;
            }
        }
        return (countOnes + countFours == arr.length) && (countFours != 0 && countOnes != 0);
    }
}
