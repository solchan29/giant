package com.heartbreaker.app.model;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardMapperTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMapperTest.class);
	
	@Inject
	private BoardMapper mapper;
	
	/*
	@Test
	public void testConnection() throws Exception{
		System.out.println(mapper.toString());
		System.out.println(mapper.getTime());
	}
	
	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 제목");
		board.setContent("새로운 내용...");
		board.setWriter("user001");
		
		mapper.create(board);
	}
	
		
	
	@Test
	public void testRead() throws Exception{

		logger.info(mapper.read(134).toString());
		
	}
	
		@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(134);
		board.setTitle("수정한 제목");
		board.setContent("수정한 내용...");
		
		mapper.update(board);
	}
	
	@Test
	public void testDelete() throws Exception{

		mapper.delete(134);
		
	}
	
	*/
	
	
	@Test
	public void testList() throws Exception{

		List<BoardVO> list = mapper.list();
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.toString());
		}
		
	}
	
	
}
