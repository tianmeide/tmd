package chapter.one.third;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1.
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，
 * 但是只能用递归函数来实现，不能用其他数据结构。
 * @author tmd
 *
 */
public class StackRecursion {
	/*
	 * 递归函数一：将栈stack的栈底元素返回并移除
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
	 * 递归函数二：逆序一个栈，就是题目要求实现的方法，具体过程就是如下代码中的revese方法。
	 * 该方法使用了上面提到的getAndRemoveLastElement方法。
	 */
	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()){
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
		System.out.println("逆序后元素的值是:	"+i);//test...
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
		//System.out.println("逆序后最后一个元素的值是：	"+ getAndRemoveLastElement(stack));
		System.out.println("逆序后最后一个元素的值是:	");
		reverse(stack);
	}

}
