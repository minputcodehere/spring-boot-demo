package idv.springboot.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = { "classpath:configTest.properties" }, encoding = "utf-8")
public class ConfigClazz {

	@Autowired
	private Environment env;

	@Value("${test.name}")
	private String name;
	@Value("${test.code}")
	private String code;

	public void printVal01() {
		System.out.println(env.getProperty("test.name"));
		System.out.println(env.getProperty("test.code"));
	}

	public void printVal02() {
		System.out.println(name);
		System.out.println(code);
	}
}
