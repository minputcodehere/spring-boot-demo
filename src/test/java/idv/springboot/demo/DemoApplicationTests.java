package idv.springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idv.springboot.demo.Entity.UserInfoEntity;
import idv.springboot.demo.Service.UserInfoService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserInfoService svc;

	@Test
	void contextLoads() {

		UserInfoEntity entity = svc.findById("A098765432");

		System.err.println("ID >>>>" + entity.getId());
		System.err.println("CNAME >>>>" + entity.getCName());
		System.err.println("ENAME >>>>" + entity.getEName());
	}

}
