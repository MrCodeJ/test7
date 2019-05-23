package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.TbUser;

public interface UserDao {
	public TbUser findUserbyLogin(String username);
	
	public List<TbUser> findUsersByPage(@Param("currentNum") int currentNum,
                                        @Param("pageSize") int pageSize, @Param("username") String username,
                                        @Param("status") Integer status);
	
	public int count(@Param("username") String username, @Param("status") Integer status);
	
	public int deleteUser(int id);
	
	public TbUser findUser(int id);
	
	public int updateUser(TbUser tbUser);
	
	public void addUser(TbUser tbUser);
}
