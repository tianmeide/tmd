package chapter.one.sixth;
/**
 * ��ջ����⺺ŵ������
 * ��ŵ������ȽϾ��䣬�����޸�һ����Ϸ�����������Ʋ��ܴ���������ֱ���ƶ������Ҳ࣬Ҳ���ܴ����Ҳ�ֱ���ƶ�������࣬���Ǳ��뾭���м䡣������ N ���ʱ�򣬴�ӡ�����ƶ����̺������ƶ��ܲ�����
 * ���磬������Ϊ����ʱ�����ϲ������Ϊ1�����²������Ϊ2�����ӡ��
 * Move 1 from left to mid
 * Move 1 from mid to right
 * Move 2 from left to mid
 * Move 1 from right to mid
 * Move 1 from mid to left
 * Move 2 from mid to right
 * Move 1 from left to mid
 * Move 1 from mid to right
 * It well move 8 steps.
 * ע�⣺���ں�ŵ����Ϸ�ĸ������ۣ����ڱ���ݹ��붯̬�滮���½��м�����
 * ����һ���ݹ�ķ���
 * ���ȣ����ֻʣ���ϲ������Ҫ�ƶ����������´���
 * 1.���ϣ���ӡ����Ƶ����С�����ӡ��Move 1 from left to mid����
 * 2.���ϣ���ӡ��С��Ƶ����󡱣���ӡ"Move 1 from mid to left"��
 * 3.���ϣ���ӡ��С��Ƶ����ҡ�����ӡ"Move 1 from mid to right"��
 * 4.���ϣ���ӡ��ҡ��Ƶ����С�����ӡ��Move 1 from right to mid����
 * 5.���ϣ���ӡ����Ƶ����ҡ�����ӡ"Move 1 from left to mid"�͡�Move 1 from mid to right����
 * 6.���ϣ���ӡ��ҡ��Ƶ����󡱣���ӡ"Move 1 from right to mid"��"Move 1 from mid to left"��
 * ���Ϲ��̾��ǵݹ����ֹ������Ҳ����ֻʣ�ϲ���ʱ�Ĵ�ӡ���̡�
 * �����������Ƿ���ʣ�¶�����������
 * ���ʣ�� N �����������ϵ���������Ϊ 1 ~ N�����������жϣ�
 * 1.���ʣ�µ� N �������ڡ��󡱣�ϣ��ȫ���Ƶ����С��������������衣
 * 1)��1~N-1������ȫ���ӡ����Ƶ����ҡ������Խ����ݹ���̡�
 * 2)����N�����ӡ����Ƶ����С���
 * 3)�ٽ�1~N-1����ȫ���ӡ��ҡ��Ƶ����С������Խ����ݹ���̡�
 * 2.�����ʣ�µ�N�����ӡ��С��Ƶ����󡱣��ӡ��С��Ƶ����ҡ����ӡ��ҡ��Ƶ����С������������1ͬ��һ���Ƿֽ�Ϊ�������ڴ˲���������
 * 3.���ʣ�µ�N�������ڡ��󡱣�ϣ��ȫ���Ƶ����ҡ�������������衣
 * 1����1~N-1������ȫ���ӡ����Ƶ����ҡ������Խ����ݹ���̡�
 * 2)����N�����ӡ����Ƶ����С���
 * 3����1-N-1����ȫ���ӡ��ҡ��Ƶ����󡱣����Խ����ݹ���̡�
 * 4������N�����ӡ��С��Ƶ����ҡ���
 * 5�����1~N-1����ȫ���ӡ����Ƶ����ҡ������Խ����ݹ���̡�
 * 4.���ʣ�µ�N�������ڡ��ҡ���ϣ��ȫ���Ƶ����󡱣����������3ͬ��һ���Ƿֽ�Ϊ�岽���ڴ˲���������
 * ���ϵݹ���̾����߼�����֮��Ĵ�����ο����´����е�hanoiProblem1������
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
		String left = "��" ;
		String mid = "��" ;
		String right = "��" ;
		sh.hanoiProblem1(num, left, mid, right);
	} 
}
