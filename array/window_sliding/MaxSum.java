public class MaxSum
{
    // Input  : arr[] = {100, 200, 300, 400}, windowSize = 2
    // Output : 700

    // Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, windowSize = 4
    // Output : 39
    // We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

    // Input  : arr[] = {2, 3}, windowSize = 3
    // Output : Invalid
    // There is no subarray of size 3 as size of whole array is 2.
    public static void main(String[] args) {
        int[] ary = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int windowSize = 4;

        System.out.println(
            maxSum(ary, windowSize));
    }

    private static int maxSum(int ary[], int windowSize) {
        int len = ary.length;

        if(windowSize > len) {
            System.out.println("array size should be greater than window size");
            return -1;
        }

        // compute sum of first window
        int maxSum = 0;
        for(int ix = 0; ix < windowSize; ix++) {
            maxSum += ary[ix];
        }

        // Compute sums of remaining windows by removing first element of previous
        // window and adding last element of current window.
        int windowSum = maxSum;
        for(int ix = windowSize; ix < len; ix++) {
            windowSum = windowSum - ary[ix - windowSize];
            windowSum = windowSum + ary[ix];

            maxSum = windowSum > maxSum ? windowSum : maxSum;
        }

        return maxSum;
    }
}
