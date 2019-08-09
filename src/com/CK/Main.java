package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0, right = nums.length - 1, mid, valMid;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            valMid = nums[mid];
            if (valMid == target || nums[left] == target || nums[right] == target) return true;
            else if (valMid > nums[left]) {
                if (valMid > target && target >= nums[left])
                    right = mid;
                else
                    left = mid;
            } else if (valMid < nums[right]) {
                if (valMid < target && target <= nums[right])
                    left = mid;
                else
                    right = mid;
            } else {
                left++;
            }
        }
        if (nums[left] == target) return true;
        if (nums[right] == target) return true;
        return false;
    }
}