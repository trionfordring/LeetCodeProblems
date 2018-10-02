package problems.P2_两数相加;

import java.math.BigInteger;

/**
 * 
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
* @author Fordring
* @date 2018年8月29日 下午12:04:14 
*
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toListNode(toInt(l1).add(toInt(l2)));
    }
    public BigInteger toInt(ListNode l){
    	BigInteger i = new BigInteger(0+"");
    	BigInteger d = new BigInteger("1");
    	while(l!=null){
    		i = i.add(new BigInteger(d.multiply(new BigInteger(l.val+""))+""));
    		d = d.multiply(new BigInteger("10"));
    		l = l.next;
    	}
    	return i;
    }
    public ListNode toListNode(BigInteger i){
    	ListNode l = new ListNode(0);
    	ListNode index = l;
    	long d = 10;
    	while(!i.equals(new BigInteger("0"))){
    		index.next = new ListNode(0);
    		index = index.next;
    		int num = i.mod(new BigInteger(d+"")).intValue();
    		i = i.divide(new BigInteger("10"));
    		index.val = (int) num;
    	}
    	if(l.next==null){
    		return new ListNode(0);
    	}
    	return l.next;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class P2_两数相加{
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l = s.toListNode(new BigInteger("100000000000000000000000000000000000000"));
		ListNode l2 = s.toListNode(new BigInteger("465"));
		System.out.println(s.toInt(s.addTwoNumbers(l, l2)));
	}
}