package chapter.one.fourth;
/**
 * ����ʵ�ֽ���ͬ��ʵ������ʱ����ķ�����
 * �����ֲ��ܸı��û�������࣬
 * ���Զ���һ���µ��࣬
 * ����ʵ����ο����µ�PetEnterQueue�ࡣ
 * @author tmd
 *
 */
public class PetEnterQueue {
	private Pet pet;
	private long count;
	
	public PetEnterQueue(Pet pet,long count){
		this.pet = pet;
		this.count = count;
	}
	
	public Pet getPet(){
		return this.pet;
	}
	
	public long getCount(){
		return this.count;
	}
	
	public String getEnterPetType(){
		return this.pet.getPetType();
	}
}
