package kr.green.springtest.service;

import java.util.List;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.pagenation.PageMaker;
import kr.green.springtest.vo.BoardVo;

import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

public interface BoardService {

	public List<BoardVo> getBoards();

	public void registerBoard(BoardVo board);

	public BoardVo detailBoard(Integer id);

	public void deleteBoard(Integer id,AccountVo user);

	public boolean updateBoard(BoardVo board, AccountVo user);
	
	public PageMaker getPageMaker(Criteria cri, int i); // 페이징 처리시 필요

	public List<BoardVo> getUsers(Criteria cri); // 페이징 처리시 필요

	public List<BoardVo> getSearchID(String search);

}