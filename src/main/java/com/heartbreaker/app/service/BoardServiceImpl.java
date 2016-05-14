package com.heartbreaker.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.heartbreaker.app.model.BoardMapper;
import com.heartbreaker.app.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardMapper mapper;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		mapper.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		mapper.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return mapper.list();
	}

}
