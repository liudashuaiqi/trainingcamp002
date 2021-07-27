package class10数组累加和问题三连;
//第一种方法是左的写法 对数器测试过,正确
//第二种方法是我的写法 对数器测试过,正确
public class Code01_LongestSumSubArrayLengthInPositiveArray {
    public static int getMaxLength1(int[] arr,int K){
        if(arr == null || arr.length == 0 || K <= 0){
            return 0;
        }
        int L = 0;
        int R = 0;//左闭右闭
        int sum = arr[0];
        int max = 0;
        while(true){ //左写法 right < arr.length
            if(sum == K){
                max = Math.max(max,R-L+1);
                sum -= arr[L++];
            }else if(sum < K){
                R++;
                if(R == arr.length){
                    break;
                }
                sum += arr[R];
            }else {
                sum -= arr[L++];
            }
        }
        return max;
    }

    public static int getMaxLength(int[] arr,int K){
        if(arr == null || arr.length == 0 || K <= 0){
            return 0;
        }
        int L = 0;
        int R = 0; //左闭右开
        int max = 0;
        int sum = 0;
        for(L = 0;L < arr.length;L++){
            while(R < arr.length&&sum  < K){
                sum += arr[R++]; //加上了之后可能就不合法了,但是R来到了窗口右侧第一个位置,也就是第一个不合法的位置
            }

            if(sum == K){
                max = Math.max(max,R-L);
            }

            sum -= arr[L];
        }
        return max;
    }

    // for test
    public static int right(int[] arr, int K) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (valid(arr, i, j, K)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // for test
    public static boolean valid(int[] arr, int L, int R, int K) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += arr[i];
        }
        return sum == K;
    }

    // for test
    public static int[] generatePositiveArray(int size, int value) {
        int[] ans = new int[size];
        for (int i = 0; i != size; i++) {
            ans[i] = (int) (Math.random() * value) + 1;
        }
        return ans;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 500000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generatePositiveArray(len, value);
            int K = (int) (Math.random() * value) + 1;
            int ans1 = getMaxLength(arr, K);
            int ans2 = right(arr, K);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println("K : " + K);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("test end");
    }

}
