package idv.springboot.demo.Controller.Business;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@RestController
@RequestMapping("/business/Kaptcha")
public class KaptchaController {

	@Autowired
	private Producer captchaProducer;

	// 圖片驗證碼
	@RequestMapping("/captcha.jpg")
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字驗證碼
		String text = captchaProducer.createText();

		System.err.println("text >> " + text);

		// this.setRespInfo(request, response, text);

		// 生成圖片驗證碼
		BufferedImage image = captchaProducer.createImage(text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	private void setRespInfo(HttpServletRequest request, HttpServletResponse response, String capText) {

		HttpSession session = request.getSession();

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
	}

}
