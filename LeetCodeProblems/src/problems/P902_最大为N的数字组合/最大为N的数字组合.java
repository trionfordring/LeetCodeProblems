package problems.P902_最大为N的数字组合;
/**
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）

现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。

返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。

 

示例 1：

输入：D = ["1","3","5","7"], N = 100
输出：20
解释：
可写出的 20 个数字是：
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
示例 2：

输入：D = ["1","4","9"], N = 1000000000
输出：29523
解释：
我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
81 个四位数字，243 个五位数字，729 个六位数字，
2187 个七位数字，6561 个八位数字和 19683 个九位数字。
总共，可以使用D中的数字写出 29523 个整数。
 

提示：

D 是按排序顺序的数字 '1'-'9' 的子集。
1 <= N <= 10^9

* @author Fordring
* @date 2018年9月9日 上午9:48:30 
*
 */
public class 最大为N的数字组合 {
	public static void main(String[] args) {
		String[] arr = {"1","2","3","4"};
		System.out.println(new 最大为N的数字组合().atMostNGivenDigitSet(arr, 1000));
	}
	
	
	public int atMostNGivenDigitSet(String[] D, int N) {
		if(D.length==0){
			return 0;
		}
        int res = 0;
        int count = 0;
        while(N>0){
        	N/=10;
        	count++;
        }
        if(count>D.length){
        	for(int i=1;i<=D.length ;i++){
        		res+=arrangementSec(i, D.length);
        	}
        	return res;
        }
        for(int i=count-1;i>0;i--){
        	res+=arrangementSec(i, D.length);
        }
        char[] n = (N+"").toCharArray();
        char[] d = new char[D.length];
        for(int i =0;i<D.length;i++){
        	d[i] = D[i].charAt(0);
        }
        int index = 0;
        int index2 = 0;
        if(n[index]<d[index2]){
        	for(int i=count-1-index;i>0;i--){
            	res+=arrangementSec(i, D.length);
            }
        }else if(n[index]>d[index2]){
        	return res;
        }else{
        	index2++;
        }
        return 0;
    }
    private long factorialSec(int m, int n) {
        long sum = 1;

        while(m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }
    public long arrangementSec(int m, int n) {
        return m <= n ? factorialSec(m, n) : 0;
    }
}
