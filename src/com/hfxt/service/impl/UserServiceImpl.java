package com.hfxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfxt.common.Pager;
import com.hfxt.dao.UserDao;
import com.hfxt.domain.TbUser;
import com.hfxt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	//登录
	public TbUser findUserbyLogin(String username, String password) {
		TbUser user = userDao.findUserbyLogin(username);
		if(password.equals(user.getPassword())){
			return user;
		}else{
			return null;
		}
	}

	@Override
	//记录总数
	public int count(String username,Integer status) {
		return userDao.count(username,status);
	}
	
	@Override
	//条件及分页
	public Pager<TbUser> findUsersByPage(int currentNum, int pageSize,String username,Integer status) {
		Pager<TbUser> pager = new Pager<TbUser>();
		if(currentNum==0) currentNum = 1;
		pager.setCurrentPage(currentNum);
		pager.setPageSize(pageSize);
		pager.setTotal(userDao.count(username, status));
		pager.setPageRecords(userDao.findUsersByPage((currentNum-1)*pageSize, pageSize, username, status));
		return pager;
	}
	
	//删除
	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public TbUser findUser(int id) {
		return userDao.findUser(id);
	}

	@Override
	public int updateUser(TbUser tbUser) {
		return userDao.updateUser(tbUser);
	}

	@Override
	public void addUser(TbUser tbUser) {
		userDao.addUser(tbUser);
	}

}
