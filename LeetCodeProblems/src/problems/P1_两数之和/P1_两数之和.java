package problems.P1_两数之和;
/**
 * P1两数之和<br/>
 * https://leetcode-cn.com/problems/two-sum/description/
* @author Fordring
* @date 2018年8月29日 下午12:00:27 
*
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int n=0;n<nums.length;n++){
                if(n!=i&&nums[i]+nums[n]==target){
                    int[] r = new int[2];
                    r[0]=i;
                    r[1]=n;
                    return r;
                }
            }
        }
        return null;
    }
}