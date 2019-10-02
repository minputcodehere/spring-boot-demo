package idv.springboot.demo;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ibm.icu.text.SimpleDateFormat;

class TokenTest {

	private String claim = "JWTClaimExample";

	@Test
	void test() {

		// 取得token
		String token = this.getToken();

		// 解Token
		this.deToken(token);
	}

	/**
	 * deToken 解Token
	 * 
	 * @param token
	 */
	private void deToken(String token) {

		DecodedJWT originToken = JWT.decode(token);
		System.out.println("token 是給誰的:" + originToken.getIssuer());
		System.out.println("token 的ID:" + originToken.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("token 建立時間:" + sdf.format(originToken.getIssuedAt()));
		System.out.println("claim信息:" + originToken.getClaim(this.claim).asString());
	}

	/**
	 * getToken 取得token
	 * 
	 * @return
	 */
	private String getToken() {

		String val = "29JppBMPf50ilE0L6dAZod9FIggdn9aI1WFVhIHQe7HV9iz63k";

		// 给定一个算法，如HmacSHA-256
		Algorithm alg = Algorithm.HMAC256(val);

//		iss(Issuer)：頒發者，是區分大小寫的字串，可以是一個字串或是網址
//		sub(Subject)：主體內容，是區分大小寫的字串，可以是一個字串或是網址
//		aud(Audience)：觀眾，是區分大小寫的字串，可以是一個字串或是網址
//		exp(Expiration Time)：Expiration Time，過期時間，是數字日期
//		nbf(Not Before)：定義在什麼時間之前，不可用，是數字日期
//		iat(Issued At)：頒發時間，是數字日期
//		jti(JWT ID)：唯一識別碼，是區分大小寫的字串

		String token = JWT.create().withIssuer("demo") // token 是給誰的
				.withSubject("login") // token 主題
				.withAudience("demoUser") // 接收jwt的一方
				.withIssuedAt(new Date()) // token 建立時間
				.withExpiresAt(this.addDate(10)) // token 過期時間
				.withJWTId(this.getId()) // 針對當前 token 的唯一標識
				.withClaim(this.claim, "JWT test!") // claim信息
				.sign(alg);

		System.out.println("Token >> " + token);

		return token;
	}

	/**
	 * addDate 計算天數
	 * 
	 * @param days
	 * @return
	 */
	private Date addDate(int days) {

		Date dt = new Date(); // 取时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(calendar.DATE, days); // 把日期往后增加一天,整数 往后推,负数往前移动
		return calendar.getTime();
	}

	/**
	 * getId 取得ID
	 * 
	 * @return
	 */
	private String getId() {

		StringBuilder sb = new StringBuilder();

		Calendar now = Calendar.getInstance();
		now.setTime(new Date());

		sb.append(now.get(now.YEAR));
		sb.append(now.get(now.MONTH) + 1);
		sb.append(now.get(now.DATE));
		sb.append(now.getTimeInMillis());

		return sb.toString();
	}

}
