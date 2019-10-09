package idv.springboot.demo.Controller.Business;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.springboot.demo.Service.UserInfoService;

@RestController
@RequestMapping("/business/basic_info")
public class BasicInfoController extends WebController {

//	@Autowired
//	private ValidateUtils validate;

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/init")
	public String init() {

		logger.info("init");

		// 初始化
		return userInfoService.getInit();
	}

	@PostMapping("/submit")
	public String submit() {

		// boolean isValidate = this.isValidate();

		String result = StringUtils.EMPTY;

		return result;

	}

//	private boolean isValidate() {
//
//		return validate.validateChinese("") || validate.validateEmail("") || validate.validatePhone("");
//	}
}
