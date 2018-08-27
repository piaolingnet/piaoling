package testPackage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.piaoling.entity.PlUser;
import com.piaoling.service.PlUserService;

public class PlUserServiceTest extends BaseJunit{

	@Autowired
	private PlUserService plUserService;
	@Test
	public void insert() {
		PlUser plUser=new PlUser();
		plUser.setComment("备注第三大的方法的");
		plUser.setEmail("法法");
		plUserService.insert(plUser);
		
	}
	
}
