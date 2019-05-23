package com.hfxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hfxt.common.Pager;
import com.hfxt.domain.TbUser;
import com.hfxt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	//ע��userservice
	@Autowired
	private UserService userService;
	
	//��ת����¼����
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	//ִ�е�¼����
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin(String username,String password,HttpSession session){
		TbUser user = userService.findUserbyLogin(username, password);
		if(user!=null){
			return "redirect:pager";
		}else{
			return "login";
		}
	}
	
	//��ҳ
	@RequestMapping(value="/pager")
	public String getUserListByPage(Model model,String currentNum,String pageSize,String username,String status){
		Integer s = 0;
		if(status!=null) s = Integer.valueOf(status);
		Integer cn = 0;
		Integer ps = 3;
		if(currentNum!=null) cn = Integer.valueOf(currentNum);
		if(pageSize!=null) ps = Integer.valueOf(pageSize);
		Pager<TbUser> pager = userService.findUsersByPage(cn, ps, username,s);
		model.addAttribute("pager", pager);
		return "index";
	}
	
	//ɾ��
	@RequestMapping("/deleteUser")
	public String deleteUser(int id,Model model){
		int num = userService.deleteUser(id);
		if(num>0){
			model.addAttribute("msg", "���˳ɹ�");
		}else{
			model.addAttribute("msg", "����ʧ��");
		}
		return "redirect:pager";
	}
	
	//��ת���޸�ҳ��
	@RequestMapping(value="/UpdateUser",method=RequestMethod.GET)
	public String toUpdateUser(int id,Model model){
		TbUser user = userService.findUser(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	//ִ���޸Ĳ���
	@RequestMapping(value="/UpdateUser",method=RequestMethod.POST)
	public String doUpdateUser(String username,String password,String age,int id){
		TbUser tbUser = new TbUser();
		tbUser.setUsername(username);
		tbUser.setPassword(password);
		tbUser.setAge(Integer.parseInt(age));
		tbUser.setId(id);
		userService.updateUser(tbUser);
		return "redirect:pager";
	}
	
	//��ת����ҳ��
	@RequestMapping(value="/AddUser",method=RequestMethod.GET)
	public String toAddUser(){
		return "updateUser";
	}
	
	//ִ�����Ӳ���
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public String doAddUser(TbUser tbUser){
		userService.addUser(tbUser);
		return "redirect:pager";
	}
}
