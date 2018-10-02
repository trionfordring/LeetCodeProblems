package problems.P3_无重复字符的最长子串;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     
* @author Fordring
* @date 2018年8月29日 下午1:16:05 
*
 */
class Solution {
	public int lengthOfLongestSubstring(String s) {
        int lenth = 1;
        if(s.length()<=1){
        	return s.length();
        }
        HashSet set = new HashSet<>();
        for(int n = 0;n<s.length();n++){
        	for(int m=n;m<s.length();m++){
        		if(!set.add(s.charAt(m))){
        			break;
        		}
        	}
        	if(lenth<set.size()){
        		lenth = set.size();
        	}
        	set.clear();
        }
        return lenth;
    }
}
