package chapter.one.fifth;

import java.util.Stack;
/**
 * ��һ��ջʵ����һ��ջ������
 * һ��ջ��Ԫ�ص�����Ϊ���ͣ������뽫��ջ�Ӷ����װ��Ӵ�С��˳������
 * ֻ������һ��ջ������֮�⣬���������µı����������������������ݽṹ��
 * ����������
 * @author tmd
 *
 */
public class StackSort {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()){
			int cur = stack.pop();
			while (!help.isEmpty() && help.peek() > cur){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()){
			stack.push(help.pop());
		}
		//����
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.push(1);
		stack.push(6);
		stack.push(4);
		stack.push(2);
		stack.push(7);
		stack.push(9);
		stack.push(8);
		stack.push(3);
		stack.push(5);
		stack.push(10);
		
		StackSort stackSort = new StackSort();
		System.out.println("�����Ľ��Ϊ:");
		stackSort.sortStackByStack(stack);
	
	}

}
