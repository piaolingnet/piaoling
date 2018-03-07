package testJava;
/**
 * 双重检查锁--单例模式
 * @author Mr-Wang
 *
 */
public class SingletonDemo2 {
	private volatile static SingletonDemo2 instance;
	private SingletonDemo2(){
		
	}
	public static SingletonDemo2 getInstence(){
		if(instance == null){
			synchronized (SingletonDemo2.class) {
				if(instance == null){
					instance = new SingletonDemo2();
				}
			}
		}
		return instance;
	}
}
