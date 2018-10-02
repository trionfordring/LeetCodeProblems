package problems.P5_最长回文子串;

public class LongestPalindromicSubstring {
	String res = "";
	public String longestPalindrome(String s) {
		if(s==null||s.length()==0){
			return "";
		}
		for(int i=0;i<s.length();i++){
			getOut(s,i);
		}
		return res;
	}
	private void getOut(String s,int i){
		int i1 = i-1;
		int i2 = i+1;
		while(true){
			if(i2>=s.length()){
				break;
			}
			if(s.charAt(i)==s.charAt(i2)){
				i2++;
			}else{
				break;
			}
		}
		while(true){
			if(i1<=0){
				break;
			}
			if(s.charAt(i)==s.charAt(i1)){
				i1--;
			}else{
				break;
			}
		}
		while(true){
			if(i1<0||i2>s.length()-1){
				break;
			}
			if(s.charAt(i1)==s.charAt(i2)){
				i1--;
				i2++;
			}else{
				break;
			}
		}
		i1++;
		i2--;
		if(i2-i1+1>res.length()){
			res = s.substring(i1, i2+1);
		}
	}
}
