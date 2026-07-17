
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        for(int right=0;right<nums.length;right++) {
            if (nums[right] == 0) {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
            }
        }
        for(int right=left;right<nums.length;right++) {
            if (nums[right] == 1) {
                nums[right] = nums[left];
                nums[left] = 1;
                left++;
            }
        }
    }
}