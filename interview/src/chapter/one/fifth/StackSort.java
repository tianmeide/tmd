package chapter.one.fifth;

import java.util.Stack;
/**
 * 用一个栈实现另一个栈的排序
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可以申请新的变量，单不能申请额外的数据结构。
 * 如何完成排序？
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
		//测试
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
		System.out.println("排序后的结果为:");
		stackSort.sortStackByStack(stack);
	
	}

}
