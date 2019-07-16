package problems.P13_罗马数转整数;
/**
 * 
 * @author fordring
 * @Date: 2019年7月17日 上午4:01:27
 *
 */
public class RomantoInteger {
	public int romanToInt(String s) {
		int temp = 0;
		int res = 0;
		int t = 0;
		for(int i=s.length()-1;i>=0;i--) {
			t=toInt(s.charAt(i));
			if(t>=temp) {
				temp = t;
				res+=t;
			}else {
				res-=t;
			}
		}
        return res;
    }
	private int toInt(char c) {
		if(c=='I')return 1;
		else if(c=='V')return 5;
		else if(c=='X')return 10;
		else if(c=='L')return 50;
		else if(c=='C')return 100;
		else if(c=='D')return 500;
		else if(c=='M')return 1000;
		else return 0;
	}
}
