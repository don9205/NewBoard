package com.spring.dbtest.service;

import java.util.List;

import com.spring.dbtest.vo.UserVo;

public interface UserService {

  public void register(String id, String pwd);

  public List<UserVo> getListView(UserVo userVo);

  public List<UserVo> getSearchView(String search);

}
