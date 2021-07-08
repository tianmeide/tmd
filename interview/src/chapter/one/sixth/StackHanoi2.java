package chapter.one.sixth;
/**
 * 用栈来求解汉诺塔问题
 * 方法二：非递归的方法----用栈来模拟整个过程
 */
import java.util.Stack;

public class StackHanoi2 {
	public int hanoiProblem2(int num,String left,String mid,String right){
		Stack<Integer> lS = new Stack<Integer>();
		Stack<Integer> mS = new Stack<Integer>();
		Stack<Integer> rS = new Stack<Integer>();
		lS.push(Integer.MAX_VALUE);
		mS.push(Integer.MAX_VALUE);
		rS.push(Integer.MAX_VALUE);
		for (int i = num;i > 0 ;i--){
			lS.push(i);
		}
		Action[] record = { Action.No};
		int step = 0;
		while (rS.size() != num + 1){
			step +=  fStackTotStack(record,Action.MTol,Action.LToM,lS,mS,left,mid);
			step += fStackTotStack(record,Action.LToM,Action.MTol,mS,lS,mid,left);
			step += fStackTotStack(record,Action.RToM,Action.MToR,mS,rS,mid,right);
			step += fStackTotStack(record,Action.MToR,Action.RToM,rS,mS,right,mid);
		}
		return step;
	}
	
	public static int fStackTotStack(Action[] record,Action preNoAct,Action nowAct,Stack<Integer> fStack,Stack<Integer> tStack,String from,String to){
		if (record[0] != preNoAct && fStack.peek() < tStack.peek()){
			tStack.push(fStack.pop());
			System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackHanoi2 sh2 = new StackHanoi2();
		int num = 2;
		String left = "左";
		String mid = "中";
		String right = "右";
		sh2.hanoiProblem2(num, left, mid, right);
	}

}
