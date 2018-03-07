package testJava;

public class SingletonDemo {

	public static void main(String[] args) {
		
		SingletonDemo1.INSTANCE.otherMethod();
	}
	private static SingletonDemo instance;
	
	private  SingletonDemo(){
		
	}
	public static SingletonDemo getInstance(){
		if(instance == null){
			instance = new SingletonDemo();
		}
		return instance;
	}
}
