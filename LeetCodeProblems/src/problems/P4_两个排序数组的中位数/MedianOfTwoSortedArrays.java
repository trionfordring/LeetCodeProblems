package problems.P4_两个排序数组的中位数;
/**
 * 
* @author Fordring
* @date 2018年8月30日 上午9:03:23 
*
*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

你可以假设 nums1 和 nums2 不同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
	private int count = 0;
	private int maxCount;
	private int minA = 0;
	private int minB = 0;
	private boolean inMin ;
	private int maxA = 0;
	private int maxB = 0;
	private boolean inMax ;
	private int[] nums1;
	private int[] nums2;
	private boolean only = false;
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums2.length==0){
			if(nums1.length%2!=0){
				return nums1[(nums1.length+1)/2-1];
			}else{
				return (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
			}
		}else if(nums1.length==0){
			if(nums2.length%2!=0){
				return nums2[(nums2.length+1)/2-1];
			}else{
				return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
			}
		}
		this.nums1 = nums1;
		this.nums2 = nums2;
		maxCount = nums1.length + nums2.length-2;
		maxA = nums1.length-1;
		maxB = nums2.length-1;
		inMin = nums1[0]<nums2[0];
		inMax = nums1[maxA]>nums2[maxB];
//		System.out.println("min:"+getMin()+" max:"+getMax());
		while(count<maxCount){
			count+=2;
			shrink();
//			System.out.println("min:"+getMin()+" max:"+getMax());
		}
		return (double)(getMin()+getMax())/2.0;
	}
	private int getMin(){
		return inMin?nums1[minA]:nums2[minB];
	}
	private int getMax(){
		return inMax?nums1[maxA]:nums2[maxB];
	}
	private void shrink(){
		if(!only){
			if(inMin){
				if(minA<nums1.length-1){
					minA++;
					inMin = nums1[minA]<nums2[minB];
					
				}else{
					inMin = false;
					only = true;
				}
			}else{
				if(minB<nums2.length-1){
					minB++;
					inMin = !(nums2[minB]<nums1[minA]);
				}else{
					inMin = true;
					only = true;
				}
				
				
			}
			if(inMax){
				if(maxA>0){
					maxA--;
					inMax = nums1[maxA]>nums2[maxB];
				}else{
					inMax = false;
					only = true;
				}
			}else{
				if(maxB>0){
					maxB--;
					inMax = !(nums2[maxB]>nums1[maxA]);
				}else{
					inMax = true;
					only = true;
				}
			}
		}else{
			while(count<maxCount){
				count+=2;
				maxA--;
				maxB--;
				minA++;
				minB++;
//				System.out.println("min:"+getMin()+" max:"+getMax());
			}
		}
	}
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] nums1 = {1};
		int[] nums2 = {2,3,4,5};
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}
}
