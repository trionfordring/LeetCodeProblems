package problems.P7_反转整数;
/**
 * 
* @author Fordring
* @date 2018年10月3日 上午8:30:45 
*
 */
public class ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res *= 10;
			res += x % 10;
			x /= 10;
		}
		if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
			return 0;
		}
		return (int)res;
	}
}
