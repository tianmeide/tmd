package chapter.one.ninth;

import java.util.Stack;
/**
 * ������Ӿ���Ĵ�С
 * ����Ŀ��
 * ����һ�����;���map�����е�ֵֻ��0��1���֣�������ȫ��1�����о��������У����ľ�������Ϊ1��������
 * ���磺
 * 1 1 1 0
 * ���У����ľ���������3��1�����Է���3.
 * ���磺
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * ���У����ľ���������6��1�����Է���6.
 * @author tmd
 *
 */
public class MaxRec {
	public int maxRecSize(int[][] map){
		if (map == null || map.length == 0 || map[0].length ==0){
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++){
			for (int j = 0;j < map[0].length; j++){
				height[j] = map[i][j] == 0 ? 0:height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
			System.out.println(maxArea);
		}
		System.out.println("���ս����	" + maxArea);
		return maxArea;
	}
	
	public int maxRecFromBottom(int[] height){
		if (height == null || height.length == 0){
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++){
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
				int j =stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()){
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxRec mr = new MaxRec();
		
		int[][] map = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		mr.maxRecSize(map);
	}

}
