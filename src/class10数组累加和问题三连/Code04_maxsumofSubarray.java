package class10数组累加和问题三连;
//牛客上面测试  已经成功
public class Code04_maxsumofSubarray {
    //求每一个i位置开头的时候,最大子数组累加和,并求出长度
    public static int maxsumofSubarray (int[] arr) {
        int n = arr.length;
        int[] maxSum = new int[n];
        int[] maxSumEnd = new int[n];

        maxSum[n-1] = arr[n-1];
        maxSumEnd[n-1] = n-1;

        int max = maxSum[n-1];
        for(int i = n-2;i >= 0; i--){
            if(maxSum[i+1] >= 0){
                maxSum[i] = arr[i]+maxSum[i+1];
                maxSumEnd[i] = maxSumEnd[i+1];
            }else{
                maxSum[i] = arr[i];
                maxSumEnd[i] = i;
            }
            max = Math.max(max,maxSum[i]);
        }
        return max;
    }
}
//此题与trainingcamp003-master\src\class04  第六个题目的代码一样(左正着求)