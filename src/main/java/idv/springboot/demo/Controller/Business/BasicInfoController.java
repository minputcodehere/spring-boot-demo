package idv.springboot.demo.Controller.Business;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/basic_info")
public class BasicInfoController {

	@RequestMapping("/init")
	public String init() {

		String result = StringUtils.EMPTY;

		return result;

	}
}
