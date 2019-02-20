package com.spring.dbtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dbtest.service.UserService;
import com.spring.dbtest.vo.UserVo;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, String id, String pwd) {
	  model.addAttribute("id",id);
    model.addAttribute("pwd",pwd);
	  
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
  public String homePost(Model model, String id, String pwd) {
	  userService.register(id, pwd);
	  model.addAttribute("id",id);
	  model.addAttribute("pwd",pwd);
    
    /* return "redirect:/"; */
	  return "home";
  }
  
	@RequestMapping(value="/list", method=RequestMethod.GET)
  public String listGet(Model model, UserVo userVo) {
    List<UserVo> getList = userService.getListView(userVo);
    model.addAttribute("list", getList);
    
    return "list";
  }
  
	@RequestMapping(value="/search", method=RequestMethod.GET)
  public String searchGet(Model model, UserVo userVo, String search) {
    List<UserVo> getSearch = userService.getSearchView(search);
    model.addAttribute("search", getSearch);
    
    return "search";
  }
  
	@RequestMapping(value="/search", method=RequestMethod.POST)
  public String searchPost(Model model, UserVo userVo, String search) {
    
    return "redirect:/search";
  }
  
  
}





