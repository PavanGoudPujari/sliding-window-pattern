//Problem:
//Given an array of positive integers and a number s,
//find the length of the smallest contigous subarray
// whose sum is >=s
//if no such subarray exist, return 0

//Variable Sliding Window
//Expand right until sum>=s
//Then Shrink left while sum>= s
//Track minimum length



public class SmallestSubarrayWithSum{
    public static int findMinLength(int[]nums, int s){
        int minLen = Integer.MAX_VALUE;
        int windowSum =0;
        int left = 0;

        for(int right =0;right<nums.length; right++){
            windowSum +=nums[right];
            while (windowSum>=s){
              minLen =Math.min(minLen, right-left+1);
              windowSum -=nums[left];
              left++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    public static void main(String[] args){
        int[] nums ={2,1,5,2,3,2};
        int s=7;
        System.out.println(findMinLength(nums,s));  // expected 2

    }
}

//Time complexity is O(n)
//Space Complexity is O(1)



