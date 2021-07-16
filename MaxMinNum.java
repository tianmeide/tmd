package chapter.one.tenth;

import java.util.LinkedList;

/**
 * ���ֵ��ȥ��СֵС�ڻ����num������������
 * ����Ŀ��
 * ��������arr������num,�������ж��ٸ��������������������
 * max(arr[i..j])-min(arr[i..j])<=num
 * max(arr[i..j])��ʾ������arr[i..j]�е����ֵ��min(arr[i..j])��ʾ������arr[i..j]�е���Сֵ��
 * ��Ҫ��
 * ������鳤��ΪN,��ʵ��ʱ�临�Ӷ�ΪO(N)�Ľⷨ��
 * @author tmd
 *
 */
public class MaxMinNum {
	
	public int getNum(int[] arr,int num){
		if (arr == null || arr.length == 0){
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		while (i < arr.length){
			while (j < arr.length){
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
					break;
				}
				j++;
			}
			if (qmin.peekFirst() == i){
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i){
				qmax.pollFirst();
			}
			res += j - i;
			i++;
		}
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxMinNum mmn = new MaxMinNum();
		int[] arr={1,5,10,15,20,25,30,35,40,45,50};
		int num = 5;
		mmn.getNum(arr, num);
	}

}
