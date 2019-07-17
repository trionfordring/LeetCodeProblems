 package problems.P11_盛最多水的容器;
/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
* @author Fordring
* @date 2019年6月10日 上午9:18:43 
*
 */
public class ContainerWithMostWater {
	int maxArea = 0;
	public int maxArea(int[] height) {
		int x=0;
		int y=height.length-1;
		while(x<y){
			reflashMaxArea(Math.min(height[x], height[y])*(y-x));
			if(height[x]<height[y]){
				x++;
			}else{
				y--;
			}
		}
		return maxArea;
	}
	private void reflashMaxArea(int area){
		if(area>maxArea){
			this.maxArea = area;
		}
	}
}
