package com.github.tiger.algorithm.sort;

/**
 * 希尔排序（比较排序）
 * <p>
 * 时间复杂度：O(nlogn)（线性对数阶）
 * <p>
 * 最好：O(nlog(2)n)
 * 最坏：O(nlog(2)n)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性：不稳定
 *
 * @author liuhongming
 * @date 07/09/2019
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        /**
         * 区间
         */
        int gap = 1;
        while (gap < n) {
            gap = gap * 3 + 1;
        }

        /**
         * 缩小增量
         */
        for (; gap > 0; gap = gap / 3) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i - gap;
                /**
                 * 跨区间
                 */
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 9, 2, 6, 1};

        shellSort(arr);

        for (int n : arr) {
            System.out.println(n);
        }
    }
}
