package testJava;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class JiheDemo {

	public static void main(String[] args) {
		
		//1.set遍历
		Set set = new HashSet();
		set.add("abc");
		set.add("bcd");
		set.add("123");
		set.add("abc");
		System.out.println("集合元素个数:"+set.size());
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println("元素"+it.next());
		}
		
		//2.TreeSet排序
		TreeSet treeSet = new TreeSet();
		treeSet.add(1);
		treeSet.add(12);
		treeSet.add(122);
		treeSet.add(11);
		treeSet.add(10);
		
		for(Iterator ite = treeSet.iterator(); ite.hasNext();){
			System.out.println("TreeSet打印"+ite.next());
		}
		//日期
		Calendar now = Calendar.getInstance();
		String ss= ""+now.get(Calendar.YEAR)
				+ (now.get(Calendar.MONTH) + 1)
				+ now.get(Calendar.DAY_OF_MONTH);
		System.out.println("日期"+ss);
	}
}
