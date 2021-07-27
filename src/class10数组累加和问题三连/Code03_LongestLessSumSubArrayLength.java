package class10数组累加和问题三连;
//对数器测过 正确
public class Code03_LongestLessSumSubArrayLength {
    public static int maxLengthAwesome(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int[] minSum = new int[n];
        int[] minSumEnd = new int[n];

        minSum[n-1] = arr[n-1];
        minSumEnd[n-1] = n-1;
        //求每一个i位置开头的时候,最小子数组累加和 跟Code04_maxsumofSubarray相反
        for(int i = n-2;i >= 0;i--){
            if(minSum[i+1] <= 0){
                minSum[i] = arr[i]+minSum[i+1];
                minSumEnd[i] = minSumEnd[i+1];
            }else{
                minSum[i] = arr[i];
                minSumEnd[i] = i;
            }
        }
        //不是滑动窗口,但也是用滑动窗口的思想去做
        //对于每一个i位置开头，求i开头的子数组<=k的最大长度,右侧一直滑到不能滑为止
        int sum = 0;
        int end = 0;
        int len = 0;
        for(int i = 0;i < arr.length;i++){
            while(end < arr.length && sum+minSum[end]<=k){
                sum += minSum[end];
                end = minSumEnd[end]+1;
            }
            len = Math.max(len,end-i);
            if(end > i){
                sum -= arr[i];
            }else{
                end = i+1;//end++也可以,现在就相当于i == end
            }
        }
        return len;
    }
    public static int maxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    public static int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        for (int i = 0; i < 10000000; i++) {
            int[] arr = generateRandomArray(10, 20);
            int k = (int) (Math.random() * 20) - 5;
            if (maxLengthAwesome(arr, k) != maxLength(arr, k)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
