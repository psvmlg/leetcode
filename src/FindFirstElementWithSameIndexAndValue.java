//Given an array of distinct integers arr, where arr is sorted in ascending order,
// return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.


// This is a very good example to show the occurence of very first element where binary search can be satisfied on a number of elements

public class FindFirstElementWithSameIndexAndValue {
    public int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                if ((mid > 0 && arr[mid - 1] < mid - 1) || mid == 0) return mid;
                else right = mid - 1;
            } else if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
