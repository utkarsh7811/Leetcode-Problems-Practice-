class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums) {
            int index = Math.abs(num) -1;
            if(nums[index]<0) {
                res.add(Math.abs(num));
            }
            else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}