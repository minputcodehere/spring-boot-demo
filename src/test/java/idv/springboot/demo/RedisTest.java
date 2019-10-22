package idv.springboot.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import redis.clients.jedis.Jedis;

class RedisTest {

	@Test
	void test() {

		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");

		System.out.println("測試連接...");

		// 查看服务是否运行
		System.out.println("是否連通 >> " + jedis.ping());

		String key = RedisTest.class.getSimpleName() + "_" + RandomStringUtils.random(15, true, true);

		// 设置 redis 字符串数据
		jedis.set(key, RedisTest.class.getName());

		// 获取存储的数据并输出
		System.out.println("value >> " + key);

		for (int idx = 0; idx < 9; idx++) {

			System.out.println("INCR >> " + jedis.incr("idx"));

		}

		System.out.println("<< END >>");
	}

}
