import java.util.*;

class Fruit {
	public static void main(String[] args) {
		final int NUM = 20;
		Fruit[] fruits = new Fruit[NUM];
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < NUM; i++) {
			int type = random.nextInt(3); //产生随机数
			switch (type) {
			case 0:
				fruits[i] = new Fruit();
				break;
			case 1:
				fruits[i] = new Orange();
				break;
			case 2:
				fruits[i] = new Apple();
				break;
			}
		}
		for(int i = 0;i<NUM;i++){
			fruits[i].eat();
		}
	}

	public void eat() {
		System.out.println("eat " + this.getClass());
	}

}

class Orange extends Fruit {
	@Override
	public void eat() {
		System.out.println("The orange tastes a little sour");
	}
}

class Apple extends Fruit {

}
