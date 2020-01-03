package algurate;

import java.util.Arrays;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/2
 * @Description:
 */
public class Heap {
    //上浮
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && array[parentIndex] > temp) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    //下沉
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void heapSort(int[] array) {
        buildHeap(array);
        System.out.println(Arrays.toString(array));
        for (int i = array.length-1; i >0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        upAdjust(arr);
//        System.out.println(Arrays.toString(arr));
//
//        arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
//        buildHeap(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
