package testPackage;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations={"classpath:spring-context.xml"}) 
public class BaseJunit {

	protected void printObj(Object object){
		if(object != null){
			System.out.println(JSON.toJSONString(object));
		}
	}
}
