package com.hxcodes.janna;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hxcodes.janna.costs.DatePatterns;
import com.hxcodes.janna.pojo.UserInfo;
import com.hxcodes.janna.serialize.json.JsonUtils;
import com.hxcodes.janna.utils.DateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JannaApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private UserInfo createUserinfo() {
		UserInfo user = new UserInfo();
		user.setAddr(RandomStringUtils.randomAlphabetic(6));
		user.setBirday(DateUtils.now());
		user.setId(RandomUtils.nextInt());
		user.setName(RandomStringUtils.randomAlphabetic(2));
		return user;
	}

	@Test
	public void testJson() {
		System.out.println("to json:" + JsonUtils.toJson(this.createUserinfo()));
	}
	
	@Test
	public void fromJson() {
		UserInfo user = JsonUtils.fromJson("{\"addr\":\"UpqtSj\",\"birday\":\"2018-12-04 10:46:01\",\"id\":761150108,\"name\":\"sd\"}", UserInfo.class);
		System.out.println("from json:" + DateUtils.fmt(user.getBirday(), DatePatterns.DEFAULT));
	}
}
