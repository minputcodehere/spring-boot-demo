package idv.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import idv.springboot.demo.Service.WebService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		/**
		 * read properties
		 */
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		WebService config = context.getBean(WebService.class);

		config.printConfig();

		// System.err.println(context.getEnvironment().getProperty("src.home"));
//
//		System.err.println(context.getEnvironment().getProperty("my.name"));
//
//		System.err.println(context.getEnvironment().getProperty("other.pwd"));

		/**
		 * Entity
		 */
		// SpringApplication.run(DemoApplication.class, args);

//		UserInfoService svc = context.getBean(UserInfoService.class); 
//
//		UserInfoEntity entity = svc.findById("A098765432");
//		
//		entity.setAddress("台中市台中區台中路200號");
//		
//		svc.add(entity);
//
//		System.out.println(entity);

	}

}
