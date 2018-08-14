package com.piaoling.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * 数据格式化工具类
 * @author Mr-Wang
 *
 */
public class FormatUtil {

	/**
	 * @Description: 四舍五入保留两位小数，不足位数0补足
	 * @param @param big
	 * @param @return
	 * @return String 
	 * @date 2018年8月12日
	 */
	 public static String get2Num(BigDecimal big){
		 if(big ==null) big=new BigDecimal("0.00");
			DecimalFormat df1 =new DecimalFormat("0.00");
			df1.setRoundingMode(RoundingMode.HALF_UP);
			return df1.format(big);
	 }
	 
	 /**
		 * @Description: 四舍五入保留四位小数，不足位数0补足
		 * @param @param big
		 * @param @return
		 * @return String 
		 * @date 2018年8月12日
		 */
		 public static String get4Num(Object big){
			 if(big ==null) big=new BigDecimal("0.0000");
				DecimalFormat df1 =new DecimalFormat("0.0000");
				df1.setRoundingMode(RoundingMode.HALF_UP);
				return df1.format(big);
		 }
		 /**
		  * @Description: 小数四舍五入转化为2为百分数，不足位数0补足
		  * @param @param big
		  * @param @return
		  * @return String 
		  * @date 2018年8月12日
		  */
		 public static String percent2Num(BigDecimal big) {
				if(big ==null) big=new BigDecimal("0.00");
				DecimalFormat df1 =new DecimalFormat("0.00%");
				df1.setRoundingMode(RoundingMode.HALF_UP);
				return df1.format(big);
		}
		 /**
		  * @Description:  格式化千分位分隔符
		  * @param @param obj
		  * @param @param format(,###,###)
		  * @param @return
		  * @return String 
		  * @date 2018年8月12日
		  */
		 public static String thousandth(Object obj){
			 if(obj ==null) obj=new BigDecimal("0.00");  
			 DecimalFormat df=new DecimalFormat(",##0.00");
			 df.setRoundingMode(RoundingMode.HALF_UP);
			 return df.format(obj);
		 }
}
