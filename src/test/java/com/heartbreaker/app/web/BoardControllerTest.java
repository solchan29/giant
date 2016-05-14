package com.heartbreaker.app.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testRegistGet() throws Exception{
		MvcResult result =
				mockMvc.perform(MockMvcRequestBuilders.get("/board/regist")).andReturn();
		logger.info(result.toString());
	}
	
	@Test
	public void testRegistPost() throws Exception{
		MvcResult result =
				mockMvc.perform(MockMvcRequestBuilders.post("/board/regist")
						.param("title", "컨트롤러 테스트 제목")
						.param("content","내용내용")
						.param("writer","김원용")).andReturn();
		logger.info(result.toString());
	}
	
}
