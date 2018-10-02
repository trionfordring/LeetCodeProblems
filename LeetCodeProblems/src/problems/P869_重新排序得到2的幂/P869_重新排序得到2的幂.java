package problems.P869_重新排序得到2的幂;
/**
 * 从正整数 N 开始，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。

如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

 

示例 1：

输入：1
输出：true
示例 2：

输入：10
输出：false
示例 3：

输入：16
输出：true
示例 4：

输入：24
输出：false
示例 5：

输入：46
输出：true
 

提示：

1 <= N <= 10^9
* @author Fordring
* @date 2018年8月29日 下午3:40:35 
*
 */
class Solution {
	public int count =0;
	private static final int[] NUMS = 
		{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
    public boolean reorderedPowerOf2(int N) {
        char[] cs = (N+"").toCharArray();
        return pai(cs,0);
    }
    private boolean pai(char[] cs,int index){
    	if(index==cs.length){
    		return false;
    	}
    	if(index==0){
    		for(int i=index;i<cs.length;i++){
    			if(cs[i]=='0'){
    				continue;
    			}
        		swap(cs, index, i);
        		if(exist(toNum(cs))||pai(cs,index+1)){
        			return true;
        		}
        		swap(cs, index, i);
        	}
    	}else{
    		for(int i=index;i<cs.length;i++){
        		swap(cs, index, i);
        		if(exist(toNum(cs))||pai(cs,index+1)){
        			return true;
        		}
        		swap(cs, index, i);
        	}
    	}
    	return pai(cs,index+1);
    }
    private void swap(char[] cs,int m,int n){
    	char temp = cs[m];
    	cs[m] = cs[n];
    	cs[n] = temp;
    }
    private int toNum(char[] c){
    	return Integer.valueOf(new String(c));
    }
    private boolean exist(int n){
    	
    	//count++;
    	for(int i=0;i<NUMS.length;i++){
    		if(n==NUMS[i]){
    			return true;
    		}
    	}
    	return false;
    }
    
}
public class P869_重新排序得到2的幂{
	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		Solution s = new Solution();
		System.out.println(s.reorderedPowerOf2(1));
		System.out.println((System.currentTimeMillis()-l)+"ms");
		System.out.println(s.count);
	}
}
