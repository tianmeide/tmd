package chapter.one.fourth;
/**
 * 本题实现将不同的实例盖上时间戳的方法，
 * 但是又不能改变用户本身的类，
 * 所以定义一个新的类，
 * 具体实现请参看如下的PetEnterQueue类。
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
