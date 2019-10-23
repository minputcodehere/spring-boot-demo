package idv.springboot.demo.Service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import idv.springboot.demo.Config.ConfigClazz;

public class WebService {

	protected static Logger logger = Logger.getLogger(WebService.class.getName());

	@Autowired
	private ConfigClazz config;

	public void printConfig() {

		logger.info("env test");
		config.printVal01();

		logger.info("annotation test");
		config.printVal02();
	}
}
