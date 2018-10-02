package problems.P6_Z字形变换;

import java.util.ArrayList;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if(numRows<=1){
			return s;
		}
		if(numRows>=s.length()){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int row = 0;
		boolean down = true;
		char[][] cs = new char[numRows][s.length()/2+1];
		int[] is = new int[numRows];
		for(int i = 0;i<s.length();i++){
			if(row==0||row==numRows-1){
				down = !down;
			}
			cs[row][is[row]] = s.charAt(i);
			is[row]++;
			if(down){
				row--;
			}else{
				row++;
			}
		}
		for(int i=0;i<numRows;i++){
			sb.append(cs[i],0,is[i]);
		}
		return sb.toString();
	}
}
