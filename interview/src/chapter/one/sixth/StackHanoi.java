package chapter.one.sixth;
/**
 * 用栈来求解汉诺塔问题
 * 汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有 N 层的时候，打印最优移动过程和最优移动总步数。
 * 例如，当塔数为两层时，最上层的塔记为1，最下层的塔记为2，则打印：
 * Move 1 from left to mid
 * Move 1 from mid to right
 * Move 2 from left to mid
 * Move 1 from right to mid
 * Move 1 from mid to left
 * Move 2 from mid to right
 * Move 1 from left to mid
 * Move 1 from mid to right
 * It well move 8 steps.
 * 注意：关于汉诺塔游戏的更多讨论，将在本书递归与动态规划的章节中继续。
 * 方法一：递归的方法
 * 首先，如果只剩最上层的塔需要移动，则有如下处理：
 * 1.如果希望从“左”移到“中”，打印“Move 1 from left to mid”。
 * 2.如果希望从“中”移到“左”，打印"Move 1 from mid to left"。
 * 3.如果希望从“中”移到“右”，打印"Move 1 from mid to right"。
 * 4.如果希望从“右”移到“中”，打印“Move 1 from right to mid”。
 * 5.如果希望从“左”移到“右”，打印"Move 1 from left to mid"和“Move 1 from mid to right”。
 * 6.如果希望从“右”移到“左”，打印"Move 1 from right to mid"和"Move 1 from mid to left"。
 * 以上过程就是递归的终止条件，也就是只剩上层塔时的打印过程。
 * 接下来，我们分析剩下多层塔的情况。
 * 如果剩下 N 层塔，从最上到最下依次为 1 ~ N，则有如下判断：
 * 1.如果剩下的 N 层塔都在“左”，希望全部移到“中”，则有三个步骤。
 * 1)将1~N-1层塔先全部从“左”移到“右”，明显交给递归过程。
 * 2)将第N层塔从“左”移到“中”。
 * 3)再将1~N-1层塔全部从“右”移到“中”，明显交给递归过程。
 * 2.如果把剩下的N层塔从“中”移到“左”，从“中”移到“右”，从“右”移到“中”，过程与情况1同理，一样是分解为三步，在此不再详述。
 * 3.如果剩下的N层塔都在“左”，希望全部移到“右”，则有五个步骤。
 * 1）将1~N-1层塔先全部从“左”移到“右”，明显交给递归过程。
 * 2)将第N层塔从“左”移到“中”。
 * 3）将1-N-1层塔全部从“右”移到“左”，明显交给递归过程。
 * 4）将第N层塔从“中”移到“右”。
 * 5）最后将1~N-1层塔全部从“左”移到“右”，明显交给递归过程。
 * 4.如果剩下的N层塔都在“右”，希望全部移到“左”，过程与情况3同理，一样是分解为五步，在此不再详述。
 * 以上递归过程经过逻辑化简之后的代码请参看如下代码中的hanoiProblem1方法。
 * @author tmd
 *
 */
public class StackHanoi {
	public int hanoiProblem1(int num,String left,String mid,String right){
		if (num < 1){
			return 0;
		}
		return process(num,left,mid,right,left,right);
	}
	
	public int process(int num,String left,String mid,String right,String from,String to){
		if(num == 1){
			if (from.equals(mid) || to.equals(mid)){
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1  from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		}
		if (from.equals(mid) || to.equals(mid)){
			String another = (from.equals(left) || to.equals(left)) ? right:left;
			int part1 = process(num - 1,left,mid,right,from,another);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			int part3 = process(num - 1,left,mid,right,another,to);
			return part1 + part2 + part3;
		} else {
			int part1 = process(num - 1,left,mid,right,from,to);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + mid);
			int part3 = process(num - 1,left,mid,right,to,from);
			int part4 = 1;
			System.out.println("Move " + num + " from " + mid + " to " + to);
			int part5 = process(num - 1,left,mid,right,from,to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}
	
	public static void main(String args[]){
		StackHanoi sh = new StackHanoi();
		int num = 2;
		String left = "左" ;
		String mid = "中" ;
		String right = "右" ;
		sh.hanoiProblem1(num, left, mid, right);
	} 
}
