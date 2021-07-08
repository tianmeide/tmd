package chapter.one.fourth;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * 用户可以调用 pollAll 方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中的dog类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，检查队列中cat类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * @author tmd
 *
 */
public class DogCatQueue {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	
	public DogCatQueue(){
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}
	
	public void add(Pet pet){
		if (pet.getPetType().equals("dog")){
			this.dogQ.add(new PetEnterQueue(pet,this.count++));
		} else if (pet.getPetType().equals("cat")){
			this.catQ.add(new PetEnterQueue(pet,this.count++));
		} else {
			throw new RuntimeException("err,not dog or cat");
		}
	}
	
	public Pet pollAll(){
		if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
			if (this.dogQ.peek().getCount()  < this.catQ.peek().getCount()){
				return this.dogQ.poll().getPet();
			} else {
				return this.catQ.poll().getPet();
			}
		} else if(!this.dogQ.isEmpty()){
			return this.dogQ.poll().getPet();
		} else if (!this.catQ.isEmpty()){
			return this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("err,queue is empty!");
		}
	}
	
	public Dog pollDog(){
		if (!this.isDogQueueEmpty()){
			return (Dog)this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty!");
		}
	}
	public Cat pollCat(){
		if (!this.isCatQueueEmpty()){
			return (Cat)this.catQ.poll().getPet();
		}  else 
			throw new RuntimeException("Cat queue is empty!");
	}
	
	public boolean isEmpty(){
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty(){
		return this.dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty(){
		return this.catQ.isEmpty();
	}
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		Dog dog4 = new Dog();
		Dog dog5 = new Dog();
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		Cat cat3 = new Cat();
		Cat cat4 = new Cat();
		Cat cat5 = new Cat();
		
		DogCatQueue dogCatQueue = new DogCatQueue();
		dogCatQueue.add(dog1);
		dogCatQueue.add(dog2);
		dogCatQueue.add(cat1);
		dogCatQueue.add(dog3);
		dogCatQueue.add(dog4);
		dogCatQueue.add(cat3);
		dogCatQueue.add(dog5);
		
		dogCatQueue.add(cat2);
		
		dogCatQueue.add(cat4);
		dogCatQueue.add(cat5);
		for(int i=0;i<5;i++){
			//System.out.println("调用 pollAll 方法，将队列中所有的实例按照进队列的先后顺序依次弹出	:"+dogCatQueue.pollAll().getPetType());
			//System.out.println("调用pollDog方法，将队列中的dog类的实例按照进队列的先后顺序依次弹出:	"+dogCatQueue.pollDog().getPetType());
			System.out.println("调用pollCat方法，检查队列中cat类的实例按照进队列的先后顺序依次弹出:	" +dogCatQueue.pollCat().getPetType());
			
		}
		//System.out.println("调用isEmpty方法，检查队列中是否还有dog或cat的实例:	"+dogCatQueue.isEmpty());
		//System.out.println("调用idDogEmpty方法，检查队列中是否有dog类的实例:	"+dogCatQueue.isDogQueueEmpty());
		System.out.println("调用isCatEmpty方法，检查队列中是否有cat类的实例:" + dogCatQueue.isCatQueueEmpty());
	}
}
