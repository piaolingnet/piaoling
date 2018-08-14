package testJava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumDemo {

	//1.格式化两位小数
	public static String test1(BigDecimal big) {
		if(big ==null) big=new BigDecimal("0.00");
		DecimalFormat df1 =new DecimalFormat("0.00");
		df1.setRoundingMode(RoundingMode.HALF_UP);
		return df1.format(big);
	}
	//2.格式化百分数两位小数
	public static String test2(BigDecimal big) {
		if(big ==null) big=new BigDecimal("0.00");
		DecimalFormat df1 =new DecimalFormat("0.00%");
		df1.setRoundingMode(RoundingMode.HALF_UP);
		return df1.format(big);
	}
	//3.格式化四位小数
	public static String test3(BigDecimal big) {
		if(big ==null) big=new BigDecimal("0.0000");
		DecimalFormat df1 =new DecimalFormat("0.0000");
		df1.setRoundingMode(RoundingMode.HALF_UP);
		return df1.format(big);
	}
	//5千分位分隔符
	 public static String thousandth(Object obj,String param){
		 if(obj ==null) obj=new BigDecimal("0.00");  
		 DecimalFormat df=new DecimalFormat(param);
		 df.setRoundingMode(RoundingMode.HALF_UP);
		 return df.format(obj);
	 }
	public static void main(String[] args) {
		

		BigDecimal ad=new BigDecimal("0.77565");
		BigDecimal ad1=new BigDecimal("0.775");
		BigDecimal ad2=new BigDecimal("-0.77566");
		System.out.println(test2(ad));
		System.out.println(test2(ad1));
		System.out.println(test2(ad2));
		
		//4
		BigDecimal adf=new BigDecimal("0.775");
		BigDecimal adf1=new BigDecimal("-0.7785555");
		System.out.println("4位小数，不足0补足："+test3(adf));
		System.out.println("4位小数，不足0补足："+test3(adf1));
		
		//5千分位
		BigDecimal adff1=new BigDecimal("775876543.785");
		BigDecimal adff2=new BigDecimal("775343431.775");
		System.out.println("千分位分隔符"+thousandth(adff1,",###,###.##"));
		System.out.println("千分位分隔符"+thousandth(adff2,",###,###.##"));
		
	}
}
