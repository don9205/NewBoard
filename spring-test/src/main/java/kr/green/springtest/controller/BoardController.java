package kr.green.springtest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.pagenation.PageMaker;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired

	BoardService boardService;
	@RequestMapping(value="/bbs/list", method=RequestMethod.GET)
	public String listGet(Model model, HttpServletRequest request, Criteria cri, String search, String tit, String num, String wri, String select) {
		// List<BoardVo> list = boardService.getBoards();
		// model.addAttribute("list",list);
		

		
		List<BoardVo> getSearch = boardService.getSearchID(search);
		model.addAttribute("getSearch", getSearch);
		
		System.out.println(getSearch);
		
		/* 페 이 징 처 리 */
		PageMaker pageMaker = boardService.getPageMaker(cri, 5);
		ArrayList list = (ArrayList) boardService.getUsers(cri);
		model.addAttribute("cri",cri);
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",pageMaker);
		
		return "bbs/list";
		
	}
	
	@RequestMapping(value="/bbs/list", method=RequestMethod.POST)
	public String listPost(Model model, BoardVo boardVo, String search, String select ) {

		return "redirect:/bbs/list";
	}

	@RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	public String registerGet(Model model) {
		return "bbs/register";
	}

	@RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	public String registerPost(Model model,BoardVo board) {
		boardService.registerBoard(board);
		return "redirect:/bbs/list";
	}

	@RequestMapping(value="/bbs/detail", method=RequestMethod.GET)
	public String detailGet(Model model,Integer id) {
		// 1.전달받은 id값을 콘솔에 출력을 하고 
		// 2.서비스에서 id값을 이용하여 해당 게시글을 가져오는 메소드 호출
		// 3.해당게시글을 jsp로 전달

		System.out.println(id);
		BoardVo board = boardService.detailBoard(id);
		System.out.println(board);
		if(board == null)
			return "redirect:/bbs/list";
		model.addAttribute("board",board);
		return "bbs/detail";
	}

	@RequestMapping(value="/bbs/delete", method=RequestMethod.GET)
	public String deleteGet(Model model,Integer id, HttpServletRequest request) {
		//request에서 session 정보를 가져와서 session에 저장된 user 정보를 가져옴
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		//삭제 권한이 없는 유저가 URI를 통해 삭제를 시도할 수 있기 때문에 권한이 없는 유저가
		// 삭제를 시도하면 막아주기 위해서 게시판 id와 현재 로그인한 유저정보를 전달
		boardService.deleteBoard(id,user);
		return "redirect:/bbs/list";

	}

	@RequestMapping(value="/bbs/update", method=RequestMethod.GET)
	public String updateGet(Model model,Integer id) {
		BoardVo board = boardService.detailBoard(id);
		if(board == null)
			return "redirect:/bbs/list";
		model.addAttribute("board",board);
		return "bbs/update";
	}

	@RequestMapping(value="/bbs/update", method=RequestMethod.POST)
	public String updatePost(Model model,BoardVo board, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		
		if(!boardService.updateBoard(board,user))
			return "redirect:/bbs/list";
		
		model.addAttribute("id",board.getId());
		return "redirect:/bbs/detail";

	}



}