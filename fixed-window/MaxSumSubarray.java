public class MaxSumSubarray{

    public static int findMaxSum(int[] nums, int k){
        int windowSum=0;
        int maxSum =0;
        for(int i=0;i<nums.length; i++){
            windowSum+=nums[i];
            if(i >= k-1){
                maxSum = Math.max(maxSum,windowSum);//9
                windowSum -= nums[i-(k-1)];
            }
        }
        return maxSum;
    }
    public static void main(String []args){
        int[] nums ={ 2,1,5,1,3,2};
        int k=3;
        // 2,1,5 = 8
        //1,5,1 = 7
        //5,1,3= 9
        //1,3,2=6
        System.out.println(findMaxSum(nums,k));
    }

    //Time complexity is O(n)
}
