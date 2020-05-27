package com.liang.expe;

import com.liang.expe.common.utils.RedisUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class MainTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private MockHttpSession session;

    @Autowired
    RedisUtils redisUtils;


    @Before
    public void setupMockMvc() {
        //初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
        session.setAttribute("userName", "zhangsan");
    }

    @Test
    public void testSign() throws NoSuchAlgorithmException {
/*		//拿到的appId 和 secretKey
		final String appId = "redis-498132";
		final String secretKey = "9fab6a27dee67c302455d6831304d6cf05829d4569cfc7ffddf926696df389a4v";

		//发送的body数据
		//UserDTO body = new UserDTO("1001", "zhangsan", 22);
        Object body = null;
		//对body数据做处理生成sign
		String jsonString = JSON.toJSONString(body);
		JSONObject jsonObject = JSON.parseObject(jsonString);
		Map<String, Object> bodyMap = ObjToTreeMap.jsonObjectToTreeMap(jsonObject);
		String param = JSON.toJSONString(bodyMap);
		String sign = null;
		try {
			sign = MD5Utils.MD5(param, secretKey);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//使用RestTemplete发送http请求
		RestTemplate sendPost = new RestTemplate();
//		String url = "http://localhost:8085/sign";
		String url = "http://www.baidu.com";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//设置coocie
		String cookie = "appId=" + appId + ";" + "sign=" + sign;
		headers.set("Cookie", cookie);

		HttpEntity<JSONObject> request = new HttpEntity<>(jsonObject, headers);
		ResponseEntity<String> response = sendPost.exchange(url, HttpMethod.POST, request, String.class);
		System.out.println(response.getBody());*/
    }

    @Test
    public void testMock() throws Exception {
        redisUtils.set("mytest", "2020-05-26");
        redisUtils.expire("mytest", 600);
		System.out.println(redisUtils.get("mytest"));
    }
		/*mockMvc.perform(
				MockMvcRequestBuilders.get("/mockTest")
						.param("name", "demo")
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
		;
	}*/

}
