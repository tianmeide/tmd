package chapter.one.third;

import java.util.Stack;

/**
 * ��ν��õݹ麯����ջ��������һ��ջ
 * һ��ջ����ѹ��1��2��3��4��5����ô��ջ����ջ�׷ֱ�Ϊ5��4��3��2��1.
 * �����ջת�ú󣬴�ջ����ջ��Ϊ1��2��3��4��5��Ҳ����ʵ��ջ��Ԫ�ص�����
 * ����ֻ���õݹ麯����ʵ�֣��������������ݽṹ��
 * @author tmd
 *
 */
public class StackRecursion {
	/*
	 * �ݹ麯��һ����ջstack��ջ��Ԫ�ط��ز��Ƴ�
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int result = stack.pop();
		if (stack.isEmpty()){
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	/*
	 * �ݹ麯����������һ��ջ��������ĿҪ��ʵ�ֵķ�����������̾������´����е�revese������
	 * �÷���ʹ���������ᵽ��getAndRemoveLastElement������
	 */
	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()){
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
		System.out.println("�����Ԫ�ص�ֵ��:	"+i);//test...
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test...
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//System.out.println("��������һ��Ԫ�ص�ֵ�ǣ�	"+ getAndRemoveLastElement(stack));
		System.out.println("��������һ��Ԫ�ص�ֵ��:	");
		reverse(stack);
	}

}
