package com.hfxt.service;

import com.hfxt.common.Pager;
import com.hfxt.domain.TbUser;

public interface UserService {
	// ��¼
	public TbUser findUserbyLogin(String username, String password);
	
	public int count(String username, Integer status);
	// ��ҳ
	public Pager<TbUser> findUsersByPage(int currentNum, int pageSize, String username, Integer status);
	// ɾ�� ����idɾ�����ؽ��Ϊint
	public int deleteUser(int id);
	// ��ѯ ����id ��ѯ����
	public TbUser findUser(int id);
	// �޸� ���������޸ķ���int
	public int updateUser(TbUser tbUser);
	// ����
	public void addUser(TbUser tbUser);
}
