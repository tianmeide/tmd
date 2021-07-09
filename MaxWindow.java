package chapter.one.seventh;

import java.util.LinkedList;

/**
 * ���ɴ������ֵ����
 * ��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�����ÿ�����ұ߻�һ��λ�á�
 * ���磬����Ϊ[4,3,5,4,3,3,6,7]�����ڴ�СΪ3ʱ��
 * [4 3 5] 4 3 3 6 7 ���������ֵΪ5
 * 4 [3 5 4] 3 3 6 7 ���������ֵΪ5
 * 4 3 [5 4 3] 3 6 7 ���������ֵΪ5
 * 4 3 5 [4 3 3] 6 7 ���������ֵΪ4
 * 4 3 5 4 [3 3 6] 7 ���������ֵΪ6
 * 4 3 5 4 3 [3 6 7] ���������ֵΪ7
 * ������鳤��Ϊn�����ڴ�СΪw����һ������n-w+1�����ڵ����ֵ��
 * ��ʵ��һ��������
 * ���룺��������arr�����ڴ�СΪw.
 * �����һ������Ϊn-w+1������res,res[i]��ʾÿһ�ִ���״̬�µ����ֵ��
 * �Ա���Ϊ�������Ӧ�÷���{5,5,5,4,6,7}
 * @author tmd
 *
 */
public class MaxWindow {
	
	public int[] getMaxWindow(int[] arr,int w){
		if(arr == null || w <1 || arr.length < w){
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0 ;
		for (int i = 0;i < arr.length; i++){
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w){
				qmax.pollFirst();
			}
			if (i >= w - 1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		//test
		for(int i =0;i<res.length;i++){
			System.out.println("������Ϊ��" + res[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxWindow mw = new MaxWindow();
		int[] arr={4,3,5,4,3,3,6,7};
		int w = 3;
		mw.getMaxWindow(arr, w);
	}

}
