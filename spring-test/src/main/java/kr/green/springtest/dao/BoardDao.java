package kr.green.springtest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getBoards();

	public void setBoard(@Param("board")BoardVo board);

	public BoardVo getBoard(@Param("id")Integer id);

	public void updateBoard(@Param("board")BoardVo board);
	
	 public List<BoardVo> getSearchID(@Param("search") String search);
	
	
	public int getCountUserLists(@Param("cri") Criteria cri);
	
  public List<BoardVo> getUserLists(@Param("cri") Criteria cri);   //페이징처리시 필요

}