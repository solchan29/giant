package com.heartbreaker.app.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {
	
	@Select("select now()")
	public String getTime();
	
	@Insert("insert into tbl_board (title, content, writer) "
			+ "             values(#{title}, #{content}, #{writer})")
	public void create(BoardVO board) throws Exception;
	
	@Select("  select bno"
			+ "      ,title"
			+ "      ,content"
			+ "      ,writer"
			+ "      ,regdate"
			+ "      ,viewcnt "
			+ "  from tbl_board"
			+ " where bno = #{bno}")
	public BoardVO read(Integer bno) throws Exception;
	
	@Update(" update tbl_board"
			+ "  set title = #{title}"
			+ "     ,content = #{content}"
			+ "where bno = #{bno}")
	public void update(BoardVO board) throws Exception;
	
	@Delete("delete from tbl_board where bno = #{bno}")
	public void delete(Integer bno) throws Exception;
	
	@Select("  select bno"
			+ "      ,title"
			+ "      ,content"
			+ "      ,writer"
			+ "      ,regdate"
			+ "      ,viewcnt "
			+ "  from tbl_board"
			+ " where bno > 0 "
			+ " order by regdate desc")
	public List<BoardVO> list() throws Exception;
	
	
}
