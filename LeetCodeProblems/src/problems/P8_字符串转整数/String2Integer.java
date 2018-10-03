package problems.P8_字符串转整数;
/**
 * 
* @author Fordring
* @date 2018年10月3日 上午8:51:36 
*
 */
public class String2Integer {
	public int myAtoi(String str) {
		if(str.length()==0){
			return 0;
		}
		String s = "";
		boolean space = true;
		boolean one = false;
		boolean zero = true;
		boolean zhen = true;
		for(int i=0;i<str.length();i++){
			
			if(		str.charAt(i)=='-'||
					str.charAt(i)=='0'||
					str.charAt(i)=='1'||
					str.charAt(i)=='2'||
					str.charAt(i)=='3'||
					str.charAt(i)=='4'||
					str.charAt(i)=='5'||
					str.charAt(i)=='6'||
					str.charAt(i)=='7'||
					str.charAt(i)=='8'||
					str.charAt(i)=='9'){
				space = false;
				if(str.charAt(i)=='-'&&(one||!zhen)){
					break;
				}
				if(str.charAt(i)!='-'&&str.charAt(i)!='0'){
					zero = false;
				}else if(zero&&str.charAt(i)=='0'){
					one = true;
					continue;
				}
				one=true;
				s+=str.charAt(i);
				
				
			}else if(!space){
				break;
			}
			
			if(space&&str.charAt(i)=='+'){
				space = false;
				zhen = false;
			}
			if(space&&str.charAt(i)!=' '){
				return 0;
			}
		}
		if(s.equals("")||s.equals("-")){
			return 0;
		}
		long res = 0L;
		if(s.charAt(0)=='-'&&s.length()>11){
			return Integer.MIN_VALUE;
		}else if(s.charAt(0)!='-'&&s.length()>10){
			return Integer.MAX_VALUE;
		}
		res = Long.valueOf(s);
		if(res>Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(res<Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)res;
	}
}
